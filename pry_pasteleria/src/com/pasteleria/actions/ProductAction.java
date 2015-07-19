package com.pasteleria.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.mail.Session;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pasteleria.bean.Product;
import com.pasteleria.bean.User;
import com.pasteleria.notifications.Email;
import com.pasteleria.services.ServiceProduct;
import com.pasteleria.util.SaveFile;

@ParentPackage(value="cloudedleopard")
public class ProductAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session=(Map<String,Object>)ActionContext.getContext().getSession();
	
	private List<Product> productos;
	private Product producto;
	private File archivo;
	private String archivoContentType;
	private String archivoFileName;
	private int mantenimiento;
	private double cotiprice;
			
	private String imagen;
	
	@Action(value="sendCotizacion",results={@Result(name="success",type="json")})
	public String cotizar(){
		
		String res=this.imagen;		
		//obtenemos solo el contenido en Base64
		String imageDataBytes =res.substring(res.indexOf(",")+1);
	
		String plantilla=ResourceBundle.getBundle("com/pasteleria/resources/configMail").getString("cotizar");
		
		if(session.get("user")!=null){
			User obj=(User)session.get("user");
			plantilla=plantilla.replace("FECHA",new SimpleDateFormat("dd-mm-YYY").format(new Date()));
			plantilla=plantilla.replace("CODIGO",obj.getIdUsuario());
			plantilla=plantilla.replace("CLIENTE",obj.getNombre()+"-"+obj.getApe_pa());
			plantilla=plantilla.replace("PRECIO",this.cotiprice+"");
			
			Email e=new Email("leonxandercs@gmail.com", imageDataBytes, new String[]{plantilla});
			new Thread(e).start();
		}else{
			session.put("dct",this.imagen);
			session.put("pct",this.cotiprice);
		}
		
		/*
		 byte[] decoded = Base64.getDecoder().decode(imageDataBytes);
		 ByteArrayImage.writeImageFromArrayBytes(decoded);
		 Email e=new Email("C:\\Files\\destino\\imgTest.png","cotizacion","leonxandercs@gmail.com","cotizacion","prueba",true);
		*/
	    
		
		this.imagen=res;
		return SUCCESS;
	}
	
	
	@Action(value="listProduct",results={@Result(name="success",type="json")})
	public String list(){
		if(mantenimiento!=0)
		  productos=new ServiceProduct().list(false);
		else
		  productos=new ServiceProduct().list(true);
		return SUCCESS;
	}
	
	@Action(value="findProduct",results={@Result(name="success",type="json")})
	public String find(){
		producto=new ServiceProduct().find(producto);
		return SUCCESS;
	}
		
	
	
	@Action(value="saveProduct",results={@Result(name=SUCCESS,type="redirectAction",location="mproduct")})
	public String cargar(){
		//Validamos si se cargo algun archivo al input File si se cargo se actualiza imagen 
		//con el archivo nuevo si no se cargo nada se mantiene la imagen original
		boolean uploaded=false;
		
		if (archivo!=null) {
			uploaded=new SaveFile().save(this.archivo,this.archivoFileName);
			this.producto.setImage_resource(archivoFileName);
		}else{
			Product obj=(new ServiceProduct().find(producto));
			//Si el producto existe y no se cargo imagen no se remplaza,sino existe se registra como vacio
			this.producto.setImage_resource(obj!=null?obj.getImage_resource():"vacia");
		}
		
		
		if (producto.getIdProducto()==0)
			new ServiceProduct().create(this.producto);
		else
			new ServiceProduct().update(this.producto);
		
		System.out.println("uploaded: "+uploaded);
		System.out.println(this.archivoContentType);
		
		return SUCCESS;
	}
	
	
	@Action(value="deleteProduct",results={@Result(name="success",type="redirectAction",location="mproduct")})
	public String delete(){
		new ServiceProduct().delete(producto);
		return SUCCESS;
	}

	@Action(value="filterProduct",results={@Result(name="success",type="json")})
	public String filter(){
		this.productos=new ServiceProduct().filter(
					producto.getCategoria().getIdCategoria(),
					producto.getCobertura().getIdCobertura(),
					producto.getMasa().getIdMasa(),producto.getRelleno().getIdRelleno()
					);
		System.out.println("Product  filter was invoked");
		return SUCCESS;
	}
	
	
	
	
	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public String getArchivoContentType() {
		return archivoContentType;
	}

	public void setArchivoContentType(String archivoContentType) {
		this.archivoContentType = archivoContentType;
	}

	public String getArchivoFileName() {
		return archivoFileName;
	}

	public void setArchivoFileName(String archivoFileName) {
		this.archivoFileName = archivoFileName;
	}

	public int getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(int mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public double getCotiprice() {
		return cotiprice;
	}
	public void setCotiprice(double cotiprice) {
		this.cotiprice = cotiprice;
	}
	
	
}
