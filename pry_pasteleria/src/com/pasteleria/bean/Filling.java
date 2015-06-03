package com.pasteleria.bean;

import java.io.Serializable;
/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Filling implements Serializable{

	private int idRelleno;
	private String descripcion;
	
	public int getIdRelleno() {
		return idRelleno;
	}
	public void setIdRelleno(int idRelleno) {
		this.idRelleno = idRelleno;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
