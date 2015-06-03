package com.pasteleria.actions;

import java.util.List;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Category;
import com.pasteleria.bean.Coverage;
import com.pasteleria.bean.Dough;
import com.pasteleria.bean.Filling;
import com.pasteleria.bean.Status;
import com.pasteleria.services.ServiceCategory;
import com.pasteleria.services.ServiceCoverage;
import com.pasteleria.services.ServiceDough;
import com.pasteleria.services.ServiceFilling;
import com.pasteleria.services.ServiceStatus;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport {

	private String mensaje;
	private List<Status> estados;
	private List<Category> categorias;
	private List<Coverage> coberturas;
	private List<Dough> masas;
	private List<Filling> rellenos;

	@Action(value = "ListStatus", results = { @Result(name = "success", location = "/dashboard/test.jsp") })
	public String getListStatus() {
		ServiceStatus statusImplement=new ServiceStatus();
		estados =statusImplement.list();
		categorias=new ServiceCategory().list();
		coberturas=new ServiceCoverage().list();
		masas=new ServiceDough().list();
		rellenos=new ServiceFilling().list();
		mensaje="Hellow Panther";
		return SUCCESS;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Status> getEstados() {
		return estados;
	}

	public void setEstados(List<Status> estados) {
		this.estados = estados;
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

	

}
