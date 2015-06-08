<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-jquery-grid-tags" prefix="sjg"%>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb"%>



<style type="text/css">
.divcenter {
	text-align: center;
}

.tableCriterios {
	/*margin-left: 15%;
	width:100%*/
}

.tablecenter {
	text-align: center;
	/*width: 70%;*/
	margin: 0 auto;
}

.tablecenter thead th {
	text-align: center;
}

.campos {
	display: inline-block;
}
    div.container {
        width:95%;
        margin: 0 auto 0 auto;
        /*margin-top:5%;*/
        margin-bottom:5%;    
    }
    .panel-primary{
    	width: 80%;
    	margin: 0 10% 10%;"
    }
        
    
</style>


<script>

function myColorChange(object) {
	var x = $(object).val();
	removerClase(object);
	if (x == 1) {
		$(object).addClass('label label-warning');
	}if (x == 2) {
		$(object).addClass('label label-success');
	}if (x == 3) {
		$(object).addClass('label label-danger');
	}if (x == 4) {
		$(object).addClass('label label-info');
	}
}

function removerClase(object){

	$(object).removeClass('label label-warning');
	$(object).removeClass('label label-success');
	$(object).removeClass('label label-danger');
	$(object).removeClass('label label-info');
}

function formatCombo(object) {
	
	var x = $(object).val();
	if (x == 1) {
		$(object).addClass('label label-warning');
	}if (x == 2) {
		$(object).addClass('label label-success');
	}if (x == 3) {
		$(object).addClass('label label-danger');
	}if (x == 4) {
		$(object).addClass('label label-info');
	}
}

function formatCombo2(object,x) {
	
	if (x == 1) {
		$(object).addClass('label label-warning');
	}if (x == 2) {
		$(object).addClass('label label-success');
	}if (x == 3) {
		$(object).addClass('label label-danger');
	}if (x == 4) {
		$(object).addClass('label label-info');
	}
}

$(document).ready(function() {

  var table=$('#example').DataTable({
        "processing": true,
        "ajax": {
        	"url":"listOrder.action",
        	 "dataSrc":"pedidos"
        	},
        	"bPaginate":true,
            "bFilter":false,
            "bInfo":false,
        "columns": [
                    { "data": "idPedidoCabe" },
                    { "data": "fechaPedido" },
                    { "data": "total" },						
                    { "data": "usuario.nombre" },
                    { "data": "estado.descripcion" }
                ] ,
                "columnDefs":[							
    	                      {
    	                    	  "targets": [5], // El objetivo de la columna de posición, desde cero.
    	                          "data":null, // La inclusión de datos
    	                          "defaultContent":"<a  class='label label-default verDetalle' id='verDetalle'>VER</a>"
    	                      }
    	                    ] 
        ,"language": {
           "lengthMenu": "Mostrar _MENU_ Registros por pagina",
           "zeroRecords": "No se hallaron Registros ",
           "info": "Mostrando pagina _PAGE_ de _PAGES_",
           "infoEmpty": "No hay Registros disponibles",
           "infoFiltered": "(filtrado de un total de _MAX_ registros)",
           "search":"Búsqueda:",
           "loadingRecords": "Cargando...",    
           "processing":     "Procesando...",
           "paginate": { 
                   "first": "Primero",        
                   "last":   "Ultimo",       
                   "next":   "siguiente",       
                   "previous": "Anterior"    
                  },
       },
       "lengthMenu": [
                      [5,10, 25, 50, -1], 
                      [5,10, 25, 50, "Todo"]
                     ]
       ,responsive:true,
       "initComplete":function(){
			$('#example tbody tr').each(function(){
				var datos=$('#example').DataTable().row(this).data();
				var cell=$(this).children('td').eq(4);
				var label="<label>"+cell.text()+"</label>";
				cell.html(label);
				formatCombo2($(cell).children('label'),datos.estado.idEstado);
				
			});
		}
         
    });
  
    
  	setInterval(function(){
  		//alert('updating');
  		table.ajax.reload;
  	},2000);
    
  	
  	
	$('#example').on('click','.verDetalle',function(){
		var row=$(this).parents('tr');
		var datos=table.row(row).data();
		var idPedidoCabecera=datos.idPedidoCabe;
		
		var tablex=$('#detalle').DataTable({
	        "processing": true,
	        "ajax": {
	        	"url":"listOrderDet.action?id="+idPedidoCabecera,
	        	 "dataSrc":"orderDetail"
	        	},
	        	"bPaginate": false,
	            "bFilter": false,
	            "bInfo":false,
	        "columns": [
	                    { "data": "pedidoCabe.idPedidoCabe" },
	                    { "data": "producto.descripcion" },
	                    { "data": "precioUnidad" },						
	                    { "data": "dedicatoria" },
	                    { "data": "nombre_agasajado" },
	                    { "data": "fec_requerimiento" }
	                ] ,
        "columnDefs":[   
                   		{
							  "targets": [6], 
							  "data" :null,				  
						      "defaultContent":""
						},
						{
	                    	  "targets": [7],
	                          "data":null,
	                          "defaultContent":"<a class='glyphicon glyphicon-ok grabar' >Guardar</a>"
	                    }
					],	
	           "language": {
	           "lengthMenu": "Mostrar _MENU_ Registros por pagina",
	           "zeroRecords": "No se hallaron Registros ",
	           "info": "Mostrando pagina _PAGE_ de _PAGES_",
	           "infoEmpty": "No hay Registros disponibles",
	           "infoFiltered": "(filtrado de un total de _MAX_ registros)",
	           "search":"Búsqueda:",
	           "loadingRecords": "Cargando...",    
	           "processing":     "Procesando...",
	           "paginate": { 
	                   "first": "Primero",        
	                   "last":   "Ultimo",       
	                   "next":   "siguiente",       
	                   "previous": "Anterior"    
	                  },
	       },
	       "lengthMenu": [
	                      [5,10, 25, 50, -1], 
	                      [5,10, 25, 50, "Todo"]
	                     ]
	       ,responsive:true
	       , "initComplete":function(){
				$('#detalle tbody tr').each(function(){
					var datos=$('#detalle').DataTable().row(this).data();
					var cell=$(this).children('td').eq(6);
					var combo="<select onchange='myColorChange(this)'>"+
					"<option value='1'>Pendiente</option>"+
					"<option value='2'>Aprobado</option>"+
					"<option value='3'>Cancelado</option>"+
					"<option value='4'>Finalizado</option>"+		
					"</select>";
					cell.html(combo);
					var combito=cell.children().eq(0);
					combito.val(datos.estado.idEstado);
					formatCombo(combito);
				});
			}
	         
	    });
		
		$('#detalle').fadeIn(1500);
		$('.tableCriterios').hide();
		$('.lstPedidos').hide();
		

		
	});
	
	
	$('#detalle').on('click','.grabar',function(){
		var row=$(this).parents('tr');
		var datos=$('#detalle').DataTable().row(row).data();
		var comboEstado=row.children('td').eq(6).children('select').val();
	
		
		$.ajax({
			type:'post',
			url:'EditStatus',
			datatype:'json',
			data:{idPedido:datos.pedidoCabe.idPedidoCabe,indice:datos.indice,estado:comboEstado},
			success:function(){
				$('#detalle').DataTable().ajax.reload;
				$.growl(
            			{
            				title:" <strong>!Cambios</strong>:",
            				message:" <strong>Guardados</strong>",
            				icon:"glyphicon glyphicon-thumbs-up"
            			},{
            				type:'success'
            			}
            		 );
			}
		});
		
	});
    
	/* Actualizando el Style del Estado del DataTable*/
    $('#example_length select').change(function(){
    	console.log('Change Number Rows');
    	updateStyles();
    });
	  
	
	  $('#example')
      .on( 'order.dt',  function () { console.log('Order' );updateStyles();} )
      .on( 'search.dt', function () {console.log('Search' );updateStyles();} )
      .on( 'page.dt',   function () { console.log('Page' );updateStyles();} )
      .dataTable();
	
	  function updateStyles(){
			$('#example tbody tr').each(function(){
				var datos=$('#example').DataTable().row(this).data();
				var cell=$(this).children('td').eq(4);
				var label="<label>"+cell.text()+"</label>";
				cell.html(label);
				formatCombo2($(cell).children('label'),datos.estado.idEstado);
				
			});
		}
	
	  
    /*  Evento Doble click */
    $('#example tbody').on( 'dblclick', 'tr', function () {
   		 
       if ( $(this).hasClass('selected') ) {
           $(this).removeClass('selected');
       }
    
  	 });
     
     <!---->
    jQuery("#buscador").keyup(function(){
        if( jQuery(this).val() != ""){
            jQuery("#example tbody>tr").hide();
            jQuery("#example td:contiene-palabra('" + jQuery(this).val() + "')").parent("tr").show();
        }
        else{
            jQuery("#example tbody>tr").show();
        }
    });
     
       jQuery.extend(jQuery.expr[":"], 
    {
        "contiene-palabra": function(elem, i, match, array) {
            return (elem.textContent || elem.innerText || jQuery(elem).text() || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
        }
    }); 
    
    <!---->
     $('#mySelect').on('change',function(){
    	 jQuery("#example tbody>tr").hide();
         jQuery("#example td:contiene-palabra('" + jQuery(this).val() + "')").parent('tr').show();
    	 
         /*         var selectedValue = $(this).val();
        $('#example').dataTable().fnFilter($(this).val()); */
        
     }); 
    <!---->  
   
});

</script>


<div class="panel panel-primary">
   <div class="panel panel-heading">
     <h1 class="panel-title">LISTADO DE PEDIDOS</h1>
   </div>
  
   <div class="tableCriterios">
	<div class="campos">
	<label>&nbsp;&nbsp;Codigo de Pedido:</label> 
	<input type="text" class="texto-gris" id="buscador" size="10"/>
	
	</div>
	<div class="campos">
		<label>&nbsp;Estado:</label> <select id="mySelect">
			<option>--Seleccione--</option>
			<option>Pendiente</option>
			<option>Cancelado</option>
			<option>Finalizado</option>
			<option>Aprobado</option>
		</select>
	</div>
	<div class="campos">
		<label>&nbsp;</label>
	</div>
	<div class="campos">
		<!-- <input type="submit" class="btn btn-primary" value="Consultar" /> -->
	</div>
   </div>
   
   <p/>
   <div class="container lstPedidos">
    <table id="example" class="table table-responsive table-striped table-bordered table-hover" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Codigo</th>
			                <th>Fecha Pedido</th>
			                <th>Total</th>
			                <th>Usuario</th>
			                <th>Estado</th>
			                <th>Ver</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>Codigo</th>
			                <th>Feha de Pedido</th>
			                <th>Total</th>
			                <th>Usuario</th>
			                <th>Estado</th>
			                <th>Ver</th>	              
			            </tr>
			        </tfoot>
			    </table>
   </div>
   <div class="container">
    <table id="detalle" class="table table-responsive table-striped table-bordered table-hover" cellspacing="0" width="100%">
			        <thead>
			            <tr>			            
			                <th>Codigo</th>
			                <th>Producto</th>
			                <th>Precio</th>
			                <th>Dedicatoria</th>
			                <th>Agasajado</th>
			                <th style=" width:30px;">Fecha Requerimiento</th>			 
			                <th>Estado</th>
			                <th>Guardar</th>
			            </tr>
			        </thead>
			 
			    </table>
   </div>
</div>

