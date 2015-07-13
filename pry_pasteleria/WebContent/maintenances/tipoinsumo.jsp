<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<script>
//var categoriasArray;

$(document).ready(function() {
	
	
var table=$('#example').DataTable({
	  "ajax": {
      	"url":"listtipoinsumos.action",
      	 "dataSrc":"tipoinsumos"
      	}, 
    	"bPaginate": false,
        "bFilter": false,
        "bInfo":false,
      	"columns": [
                       { "data": "tipoinsumos[0]" },
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
   
});

  
$.getJSON('listtipoinsumos',function(data){
    	var data=data.tipoinsumos;
    	var tb=$('#example tbody');
    	tb.html('');
    	for (var i = 0; i < data.length; i++) {
    		tb.append('<tr><td>'+data[i]+'</td></td>');
		}
    	
    	

    	
    });
 
 
    
    /*  Evento Doble click */
    $('#example tbody').on( 'dblclick', 'tr', function () {
       if ( $(this).hasClass('selected') ) {
           $(this).removeClass('selected');
       }
       else {
           table.$('tr.selected').removeClass('selected');
           $(this).addClass('selected');
           //Extraemos los datos
           var dato1=$(".selected td")[0].innerHTML;
           
           mostrarmodal(dato1);
	       $('#myModalNuevo').modal();
	       $(this).removeClass('selected');
	       $("#delete").show();
       }
  	 });
    
    //--------function modal -----------
    function mostrarmodal(dato1){
    	  $('#myModalNuevo').on('show.bs.modal', function (event) {
		  var modal = $(this);
		  modal.find('.modal-header h4').text('Modificar Producto: ' + dato1);
		  modal.find('.modal-body #idProducto').val(dato1);
		  modal.find('.modal-body #tipo').val(dato1);
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
	  }
    
    function verNuevo(){
    	var modal =$('#myModalNuevo');
    	$('#myModalNuevo').modal('show');
    	limpiarfields();
    	modal.find('.modal-header h4').text('Registrar Producto: ');
    	modal.find('.modal-body #idProducto').val('nuevo');
    	$("#delete").hide();
    };

	$('#btnNuevo').click(function(){
	    	limpiarfields();
			verNuevo();
	});
	


	  $('#delete').click(function(){
	      	$('#borrame').remove();
	      	var modal = $('#myModalNuevo');
	      	var id=modal.find('.modal-body #tipo').val();
	      	var c1="<a id=\"borrame\" class=\"btn btn-primary \" ";
	      	var str1 = "href=\"deletetipoinsumos?tipo=";
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
            <small>Tipo de Insumos para Arma tu Torta</small>
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
			                <th>Tipo</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>Tipo</th>
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
  <s:form action="addtipoinsumos" enctype="multipart/form-data" method="post" acceptcharset="utf-8" theme="bootstrap" cssClass="well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Registrar Producto</h4>
    </div>
		 <div class="modal-body">
	        <s:hidden id="idProducto" name="tipoAntiguo" />
	    	<div class="form-group">
		   		<s:textfield label="Insumo :" name="tipo" id="tipo" cssClass="form-control" onkeypress="return validarLetra(event)"/>
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


