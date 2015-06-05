package com.pasteleria.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Order implements Serializable {
	
	private String idPedidoCabe;
	private User usuario;
	private String fechaPedido;
	private String fechaFinPedido;
	private Status estado;
	private List<OrderDetail> orderDetail;
	private double total;
	
	
	public Order() {
		super();
	}
	
	

	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	public Order(String idPedidoCabe) {
		super();
		this.idPedidoCabe = idPedidoCabe;
	}	
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	public String getIdPedidoCabe() {
		return idPedidoCabe;
	}
	public void setIdPedidoCabe(String idPedidoCabe) {
		this.idPedidoCabe = idPedidoCabe;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public String getFechaFinPedido() {
		return fechaFinPedido;
	}
	public void setFechaFinPedido(String fechaFinPedido) {
		this.fechaFinPedido = fechaFinPedido;
	}
	public Status getEstado() {
		return estado;
	}
	public void setEstado(Status estado) {
		this.estado = estado;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
	
	
}
