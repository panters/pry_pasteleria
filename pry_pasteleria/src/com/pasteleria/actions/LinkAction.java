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
	private byte newsession;

	
	Map<String,Object> session=ActionContext.getContext().getSession();
		
	@Action(value="layout",
			results={@Result(name=SUCCESS,type="tiles",location="layout")})
	public String layout(){
		navbar=new ServiceNavbar().getNavBarWithRol(1);
		if(session.get("user")!=null && ((User)session.get("user")).getRol().getIdRol()==2){
		     navbar=new ServiceNavbar().getNavBarWithRol(2);
		}
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
		if(session.get("user")!=null){
			this.username=((User)session.get("user")).getNombre()+" "+((User)session.get("user")).getApe_pa();
			session.put("lock",true);
		}else
			return "notlogged";
		return SUCCESS;
	}
	
	@Action(value="catalogo",
			results={@Result(name=SUCCESS,type="tiles",location="catalogo")})
	public String catalogo(){
		return SUCCESS;
	}
	
	@Action(value="catalogoAdmin",
			results={@Result(name=SUCCESS,type="tiles",location="catalogoAdmin"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String catalogoAdmin(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="seguimiento",
			results={@Result(name="admin",type="tiles",location="seguimiento"),
			@Result(name=SUCCESS,type="redirectAction",location="logueo"),
			@Result(name="cliente",type="tiles",location="seguimientoCustomer"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String seguimiento(){
		
		if (session.get("user")!=null) {
			User u=(User) session.get("user");
			if (u.getRol().getIdRol()==2) {
				System.out.println("usuario cliente");
				return "cliente";
			}else{
				System.out.println("usuario empleado");
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
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
			results={@Result(name=SUCCESS,type="tiles",location="carritoAdmin"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String carritoAdmin(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
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
			results={@Result(name=SUCCESS,type="tiles",location="mproducto"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mProducto(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mcliente",
			results={@Result(name=SUCCESS,type="tiles",location="mcliente"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mCliente(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mempleado",
			results={@Result(name=SUCCESS,type="tiles",location="mempleado"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mEmpleado(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mcobertura",
			results={@Result(name=SUCCESS,type="tiles",location="mcobertura"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mCobertura(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mcustomer",
			results={@Result(name=SUCCESS,type="tiles",location="mcustomer"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mCustomer(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
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
	
	@Action(value="memployed",results={@Result(name=SUCCESS,type="tiles",location="memployed"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String memployed(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mproduct",results={@Result(name=SUCCESS,type="tiles",location="mproduct"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mproduct(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="minsumo",results={@Result(name=SUCCESS,type="tiles",location="minsumo"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mInsumo(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mtipoinsumo",results={@Result(name=SUCCESS,type="tiles",location="mtipoinsumo"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mtipoInsumo(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	
	@Action(value="mrol",results={@Result(name=SUCCESS,type="tiles",location="mrol"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mrol(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mdough",results={@Result(name=SUCCESS,type="tiles",location="mdough"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mdough(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mfilling",results={@Result(name=SUCCESS,type="tiles",location="mfilling"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mfilling(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	@Action(value="mcategory",results={@Result(name=SUCCESS,type="tiles",location="mcategory"),
			@Result(name="noadmin",location="/security/loginAdmin.jsp"),
			@Result(name="nologged",type="redirectAction",location="lockscreen")})
	public String mcategory(){
		if(session.get("user")!=null){
			User obj=(User) session.get("user");
			if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
				if(session.get("lock")!=null){
					if((boolean)session.get("lock"))
						return "nologged";
				}
				return SUCCESS;
			}
		}
		return "noadmin";
	}
	
	
	
	
	@Action(value="Admin",results={@Result(name=SUCCESS,location="/security/loginAdmin.jsp"),
			@Result(name="desbloquear",type="redirectAction",location="lockscreen")})
	public String loginAdmin(){
		
		if(session.get("user")!=null){
			if(this.newsession==1)
				return SUCCESS;
			else{
				User obj=(User) session.get("user");
				if(obj.getRol().getIdRol()==3 || obj.getRol().getIdRol()==4){
					return "desbloquear";
				}
			}
		}
		return SUCCESS;
	}

	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNavbar() {
		return navbar;
	}
	public void setNavbar(String navbar) {
		this.navbar = navbar;
	}
	public byte getNewsession() {
		return newsession;
	}
	public void setNewsession(byte newsession) {
		this.newsession = newsession;
	}

	
	
	
	
	
}
