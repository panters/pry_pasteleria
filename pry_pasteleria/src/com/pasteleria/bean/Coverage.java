package com.pasteleria.bean;

import java.io.Serializable;
/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Coverage implements Serializable {

	private int idCobertura;
	private String descripcion;
	
	public int getIdCobertura() {
		return idCobertura;
	}
	public void setIdCobertura(int idCobertura) {
		this.idCobertura = idCobertura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
