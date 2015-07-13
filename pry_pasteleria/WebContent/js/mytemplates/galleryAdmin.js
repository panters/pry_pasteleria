/**
 * Archivo Javascript que se ejecuta al cargar el Catalogo de Productos
 */

var row;
var products;
var childRow='ola soy un virus';

$(document).ready(function(){	
	
	row=$('.panelalex'); //obtenemos el panel
	row.html(''); //limpiamos el panel que contiene la grilla de productos

			var cantidad=1;
			var precio=0;
			var patron = /^\d*$/; //patron de validacion numerica
		    var subtotal=$("#price");
		    var datos;
		       
		  $("#myModal input[type=number]").change(function(){
		        var number=this.value*precio;
		        number=Math.round(number * 100) / 100;
		        if (validatenumber(this)) {
		          subtotal.text(number);
		        };
		   });
				
		  
		  $("#myModal input[type=number]").keypress(function(e){
		    	e.preventDefault();
 	    	  alert('Escritura deshabilitada, utilize los indicadores para cambiar la cantidad');
		   });
		  
		   function validatenumber(element){
			      if (!patron.test(element.value)) {
			        alert('numero invalido,no se permite decimales ni negativos');
			        this.value=1;
			        subtotal.text(precio);
			        return false;
			      }
		     return true;
		   }
		   

    $.getJSON('listProduct',function(data){
		//recuperamos el array de productos
		products=data.productos;
		//llenamos la grilla de productos
		getProductsGrid(products);
	});
			
    function getProductsGrid(products){
    	
		for (var i = 0; i <products.length; i++) {
			//declaramos una variable producto
			var producto=(products[i]);
			
			var imagen='<img src="verImagen?imagenName='+producto.image_resource+'" width="200" alt="134x180"/>'
			//almanecamos la info del producto[i] en un JSON
		    var datos={"torta":{
				"idx":i,
				"idProducto":producto.idProducto,
				"label":(producto.descripcion).toUpperCase(),
				"imagen":producto.image_resource,
				"precio":producto.precio,
				"cobertura":producto.cobertura.descripcion,
				"masa":producto.masa.descripcion,
				"relleno":producto.relleno.descripcion
	           }
     		 };	
			//agregamos el producto al catalogo
			row.append(agregaProductContainer(i,datos.torta.label, imagen, datos.torta.precio, 
			datos.torta.cobertura,datos.torta.masa,datos.torta.relleno));
			
			//le asignamos la data respectiva al container html producto
			var currentProduct=$('.thumbnail').eq(i);
			$(currentProduct).data("dataproducto",datos);
			
		}
    }

	function agregaProductContainer(position,label,imagen,precio,cobertura,masa,relleno){
				
		var containerProducto='<div class="col-xs-6 col-sm-4 col-md-4 col-lg-3">'+
		'<div id="'+position+'" class="thumbnail calex">'+
		imagen+
		'<div class="caption">'+
			'<h3 style="height: 50px;">'+label.charAt(0)+label.slice(1).toLowerCase()+'</h3>'+
			'<p style="height: 150px;">El pastel de '+label.toLowerCase()+', tiene como base lo mejor de nuestros '+masa+
			' con una cobertura de '+cobertura+' y un exquisito relleno de '+relleno+'.</p>'+
				'<p class="palex">'+
				'<a href="#" class="btn btn-primary">Agregar al Carrito</a>'+
				'</p>'+
		'</div>'+
		'</div>'+
		'</div>';
			
		return containerProducto;
	}
	
 	console.log('ready - gallery loaded successfully');

		   
		   
   //evento para agregar producto al carrito
   $('.panelalex').on('click','.caption p a',function(){
       var modal=$("#myModal");
       	 limpiarfields();
         updateModal(this);
         modal.modal('show');
   	});
		  
   //llena el modal con los datos del producto seleccionado
   function updateModal(elemento){
	   
	 var father=$(elemento).parent("p").parent(".caption").parent(".thumbnail");

     datos=$(father).data("dataproducto");
     precio=datos.torta.precio;  
	 
     var img=$(father).find('img').clone();
	 $(img).attr('width','100%');
	 $('#myModal h3').text(datos.torta.label.charAt(0)+datos.torta.label.slice(1).toLowerCase());
	 $('#myModal input[type=number]').val(cantidad);
	 $("#myModal .modal-body img").replaceWith(img);
	 $('#price').text(datos.torta.precio);
	 
	 $('#idProducto').val(datos.torta.idProducto);
	 $('#pdescripcion').val(datos.torta.label.charAt(0)+datos.torta.label.slice(1).toLowerCase());
	 $('#pprecio').val(datos.torta.precio);
	 $('#pimagen').val(datos.torta.imagen);
	 
	 $('#pcobertura').val(datos.torta.cobertura);
	 $('#pmasa').val(datos.torta.masa);
	 $('#prelleno').val(datos.torta.relleno);
    // ya no es necesario
    //$('#myModal').data("dataproducto",datos);
   }
	
   
 	//Clean Fields
   function limpiarfields(){
		/* Limpiar el Validate */
	    $('.modal-body .form-group').removeClass('has-error');
	    $('.modal-body .form-group').removeClass('has-success');
	    $(".help-block").hide();
	    $(".modal-body .form-control-feedback").removeClass('.glyphicon glyphicon-ok');
	    /* Limpiar el Modal */
		var modal =$('#myModal');
		modal.find('.modal-body input').val('');
	}
   
   
   // Interceptamos el evento submit enviar el producto al carrito por Ajax
   $('#formComprar').submit(function(e){
	   e.preventDefault();
	   //detenemos el evento para validar el form
	   var $form=$(this);
	   if (! $form.valid()) {
			return false;
		  //si no es valido no hacemos nada
		}else{
			
			 $('#myModal').modal('hide');
			// Enviamos el formulario usando AJAX
			  $.ajax({
				  type:'POST',
				  url:$(this).attr('action'),
				  data:$(this).serialize(),
			  	  //capturamos el resultado
			  	  success:function(data){
			  		//Mostramos un mensaje
			  		$.growl(
			  				{
			  					title:"<strong> Producto</strong>",
			  					message:" agreado al carrito",
			  					icon:"glyphicon glyphicon-shopping-cart"
			  				},{
			  					type:'info'
			  				}
			  			  );
			  	  }
			  	});
		}
	 
	
	   return false;
   });
   
   //Filtrado de productos segun diversos criterios
   $('#formFiltros').submit(function(){
		$.ajax({
			url:$(this).attr('action'),
			type:'POST',
			datatype:'json',
			data:$(this).serialize(),
			success:function(json){
				row.html('');//limpiamos la grilla de productos
				products=json.productos;
				if(products.length==0)
					row.html('<h3>Ning&uacute;n productos coincide con el criterio de b&uacute;squeda</h3>');
				else
				getProductsGrid(products);//recargamos la grilla con los productos encontrados
			}
			
		});
		return false;
	});
		   
 
  /* 
   function comprar(datos,cantidad,agazajado,dedicatoria,fecha){
		
	 	var parametros=new Object();
	 	parametros.idPedidoCabe=1;
	 	parametros.producto={
	 				idProducto:datos.torta.idProducto,
	 				descripcion:datos.torta.label.charAt(0)+datos.torta.label.slice(1).toLowerCase(),
	 				precio:datos.torta.precio
	 				};
	 	parametros.dedicatoria=dedicatoria;
	 	parametros.nombre_agasajado=agazajado;
	 	parametros.fec_requerimiento=fecha;
	 	parametros.cantidad=cantidad;
	 		
	 var orderDetail=JSON.stringify(parametros);
	 	
	 $.ajax({
		url:"addToCarrito.action",
		type:"post",
		datatype:"json",
		contentType:'application/json;charset-utf-8',
		data:orderDetail,
		
		success:function(result){
			alert('Se agrego al Carrito');
		}
 	});
		
	}  */
		   
	

	
});