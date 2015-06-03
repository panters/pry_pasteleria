package com.pasteleria.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
/**
 * 
 * @author Pantera
 *
 */
public class ByteArrayImage{

	
	
	public byte[] setImageToArrayBytes(String filename){
		byte[] bytes=null;
		
		  try {
			  	//busca el archivo por su nombre en el Directorio establecido
	            File file = new File("C:\\Files\\imagen\\"+filename);
	            //System.out.println(file.exists() + "!!");
	           
	            FileInputStream fis = new FileInputStream(file);
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            byte[] buf = new byte[1024];
	            try {
	                for (int readNum; (readNum = fis.read(buf)) != -1;) {
	                    bos.write(buf, 0, readNum);
	                  //  System.out.println("read " + readNum + " bytes,");
	                }
	            } catch (IOException ex) {
	                Logger.getLogger(ByteArrayImage.class.getName()).log(Level.SEVERE, null, ex);
	            }
	          //convierte el archivo a un array de byte
	            bytes = bos.toByteArray();
	            
		  }catch (FileNotFoundException e) {
			  System.out.println(e.getMessage());
	      }
	         
	     return bytes;
	}
	
	
	public void writeImageFromArrayBytes(byte[] bytes){
		
		try {
           
            File newFile= new File("C:\\Files\\destino\\imgTest-"+System.currentTimeMillis()+".jpg");
            BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIO.write(imag, "jpg", newFile);
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) {
    	byte[] bytes=new ByteArrayImage().setImageToArrayBytes("emblema.jpg");
    	new ByteArrayImage().writeImageFromArrayBytes(bytes);
    }
    
}