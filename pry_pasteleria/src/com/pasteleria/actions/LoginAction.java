package com.pasteleria.actions;


import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.User;
import com.pasteleria.daos.SqlServerNavbarDAO;
import com.pasteleria.notifications.Email;
import com.pasteleria.services.ServiceNavbar;
import com.pasteleria.services.ServiceUser;

/**
 * 
 * @author Pantera
 *
 */
@SuppressWarnings("serial")
@ParentPackage(value="cloudedleopard")
public class LoginAction  extends ActionSupport{

	private String navbar;
	private String email;
	private String password;
	private String logged;
	private int rol;
	private int a;
	
	
	public Map<String, Object> session=(Map<String, Object>)ActionContext.getContext().getSession();
	
	@Action(value="ValidateUser",
			results={@Result(name=SUCCESS,type="tiles",location="catalogo"),
			@Result(name=ERROR,type="tiles",location="login"),
			@Result(name="ERROR1",location="/security/loginAdmin.jsp"),
			@Result(name="orderPending",type="tiles",location="carrito"),
			@Result(name="admin",type="tiles",location="layoutAdmin")
			})
	public String validateUser()
	{
		User user=new ServiceUser().find(email, password);
		
		if (user!=null)
		{
			if((user.getRol().getIdRol()==3 || user.getRol().getIdRol()==4) && a==1 ){
				session.put("navbar",new SqlServerNavbarDAO().getNavBarWithEmployeds(user.getRol().getIdRol()));
				session.put("user", user);
				return "admin";
			}
			else if(user.getRol().getIdRol()==2 &&  a==2){
				this.navbar=new ServiceNavbar().getNavBarWithRol(user.getRol().getIdRol());
				session.put("navbar", this.navbar);
				session.put("user", user);
				session.put("lock",false);
				addActionMessage(user.getNombre());
				
				if (session.get("cart")!=null) {
					return "orderPending";
				}
			}
			else{
				if(a==2){
					addActionError("Credenciales Incorrectas");
					return ERROR;	
				}else{
					addActionError("Credenciales Incorrectas");
					return "ERROR1";
				}	
			}
			
			return SUCCESS;
		}
		else
		{
			if(a==2){
				addActionError("Credenciales Incorrectas");
				return ERROR;	
			}else{
				addActionError("Credenciales Incorrectas");
				return "ERROR1";
			}
					
		}
		
	}
	
	
	@Action(value="reloadSession",results={@Result(name=SUCCESS,type="redirectAction",location="layoutAdmin"),
			@Result(name="notlogged",type="redirectAction",location="Admin"),
			@Result(name=ERROR,location="/security/lockscreen.jsp"),})
	public String reloadSession(){
		if (session.get("user")!=null){
			this.logged="true";
			if(((User)session.get("user")).getRol().getIdRol()==3 || ((User)session.get("user")).getRol().getIdRol()==4){
				if(((User)session.get("user")).getPassword().equals(this.password)){
					session.put("lock",false);
					return SUCCESS;
				}else{
					addActionError("Credenciales Incorrectas");
					return ERROR;
				}
			}
	    }		
		return "notlogged";
	}
	
	
	@Action(value="isLogged",results={@Result(name=SUCCESS,type="json")})
	public String isLogged(){
		if (session.get("user")!=null){
			this.logged="true";
			this.rol=((User)session.get("user")).getRol().getIdRol();
	}		
		else
			this.logged="false";
			System.out.println(logged);
		return SUCCESS;
	}
	
	
	@Action(value="enviarClave",
			results={@Result(name=SUCCESS,type="tiles",location="login"),
			@Result(name=ERROR,type="tiles",location="recoverPwd")
			})
	public String recuperarClave(){
		
		User u=new ServiceUser().find(email);
		if(u!=null){
			Email e=new Email(this.email, "Tu claves es <strong>"+u.getPassword()+"</strong>",true);
			new Thread(e).start();
			addActionMessage("Correo Enviado Satisfactoriamente");
		}else{
			addActionError("Usuario no registrado");
			return ERROR;
		}
		return SUCCESS;
	}
	

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNavbar() {
		return navbar;
	}

	public String getLogged() {
		return logged;
	}

	public void setLogged(String logged) {
		this.logged = logged;
	}

	public void setNavbar(String navbar) {
		this.navbar = navbar;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	
	
}
