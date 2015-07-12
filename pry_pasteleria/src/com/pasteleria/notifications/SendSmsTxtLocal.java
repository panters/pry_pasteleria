package com.pasteleria.notifications;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class SendSmsTxtLocal {
	
	
	//Servicio probado https://control.txtlocal.co.uk expira 12/05/15 salod:6
	
	
	public String sendSms() {
		try {
			// Construct data
			String user = "username=" + "leonxandercs@gmail.com";
			String hash = "&hash=" + "Leonxandercs3";
			String message = "&message=" + "Prueba de Envio de Sms desde Java...by tu papi  Alexander";
			String sender = "&sender=" + "Alexander	";
			String n2="51959228405";
			String numbers = "&numbers=" + "51954191116";

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
				System.out.println(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	
	public static void main(String[] args) {
		new SendSmsTxtLocal().sendSms();
	}
}