package com.pasteleria.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

public class SaveFile {
	
	public boolean save(File filetoSave,String filename){
		boolean success=false;
		
		
		try {
				File path=new File("C:/Files/imagen");
			
			if (path.exists()==false) {
				path = new File("C:\\Files\\imagen\\");
           	 	path.mkdirs();
           	 	path=new File("C:/Files/imagen");
           	 	File file=new File(path,filename);
           	 	FileUtils.copyFile(filetoSave,file);
			}
			else{
				File uploadedFile = new File(path,filename);
				FileUtils.copyFile(filetoSave,uploadedFile);
			}
			
			success=true;
			
			System.out.println(path);
			System.out.println(filename);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	
	public static PrintWriter  crearArchivo(String path,String name) throws IOException{
	    //Las siguientes 3 líneas nos permite crear un archivo y escribir en el
		 PrintWriter  salida=null;
		 try {
			  	File archivo = new File(path+"\\"+name);
			    FileWriter writer = new FileWriter(archivo);
			   salida = new PrintWriter(writer);
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		  return salida;
	  }
	
	public static boolean escribirArchivo(PrintWriter salida, String cadena)throws Exception{
		
		try {
			//Tambien el método write nos permite escribir
			salida.write(cadena);
		    //Es importante no olvidar cerrar el archivo
		    salida.close();
		    //retornamos true-operacion correcta
		    return true;
		    
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}
