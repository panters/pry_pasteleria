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
	private Customer cliente;
	private String fechaPedido;
	private String fechaFinPedido;
	private Status estado;
	private List<OrderDetail> orderDetail;
	private double total;
	private Employed empleado ;
	private EstadoPago estadoPago;
	private double montoPagado;
	private  FormaCompra formaCompra;
	
	public Order() {
		super();
	}
	
	public Order(String idPedidoCabe) {
		super();
		this.idPedidoCabe = idPedidoCabe;
	}

	
	
	public String getIdPedidoCabe() {
		return idPedidoCabe;
	}

	public void setIdPedidoCabe(String idPedidoCabe) {
		this.idPedidoCabe = idPedidoCabe;
	}

	public Customer getCliente() {
		return cliente;
	}

	public void setCliente(Customer cliente) {
		this.cliente = cliente;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Employed getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employed empleado) {
		this.empleado = empleado;
	}

	public EstadoPago getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(EstadoPago estadoPago) {
		this.estadoPago = estadoPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public FormaCompra getFormaCompra() {
		return formaCompra;
	}

	public void setFormaCompra(FormaCompra formaCompra) {
		this.formaCompra = formaCompra;
	}	
	
}
