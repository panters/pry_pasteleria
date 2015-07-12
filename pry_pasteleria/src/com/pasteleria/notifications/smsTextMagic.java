package com.pasteleria.notifications;


import java.util.Calendar;
import java.util.GregorianCalendar;

import com.textmagic.sms.TextMagicMessageService;
import com.textmagic.sms.exception.ServiceException;

public class smsTextMagic {
	
	public Calendar fecha=new GregorianCalendar();
	public String hora;
	
	{
		this.hora = fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE);
		
	}
	
	//Probado y funcionando expira en 26/04/15 https://my.textmagic.com !
	
    public static void main (String []argz) {
    	
    	String hora=new smsTextMagic().hora;
    	System.out.println(hora);
        
    	String dummyPhone = "51954191116";
          TextMagicMessageService service =
            new TextMagicMessageService ("luis.montalvan@htw.com.pe","leonxandercs3");
          try {
               service.send("Hello this Message was sending from java aplication"+hora, dummyPhone);
               System.out.println("Enviado");
          }catch(ServiceException ex) {
               System.out.println(" :-( ");
          }catch(Exception e){
        	  e.printStackTrace();
          }
          
    	
    }
    
    
}