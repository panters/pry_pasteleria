package com.pasteleria.bean;

import java.io.Serializable;
/**
 * @author Pantera
 */
@SuppressWarnings("serial")
public class Rol  implements Serializable{
	
	private int idRol;
	private String descripcion;
	
	
	public Rol() {
		super();
	}
	
	public Rol(int idRol, String descripcion) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
	}
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
