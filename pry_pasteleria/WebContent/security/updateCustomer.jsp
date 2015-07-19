<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>    


<script>
   $(document).ready(function(){
	   
	   if($('#sexo').val() == 'M'){
			  $('#sexoM').prop('checked',true);
			  $('#sexoF').prop('checked',false);
			 // $('#sexo').val(dato7);
		  }
		if($('#sexo').val() == 'F'){
			  $('#sexoM').prop('checked',false);
			  $('#sexoF').prop('checked',true);
			 // $('#sexo').val(dato7);
		  }
	   
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
		
	   
	   
	   $('#cancelar').click(function(){
		   $('#formUpdateCustomer').hide();
		   window.location.href="catalogo.action";
	   });
	   
	   
	   $('#formUpdateCustomer').submit(function(e){
		  
		   e.preventDefault();
		   
		   var $form=$(this);
		   if(! $form.valid()){
			   return false;
		   }else{
			   
			   $.ajax({
				   type: 'POST',
				   url: $(this).attr('action'),
				   data: $(this).serialize(),
				   success: function(data){
					   $.growl(
		            			{
		            				title:" <strong>!Mensaje :</strong>:",
		            				message:" <strong>Modificacion Correcta</strong>",
		            				icon:"glyphicon glyphicon-thumbs-up"
		            			},{
		            				type:'success'
		            			}
		            		  );
					   $(location).attr('href','catalogo.action');
				   }
			   })
			   
			   return false;
			   
		   }
		   return false;
		   
	   });
	   
   });

</script>
<div class="container">
	<div class="col-md-2"></div>
	<div class="col-md-8 col-center">
	<s:form id="formUpdateCustomer" action="saveCustomer"  theme="bootstrap" cssClass="well form-vertical">
		    <div class="modal-header">
		    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		    	<h4>Mis Datos</h4>
		    </div>
				   <div class="form-group">
			    		<s:hidden id="idUsuario" name="cliente.idUsuario"/>
			    	<div class="form-group">
				   		<s:textfield label="Nombre :" name="cliente.nombre" id="nombre" cssClass="form-control"/>
			    	</div>
			    	<div class="form-group">
			    		<s:textfield label="Apellido Paterno :" name="cliente.ape_pa" id="ape_pa" cssClass="form-control"/>
			    	</div>
			    	<div class="form-group">
			    		<s:textfield label="Apellido Materno :" name="cliente.ape_ma" id="ape_ma" cssClass="form-control"/>
			    	</div>
			    	<div class="form-group">
			    		<s:textfield label="DNI :" name="cliente.dni" id="dni" cssClass="form-control"/>
			    	</div>
			    	<div class="form-group">
			    		<s:textfield label="Fecha Nacimiento :" name="cliente.fec_nacimiento" id="fec_nacimiento" cssClass="form-control" readonly="true"/>
			    	</div>
		        	<div class="form-group">
	    			<div class="radio">
							Sexo:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" id="sexoM" value="M" name="s">Masculino</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio" id="sexoF" value="F" name="s">Femenino</label>
							<s:hidden id="sexo" name="cliente.sexo" />
					</div>
	    			</div>     		    		    	
			    	<div class="form-group">
			    		<s:textfield label="Email:" name="cliente.email" id="email" cssClass="form-control"/>
			    	</div>
			    	
			    	<s:select label="Estado Civil:" 
    				id="estado_civil"
					headerKey="0" headerValue="--Seleccione Estado--"
					list="#{'S':'Soltero(o)', 'C':'Casado(a)', 'V':'Viudo(a)', 'D':'Divorciado(a)'}" 
					name="cliente.estado_civil" 
					cssClass="form-control"/>
			    	
			    	<div class="form-group">
			    		<s:textfield label="Telefono:" name="cliente.telefono" id="telefono" cssClass="form-control"/>
			    	</div>
			    	<div class="form-group">
			    		<s:textfield label="Celular:" name="cliente.celular" id="celular" cssClass="form-control"/>
			    	</div>
			    	<div class="form-group">
			    		<s:hidden label="Password:" name="cliente.password" id="celular" cssClass="form-control"/>
			    	</div>
		   		 </div>
		      <div class="modal-footer">
		  	  <div style="text-align:left;">
		  	  		<s:submit cssClass="btn btn-primary" value="Actualizar Datos"/>&nbsp;&nbsp;
		   	  </div>
		      	<button type="button" id="cancelar" class="btn btn-default" data-dismiss="modal" >Cancelar</button>
		    </div>
		    </s:form>
    </div>
	<div class="col-md-2"></div>
</div>