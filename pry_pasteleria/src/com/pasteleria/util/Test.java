package com.pasteleria.util;

import java.util.Arrays;

public class Test {

	
	public static void main(String[] args) {
		
	 
	}
	
	
	public static void agregar(){
		try {
			String path="c:\\files\\data";
			String[] data;
			data=ReaderJSON.getArrayOfJsonArray(path+"\\tipo.json");
	        
	        data=Arrays.copyOf(data,data.length+1);
	        data[data.length-1]="nuevo";
	        
	        path="c:\\files\\data";
	        SaveFile.escribirArchivo(SaveFile.crearArchivo(path,"tipo.json"),Arrays.toString(data));
			
	        System.out.println(Arrays.toString(data));;
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void eliminar(){
		// eliminar();
				try {
					String path="c:\\files\\data";
					String[] data;
					data=ReaderJSON.getArrayOfJsonArray(path+"\\tipo.json");
					
					String[] aux=new String[data.length-1];
					int j=0;
					for (int i = 0; i <data.length; i++) {
						if (!data[i].equals("nuevo")) {
							aux[j]=data[i];
							j++;
						}
					}
					
			        SaveFile.escribirArchivo(SaveFile.crearArchivo(path,"tipo.json"),Arrays.toString(aux));
					
			        System.out.println(Arrays.toString(aux));;
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}

}



