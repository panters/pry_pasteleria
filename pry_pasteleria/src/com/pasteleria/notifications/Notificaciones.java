package com.pasteleria.notifications;

import java.io.IOException;

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
		System.out.println("Envio email: "+notifyMail());
		//System.out.println(notifySms());
		//System.out.println(notifySmsMagic());
		System.out.println(notifyCall());
	}
	
	
	@SuppressWarnings("unused")
	private boolean notifySms(){
		return new SendSmsTxtLocal().sendSms(celular,nombre,apepa+" "+apema, idPedido);
	}
	
	@SuppressWarnings("unused")
	private boolean notifySmsMagic(){
		return new smsTextMagic().sendSms(celular,nombre,apepa+" "+apema, idPedido);
	}
	
	private boolean notifyCall(){
		boolean result=false;
		try {
			result=new VoipAsteriskManager().run(this.celular);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		new Notificaciones("2002","leonxandercs@gmail.com","nombre","apepa","apema","idPedido").run();
	}

}
