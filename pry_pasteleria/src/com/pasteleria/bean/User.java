package com.pasteleria.bean;

import java.io.Serializable;
/**
 * @author Pantera
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String idUsuario;
	private String login;
	private String password;
	private Rol rol;
	private String nombre;
	private String ape_pa;
	private String ape_ma;
	private String dni;
	private String fec_nacimiento;
	private String sexo;
	private String email;
	private String estado_civil;
	private String telefono;
	private String celular;
	
	
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe_pa() {
		return ape_pa;
	}
	public void setApe_pa(String ape_pa) {
		this.ape_pa = ape_pa;
	}
	public String getApe_ma() {
		return ape_ma;
	}
	public void setApe_ma(String ape_ma) {
		this.ape_ma = ape_ma;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFec_nacimiento() {
		return fec_nacimiento;
	}
	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
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
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
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
	

}
