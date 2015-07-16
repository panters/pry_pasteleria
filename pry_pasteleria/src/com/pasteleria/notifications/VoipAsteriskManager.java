package com.pasteleria.notifications;

import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

public class VoipAsteriskManager
{
    private ManagerConnection managerConnection;
    //private final String SUCCESS="Success";
    //private final String ERROR="Error";
    private static final String[] STATUS={"Error","Success"};
    

    public VoipAsteriskManager() throws IOException
    {
        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                "192.168.1.40", "admin", "asterisk");

        this.managerConnection = factory.createManagerConnection();
    }

    
    
    
    
    @SuppressWarnings("deprecation")
	public void run() throws IOException, AuthenticationFailedException,
            TimeoutException
    {
    	
        OriginateAction originateAction;
        ManagerResponse originateResponse;
        String responseStatus="";
        
        /**************************************************************************
         * PRIORITYS:
         * ------------------------------------------------------------------------
         * 1=conecta llamda entre channel(first) y exten(last)
         * 2=llama a channel y emite grabacion de exten
         * 3=hangout
         * 
         **************************************************************************/
        
        originateAction = new OriginateAction();
        originateAction.setChannel("SIP/2002");//chanel a llamar
        originateAction.setContext("users");
        originateAction.setExten("5656"); //extensión
        originateAction.setCallerId("Master Java");
        originateAction.setPriority(new Integer(1));//Ejecuta Script IVR
        originateAction.setTimeout(new Integer(20000));
        
        // connect to Asterisk and log in
        managerConnection.login();
        
        System.out.println(managerConnection.getVersion());
        System.out.println("Estado: "+managerConnection.getState());
        
        
        int callAttemp=0;//intentamos llamar 3 veces en caso cuelgue o no conteste
        
        while (!responseStatus.equals(STATUS[1]) && callAttemp<=0) {
			
        	 // enviando el originate action y estableciendo el tiempo espera en  30 segundos 
            // to send a reply
            System.out.println("Llamando..");
            originateResponse = managerConnection.sendAction(originateAction, 30000);
            
        	 System.out.println("Mensaje: "+originateResponse.getMessage());
        	 
             // print out whether the originate succeeded or not
             System.out.println("obteniendo la respuesta: "+ originateResponse.getResponse());
             responseStatus=originateResponse.getResponse();
             callAttemp ++;
        	
		}

        //Finalmente log off and disconnect
        managerConnection.logoff();
    }

    
    @SuppressWarnings("deprecation")
	public boolean run(String celular){

		OriginateAction originateAction;
		ManagerResponse originateResponse;
		String responseStatus="";
		
		/**************************************************************************
		 * PRIORITYS:
		 * ------------------------------------------------------------------------
		 * 1=conecta llamda entre channel(first) y exten(last)
		 * 2=llama a channel y emite grabacion de exten
		 * 3=hangout
		 * 
		 **************************************************************************/
		
		originateAction = new OriginateAction();
		originateAction.setChannel("SIP/"+celular);//chanel a llamar
		originateAction.setContext("users");
		originateAction.setExten("5656"); //extensión
		originateAction.setCallerId("Pasteleria Encantadas");
		originateAction.setPriority(new Integer(1));//Ejecuta Script IVR
		originateAction.setTimeout(new Integer(20000));
		
		try {
			
	
		// connect to Asterisk and log in
		managerConnection.login();
		
		System.out.println(managerConnection.getVersion());
		System.out.println("Estado: "+managerConnection.getState());
		
		
		int callAttemp=0;//intentamos llamar 3 veces en caso cuelgue o no conteste
		
			while (!responseStatus.equals(STATUS[1]) && callAttemp<=0) {
				
				 // enviando el originate action y estableciendo el tiempo espera en  30 segundos 
			    // to send a reply
			    System.out.println("Llamando..");
			    originateResponse = managerConnection.sendAction(originateAction, 30000);
			    
				 System.out.println("Mensaje: "+originateResponse.getMessage());
				 
			     // print out whether the originate succeeded or not
			     System.out.println("obteniendo la respuesta: "+ originateResponse.getResponse());
			     responseStatus=originateResponse.getResponse();
			     callAttemp ++;
				
			}
		 //Finalmente log off and disconnect
		 managerConnection.logoff();
		
		} catch (IOException e1) {
			// TODO: handle exception
		}catch (AuthenticationFailedException e2) {
			// TODO: handle exception
		}catch(TimeoutException e3){
			// TODO: handle exception
		}
		
		if (responseStatus.equals(STATUS[1]))
			return true;
		  else
			return false;
		
}
    
    public static void main(String[] args) throws Exception
    {
        VoipAsteriskManager asteriskManager;

        asteriskManager = new VoipAsteriskManager();
        asteriskManager.run("954191116");
    }
    
    
}