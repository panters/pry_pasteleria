package com.pasteleria.notifications;

import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.TimeoutException;

public class Notificaciones implements Runnable {

	
	private String celular;
	private String email;
	private String nombre;
	private String apepa;
	private String apema;
	private String idPedido;
	
	public Notificaciones(String celular,String email, String nombre, String apepa,String apema, String idPedido) {
		this.celular=celular;
		this.email = email;
		this.nombre = nombre;
		this.apepa = apepa;
		this.apema = apema;
		this.idPedido = idPedido;
	}


	@Override
	public void run() {
		notifyMail();
		notifyCall();
	}
	
	
	private boolean notifyCall(){
		boolean result=false;
		try {
			result=new VoipAsteriskManager().run(this.celular);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	private  boolean notifyMail(){
		
		Email email=new Email(this.email,
				this.nombre+" "
		 		+this.apepa+" "
		 		+this.apema,this.idPedido);
		
		return email.sendMail();
		
	}
	
	public static void main(String[] args) {
		new Notificaciones("2002","leonxandercs@gmail.com","nombre","apepa","apema","idPedido");
	}

}
