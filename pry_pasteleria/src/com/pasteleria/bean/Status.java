package com.pasteleria.bean;

import java.io.Serializable;
/**  
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Status implements Serializable {

	private int idEstado;
	private String descripcion;
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
