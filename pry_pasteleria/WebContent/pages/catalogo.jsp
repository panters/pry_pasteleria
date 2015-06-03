<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<s:if test="hasActionMessages()">
	<s:actionmessage id="messageSucces" />
	<script>
		var msj = $('#messageSucces li span').text();
		$('#messageSucces').remove();
		$.growl(
			{
				title:" <strong>! Bienvenido</strong> a Tortas Encantadas: ",
				message:msj+" <strong>!</strong>",
				icon:"glyphicon glyphicon-thumbs-up"
			},{
				type:'success'
			}
		  );
	</script>
</s:if>
<script>
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
		        if (validatenumber()) {
		          subtotal.text(number);
		        };
		   });
				
		  
		   function validatenumber(){
			    $("#myModal input[type=number]").keyup(function(){
			      if (!patron.test(this.value)) {
			        alert('numero invalido,no se permite decimales ni negativos');
			        this.value=1;
			        subtotal.text(precio);
			        console.log('mensaje:keyup');
			        return false;
			      }
			     // return true;
			   });
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
				
		var containerProducto='<div class="col-xs-6 col-sm-3 col-md-3 col-lg-2">'+
		'<div id="'+position+'" class="thumbnail calex">'+
		imagen+
		'<div class="caption">'+
			'<h3>'+label.charAt(0)+label.slice(1).toLowerCase()+'</h3>'+
			'<p>El pastel de '+label.toLowerCase()+', tiene como base lo mejor de nuestros '+masa+
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
					row.html('<h3>Ningún productos coincide con el criterio de búsqueda</h3>');
				else
				getProductsGrid(products);//recargamos la grilla con los productos encontrados
			}
			
		});
		return false;
	});
		   
   /*Este metodo ya no se utiliza -- era para enviar el producto como data JSON a el action
   lo mantengo como modelo  para posible  uso posterior
   
   $('#addToCart').click(function(event){
	   
	   var datos=$('#myModal').data("dataproducto");
	   cantidad=$('#myModal input[type=number]').val();  
	   var agazajado=$('#agazajado').val();
	   var dedicatoria=$('#dedicatoria').val();
	   var fecha=$('#fecha').val();			
	   
	   comprar(datos,cantidad,agazajado,dedicatoria,fecha);
	   $('#myModal').modal('hide');
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

</script>

 <div class="row col-xs-12  col-sm-12  col-md-12  col-lg-12">
	
					
		<div class="col-xs-12  col-sm-2  col-md-2  col-lg-2">
			<s:form id="formFiltros" theme="bootstrap" method="post" action="filterProduct">
	    			<s:url id="URL_ListCategorys" action="listCategory"/>
					<sj:select cssClass="form-control"
					id="cbocategoria" 
					label="Categoria :"
					list="categorias"
					listKey="idCategoria"
					listValue="descripcion"
					href="%{URL_ListCategorys}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.categoria.idCategoria" />
	    	 
			 
	    		<s:url id="URL_ListCoverages" action="listCoverage"/>
				<sj:select cssClass="form-control" 
					id="cbocobertura" 
					label="Cobertura :"
					list="coberturas"
					listKey="idCobertura"
					listValue="descripcion"
					href="%{URL_ListCoverages}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.cobertura.idCobertura" />
	    	 
	    		<s:url id="URL_ListDoughs" action="listDough"/>
				<sj:select cssClass="form-control"
					id="cbomasa" 
					label="Masa :"
					list="masas"
					listKey="idMasa"
					listValue="descripcion"
					href="%{URL_ListDoughs}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.masa.idMasa" />
	    	 
	    		<s:url id="URL_ListFillings" action="listFilling"/>
				<sj:select cssClass="form-control"
					id="cborelleno" 
					label="Relleno :"
					list="rellenos"
					listKey="idRelleno"
					listValue="descripcion"
					href="%{URL_ListFillings}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.relleno.idRelleno" />
			<br/>					   
			<s:submit value="Consultar Producto" cssClass="btn btn-primary col-xs-12"/>
		</s:form>
		</div><!-- fin filtros -->

		<div class="panelalex col-xs-12  col-sm-10  col-md-10  col-lg-10">	

		</div> <!-- Fin panel--> 
	
</div>  <!-- Fin Row -->



<!------------------------------------------------ -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="myModalLabel">Modal title</h3>
			</div>

		 <s:form theme="bootstrap"  action="addToCarrito" method="post" acceptcharset="UTF-8" id="formComprar" cssClass="form animate-form">
		 	<s:hidden id="idProducto" name="orderDetail.producto.idProducto"/>
		 	<s:hidden id="pdescripcion" name="orderDetail.producto.descripcion"/>
		 	<s:hidden id="pprecio" name="orderDetail.producto.precio"/>
		 	<s:hidden id="pimagen" name="orderDetail.producto.image_resource"/>
		 	<s:hidden id="pcobertura" name="orderDetail.producto.cobertura.descripcion"/>
		 	<s:hidden id="pmasa" name="orderDetail.producto.masa.descripcion"/>
		 	<s:hidden id="prelleno" name="orderDetail.producto.relleno.descripcion"/>
		 	
			<div class="modal-body">
				<div class="alex col-xs-12 col-sm-5 col-md-5 col-lg-5">
					<img src="">
				</div>
				
				<div class="alex col-xs-12 col-sm-7 col-md-7 col-lg-7">
					<table class="detaAC">
						<tr>
							<td>Cantidad</td>
							<td><s:textfield type="number" name="orderDetail.cantidad" min="1" max="7" /></td>
						</tr>
						<!-- 
						<tr>
							<td>Nombre Agazajado:</td>
							<td>
								<div class="form-group has-feedback">
								<s:textfield id="agazajado"  cssClass="form-control" name="orderDetail.nombre_agasajado"/>
								<span	class="glyphicon glyphicon-ok form-control-feedback"></span>
								</div>
							</td>
						</tr>
						
						<tr>
							<td>Dedicatoria:</td>
							<td>
							<div class="form-group has-feedback">
							<s:textfield id="dedicatoria"  cssClass="form-control" name="orderDetail.dedicatoria"/>
							<span	class="glyphicon glyphicon-ok form-control-feedback"></span>
							</div>
							</td>
						</tr>
						<tr>
							<td>Fecha de Entrega:</td>
							<td>
								<div class="form-group has-feedback">
								<div class="input-group date">
								<s:textfield id="fecha"  cssClass="form-control" name="orderDetail.fec_requerimiento"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i>
									</span>
								</div>
								</div>
							</td>
						</tr>
						 -->
						<tr>
							<td><font size="5">Precio:</font></td>
							<td><font size="6">S/.</font><font size="6" id="price">60.00</font></td>
						</tr>
					</table>
				</div>

			</div>

			<div class="modal-footer alexito">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<s:submit value="Agregar al Carrito" cssClass="btn btn-primary"/>
			</div>
			
		</s:form>
		</div>
	</div>
</div>
  
