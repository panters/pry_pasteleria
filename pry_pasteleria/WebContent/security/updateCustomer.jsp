<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>    


<script>
   $(document).ready(function(){
   
	   $('#cancelar').click(function(){
		   $('#form').hide();
		   window.location.href="catalogo.action";
	   });
	   
	   
   });

</script>
<div>
<s:form id="form" action="saveCustomer"  theme="bootstrap" cssClass="well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Mis Datos</h4>
    </div>
		   <div class="form-group">
	    		<s:hidden id="idUsuario" name="cliente.idUsuario"/>
	    	<div class="form-group">
		   		<s:textfield label="Nombre :" name="cliente.nombre" id="nombre" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Apellido Paterno :" name="cliente.ape_pa" id="ape_pa" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Apellido Materno :" name="cliente.ape_ma" id="ape_ma" cssClass="form-control" onkeypress="return validarLetra(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="DNI :" name="cliente.dni" id="dni" cssClass="form-control" maxlength="8" onkeypress="return validarEntero(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Fecha Nacimiento :" name="cliente.fec_nacimiento" id="fec_nacimiento" cssClass="form-control"/>
	    	</div>
        	<div class="form-group">
	    		<s:textfield label="Sexo:" name="cliente.sexo" id="sexo" cssClass="form-control"/>
	    	</div> 	    		    		    	
	    	<div class="form-group">
	    		<s:textfield label="Email:" name="cliente.email" id="email" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Estado Civil:" name="cliente.estado_civil" id="estado_civil" cssClass="form-control"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Telefono:" name="cliente.telefono" id="telefono" cssClass="form-control" maxlength="7" onkeypress="return validarEntero(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:textfield label="Celular:" name="cliente.celular" id="celular" cssClass="form-control" maxlength="9" onkeypress="return validarEntero(event)"/>
	    	</div>
	    	<div class="form-group">
	    		<s:hidden label="Password:" name="cliente.password" id="celular" cssClass="form-control" maxlength="9" onkeypress="return validarEntero(event)"/>
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