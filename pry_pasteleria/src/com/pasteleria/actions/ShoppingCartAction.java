package com.pasteleria.actions;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.OrderDetail;
import com.pasteleria.bean.Product;
/**
 * 
 * @author Pantera
 *
 */
@ParentPackage(value="cloudedleopard")
public class ShoppingCartAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	 
	private Map<String,Object> session=(Map<String,Object>)ActionContext.getContext().getSession();
	
	private OrderDetail orderDetail;
	private List<OrderDetail> currentOrder=new LinkedList<OrderDetail>();
	private int idProducto;
	private int cantidad;
	private double total;

	
	
	
	@SuppressWarnings("unchecked")
	@Action(value="listCart",results={@Result(name=SUCCESS,type="json")})
	public String list(){
		this.currentOrder=(LinkedList<OrderDetail>) session.get("cart");
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value="addToCarrito",results={@Result(name=SUCCESS,type="json")})
	public String  add(){
		
		try {		
		        
		     if ((List<OrderDetail>) session.get("cart")!=null) {
		        	boolean existe=false;
		        	this.currentOrder=(LinkedList<OrderDetail>) session.get("cart");
		        
		        	for (Iterator<OrderDetail> iter= currentOrder.iterator(); iter.hasNext();) {
						OrderDetail obj =iter.next();
						 if((existe=obj.equals(this.orderDetail))){
							 //Controlamos la máxima cantidad a 7 siempre
							 if ((this.orderDetail.getCantidad()+obj.getCantidad())>=7)
								obj.setCantidad(7);
							 else
								obj.setCantidad(this.orderDetail.getCantidad()+obj.getCantidad());
							 break;
						 }
					}		
		        	
		        	if (!existe) {
						currentOrder.add(orderDetail);
					}
					session.put("cart",currentOrder);
				
			}else{				
				  currentOrder.add(this.orderDetail);
				  session.put("cart",currentOrder);
				  System.out.println("primer producto agregado");
			}
	        
	        
        }catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value="updateItemCart",results={@Result(name=SUCCESS,type="json")})
	public String update(){
		
		 this.currentOrder=(LinkedList<OrderDetail>) session.get("cart");
		 
		 for (Iterator<OrderDetail> iterator = currentOrder.iterator(); iterator.hasNext();){
			OrderDetail obj = (OrderDetail) iterator.next();
			OrderDetail aux=new OrderDetail();
			aux.setProducto(new Product(this.idProducto));
			if (obj.equals(aux)){
				obj.setCantidad(this.cantidad);
				System.out.println("product: "+this.idProducto+" was update");
				break;
			}		 
		 }
		 
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value="removeItemCart",results={@Result(name=SUCCESS,type="json")})
	public String remove(){
		
		boolean eliminado=false;
		
		try {
	        this.currentOrder=(LinkedList<OrderDetail>) session.get("cart");
	        //Asigamos le id recibido a un Producto para eliminarlo
	        OrderDetail obj=new OrderDetail();
	        obj.setProducto(new Product(this.idProducto));
	        //Se elimina el producto del carrito
	        eliminado=currentOrder.remove(obj);
			System.out.println("Eliminado: "+eliminado+obj.getProducto().getIdProducto());
			
		   }catch (Exception e) {
			e.printStackTrace();
		   }
		return SUCCESS;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public double getTotal() {
		this.currentOrder=(LinkedList<OrderDetail>) session.get("cart");
		for (OrderDetail obj : currentOrder) {
			total+=obj.getSubTotal();
		}
		return total;
	}
	
	
	public void setTotal(double total) {
		this.total = total;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public List<OrderDetail> getCurrentOrder() {
		return currentOrder;
	}
	public void setCurrentOrder(List<OrderDetail> currentOrder) {
		this.currentOrder = currentOrder;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
