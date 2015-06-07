package com.pasteleria.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Order;
import com.pasteleria.bean.OrderDetail;
import com.pasteleria.bean.User;
import com.pasteleria.services.HasServiceOrder;
import com.pasteleria.services.HasServiceOrderDetail;

@ParentPackage(value="cloudedleopard")
public class OrderAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session=ActionContext.getContext().getSession();
	private List<Order> pedidos;
	private Order order;
	private List<OrderDetail> orderDetail;
	private String id;
	
	@Action(value="listOrderDet",results={@Result(name=SUCCESS,type="json")})
	public String listDet(){
		
		orderDetail=new HasServiceOrderDetail().list(id);
			   
		return SUCCESS;
	}
	
	@Action(value="listOrder",results={@Result(name=SUCCESS,type="json")})
	public String list(){
		
		if (session.get("user")!=null) {
			User u=(User) session.get("user");
			System.out.println((u.getIdUsuario()).substring(0));
			 
			if(u.getRol().getIdRol()==2){
			//if(((u.getIdUsuario()).charAt(0))=='C'){
				System.out.println("Hola a Cliente");
				pedidos=new HasServiceOrder().list(u.getIdUsuario());
			}
			else{
				System.out.println("Hola Admin");
				pedidos=new HasServiceOrder().list();
			}
		}
	
		return SUCCESS;	
	}
	
	
	@Action(value="registerOrder",results={@Result(name=SUCCESS,type="json")})
	public String registerOrder(){
		
		System.out.println("register Order was invoked");
		System.out.println(orderDetail.get(0).getFec_requerimiento());
		try {
			
			this.order=new Order();
			//Recuperams el  Usuairo Logueado
			User u=(User) session.get("user");

			//Asignamos el id al Cliente que registra el pedido(en observación)
			this.order.setUsuario(u);
			
			//Registramos el pedido y obtenemos el Codigo del Pedido Generado
			this.order.setIdPedidoCabe(new HasServiceOrder().create(this.order));
			int salida=new HasServiceOrderDetail().createfromList(this.order.getIdPedidoCabe(),this.orderDetail);
			if (salida>0) {
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
		
		new HasServiceOrder().update(order);
		
		return SUCCESS;
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
