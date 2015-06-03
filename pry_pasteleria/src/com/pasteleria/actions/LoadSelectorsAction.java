package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Category;
import com.pasteleria.bean.Coverage;
import com.pasteleria.bean.Dough;
import com.pasteleria.bean.Filling;
import com.pasteleria.bean.Rol;
import com.pasteleria.services.HasServiceRol;
import com.pasteleria.services.ServiceCategory;
import com.pasteleria.services.ServiceCoverage;
import com.pasteleria.services.ServiceDough;
import com.pasteleria.services.ServiceFilling;

@ParentPackage(value="cloudedleopard")
public class LoadSelectorsAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Rol> roles;
	private List<Category> categorias;
	private List<Coverage> coberturas;
	private List<Dough> masas;
	private List<Filling> rellenos;
	
	private Rol rol;
	private Category categoria;
	private Coverage cobertura;
	private Dough masa;
	private Filling relleno;
	
	@Action(value="listRol",results={@Result(name="success",type="json")})
	public String list(){
		roles=new HasServiceRol().list();
		return SUCCESS;
	}
	
	@Action(value="listCategory",results={@Result(name="success",type="json")})
	public String listCategoria(){
		categorias=new ServiceCategory().list();
		return SUCCESS;
	}
	
	@Action(value="listCoverage",results={@Result(name="success",type="json")})
	public String listCobertura(){
		coberturas=new ServiceCoverage().list();
		return SUCCESS;
	}
	
	@Action(value="listDough",results={@Result(name="success",type="json")})
	public String listMasa(){
		masas=new ServiceDough().list();
		return SUCCESS;
	}
	
	@Action(value="listFilling",results={@Result(name="success",type="json")})
	public String listRelleno(){
		rellenos=new ServiceFilling().list();
		return SUCCESS;
	}
	
	
	public List<Category> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Category> categorias) {
		this.categorias = categorias;
	}
	public List<Coverage> getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(List<Coverage> coberturas) {
		this.coberturas = coberturas;
	}
	public List<Dough> getMasas() {
		return masas;
	}
	public void setMasas(List<Dough> masas) {
		this.masas = masas;
	}
	public List<Filling> getRellenos() {
		return rellenos;
	}
	public void setRellenos(List<Filling> rellenos) {
		this.rellenos = rellenos;
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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	

	
}
