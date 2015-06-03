package com.pasteleria.bean;

import java.io.Serializable;
/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Dough implements Serializable{
	
    private int idMasa;
    private String descripcion;
 
	public int getIdMasa() {
		return idMasa;
	}
	public void setIdMasa(int idMasa) {
		this.idMasa = idMasa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
 

}
