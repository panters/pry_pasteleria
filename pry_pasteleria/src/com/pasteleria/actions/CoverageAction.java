package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Coverage;
import com.pasteleria.services.ServiceCoverage;

@ParentPackage(value="cloudedleopard")
public class CoverageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Coverage> coberturas;
	private Coverage cobertura;
	
	
	@Action(value="findCoverage",results={@Result(name="success",type="json")})
	public String find(){
		cobertura=new ServiceCoverage().find(cobertura);
		return SUCCESS;
	}
	
	@Action(value="createCoverage",results={@Result(name="success",type="json")})
	public String create(){
		if (cobertura.getIdCobertura()==0) 
			new ServiceCoverage().create(cobertura);
		else
			new ServiceCoverage().update(cobertura);
		return SUCCESS;
	}
	
	@Action(value="deleteCoverage",results={@Result(name="success",type="json")})
	public String delete(){
		new ServiceCoverage().delete(cobertura);
		return SUCCESS;
	}

	public List<Coverage> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<Coverage> coberturas) {
		this.coberturas = coberturas;
	}

	public Coverage getCobertura() {
		return cobertura;
	}

	public void setCobertura(Coverage cobertura) {
		this.cobertura = cobertura;
	}
	

}
