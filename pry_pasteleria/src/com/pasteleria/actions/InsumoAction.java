package com.pasteleria.actions;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Insumo;
import com.pasteleria.services.ServiceInsumo;
import com.pasteleria.util.SaveFile;

@ParentPackage(value="cloudedleopard")
public class InsumoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Insumo> insumos;
	private Insumo insumo;
	private String[] tipoinsumos;
	
	private File archivo;
	private String archivoContentType;
	private String archivoFileName;
	
	
	@Action(value="listtipoinsumos",results={@Result(name="success",type="json")})
	public String listTipo(){
		ResourceBundle rb=ResourceBundle.getBundle("com/pasteleria/resources/tipoInsumos");
		this.tipoinsumos=(rb.getString("tipo")).split(",");
		return SUCCESS;
	}
	
	@Action(value="findInsumo",results={@Result(name="success",type="json")})
	public String find(){
		this.insumo=new ServiceInsumo().find(this.insumo);
		return SUCCESS;
	}
		
	
	@Action(value="saveInsumo",results={@Result(name=SUCCESS,type="redirectAction",location="minsumo")})
	public String cargar(){
		//Validamos si se cargo algun archivo al input File si se cargo se actualiza imagen 
		//con el archivo nuevo si no se cargo nada se mantiene la imagen original
		boolean uploaded=false;
		
		if (archivo!=null) {
			uploaded=new SaveFile().save(this.archivo,this.archivoFileName);
			this.insumo.setImagen(archivoFileName);
		}else{
			this.insumo.setImagen((new ServiceInsumo().find(this.insumo)).getImagen());
		}
		
		if (this.insumo.getIdinsumo()==0)
			new ServiceInsumo().create(this.insumo);
		else
			new ServiceInsumo().update(this.insumo);
		
		System.out.println("uploaded: "+uploaded);
		System.out.println(this.archivoContentType);
		
		return SUCCESS;
	}
	
	
	
	@Action(value="deleteInsumo",results={@Result(name=SUCCESS,type="redirectAction",location="minsumo")})
	public String delete(){
		new ServiceInsumo().delete(this.insumo);
		return SUCCESS;
	}
	
	
	
	
	public List<Insumo> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<Insumo> insumos) {
		this.insumos = insumos;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	public String getArchivoContentType() {
		return archivoContentType;
	}
	public void setArchivoContentType(String archivoContentType) {
		this.archivoContentType = archivoContentType;
	}
	public String getArchivoFileName() {
		return archivoFileName;
	}
	public void setArchivoFileName(String archivoFileName) {
		this.archivoFileName = archivoFileName;
	}

	public String[] getTipoinsumos() {
		return tipoinsumos;
	}

	public void setTipoinsumos(String[] tipoinsumos) {
		this.tipoinsumos = tipoinsumos;
	}
	
	
	
	
}
