/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteleria.notifications;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/**
 *
 * @author SkyNet
 */
public class TextoToVoz {

    /**
     * @param args the command line arguments
     */
   private static byte[] obten(String url)
   {
    URL urlpagina = null;
    InputStream isr = null;
    URLConnection urlCon = null;
    ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
    byte[] byteChunk = new byte[4096];
    int noOfBytes = 0;
     try {
       urlpagina = new URL(url);
       urlCon  = urlpagina.openConnection();
       urlCon.addRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
       urlCon.connect();
       isr = urlCon.getInputStream();
   
        while ((noOfBytes = isr.read(byteChunk)) > 0) {
            byteOutputStream.write(byteChunk, 0, noOfBytes);
        }
       
       isr.close();
     } catch (Exception ex){
         ex.printStackTrace();
         return null;
     }
     return byteOutputStream.toByteArray();
   }


    public static boolean Lee(String texto){
       
        String url = "http://translate.google.com.mx/translate_tts?ie=UTF-8&q=||||&tl=es&total=1&idx=0&textlen=6&prev=input";
        url = url.replace("||||", texto.replace(" ", "%20"));
        url = url.replace("\n", "");
        url = url.replace("\"", "");
        
        byte[] cad = obten(url);

        if (cad == null){
            return false;
        }
        InputStream is = new ByteArrayInputStream(cad);
        try {
            Player player = new Player(is);
            player.play();
            
        } catch (JavaLayerException ex) {
            return false;
        }
            return true;
        }
    
    
		public static void main(String[] args){
		    Lee("ajime no ippo es todo");
		}    
		    
    
}