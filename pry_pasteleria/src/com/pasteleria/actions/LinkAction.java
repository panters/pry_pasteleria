package com.pasteleria.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.services.ServiceNavbar;
import com.pasteleria.bean.User;
import com.pasteleria.daos.SqlServerNavbarDAO;
/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
@ParentPackage(value="cloudedleopard")
public class LinkAction  extends ActionSupport{
	
	private String navbar;
	private String username;
	
	Map<String,Object> session=ActionContext.getContext().getSession();
		
	@Action(value="layout",
			results={@Result(name=SUCCESS,type="tiles",location="layout")})
	public String layout(){
		navbar=new ServiceNavbar().getNavBarWithRol(1);
		session.put("navbar", this.navbar);
		return SUCCESS;
	}
	
	@Action(value="layoutAdmin",results={@Result(name=SUCCESS,type="tiles",location="layoutAdmin"),
			@Result(name="nologged",type="redirectAction",location="Admin")})
	public String layoutAdmin(){
		
		if(session.get("user")!=null){
			session.put("navbar",new SqlServerNavbarDAO().getNavBarWithEmployeds(((User)session.get("user")).getRol().getIdRol()));
		}else{
			return "nologged";
		}
		return SUCCESS;
	}
	
	@Action(value="logueo",
			results={@Result(name=SUCCESS,type="tiles",location="login")})
	public String logueo(){
		return SUCCESS;
	}
	
	@Action(value="lockscreen",
			results={@Result(name=SUCCESS,location="/security/lockscreen.jsp"),
			@Result(name="notlogged",type="redirectAction",location="Admin")})
	public String lock(){
		if(session.get("user")!=null)
			this.username=((User)session.get("user")).getNombre()+" "+((User)session.get("user")).getApe_pa();
		else
			return "notlogged";
		return SUCCESS;
	}
	
	@Action(value="catalogo",
			results={@Result(name=SUCCESS,type="tiles",location="catalogo")})
	public String catalogo(){
		return SUCCESS;
	}
	
	@Action(value="catalogoAdmin",
			results={@Result(name=SUCCESS,type="tiles",location="catalogoAdmin")})
	public String catalogoAdmin(){
		return SUCCESS;
	}
	
	@Action(value="seguimiento",
			results={@Result(name="admin",type="tiles",location="seguimiento"),
			@Result(name="cliente",type="tiles",location="seguimientoCustomer")})
	public String seguimiento(){
		
		if (session.get("user")!=null) {
			User u=(User) session.get("user");
			if (u.getRol().getIdRol()==2) {
				System.out.println("usuario cliente");
				return "cliente";
			}else{
				System.out.println("usuario empleado");
				return "admin";
			}
		}else{
			System.out.println("usuario null");
		}
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
	
	@Action(value="carritoAdmin",
			results={@Result(name=SUCCESS,type="tiles",location="carritoAdmin")})
	public String carritoAdmin(){
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
	
	@Action(value="updateCustomer",
			results={@Result(name=SUCCESS,type="redirectAction",location="findCustomer")})
	public String updateCustomer(){
		return SUCCESS;
	}
	
	@Action(value="updatePassword",
			results={@Result(name=SUCCESS,type="redirectAction",location="findCustomerupd")})
	public String updatePassword(){
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
	
	@Action(value="minsumo",results={@Result(name=SUCCESS,type="tiles",location="minsumo")})
	public String mInsumo(){
		return SUCCESS;
	}
	
	@Action(value="mtipoinsumo",results={@Result(name=SUCCESS,type="tiles",location="mtipoinsumo")})
	public String mtipoInsumo(){
		return SUCCESS;
	}
	
	
	@Action(value="mrol",results={@Result(name=SUCCESS,type="tiles",location="mrol")})
	public String mrol(){
		return SUCCESS;
	}
	
	@Action(value="mdough",results={@Result(name=SUCCESS,type="tiles",location="mdough")})
	public String mdough(){
		return SUCCESS;
	}
	
	@Action(value="mfilling",results={@Result(name=SUCCESS,type="tiles",location="mfilling")})
	public String mfilling(){
		return SUCCESS;
	}
	
	@Action(value="mcategory",results={@Result(name=SUCCESS,type="tiles",location="mcategory")})
	public String mcategory(){
		return SUCCESS;
	}
	
	@Action(value="Admin",results={@Result(name=SUCCESS,location="/security/loginAdmin.jsp")})
	public String loginAdmin(){
		return SUCCESS;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
