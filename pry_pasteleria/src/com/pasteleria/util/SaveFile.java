package com.pasteleria.util;

import java.io.File;

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
	

}
