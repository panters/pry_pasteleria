package com.pasteleria.bean;

import java.io.Serializable;


/**
 * @author Pantera
 */
@SuppressWarnings("serial")
public class Customer extends User implements Serializable {

	private String fecha_registro;
	private String nombrecli;
	private String idCliente;
	
	public Customer() {
		super();
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Customer(String idcliente) {
		this.setIdUsuario(idcliente);
	}
	
	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

}
