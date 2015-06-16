/**
 * Archivo Javascript que se ejecuta al cargar el carrito de Compras
 */
$(document).ready(function(){
	
	var patron = /^\d*$/; //patron de validacion numerica
	var lista=[];
	var datos=[];
	var total;
	
	//Evita la escritura en los input[type=number] para que solo se modifique cantidad con las flechitas
	$('#cart tbody').on('keypress','#txtCantidad',function(e){
		e.preventDefault();
		alert('Escritura deshabilitada, utilize los indicadores para cambiar la cantidad');
	});
	
	
	$('#continuarSteptwo').attr('disabled',true);
	
	var logueado='false';
	//Cosultamos al servidor si el usuario esta logueado
	$.get("isLogged.action",function(data){
		logueado=data.logged;
	});
	
	//Registro del Pedido
	$('#formRegPedido').submit(function(event){
		event.preventDefault();
		if (logueado=='false')
			window.location.href="logueo.action";
		else{
			
			$.ajax({
				url:$(this).attr('action'),
				type:"post",
				datatype:"json",
				data:$(this).serialize(),
				success:function(data){
					$.growl(
						{
							title:" <strong>Pedido: "+data.order.idPedidoCabe+"</strong> ",
							message:"Registrado exitosamente..!",
							icon:"glyphicon glyphicon-thumbs-up"
						},{
							type:'success'
					   });
					setTimeout(function(){window.location.href="seguimiento.action";},3000);
				}
			 });
		}
		return false;
	});
	

	$('#cartDetail tbody').html('');
	
	 $('#setptwo').hide();
	 
	//Continuar con Pedido solo si esta Logueado y Actualiza las grillas de detalles luego las muestra
	 $('#continuarSteptwo').click(function(){
		 if (logueado=='false')
				window.location.href="logueo.action";
	     loadDetailFields();
		 $('#stepone').fadeOut(1000);
		 $('#setptwo').fadeIn(3000);
		 
	});
	
	 //Boton volver
	 $('#volver').click(function(){
		 $('#setptwo').hide();
		 $('#stepone').fadeIn();
		 
	});
	
	//Oculta las filas al dar omitir
	$('#cartDetail').on('click','#skipRow',function(){
		$(this).parent().parent().parent().parent().hide();
	});
	

	
	//Evento de modificación de cantidad: actualiza la cantidad,subtotoal y total en el carrito y la sessión
	$('#cart tbody').on('change','#txtCantidad',function(){
		
		//var idProd=$(this).parent().parent().children().eq(0).children().eq(0).val();
		var idProd=$(this).parents('tr').children().eq(0).children().eq(0).val();
		var cant=$(this).val();	
		
		var precio=$(this).parents('tr').children().eq(1).html();
		precio=new String(precio).substring(3,precio.length);
		
		var subt=$(this).parents('tr').children().eq(3);
		
		console.log('cambie d enumero');
		
		//Actualizamos el carrito
		$.ajax({
			url:"updateItemCart",
			type:"post",
			datatype:"json",
			data:{idProducto:idProd,cantidad:cant},
			success:function(data){
				var num=data.total;
				subt.html("S/."+ Math.round((precio*cant)*100)/100);
				num=Math.round(num * 100) / 100;
				$('.txtTotal').text(num);
			}
		});
		
	});
	
	//Función que actualiza las grillas del carrtio
	function loadDetailFields(){
		$('#cartDetail tbody').html('');
		$.getJSON('listCart.action',function(data){			
			lista=data.currentOrder;
			var k=0;
			for (var i = 0; i < lista.length; i++) {
				var detalle=(lista[i]);
				 datos[i]={"torta":{
						"idProducto":detalle.producto.idProducto,
						"label":detalle.producto.descripcion,
						"cantidad":detalle.cantidad,
						"precio":detalle.producto.precio
			           }
		     		 };	
				for (var j = 0; j < datos[i].torta.cantidad; j++) {
					$('#cartDetail tbody').append(addFieldDetail(i,k));
					k++;
				}
				
			}
		});		
	}
	
	// Crea los fields para ingresar el detalle  envía los datos como un Array al servidor mediante un POST Ajax
	function addFieldDetail(i,j){
		
		return '<tr>'+
		'<td>'+datos[i].torta.idProducto+'</td>'+
	    '<td>'+datos[i].torta.label+'</td>'+
	    
	    '<td style="display:none;">'+
		'<div class="form-group has-feedback">'+
	    '<input type="text" class="form-control" name="orderDetail['+j+'].producto.idProducto" value='+datos[i].torta.idProducto+' />'+
	    '<span	class="glyphicon glyphicon-ok form-control-feedback"></span>'+
		'</div>'+
		'</td>'+
		
		'<td style="display:none;">'+
		'<div class="form-group has-feedback">'+
	    '<input type="text" class="form-control" name="orderDetail['+j+'].producto.precio" value='+datos[i].torta.precio+' />'+
	    '<span	class="glyphicon glyphicon-ok form-control-feedback"></span>'+
		'</div>'+
		'</td>'+
	    
	    '<td>'+
		'<div class="form-group has-feedback">'+
	    '<input type="text" class="form-control" name="orderDetail['+j+'].nombre_agasajado"  pattern="[A-Za-z ]+" >'+
	    '<span	class="glyphicon glyphicon-ok form-control-feedback"></span>'+
		'</div>'+
		'</td>'+
	    
	    '<td>'+
		'<div class="form-group has-feedback">'+
		'<input type="text" class="form-control" name="orderDetail['+j+'].dedicatoria" pattern="[A-Za-z ]+" >'+
	    '<span	class="glyphicon glyphicon-ok form-control-feedback"></span>'+
		'</div>'+
		'</td>'+
	    '<td>'+
		'<div class="form-group has-feedback">'+
		'<div class="input-group date">'+
		'<input type="text" class="form-control" id="fechita" name="orderDetail['+j+'].fec_requerimiento" pattern="\\d{1,2}/\\d{1,2}/\\d{4}" required="true" />'+
			'<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i>'+
			'</span>'+
		'</div>'+
		'</div>'+
	    '</td>'+
	    '<td>'+/*
	    '<div class="form-group has-feedback">'+
	    '<div class="btn-group btn-group-xs" role="group" aria-label="Extra-small button group">'+
	      '<button id="skipRow" type="button" class="btn btn-default">Omitir</button>'+
	    '</div></div>'+
	    '</td>'+*/
	    '</tr>';
	}
	
	
	
	 actualizarGrillar();
			 	 
	//Funcion para listar el carrito con la ultima data guardada en la sessión(Actualiza todos los productos del carrito)
	function actualizarGrillar(){

		$.getJSON('listCart.action',function(data){
			total=data.total;
			total=Math.round(total * 100) / 100;
			$('.txtTotal').text(total);//setteamos el total al campo para que se muestre
			
			lista=data.currentOrder;		
			
			if (lista.length<1 || lista==null) {
				$('#continuarSteptwo').attr('disabled',true);
			}else{
				$('#continuarSteptwo').attr('disabled',false);
			}
			
			$('#cart tbody').html('');
			
			for (var i = 0; i < lista.length; i++) {
				//declaramos una variable de un objeto
				var detalle=(lista[i]);
				
				//var imagen='<img src="verImagen?imagenName='+detalle.producto.image_resource+'" width="200" alt="134x180"/>';
				var imagen='<img src="verImagen?imagenName='+detalle.producto.image_resource+'"width=100% alt="..." class="img-responsive"/>';
				//almanecamos la info del producto[i] en un JSON			
			    datos[i]={"torta":{
							"idx":i,
							"idProducto":detalle.producto.idProducto,
							"label":detalle.producto.descripcion,
							"imagen":imagen,
							"precio":detalle.producto.precio,
							"cantidad":detalle.cantidad,
							"subTotal":detalle.subTotal,
							"fec_requerimiento":detalle.fec_requerimiento,
							"cobertura":detalle.producto.cobertura.descripcion,
							"masa":detalle.producto.masa.descripcion,
							"relleno":detalle.producto.relleno.descripcion
				           }
			     		 };	
				
				var fila='<tr>'+
				'<td data-th="Product">'+
				 '<input type="hidden" value="'+datos[i].torta.idProducto+'"/>'+
				 '<div class="row">'+
						'<div class="col-sm-4 col-xs-12">'+imagen+'</div>'+
						'<div class="col-sm-8">'+
							'<h4 class="nomargin">Producto '+datos[i].torta.idProducto+'-'+datos[i].torta.label+'</h4>'+
							'<p>El pastel de '+datos[i].torta.label+', tiene como base lo mejor de nuestros '+datos[i].torta.masa+
							' con una cobertura de '+datos[i].torta.cobertura+' y un exquisito relleno de '+datos[i].torta.relleno+'.</p>'+
						'</div>'+
					'</div>'+
				'</td>'+
				'<td data-th="Precio">'+'S/.'+datos[i].torta.precio+'</td>'+
				'<td data-th="Cantidad">'+
					'<input id="txtCantidad" type="number" class="form-control text-center" value="'+datos[i].torta.cantidad+'" min="1" max="7" >'+
				'</td>'+
				'<td data-th="Subtotal" class="text-center">S/.'+datos[i].torta.subTotal+'</td>'+
				'<td class="actions" data-th="">'+
					//'<button class="btn btn-primary btn-sm"><i class="glyphicon glyphicon-edit"></i></button>'+
					'<button class="eliminar btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i></button>	'+							
				'</td>'+
			'</tr>';

			$('#cart tbody').append(fila);
			
		    }
			
			
		});
		
	}
	
	//Elimina el producto del carrito y actualiza la grilla
	$('#cart').on('click','.eliminar',function(){			
		var id=$(this).parent().parent().children().eq(0).children().eq(0).val();
		//Se elimina mediante Ajax
		 $.ajax({
				url:"removeItemCart.action",
				type:"post",
				datatype:"json",
				data:{idProducto:id},
				success:function(result){
					//table.ajax.reload(null,false);
					actualizarGrillar();
					$.growl(
						{
							title:" <strong> Producto</strong> ",
							message:"eliminado",
							icon:"glyphicon glyphicon-thumbs-up"
						},{
							type:'info'
						}
					  );
				}
		 	});		
	});

	

	
});

