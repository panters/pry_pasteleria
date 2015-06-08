/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteleria.notifications;

/**
 *
 * @author Sanlegas
 */
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
    
	private ResourceBundle rb=ResourceBundle.getBundle("com/pasteleria/resources/configMail");
	
    private String usuarioCorreo=rb.getString("cuenta");
    private String password=rb.getString("clave");
    
    private String rutaArchivo;
    private String nombreArchivo;
    
    private String destinatario;
    private String asunto;
    
    private String usuario;
    private String idpedido;
    
    public Email(String rutaArchivo, String nombreArchivo, String destinatario,String usuario,String idpedido) {
         this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.destinatario = destinatario;
        this.asunto = "Registro de Pedido";
        this.usuario=usuario;
        this.idpedido=idpedido;
    }
    
    public Email(String destinatario,String usuario,String idpedido){
        this("", "", destinatario, usuario, idpedido);
    }
    
    public Email(String destinatario,String asunto,String usuario,String idpedido){
        this("","",destinatario,usuario,idpedido);
        this.asunto=asunto;
    }    

    
    
    public boolean sendMail(){
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(customMessage(usuario,idpedido));

            BodyPart adjunto = new MimeBodyPart();
            if (!rutaArchivo.equals("") || rutaArchivo!=null || rutaArchivo.length()<1){
                 adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
                adjunto.setFileName(nombreArchivo);                
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!rutaArchivo.equals("")){
                multiParte.addBodyPart(adjunto);
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }        
    }
    
    public String customMessage(String usuario,String idPedido){
    	
    	String mensaje="Estimado Cliente "+usuario+"\n"+
    				   "Su pedido ha sido registrado con el codigo: "+idPedido+
    				   "\n"+"Saludos"+
    				   "\n\n"+"Tortas Encantadas"+"\n"+"Telefono:954191116"+
    				   "\n"+"Av.Carlo izaguirre N�3040";
    				   ;
    	return mensaje;
    }
    
    
    
    public static void main(String[] args){
        
      
        Email e = new Email("C:\\Users\\Pantera\\Downloads\\emblema.jpg","adjunto.jpg","leonxandercs@gmail.com","Alexander Chavez","P00001");
  
        if (e.sendMail()){
        	System.out.println("Envio correcto");
        }else{
            System.out.println("envio fallido");
        }
        
    }

}