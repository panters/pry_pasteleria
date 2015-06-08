package com.pasteleria.notifications;

import java.text.SimpleDateFormat;
import java.util.Date;
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
/**
 * 
 * @author Pantera
 *
 */
public class Email implements Runnable{ //Implementamos de Runable para utilizarlo como Hilo
    
	private ResourceBundle rb=ResourceBundle.getBundle("com/pasteleria/resources/configMail");
	
    private String usuarioCorreo=rb.getString("cuenta");
    private String password=rb.getString("clave");
    
    private String rutaArchivo;
    private String nombreArchivo;
    
    private String destinatario;
    private String asunto;
    
    private String usuario;
    private String idpedido;
    
    //Constructores
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

    
    
   //Metodo implementado de la Interfaz Runable
	@Override
	public void run() {	
		boolean sendMail=sendMail();
		System.out.println("Email enviado: "+sendMail);
	}
    
	//Metodo que envia el Email
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
            //texto.setText(customMessage(usuario,idpedido));

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
            message.setText(customMessage(usuario, idpedido), "UTF-8", "html");

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
    
    
    //Metodo de plantilla de email
    
    public String customMessage(String usuario,String idPedido){
    	
    	Date date=new Date();
    	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
    	
    	String mensaje=rb.getString("plantilla");    	
    	mensaje=mensaje.replaceAll("usuario", usuario);
    	mensaje=mensaje.replaceAll("idpedido", idPedido);
    	mensaje=mensaje.replaceAll("date",String.valueOf(formato.format(date)));
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
