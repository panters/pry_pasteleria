package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Dough;
import com.pasteleria.services.ServiceDough;

@ParentPackage(value="cloudedleopard")
public class DoughAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Dough> masas;
	private Dough masa;
	
	@Action(value="listDough",results={@Result(name="success",type="json")})
	public String list(){
		masas=new ServiceDough().list();
		return SUCCESS;
	}
	
	@Action(value="findDough",results={@Result(name="success",type="json")})
	public String find(){
		masa=new ServiceDough().find(masa);
		return SUCCESS;
	}
	
	@Action(value="createDough",results={@Result(name="success",type="json")})
	public String create(){
		if (masa.getIdMasa()==0) 
			new ServiceDough().create(masa);
		else
			new ServiceDough().update(masa);
		return SUCCESS;
	}
	
	@Action(value="deleteDough",results={@Result(name="success",type="tiles",location="mdough")})
	public String delete(){
		new ServiceDough().delete(masa);
		return SUCCESS;
	}

	public List<Dough> getMasas() {
		return masas;
	}

	public void setMasas(List<Dough> masas) {
		this.masas = masas;
	}

	public Dough getMasa() {
		return masa;
	}

	public void setMasa(Dough masa) {
		this.masa = masa;
	}

	

}
