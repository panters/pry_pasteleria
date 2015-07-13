package com.pasteleria.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * Created by Pantera on 15/04/2015.
 */
public class ReaderJSON {

    private static BufferedReader myreader;
    private static StringBuffer sb=new StringBuffer();
    
    

    public static JSONObject getJSONObject(InputStream resource)
    {
        JSONObject json=null;

        try{

            myreader=new BufferedReader(new InputStreamReader(resource,"utf-8"));
            String tmp="";
            while ((tmp=myreader.readLine())!=null){
                sb.append(tmp);
            }
            json=new JSONObject(sb.toString());

        }catch (UnsupportedEncodingException e){
            System.out.println("codificacion no soportada");
        } catch (Exception ex){
            ex.getStackTrace();
        }finally{
            try {
                myreader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return json;
    }

    public static  List<String> getJSONArrayToList(JSONObject json,String key){
        List<String> list=new ArrayList<>();
        try{
            JSONArray jsonArray=json.getJSONArray(key);
            for(int i=0;i<jsonArray.length();i++){
                list.add(jsonArray.getString(i));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getJSONArrayToList(JSONObject jsonObject,String arrayKey,String key){

        List<String> list=new ArrayList<>();

        try{
            JSONArray jsonArray=jsonObject.getJSONArray(arrayKey);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject json=jsonArray.getJSONObject(i);
                list.add(json.getString(key));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public static List<String> getJSONArrayToList(JSONArray jsonArray,String arrayKey,int postition){

        List<String> list=new ArrayList<>();

        try{
            JSONObject json=jsonArray.getJSONObject(postition);
            JSONArray  jsonArrayChild=json.getJSONArray(arrayKey);
            for (int j=0;j<jsonArrayChild.length();j++){
                list.add(jsonArrayChild.getString(j));
           }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    
    
    public static String[] getArrayOfJsonArray(String path){
    	
		String[] tipos=null;
		JsonParser parser = new JsonParser();
		
		try {
			FileReader fr = new FileReader(path);
			JsonElement json = parser.parse(fr);
		
			if (json.isJsonArray()) {
			 try{
		            JsonArray jsonArray=json.getAsJsonArray();
		            tipos=new String[jsonArray.size()];
		            for(int i=0;i<jsonArray.size();i++){
		            tipos[i]=(jsonArray.get(i)).getAsString();
		            }
		            
		            System.out.println(Arrays.toString(tipos));;
		            
		        }catch(Exception e){
		            e.printStackTrace();
		        }
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tipos;
	}

    
	public static void dumpJSONElement(JsonElement elemento) {
	    if (elemento.isJsonObject()) {
	        System.out.println("Es objeto");
	        JsonObject obj = elemento.getAsJsonObject();
	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	        while (iter.hasNext()) {
	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
	            System.out.println("Clave: " + entrada.getKey());
	            System.out.println("Valor:");
	            dumpJSONElement(entrada.getValue());
	        }
	 
	    } else if (elemento.isJsonArray()) {
	        JsonArray array = elemento.getAsJsonArray();
	        System.out.println("Es array. Numero de elementos: " + array.size());
	        java.util.Iterator<JsonElement> iter = array.iterator();
	        while (iter.hasNext()) {
	            JsonElement entrada = iter.next();
	            dumpJSONElement(entrada);
	        }
	    } else if (elemento.isJsonPrimitive()) {
	        System.out.println("Es primitiva");
	        JsonPrimitive valor = elemento.getAsJsonPrimitive();
	        if (valor.isBoolean()) {
	            System.out.println("Es booleano: " + valor.getAsBoolean());
	        } else if (valor.isNumber()) {
	            System.out.println("Es numero: " + valor.getAsNumber());
	        } else if (valor.isString()) {
	            System.out.println("Es texto: " + valor.getAsString());
	        }
	    } else if (elemento.isJsonNull()) {
	        System.out.println("Es NULL");
	    } else {
	        System.out.println("Es otra cosa");
	    }
	}
    
}
