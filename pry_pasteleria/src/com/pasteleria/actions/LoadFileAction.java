package com.pasteleria.actions;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.util.ByteArrayImage;
import com.pasteleria.util.SaveFile;

@ParentPackage(value="cloudedleopard")
public class LoadFileAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private File archivo;
	private String archivoContentType;
	private String archivoFileName;
	
	private String imagenName;
	private InputStream imagen;
	
	@Action(value="cargar",results={@Result(name=SUCCESS,type="json")})
	public String cargar(){
		
		boolean uploaded=new SaveFile().save(this.archivo,this.archivoFileName);
		
		System.out.println(uploaded);
		System.out.println(this.archivoContentType);
		
	
		return SUCCESS;
	}
	
	
	@Action(value = "verImagen",results = {
			@Result(params={"inputName","imagen"},name = "success", type="stream") })
	public String imagenProducto() throws Exception {
		try {
			
			byte[] bytes=new ByteArrayImage().setImageToArrayBytes(this.imagenName);
			imagen= new ByteArrayInputStream(bytes);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SUCCESS;
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

	public String getImagenName() {
		return imagenName;
	}


	public void setImagenName(String imagenName) {
		this.imagenName = imagenName;
	}


	public InputStream getImagen() {
		return imagen;
	}


	public void setImagen(InputStream imagen) {
		this.imagen = imagen;
	}


	
	
	
}
