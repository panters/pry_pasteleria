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
	
	private Order order;
	private List<OrderDetail> orderDetail;
	
	
	
	@Action(value="registerOrder",results={@Result(name=SUCCESS,type="json")})
	public String registerOrder(){
		
		System.out.println("register Order was invoked");
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
