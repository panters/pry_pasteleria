package com.pasteleria.bean;

import java.io.Serializable;
/**  
 * @author Pantera 
 */
@SuppressWarnings("serial")
public class Navbar implements Serializable{

private int idMenu;
private String descripcion;
private String url;
private int padre;
private String icono;

public int getIdMenu() {
	return idMenu;
}
public void setIdMenu(int idMenu) {
	this.idMenu = idMenu;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getPadre() {
	return padre;
}
public void setPadre(int padre) {
	this.padre = padre;
}
public String getIcono() {
	return icono;
}
public void setIcono(String icono) {
	this.icono = icono;
}




}
