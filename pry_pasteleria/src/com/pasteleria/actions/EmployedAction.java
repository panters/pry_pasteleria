package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Employed;
import com.pasteleria.services.ServiceEmployed;

@ParentPackage(value="cloudedleopard")
public class EmployedAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Employed> empleados;
	private Employed empleado;
	
	@Action(value="listEmployed",results={@Result(name="success",type="json")})
	public String list(){
		empleados=new ServiceEmployed().list();
		return SUCCESS;
	}
	
	@Action(value="findEmployed",results={@Result(name="success",type="json")})
	public String find(){
		empleado=new ServiceEmployed().find(empleado);
		return SUCCESS;
	}
	
	@Action(value="saveEmployed",results={@Result(name="success",type="json")})
	public String save(){
		if (empleado.getIdUsuario().equals("nuevo")) {
			new ServiceEmployed().create(empleado);
		}else{
			new ServiceEmployed().update(empleado);
		}
		return SUCCESS;
	}
	
	@Action(value="deleteEmployed",results={@Result(name="success",type="redirectAction",location="memployed")})
	public String delete(){
		new ServiceEmployed().delete(empleado);
		return SUCCESS;
	}

	public List<Employed> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Employed> empleados) {
		this.empleados = empleados;
	}

	public Employed getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employed empleado) {
		this.empleado = empleado;
	}
	
	
	
}
