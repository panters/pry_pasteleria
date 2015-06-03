package com.pasteleria.bean;

import java.io.Serializable;


/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Employed extends User implements Serializable{

	private String fecha_ingreso;
	private Double sueldo;
	private String fecha_salida;
	private String activo;
	
	public Employed() {
		super();
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
}
