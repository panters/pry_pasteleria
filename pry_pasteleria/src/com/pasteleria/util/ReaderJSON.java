package com.pasteleria.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pantera on 15/04/2015.
 */
public class ReaderJSON {

    BufferedReader myreader;
    StringBuffer sb=new StringBuffer();

    public JSONObject getJSONObject(InputStream resource)
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

    public List<String> getJSONArrayToList(JSONObject json,String key){
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

    public List<String> getJSONArrayToList(JSONObject jsonObject,String arrayKey,String key){

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

    public List<String> getJSONArrayToList(JSONArray jsonArray,String arrayKey,int postition){

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

}
