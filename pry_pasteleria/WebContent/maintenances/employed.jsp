<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<style type="text/css">
    div.container {
        width:95%;
        margin: 0 auto 0 auto;
        margin-top:5%;
        margin-bottom:5%;    
    }
    .panel-primary{
    	width: 80%;
    	margin: 0 10% 10%;"
    }
</style>
<script>
$(document).ready(function() {
	
	$( ".fechas" ).datepicker({
		changeMonth: true,
		changeYear: true,
		language: "es",
		yearRange: '1940:2000'
		});
	
	
    var table=$('#example').DataTable( {
        "processing": true,
        "ajax": {
        	"url":"listEmployed.action",
        	 "dataSrc":"empleados"
        	},
        "columns": [
                    { "data": "idUsuario" },
                    { "data": "nombre" },
                    { "data": "ape_pa" },
                    { "data": "ape_ma" },
                    { "data": "dni" },
                    { "data": "fec_nacimiento" },
                    { "data": "sexo" },
                    { "data": "email" },
                    { "data": "estado_civil" },
                    { "data": "telefono" },
                    {"data":"celular"},
                    {"data":"fecha_ingreso"},
                    {"data":"sueldo"},
                    {"data":"fecha_salida"},
                    { "data": "rol.descripcion" }
                ]
       , "language": {
           "lengthMenu": "Mostrar _MENU_ Registros por pagina",
           "zeroRecords": "No se hallaron Registros ",
           "info": "Mostrando pagina _PAGE_ de _PAGES_",
           "infoEmpty": "No hay Registros disponibles",
           "infoFiltered": "(filtrado de un total de _MAX_ registros)",
           "search":"B�squeda:",
           "loadingRecords": "Cargando...",    
           "processing":     "Procesando...",
           "paginate": { 
                   "first": "Primero",        
                   "last":   "Ultimo",       
                   "next":   "siguiente",       
                   "previous": "Anterior"    
                  },
       },
       responsive:true
    });
    
    
    /*Evento Un click -- sombrea la celda seleccionada*/
    $('#example tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');       
        }
     });
    
    /*  Evento Doble click */
    $('#example tbody').on( 'dblclick', 'tr', function () {
    	limpiarfields();
   	
       if ( $(this).hasClass('selected') ) {
           $(this).removeClass('selected');
       }
       else {
           table.$('tr.selected').removeClass('selected');
           $(this).addClass('selected');
           //Optenemos toda la data de la Fila
       	   var currentRow=table.row(this).data();
           //recuperamos los datos con JSON
		   var dato1=currentRow.idUsuario;
		   var dato2=currentRow.nombre;
		   var dato3=currentRow.ape_pa;
		   var dato4=currentRow.ape_ma;
		   var dato5=currentRow.dni;
		   var dato6=currentRow.fec_nacimiento;
		   var dato7=currentRow.sexo;
		   var dato8=currentRow.email;
		   var dato9=currentRow.estado_civil;
		   var dato10=currentRow.telefono;
		   var dato11=currentRow.celular;
		   
		   var dato12=currentRow.fecha_ingreso;
		   var dato13=currentRow.sueldo;
		   var dato14=currentRow.fecha_salida;
		   var dato15=currentRow.rol.descripcion;
		   
		   
		   $("#cborol option").each(function(){
  				if(dato15==$(this).text())
 				 dato15=$(this).val();
  		   });
           
           mostrarmodal(dato1,dato2,dato3,dato4,dato5,dato6,dato7,dato8,dato9,dato10,dato11,dato12,dato13,dato14,dato15);
	       $('#myModalNuevo').modal();	
	       $("#delete").show();
       }
  	 });
    
    //--------function modal -----------
    function mostrarmodal(dato1,dato2,dato3,dato4,dato5,dato6,dato7,dato8,dato9,dato10,dato11,dato12,dato13,dato14,dato15){
    	  $('#myModalNuevo').on('show.bs.modal', function (event) {
		  var modal = $(this);
		  modal.find('.modal-header h4').text('Modificar Empleado: ' + dato1);
	
		  modal.find('.modal-body #idUsuario').val(dato1);
		  modal.find('.modal-body #nombre').val(dato2);
		  modal.find('.modal-body #ape_pa').val(dato3);
		  modal.find('.modal-body #ape_ma').val(dato4);
		  modal.find('.modal-body #dni').val(dato5);
		  modal.find('.modal-body #fec_nacimiento').val(dato6);
		  modal.find('.modal-body #sexo').val(dato7);
		  modal.find('.modal-body #email').val(dato8);
		  modal.find('.modal-body #estado_civil').val(dato9);
		  modal.find('.modal-body #telefono').val(dato10);
		  modal.find('.modal-body #celular').val(dato11);
		  
		  modal.find('.modal-body #fecha_ingreso').val(dato12);
		  modal.find('.modal-body #sueldo').val(dato13);
		  modal.find('.modal-body #fecha_salida').val(dato14);
		  modal.find('.modal-body #cborol').val(dato15);
		  
		  if(dato7=='M'){
			  $('#sexoM').prop('checked',true);
			  $('#sexoF').prop('checked',false);
			  $('#sexo').val(dato7);
		  }
		  else{
			  $('#sexoM').prop('checked',false);
			  $('#sexoF').prop('checked',true);
			  $('#sexo').val(dato7);
		  }
			  
		  
		  
		  
		});
    }
    
    
    
    //Clean Fields
    function limpiarfields(){
    	/* Limpiar el Validate */
    	$('.modal-body .form-group').removeClass('has-error');
    	$('.modal-body .form-group').removeClass('has-feedback');
    	$('.modal-body .form-group').removeClass('has-success');
    	$('.modal-body .form-group').removeClass('glyphicon glyphicon-ok');
    	$('.error').remove();
    	$(".help-block").hide();
    	/*limpiar el efecto*/
    	$('form').removeClass('animated shake');
	    /* Limpiar el Modal */
		var modal =$('#myModalNuevo');
		modal.find('.modal-body input').val('');
		$('.modal-body #estado_civil').val(0);
		}
    
    function verNuevo(){
    	var modal =$('#myModalNuevo');
    	$('#myModalNuevo').modal('show');
    	limpiarfields();
    	modal.find('.modal-header h4').text('Registrar Empleado: ');
    	modal.find('.modal-body #idUsuario').val('nuevo');
    	$('#sexoM').prop('checked',true);
    	$('#sexo').val('M');
    	$("#delete").hide();
    };

	$('#btnNuevo').click(function(){
	    	limpiarfields();
			verNuevo();
	});
	

	$('#sexoF').change(function(){
		  if( $('#sexoF').prop('checked')){
			  $('#sexoF').prop('checked',true);
			  $('#sexo').val('F');
		  }
		  else{
			  $('#sexoM').prop('checked',true);
			  $('#sexoF').prop('checked',false);
			  $('#sexo').val('M');
		  }
	});
	
	$('#sexoM').change(function(){

		  if($('#sexoM').prop('checked')){
			  $('#sexoM').prop('checked',true);
			  $('#sexo').val('M');
		  }
		  else{
			  $('#sexoM').prop('checked',false);
			  $('#sexoF').prop('checked',true);
			  $('#sexo').val('F');
		  }
	});

	  $('#delete').click(function(){
	      	$('#borrame').remove();
	      	var modal = $('#myModalNuevo');
	      	var id=modal.find('.modal-body #idUsuario').val();
	      	var c1="<a id=\"borrame\" class=\"btn btn-primary \" ";
	      	var str1 = "href=\"deleteEmployed?empleado.idUsuario=";
	        var str2 = "\">Si</a>";
	        var res = c1.concat(str1,id,str2);
	          
	      	$("#conexionServer").before(res);
	      	$("#modalEliminar").modal('show');
	      });   
 
	  
	// Interceptamos el evento submit
	    $('#FormEmpleado').submit(function(e) {
	    e.preventDefault();
	    //detenemos el evento para validar el form
		   var $form=$(this);
		   if (! $form.valid()) {
				return false;
			  //si no es valido no hacemos nada
			}else{
		  		// Enviamos el formulario usando AJAX
		        $.ajax({
		            type: 'POST',
		            url: $(this).attr('action'),
		            data: $(this).serialize(),
		            // Mostramos un mensaje con la respuesta de PHP
		            success: function(data) {
		            	if(data.eexiste==1){
							var msj="Ya hay un usuario registrado con este correo";
							$.growl(
									{
										title:" <strong>!Mensaje: </strong></b>",
										message:msj,
										icon:"glyphicon glyphicon-alert"
									},{
										type:'danger'
									}
								  );
						}else{
				           	    $('#myModalNuevo').modal('hide');	
				                $('#result').html(data);
				                $.growl(
				            			{
				            				title:" <strong>!Cambios</strong>:",
				            				message:" <strong>Guardados</strong>",
				            				icon:"glyphicon glyphicon-thumbs-up"
				            			},{
				            				type:'success'
				            			}
				            		  );
				                //recargamos el DataTable
				                table.ajax.reload();
					   }        
		            }
		        })        
		        return false;
			}
		  return false;
	    }); 
	  
    
} );

</script>
	<section class="content-header">
		 <h1>
            Mantenimiento 
            <small>Empleado</small>
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
    
	<div class="container">
	<!--<div class="table-responsive">  -->
			<table id="example" class="table table-responsive table-striped table-bordered table-hover" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Codigo</th>
			                <th>Nombre</th>
			                <th>A.Paterno</th>
			                <th>A.Materno</th>
			                <th>Dni</th>
			                <th>Nacimiento</th>
			                <th>Sexo</th>
			                <th>Email</th>
			                <th>E.Civil</th>
			                <th>Telefono</th>
			                <th>Celular</th>
			                <th>Fecha Ingreso</th>
			                <th>Sueldo</th>
			                <th>Fin Contrato</th>
			                <th>Rol</th>
			            </tr>
			        </thead>
			 
			        <tfoot>
			            <tr>
			                <th>Codigo</th>
			                <th>Nombre</th>
			                <th>A.Paterno</th>
			                <th>A.Materno</th>
			                <th>Dni</th>
			                <th>Nacimiento</th>
			                <th>Sexo</th>
			                <th>Email</th>
			                <th>E.Civil</th>
			                <th>Telefono</th>
			                <th>Celular</th>
			                <th>Fecha Ingreso</th>
			                <th>Sueldo</th>
			                <th>Fin Contrato</th>
			                <th>Rol</th>
			            </tr>
			        </tfoot>
			    </table>
			   
			<!--</div>-->

</div>

</div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
        </section><!-- /.content -->

<!-- -----------Modal Register New------------ -->

<div class="modal fade" id="myModalNuevo" role="dialog" ria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
  <s:form id="FormEmpleado" action="saveEmployed"  theme="bootstrap" cssClass="animate-form well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Registro</h4>
    </div>
		<div class="modal-body">
	    		<s:hidden id="idUsuario" name="empleado.idUsuario" />
	    	<div class="form-group">
		   		<s:textfield label="Nombre :" name="empleado.nombre" id="nombre" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Apellido Paterno :" name="empleado.ape_pa" id="ape_pa" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Apellido Materno :" name="empleado.ape_ma" id="ape_ma" cssClass="form-control" />
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="DNI :" name="empleado.dni" id="dni" cssClass="form-control" maxlength="8"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Fecha Nacimiento :" name="empleado.fec_nacimiento" id="fec_nacimiento" cssClass="form-control fechas" readonly="true"  />
	    	</div>
	    	<div class="form-group">
	    		<div class="radio">
							Seleccione Sexo:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" id="sexoM" value="M" name="s">Masculino</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio" id="sexoF" value="F" name="s">Femenino</label>
							<s:hidden id="sexo" name="empleado.sexo" />
				</div>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Email:" name="empleado.email" id="email" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<!--<s:textfield label="Estado Civil:" name="empleado.estado_civil" id="estado_civil" cssClass="form-control"/>-->
	    		<s:select label="Estado Civil:" 
	    		id="estado_civil"
				headerKey="0" headerValue="--Seleccione Estado--"
				list="#{'S':'Soltero(o)', 'C':'Casado(a)', 'V':'Viudo(a)', 'D':'Divorciado(a)'}" 
				name="empleado.estado_civil" 
				cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Telefono:" name="empleado.telefono" id="telefono" cssClass="form-control" maxlength="7" />
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Celular:" name="empleado.celular" id="celular" cssClass="form-control" maxlength="9" />
	    	</div>
	    	
	    	<div class="form-group">
	    		<s:textfield label="Fecha Ingreso:" name="empleado.fecha_ingreso" id="fecha_ingreso" cssClass="form-control fechas"  readonly="true"  />
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Sueldo:" name="empleado.sueldo" id="sueldo" cssClass="form-control" />
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Fin Contrato:" name="empleado.fecha_salida" id="fecha_salida" cssClass="form-control fechas"  readonly="true"  />
	    	</div>
	    	<div class="form-group">
	    		<s:url id="URL_ListRoles" action="listRol"/>
				<sj:select id="cborol" cssClass="form-control"
				label="Rol"
				list="roles"
				listKey="idRol"
				listValue="descripcion"
				href="%{URL_ListRoles}"
				headerKey="0"
				headerValue="--Seleccione--" 
				name="empleado.rol.idRol" />
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

