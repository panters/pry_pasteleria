package com.pasteleria.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Customer;
import com.pasteleria.bean.User;
import com.pasteleria.services.ServiceCustomer;
import com.pasteleria.services.ServiceUser;

@ParentPackage(value="cloudedleopard")
public class CustomerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Customer> clientes;
	private Customer cliente;
	
	private String username;
	private String apellidop;
	private String apellidom;
	private String documento;
	private String nacimiento;
	private String sexo;
	private String email;
	private String estadocivil;
	private String telefono;
	private String celular;
	private String password;
	
	private byte cexiste;
	
	@Action(value="listCustomer",results={@Result(name="success",type="json")})
	public String list(){
		clientes=new ServiceCustomer().list();
		System.out.println("fui invocado");
		return SUCCESS;
	}
	
	@Action(value="findCustomer",results={@Result(name=SUCCESS,type="tiles",location="customerupd")})
	public String findPas(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		User u=(User) session.get("user");
		cliente=new ServiceCustomer().find(u);
		return SUCCESS;
	}
	
	@Action(value="findCustomerupd",results={@Result(name=SUCCESS,type="tiles",location="customerupdpass")})
	public String find(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		User u=(User) session.get("user");
		cliente=new ServiceCustomer().find(u);
		return SUCCESS;
	}
	
	@Action(value="updatePassword1",results={@Result(name=SUCCESS,type="tiles",location="catalogo")})
	public String updatePassword(){
		new ServiceCustomer().updatePassword(cliente);
		return SUCCESS;
	}
	
	@Action(value="saveCustomer",results={
			@Result(name="success",type="json"),
			@Result(name="admin",type="json"),
			@Result(name="cliente",type="tiles",location="catalogo")
			})
	public String save(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		User u=(User) session.get("user");
	if(session.get("user")!=null){	
		if (cliente.getIdUsuario().equals("nuevo")) {
			
			if(this.email!=null){
				if((new ServiceUser().find(this.email))!=null){
					this.cexiste=1;
					System.out.println("ya existe");
				}else{
					new ServiceCustomer().register(username, apellidop, apellidom, documento, nacimiento, sexo,email, estadocivil, telefono, celular, password);
				}
			}else{
				if((new ServiceUser().find(this.cliente.getEmail()))!=null){
					this.cexiste=1;
					System.out.println("existe");
				    return "admin";
				}else{
					new ServiceCustomer().create(cliente);
				}
			}
			
		}else{
				if(u.getRol().getIdRol()==2){
					new ServiceCustomer().update(cliente);
					addActionMessage("Cambios Guardados");
					 return "cliente";
				}else{
					new ServiceCustomer().update(cliente);
					return "admin";
				}				
		}
	}else{
		if((new ServiceUser().find(this.email))!=null){
			this.cexiste=1;
			System.out.println("ya existe");
		}else{
			new ServiceCustomer().register(username, apellidop, apellidom, documento, nacimiento, sexo, email, estadocivil, telefono, celular, password);
		}
    }	
		return SUCCESS;
	}
	
	
	@Action(value="deleteCustomer",results={
			@Result(name="success",type="redirectAction",location="mcustomer")})
	public String delete(){
		new ServiceCustomer().delete(cliente);
		return SUCCESS;
	}

	public List<Customer> getClientes() {
		return clientes;
	}

	public void setClientes(List<Customer> clientes) {
		this.clientes = clientes;
	}

	public Customer getCliente() {
		return cliente;
	}

	public void setCliente(Customer cliente) {
		this.cliente = cliente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getApellidom() {
		return apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getCexiste() {
		return cexiste;
	}

	public void setCexiste(byte cexiste) {
		this.cexiste = cexiste;
	}
	
	
}
