package com.pasteleria.bean;

import java.io.Serializable;

/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable {

	private int idProducto;
	private String descripcion;
	private int stock;
	private double precio;
	private String image_resource;
	private Category categoria;
	private Coverage cobertura;
	private Dough masa;
	private Filling relleno;
	
	
	
	public Product(int idProducto) {
		this.idProducto=idProducto;
	}

	public Product() {
	}


	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getImage_resource() {
		return image_resource;
	}
	public void setImage_resource(String image_resource) {
		this.image_resource = image_resource;
	}
	public Category getCategoria() {
		return categoria;
	}
	public void setCategoria(Category categoria) {
		this.categoria = categoria;
	}
	public Coverage getCobertura() {
		return cobertura;
	}
	public void setCobertura(Coverage cobertura) {
		this.cobertura = cobertura;
	}
	public Dough getMasa() {
		return masa;
	}
	public void setMasa(Dough masa) {
		this.masa = masa;
	}
	public Filling getRelleno() {
		return relleno;
	}
	public void setRelleno(Filling relleno) {
		this.relleno = relleno;
	}
	
	

}

