package com.pasteleria.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Rol;
import com.pasteleria.services.HasServiceRol;


@ParentPackage(value="cloudedleopard")
public class RolAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Rol> roles;
	private Rol rol;
	
	
	
	
	@Action(value="listRol",results={@Result(name="success",type="json")})
	public String list(){
		roles=new HasServiceRol().list();
		return SUCCESS;
	}
	
	@Action(value="findRol",results={@Result(name="success",type="json")})
	public String find(){
		rol=new HasServiceRol().find(rol);
		return SUCCESS;
	}
	
	@Action(value="createRol",results={@Result(name="success",type="json")})
	public String create(){
		if (rol.getIdRol()==0){ 
			System.out.println("jjjjj");
			new HasServiceRol().create(rol);
		}else{
			new HasServiceRol().update(rol);
		}
		return SUCCESS;
	}
	
	@Action(value="deleteRol",results={@Result(name="success",type="json")})
	public String delete(){
		new HasServiceRol().delete(rol);
		return SUCCESS;
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

