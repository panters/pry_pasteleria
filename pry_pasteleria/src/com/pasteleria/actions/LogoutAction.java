package com.pasteleria.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.services.ServiceNavbar;
/**
 * 
 * @author Pantera
 *
 */
@ParentPackage(value="cloudedleopard")
@SuppressWarnings(value="serial")
public class LogoutAction extends ActionSupport {

	private SessionMap<String, Object> session=(SessionMap<String, Object>) ActionContext.getContext().getSession();
	
	
	@Override
	@Action(value="logout",results={@Result(name="success",type="redirectAction",location="logueo")})
	public String execute() throws Exception {
		session.invalidate();		
		String navbar=new ServiceNavbar().getNavBarWithRol(1);
		session.put("navbar", navbar);
		return SUCCESS;
	}
	
	@Action(value="logoutAdmin",results={@Result(name="success",type="redirectAction",location="Admin")})
	public String executeAdmin() throws Exception {
		session.invalidate();
		return SUCCESS;
	}

}
