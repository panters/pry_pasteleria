<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>


<script>
   $(document).ready(function(){
	   
		     $('#myModalNuevo').modal('show');
		     
		     $('#guardar').click(function(){
		    	 
		    	 if($('#password').val().length<1){
		    		 alert("Debe una contraseña");
		    	 }else{
		    		 $.growl(
								{
							    title:"<strong>!Su contraseña ha sido: </strong>:",
							    message:"<strong>Modificada</strong>",
							    icon:"glyphicon glyphicon-thumbs-up"
					        	},{
					        		type:'success'
					        	}
					       );
		    	 }
		     });
		     
		    $('#cancelar').click(function(){
		    	window.location.href="catalogo.action";
		    });		    

   });

</script>

<div class="modal fade" id="myModalNuevo" role="dialog" ria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
  <s:form id="form" action="updatePassword1"  theme="bootstrap" cssClass="well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Cambiar mi Contraseña</h4>
    </div>
		<div class="modal-body">
	    		<s:hidden id="idUsuario" name="cliente.idUsuario" />
	    	<div class="form-group">
		   		<s:hidden label="Nombre :" name="cliente.nombre" id="nombre" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Apellido Paterno :" name="cliente.ape_pa" id="ape_pa" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Apellido Materno :" name="cliente.ape_ma" id="ape_ma" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="DNI :" name="cliente.dni" id="dni" cssClass="form-control" maxlength="8" onkeypress="return validarEntero(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Fecha Nacimiento :" name="cliente.fec_nacimiento" id="fec_nacimiento" cssClass="form-control"/>
	    	</div>
        	<div class="form-group">
	    		<s:hidden label="Sexo:" name="cliente.sexo" id="sexo" cssClass="form-control"/>
	    	</div> 	    		    		    	
	    	<div class="form-group">
	    		<s:hidden label="Email:" name="cliente.email" id="email" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Estado Civil:" name="cliente.estado_civil" id="estado_civil" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Telefono:" name="cliente.telefono" id="telefono" cssClass="form-control" maxlength="7" onkeypress="return validarEntero(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Celular:" name="cliente.celular" id="celular" cssClass="form-control" maxlength="9" onkeypress="return validarEntero(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Contraseña Actual:" name="cliente.password" cssClass="form-control" onkeypress="return validarEntero(event)"/>
	    	</div>
   		 </div>
      <div class="modal-footer">
  	  <div style="text-align:left;">
  	  		<s:submit cssClass="btn btn-primary" id="guardar" value="Guardar Cambios"/>&nbsp;&nbsp;
   	  </div>
      	<button type="button" class="btn btn-default" id="cancelar" data-dismiss="modal">Cancelar</button>
    </div>
    </s:form>
  </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div>


