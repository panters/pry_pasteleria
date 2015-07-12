package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Coverage;
import com.pasteleria.bean.Filling;
import com.pasteleria.services.HasServiceRol;
import com.pasteleria.services.ServiceCoverage;
import com.pasteleria.services.ServiceFilling;

@ParentPackage(value="cloudedleopard")
public class FillingAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Filling> rellenos;
	private Filling relleno;
	
	@Action(value="listFilling",results={@Result(name="success",type="json")})
	public String list(){
		rellenos=new ServiceFilling().list();
		return SUCCESS;
	}
	
	@Action(value="findFilling",results={@Result(name="success",type="json")})
	public String find(){
		relleno=new ServiceFilling().find(relleno);
		return SUCCESS;
	}
	
	@Action(value="createFilling",results={@Result(name="success",type="json")})
	public String create(){
		if (relleno.getIdRelleno()==0) 
			new ServiceFilling().create(relleno);
		else
			new ServiceFilling().update(relleno);
		return SUCCESS;
	}
	
	@Action(value="deleteFilling",results={@Result(name="success",type="tiles",location="mfilling")})
	public String delete(){
		new ServiceFilling().delete(relleno);
		return SUCCESS;
	}

	public List<Filling> getRellenos() {
		return rellenos;
	}

	public void setRellenos(List<Filling> rellenos) {
		this.rellenos = rellenos;
	}

	public Filling getRelleno() {
		return relleno;
	}

	public void setRelleno(Filling relleno) {
		this.relleno = relleno;
	}

}
