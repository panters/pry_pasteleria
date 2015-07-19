<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>


<script>
   $(document).ready(function(){
	   
	   function limpiarfields(){
		   
			var modal =$('#myModalNuevo');
			modal.find('.modal-body input').val('');
	   }
	   
		     $('#myModalNuevo').modal('show');
		     
		     $('#formActPass').submit(function(e){
				  
				   e.preventDefault();
				   
				  /*  var aa='${session.user.password}';
				   if($('#passAct').val() == aa){
					   alert(aa);
				   }else{fac
					   alert("No es la contraseña");
					   return false;
				   } 
				   
				    if($('#passNuevo1').val() == $('#passNuevo2').val()){
					   alert("ssss");
				   }else{
					   alert("Las Contraseñas no Coinciden");
					   return false;
				   } */ 
				   
				   /* if($('#passNuevo2').val() == $('#passNuevo1').val()){
					   alert("ssss");
				   } */

				 // var ses='${session.user.password}';
				   
				  var $form=$(this);
				   if(! $form.valid()){
					   
					   return false;
				   }else{
					  
					   if($('#passAct').val() == $('#pass').val()){
						   
								   if($('#passNuevo2').val() == $('#passNuevo1').val()){
		
									   $.ajax({
										   type: 'POST',
										   url: $(this).attr('action'),
										   data: $(this).serialize(),
										   success: function(data){
											   $.growl(
								            			{
								            				title:" <strong>!Mensaje :</strong>:",
								            				message:" <strong>Cambios Guardados</strong>",
								            				icon:"glyphicon glyphicon-thumbs-up"
								            			},{
								            				type:'success'
								            			}
								            		  );
											   $(location).attr('href','catalogo.action');	
											   
										   }
									     
									   })
									   
									   return false;
									      
								   }else{
									   alert("Las Contraseñas no coinciden");
									   limpiarfields();
								   } 
						   
					   }else{
						   
						   alert("La contraseña actual ingresada no es la correcta");
						   limpiarfields();
					   } 						
					   
				   }
				   return false;
				    
			   });
		     
		     
		     
		    $('#cancelar').click(function(){
		    	window.location.href="catalogo.action";
		    });		    

   });

</script>

<div class="modal fade" id="myModalNuevo" role="dialog" ria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
  <s:form id="formActPass" action="updatePassword1"  theme="bootstrap" cssClass="well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Cambiar mi Contraseña</h4>
    </div>
		<div class="modal-body">
	    		<s:hidden id="idUsuario" name="cliente.idUsuario" />
	    	<div class="form-group">
		   		<s:hidden label="Nombre :" name="cliente.nombre" id="nombre" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Apellido Paterno :" name="cliente.ape_pa" id="ape_pa" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Apellido Materno :" name="cliente.ape_ma" id="ape_ma" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="DNI :" name="cliente.dni" id="dni" cssClass="form-control"/>
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
	    		<s:hidden label="Telefono:" name="cliente.telefono" id="telefono" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Celular:" name="cliente.celular" id="celular" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:password label="Contraseña Actual:" id="passAct" name="passAct" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:password label="Contraseña Nueva:" id="passNuevo1" name="password" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
		    	<s:password label="Confirme su Contraseña:" id="passNuevo2" name="cliente.password" cssClass="form-control"/>
	    	</div>
   		 </div>
      <div class="modal-footer">
  	  <div style="text-align:left;">
  	  		<s:submit cssClass="btn btn-primary" id="guardar" value="Guardar Cambios"/>&nbsp;&nbsp;
   	  </div>
      	<button type="button" class="btn btn-default" id="cancelar" data-dismiss="modal">Cancelar</button>
    </div>
    </s:form>
    <s:hidden name="cliente.password" id="pass"/>
  </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div>


