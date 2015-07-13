<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<script>
//var categoriasArray;

$(document).ready(function() {

  var table=$('#example').DataTable({
        "processing": true,
        "ajax": {
        	"url":"listInsumos.action",
        	 "dataSrc":"insumos"
        	},
        "columns": [
                    { "data": "idinsumo" },
                    { "data": "descripcion" },
                    { "data": "precio" },
                    { "data": "tipo" },
                    { "data": "imagen" }
                    
                ]
       , "language": {
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
                     ],
        responsive:true
        
    });
    
    
    
    /* Actualizando las Imagenes del DataTable*/
    $('#example_length select').change(function(){
    	console.log('Change Number Rows');
    	updateImages();
    });

    $('#example')
       .on( 'order.dt',  function () { console.log('Order' );updateImages();} )
       .on( 'search.dt', function () {console.log('Search' );updateImages();} )
       .on( 'page.dt',   function () { console.log('Page' );updateImages();} )
       .dataTable();

       function updateImages(){

             setTimeout(function(){

                   $("tr").each(function(){
                       var k=$(this).children("td").eq(4);
                   
                        var j= $(k).html();
                        var str=new String(j); 
                        var contenido=str.substring(0,4);

                        if(contenido=='<img'){
                           console.log('ya tiene imagen');
                        }else{
                           console.log('No tiene imagen se Actualizara');
                         //$(k).html("<img src='img/" + j + "' width=\'50\' heigth=\'50\'/>");
                           $(k).html("<img  src='verImagen?imagenName="+j+"' width=\'50\' height=\'50\' />");
                        }
					});
                   
              },500);
       }
       
     /* Actualizando las Imagenes del DataTable */
    
    /*  Evento Doble click */
    $('#example tbody').on( 'dblclick', 'tr', function () {
   		 
       if ( $(this).hasClass('selected') ) {
           $(this).removeClass('selected');
       }
       else {
           table.$('tr.selected').removeClass('selected');
           $(this).addClass('selected');
           //Obtenemos Fila actual
           var currentRow=table.row(this).data();
           //Extraemos los datos con JSON
           var dato1=currentRow.idinsumo;
           var dato2=currentRow.descripcion;
           var dato3=currentRow.precio;
           var dato4=currentRow.tipo;
         
   		   $("#cbocategoria option").each(function(){
   				if(dato4==$(this).val())
  				 dato4=$(this).val();
   		   });
   		   
   		  var dato5=currentRow.imagen;
           
           mostrarmodal(dato1,dato2,dato3,dato4,dato5);
	       $('#myModalNuevo').modal();	
	       $("#delete").show();
       }
  	 });
    
    //--------function modal -----------
    function mostrarmodal(dato1,dato2,dato3,dato4,dato5){
    	  $('#myModalNuevo').on('show.bs.modal', function (event) {
		  var modal = $(this);
		  modal.find('.modal-header h4').text('Modificar Producto: ' + dato1);
	
		  modal.find('.modal-body #idProducto').val(dato1);
		  modal.find('.modal-body #descripcion').val(dato2);
		  modal.find('.modal-body #precio').val(dato3);
		  modal.find('.modal-body #cbocategoria').val(dato4);
		  modal.find('.modal-body #imagen').val(dato5);
		  
		  $('#img_bkp').html("<label>Imagen Actual:<br/></label><img  src='verImagen?imagenName="+dato5+"' width=\'100\' height=\'70\' />");
		  
		});
    }
    
    //Clean Fields
    function limpiarfields(){
		/* Limpiar el Validate */
	    $('.modal-body .form-group').removeClass('has-error');
	    $('.modal-body .form-group').removeClass('has-success');
	    $(".help-block").hide();
	    /* Limpiar el Modal */
		var modal =$('#myModalNuevo');
		modal.find('.modal-body input').val('');
		//modal.find('.modal-body #precio').val('S/.0.00');
		$('#cbocategoria').val(0);
		$('#img_bkp').html('');
		}
    
    function verNuevo(){
    	var modal =$('#myModalNuevo');
    	$('#myModalNuevo').modal('show');
    	limpiarfields();
    	modal.find('.modal-header h4').text('Registrar Producto: ');
    	modal.find('.modal-body #idProducto').val('0');
    	$("#delete").hide();
    };

	$('#btnNuevo').click(function(){
	    	limpiarfields();
			verNuevo();
	});
	


	  $('#delete').click(function(){
	      	$('#borrame').remove();
	      	var modal = $('#myModalNuevo');
	      	var id=modal.find('.modal-body #idProducto').val();
	      	var c1="<a id=\"borrame\" class=\"btn btn-primary \" ";
	      	var str1 = "href=\"deleteInsumo?insumo.idinsumo=";
	        var str2 = "\">Si</a>";
	        var res = c1.concat(str1,id,str2);
	          
	      	$("#conexionServer").before(res);
	      	$("#modalEliminar").modal('show');
	      });
	  
	
} );

</script>

	<section class="content-header">
		 <h1>
            Mantenimiento 
            <small>Insumos de Arma tu Torta</small>
          </h1>
          <ol class="breadcrumb">
          <a href="#" class="btn btn-primary" data-toggle="modal" id="btnNuevo">+ Nuevo</a>
            <!-- <li style="font-size: 2em;"><a href="#" id="btnNuevo"><i class="fa fa-dashboard"></i>Nuevo</a></li> -->
          </ol>
    </section>     

  	 
	<section class="content">
	<div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title"></h3>
                </div><!-- /.box-header -->
                <div class="box-body">
	
	<!--<div class="table-responsive">  -->
			<table id="example" class="table table-responsive table-striped table-bordered table-hover" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Codigo</th>
			                <th>Insumo</th>
			                <th>Precio</th>
			                <th>Tipo</th>
			                <th>Imagen</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>Codigo</th>
			                <th>Insumo</th>
			                <th>Precio</th>
			                <th>Tipo</th>
			                <th>Imagen</th>
			            </tr>
			        </tfoot>
			    </table>


     </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
        </section><!-- /.content -->
<!-- -----------Modal Register New------------ -->

<div class="modal fade" id="myModalNuevo" role="dialog" ria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
  <s:form action="saveInsumo" enctype="multipart/form-data" method="post" acceptcharset="utf-8" theme="bootstrap" cssClass="well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Registrar Producto</h4>
    </div>
		<div class="modal-body">
	    		<s:hidden id="idProducto" name="insumo.idinsumo" />
	    	<div class="form-group">
		   		<s:textfield label="Insumo :" name="insumo.descripcion" id="descripcion" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	
	    	<div class="form-group">
	    		<s:textfield label="Precio :" name="insumo.precio" id="precio" cssClass="form-control" onkeypress="return validarPrecio(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:file label="Imagen :" name="archivo"/>
	    		<div id="img_bkp"></div>
	    		<!--  
	    		<s:textfield label="Imagen :" name="producto.image_resource" id="imagen" cssClass="form-control"/>
	    		-->
	    	</div>
	    	<div class="form-group">
	    			<s:url id="URL_ListTipos" action="listtipoinsumos"/>
					<sj:select cssClass="form-control"
					id="cbocategoria" 
					label="Tipo :"
					list="tipoinsumos"
					href="%{URL_ListTipos}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="insumo.tipo" />
	    	</div>
   		 </div>
      <div class="modal-footer">
  	  <div style="text-align:left;">
  	  		<s:submit cssClass="btn btn-primary" value="Guardar"/>&nbsp;&nbsp;
  	  		<s:reset  id="cleanForm" cssClass="btn btn-primary" value="Limpiar"/>
   	  		<button  id="delete" type="button" class="btn btn-danger" data-toggle="modal">Eliminar</button>&nbsp;&nbsp;
   	  </div>
      	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
    </div>
    </s:form>
  </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->

</div>
<!-- -----------END MODAL NUEVO --------------- -->

<!-- ------------Show Message Modal------------ -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" id="modalEliminar" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
    <div class="modal-header">
    	<h4 class="modal-title">Guardar Cambios</h4>
    </div>
    <form action="">
      <div class="modal-body" style="text-align: right;">
         <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
         <div id="conexionServer"></div>
         <!--  <button type="button" class="btn btn-primary eliminar" data-dismiss="modal">Si</button>
         <input type="hidden" value="delete" name="accion"></input>-->
         </div>
     </form>
      </div>
    </div>
  </div>



