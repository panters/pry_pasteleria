package com.pasteleria.bean;

import java.io.Serializable;
/**
 *  
 * @author Pantera
 *
 */

@SuppressWarnings("serial")
public class Category implements Serializable{

	private int idCategoria;
	private String descripcion;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
