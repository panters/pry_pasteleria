package com.pasteleria.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Customer;
import com.pasteleria.bean.Employed;
import com.pasteleria.bean.FormaCompra;
import com.pasteleria.bean.Order;
import com.pasteleria.bean.OrderDetail;
import com.pasteleria.bean.User;
import com.pasteleria.notifications.Email;
import com.pasteleria.notifications.Notificaciones;
import com.pasteleria.services.HasServiceOrder;
import com.pasteleria.services.HasServiceOrderDetail;
import com.pasteleria.services.ServiceCustomer;

@ParentPackage(value="cloudedleopard")
public class OrderAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session=ActionContext.getContext().getSession();
	private List<Order> pedidos;
	private Order order;
	private List<OrderDetail> orderDetail;
	private String id;
	private String idPedido;
	private int indice;
	private int estado;
	private String idcliente;
	
	@Action(value="listOrderDet",results={@Result(name=SUCCESS,type="json")})
	public String listDet(){
		
		orderDetail=new HasServiceOrderDetail().list(id);
			   
		return SUCCESS;
	}
	
	@Action(value="listOrder",results={@Result(name=SUCCESS,type="json")})
	public String list(){
		
		if (session.get("user")!=null) {
			User u=(User) session.get("user");
			 
			if(u.getRol().getIdRol()==2){
				pedidos=new HasServiceOrder().list(u.getIdUsuario());
			}
			else{
				pedidos=new HasServiceOrder().list();
			}
		}
	
		return SUCCESS;	
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value="registerOrder",results={@Result(name=SUCCESS,type="json")})
	public String registerOrder(){
		
		System.out.println("register Order was invoked");
		System.out.println(orderDetail.get(0).getFec_requerimiento());
		try {
			
			this.order=new Order();
			//Recuperams el  Usuairo Logueado
			User u=(User) session.get("user");
			Employed employed=new Employed();
			Customer customer=new Customer();
			customer.setIdUsuario(u.getIdUsuario());
			customer=new ServiceCustomer().find(customer);
			//Asignamos el id al Cliente que registra el pedido(en observación)
			 
			if (u.getRol().getIdRol()==2) {
				employed.setIdUsuario("E0000");
				customer.setIdUsuario(u.getIdUsuario());
				customer=new ServiceCustomer().find(customer);
				this.order.setFormaCompra(new FormaCompra(1));
				
				System.out.println("Asignaod "+this.idcliente);
			}else{
				
				employed.setIdUsuario(u.getIdUsuario());
				customer.setIdUsuario(this.idcliente);
				customer=new ServiceCustomer().find(customer);
				this.order.setFormaCompra(new FormaCompra(2));
				System.out.println("Asignaod "+this.idcliente);
				
			}
			
			double total=0;
			for (OrderDetail oj : (List<OrderDetail>)session.get("cart")) {
				total+=oj.getSubTotal();
			}
			
			this.order.setCliente(customer);
			this.order.setEmpleado(employed);
			this.order.setTotal(total);
			
			//Registramos el pedido y obtenemos el Codigo del Pedido Generado
			this.order.setIdPedidoCabe(new HasServiceOrder().create(this.order));
			
			
			int salida=new HasServiceOrderDetail().createfromList(this.order.getIdPedidoCabe(),this.orderDetail);
			if (salida>0) {
				System.out.println(customer.getCelular()+customer.getEmail()+customer.getNombre()+
						customer.getApe_pa()+customer.getApe_ma()+this.order.getIdPedidoCabe());
				//Creamos un objeto Email que implementa de Runable
				Notificaciones 	notifi=new Notificaciones(customer.getCelular(),customer.getEmail(),
						customer.getNombre(),customer.getApe_pa(),customer.getApe_ma(),this.order.getIdPedidoCabe());
				//Enviamos el email con un Hilo para que proceso no afecte al tiempo de registro del Pedido
				new Thread(notifi).start();
				System.out.println("Registro correcto");
			}
			
			ActionContext.getContext().getSession().remove("cart");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="EditStatus",results={@Result(name=SUCCESS,type="json")})
	public String EditStatus(){
		
		new HasServiceOrderDetail().update(idPedido,indice,estado);
		
		Order p=new HasServiceOrder().find(new Order(this.idPedido));
		Customer customer=new ServiceCustomer().find(new Customer(p.getCliente().getIdUsuario()));
		if(customer!=null){
			//Creamos un objeto Email que implementa de Runable
			Notificaciones 	notifi=new Notificaciones(customer.getCelular(),customer.getEmail(),
					customer.getNombre(),customer.getApe_pa(),customer.getApe_ma(),this.order.getIdPedidoCabe());
			//Enviamos el email con un Hilo para que proceso no afecte al tiempo de registro del Pedido
			new Thread(notifi).start();
		}
		
		return SUCCESS;
	}
	
	
	
	
	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Order> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Order> pedidos) {
		this.pedidos = pedidos;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
}
