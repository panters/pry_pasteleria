package com.pasteleria.notifications;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.PreencodedMimeBodyPart;
import javax.mail.util.ByteArrayDataSource;
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
    private String body;
    private boolean recuperarClave=false;
    
    private String mensaje;
    private String usuario;
    private String idpedido;
    @SuppressWarnings("unused")
	private boolean cotizar;
    private String imageBase64;
    private String plantilla[];
    //Constructores
    public Email(String rutaArchivo, String nombreArchivo, String destinatario,String usuario,String idpedido) {
         this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.destinatario = destinatario;
        this.asunto = "Registro de Pedido";
        this.usuario=usuario;
        this.idpedido=idpedido;
    }
    
    
    public Email(String rutaArchivo, String nombreArchivo, String destinatario, String asunto,String mensaje,boolean cotizar) {
        this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.cotizar=cotizar;
    }
    
    
    public Email(String destinatario,String usuario,String idpedido){
        this("", "", destinatario, usuario, idpedido);
    }
    
    public Email(String destinatario,String asunto,String usuario,String idpedido){
        this("","",destinatario,usuario,idpedido);
        this.asunto=asunto;
    }    

    public Email(String destinatario,String body,boolean recuperarClave){
    	this.destinatario=destinatario;
    	this.body=body;
    	this.recuperarClave=recuperarClave;
    }
    
    public Email(String destinatario,String imageBase64,String plantilla[]){
    	this.destinatario=destinatario;
    	this.imageBase64=imageBase64;
    	this.plantilla=plantilla;
    }
    
   //Metodo implementado de la Interfaz Runable
	@Override
	public void run(){	
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
            props.put("mail.imaps.partialfetch", false);

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            

            BodyPart adjunto = new MimeBodyPart();
            
            if ( rutaArchivo!=null ){
            	
            	if(!rutaArchivo.equals("") || rutaArchivo.length()>1){
            		adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
                    adjunto.setFileName(nombreArchivo);  
                    
                    texto.setText(this.mensaje);
            	}
                               
            }
            
            if(this.imageBase64!=null){
            	 texto.setText(this.plantilla[0]);
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (rutaArchivo!=null){
            	if(!rutaArchivo.equals("")){
            		multiParte.addBodyPart(adjunto);
            	}
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            
            
            if (recuperarClave) {
            	message.setSubject("Recupera tu Contrseña");
            	message.setContent(multiParte);
            	message.setText("<h4>Contraseña Recuperada</h4><p>"+this.body+"</p>", "UTF-8", "html");
			}else{
				if(this.imageBase64!=null){
					MimeBodyPart filePart =  new  PreencodedMimeBodyPart( "base64" ); 
			        filePart.setText ("agregado");
					message.setSubject("Cotización de Torta personalizada");
					multiParte.addBodyPart(addAttachment("diseño de torta",this.imageBase64));
		            message.setContent(multiParte);
				}else{
					message.setSubject(asunto);
		            message.setContent(multiParte);
		            if(this.rutaArchivo==null || this.rutaArchivo.isEmpty() || this.rutaArchivo.equals(""))
		            message.setText(customMessage(usuario, idpedido), "UTF-8", "html");
				}
			}
            
           
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

    @SuppressWarnings("resource")
	private MimeBodyPart addAttachment(final String fileName, final String fileContent) throws MessagingException {
        if (fileName == null || fileContent == null) {
            return null;
        }
 
        MimeBodyPart filePart = new MimeBodyPart();

        String data = fileContent;
        DataSource ds;
        InputStream in = new ByteArrayInputStream(data.getBytes());
        try {
            in = MimeUtility.decode(in, "base64");
            try {
                ds = new ByteArrayDataSource(in , "image/*");
            } finally {
                in.close();
            }
        } catch (IOException ioe) {
            throw new MessagingException(fileName, ioe);
        }

        // "image/*"
        filePart.setDataHandler(new DataHandler(ds));
        filePart.setFileName(fileName);
 
        return filePart;
    }
    
    
    
    public static void main(String[] args){
        
      
    	 //Email e = new Email("C:\\Users\\Pantera\\Downloads\\emblema.jpg","adjunto.jpg","leonxandercs@gmail.com","Adjunto","Prueba del tutorial para mandar un email");
    	 Email e=new Email("C:\\Files\\destino\\imgTest.png","cotizacion","leonxandercs@gmail.com","cotizacion","prueba",true);
 		
    	 //Email e=new Email("leonxandercs@gmail.com", "Tu claves es 123456",true);
   
        if (e.sendMail()){
        	System.out.println("Envio correcto");
        }else{
            System.out.println("envio fallido");
        }
        
    }



}
