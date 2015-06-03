package com.pasteleria.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.services.ServiceNavbar;
/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
@ParentPackage(value="cloudedleopard")
public class LinkAction  extends ActionSupport{
	
	private String navbar;
	
	Map<String,Object> session=ActionContext.getContext().getSession();
		
	@Action(value="layout",
			results={@Result(name=SUCCESS,type="tiles",location="layout")})
	public String layout(){
		navbar=new ServiceNavbar().getNavBarWithRol(1);
		session.put("navbar", this.navbar);
		return SUCCESS;
	}
	
	@Action(value="logueo",
			results={@Result(name=SUCCESS,type="tiles",location="login")})
	public String logueo(){
		return SUCCESS;
	}
	
	@Action(value="catalogo",
			results={@Result(name=SUCCESS,type="tiles",location="catalogo")})
	public String catalogo(){
		return SUCCESS;
	}
	
	@Action(value="seguimiento",
			results={@Result(name=SUCCESS,type="tiles",location="seguimiento")})
	public String seguimiento(){
		return SUCCESS;
	}
	
	@Action(value="armar",
			results={@Result(name=SUCCESS,type="tiles",location="armar")})
	public String armar(){
		return SUCCESS;
	}
	
	@Action(value="carrito",
			results={@Result(name=SUCCESS,type="tiles",location="carrito")})
	public String carrito(){
		return SUCCESS;
	}
	
	
	@Action(value="singup",
			results={@Result(name=SUCCESS,type="tiles",location="singup")})
	public String singup(){
		return SUCCESS;
	}
	
	@Action(value="recoverPwd",
			results={@Result(name=SUCCESS,type="tiles",location="recoverPwd")})
	public String recoverPwd(){
		return SUCCESS;
	}
	
	@Action(value="mproducto",
			results={@Result(name=SUCCESS,type="tiles",location="mproducto")})
	public String mProducto(){
		return SUCCESS;
	}
	
	@Action(value="mcliente",
			results={@Result(name=SUCCESS,type="tiles",location="mcliente")})
	public String mCliente(){
		return SUCCESS;
	}
	
	@Action(value="mempleado",
			results={@Result(name=SUCCESS,type="tiles",location="mempleado")})
	public String mEmpleado(){
		return SUCCESS;
	}
	
	@Action(value="mcobertura",
			results={@Result(name=SUCCESS,type="tiles",location="mcobertura")})
	public String mCobertura(){
		return SUCCESS;
	}
	
	@Action(value="mcustomer",
			results={@Result(name=SUCCESS,type="tiles",location="mcustomer")})
	public String mCustomer(){
		return SUCCESS;
	}
	
	@Action(value="memployed",results={@Result(name=SUCCESS,type="tiles",location="memployed")})
	public String memployed(){
		return SUCCESS;
	}
	
	@Action(value="mproduct",results={@Result(name=SUCCESS,type="tiles",location="mproduct")})
	public String mproduct(){
		return SUCCESS;
	}
}
