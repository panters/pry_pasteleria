package com.pasteleria.util;

import com.pasteleria.notifications.Notificaciones;

public class Test {

	
	public static void main(String[] args) {
		
		Notificaciones 	notifi=new Notificaciones("954191116","leonxandercs@gmail.com","alexander","chavez","simbron","P0001");
		new Thread(notifi).start();
		
	}
	
	
	
}



