package com.pasteleria.bean;

import java.io.Serializable;

public class Insumo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idinsumo;
	private String descripcion;
	private String precio;
	private String tipo;
	private String imagen;
	
	
	public int getIdinsumo() {
		return idinsumo;
	}
	public void setIdinsumo(int idinsumo) {
		this.idinsumo = idinsumo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	

}
