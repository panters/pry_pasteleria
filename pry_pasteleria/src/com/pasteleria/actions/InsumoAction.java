package com.pasteleria.actions;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Insumo;
import com.pasteleria.services.ServiceInsumo;
import com.pasteleria.util.ReaderJSON;
import com.pasteleria.util.SaveFile;

@ParentPackage(value="cloudedleopard")
public class InsumoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private List<Insumo> insumos;
	private Insumo insumo;
	private String[] tipoinsumos;
	private String tipo;
	private String tipoAntiguo;
	
	private File archivo;
	private String archivoContentType;
	private String archivoFileName;
	
	
	@Action(value="listtipoinsumos",results={@Result(name="success",type="json")})
	public String listTipo(){
		//obtenemos los tipos del archivo
		String path="c:\\files\\data\\tipo.json";
		this.tipoinsumos=ReaderJSON.getArrayOfJsonArray(path);
		return SUCCESS;
	}
	
	@Action(value="addtipoinsumos",results={@Result(name="success",type="redirectAction",location="mtipoinsumo")})
	public String addTipo(){
		this.tipo=this.tipo.replaceAll("\\s","");
		System.out.println(tipo);
		try {
			
			if (this.tipoAntiguo.isEmpty() || this.tipoAntiguo.equals("nuevo")){
				String path="c:\\files\\data";
				String[] data;
				//obtenemos los tipos
				data=ReaderJSON.getArrayOfJsonArray(path+"\\tipo.json");
		        
		        data=Arrays.copyOf(data,data.length+1);
		        //Agregamos el nuevo tipo definido por el cliente al arreglo
		        data[data.length-1]=this.tipo;
		        //Sobrescirbimos el archivo
		        SaveFile.escribirArchivo(SaveFile.crearArchivo(path,"tipo.json"),Arrays.toString(data));
				//mostramos en consola el resultado
		        System.out.println(Arrays.toString(data));
			}else{
				try {
					String path="c:\\files\\data";
					String[] data;
					data=ReaderJSON.getArrayOfJsonArray(path+"\\tipo.json");
					
					
					for (int i = 0; i <data.length; i++) {
						if (data[i].equals(this.tipoAntiguo)) {
							data[i]=this.tipo;
						}
					}
					
			        SaveFile.escribirArchivo(SaveFile.crearArchivo(path,"tipo.json"),Arrays.toString(data));
					
			        System.out.println(Arrays.toString(data));;
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="deletetipoinsumos",results={@Result(name="success",type="redirectAction",location="mtipoinsumo")})
	public String deleteTipo(){
		try {
			String path="c:\\files\\data";
			String[] data;
			//Obtenemos el arreglo de tipos del archivo
			data=ReaderJSON.getArrayOfJsonArray(path+"\\tipo.json");
			System.out.println("eliminar:"+this.tipo);
			String[] aux=new String[data.length-1];
			int j=0;
			for (int i = 0; i <data.length; i++) {
				if (!data[i].equals(this.tipo)) {//Agregamos el tipo que sea diferente al eliminado
					aux[j]=data[i];
					j++;
				}
			}
			//Guardamos el arreglo modificado en el archivo
	        SaveFile.escribirArchivo(SaveFile.crearArchivo(path,"tipo.json"),Arrays.toString(aux));
			//mostramos en consola el resultado
	        System.out.println(Arrays.toString(aux));;
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipoAntiguo() {
		return tipoAntiguo;
	}
	public void setTipoAntiguo(String tipoAntiguo) {
		this.tipoAntiguo = tipoAntiguo;
	}

	

	
	
	
	
	
}
