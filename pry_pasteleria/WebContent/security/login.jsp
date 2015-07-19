<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="css/styles_account.css" media="all" rel="stylesheet">
<s:if test="hasActionMessages()">
<s:actionmessage id="messageSucces" />
	<script>
		var msj = $('#messageSucces li span').text();
		$('#messageSucces').remove();
		$.growl(
			{
				title:" <strong>!Mensaje: </strong></b>",
				message:msj,
				icon:"glyphicon glyphicon-thumbs-up"
			},{
				type:'success'
			}
		  );
		
		
	</script>
</s:if>

<s:if test="hasActionErrors()">
	<s:actionerror id="messagerror" />
	<script>
		var msj = $('#messagerror li span').text();
		$('#messagerror').remove();
		$.growl(
				{
					title:" <strong>Error: </strong></b>",
					message:msj,
					icon:"glyphicon glyphicon-alert"
				},
				{
					type:'danger'
				}
			);
	</script>
</s:if>

<script>

$(document).ready(function(){
	
	$('#olvClave').click(function(){
		$('#myModalRecPass').modal('show');
		$('#emailrec').val('');
	});
	
	$('#formRecPass').submit(function(e){
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
		            				message:" <strong>Envio Conforme</strong>",
		            				icon:"glyphicon glyphicon-thumbs-up"
		            			},{
		            				type:'success'
		            			}
		            		  );					   
					   window.location.href="logueo.action";	
		             }
			   })
			   return false;
		   }
		   return false;
	});
});
</script>


<div class="centrando">
<div class="row row-centered">
  
	  <div class="col-xs-12 col-sm-0 col-md-0 col-lg-2 col-centered">
	  </div>
	  
	<div class="wrapper col-xs-12 col-sm-6 col-sm-push-6 col-md-6 col-md-push-6 col-lg-4 col-lg-push-4 col-centered nopading" >
	
					<s:form action="ValidateUser" cssClass="form animate-form"
						id="form" onsubmit="return true;" acceptcharset="UTF-8" >
						<div class="form-header">
							<h1>INICIE SESIÓN</h1>
						</div>
						<br></br>
						<div class="form-group has-feedback">
							<div class="input-group-addon">
								<div class="glyphicon glyphicon-envelope"></div>
							</div>
							<input class="form-control" id="email" name="email"
								placeholder="Correo Electrónico" type="text">
								<s:hidden name="a" value="2"/>
							<span	class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<div class="input-group-addon">
								<div class="glyphicon glyphicon-lock"></div>
							</div>
							<input class="form-control" id="password" name="password"
								placeholder="Contraseña" type="password">
								 <span class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
						<div style="text-align: left; height: 0px;">
							&nbsp; <a href="#" id="olvClave">Olvidaste tu clave?</a>&nbsp;
							&nbsp;&nbsp;<a class="registrate" href="singup.action">Crear una cuenta</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<div class="form-group submit">
							<input class="btn btn-lg" type="submit" value="ENVIAR">
						</div>
					</s:form>
	  </div>
	
	
	    <div  class="col-xs-12 col-sm-6 col-sm-pull-6 col-md-6 col-md-pull-6 col-lg-4 col-lg-pull-4 col-centered firstcolum">
				<!------------------------------------------------ -->
			<div style="text-align: left; margin-left: 20px;">
				<br/>
				<h1>
					<strong style="color: #954F9A;">Bienvenido a Tortas
						Encantada</strong>
				</h1>
				<h3>Crear una cuenta en menos de un minuto</h3>
				¿Es su primer pedido? Aprovechese de las ventajas de Tortas
				Encantada al &nbsp;<a href="singup.action">Crear una cuenta</a> . <br></br>
				<h1></h1>
				<br></br>
			</div> <!------------------------------------------------ -->
	    </div>
	
   	  <div class="col-xs-12 col-sm-0 col-md-0 col-lg-2 col-centered">
	  
	  </div>

   </div> <!--en row -->
</div> <!-- FIN CONTENEDOR LOGIN -->	
<br/>	


<!-- Modal recuperar contraseña -->
<div class="modal fade" id="myModalRecPass" role="dialog" ria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
  <s:form id="formRecPass" action="enviarClave"  theme="bootstrap" cssClass="animate-form well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Recuperar mi Contraseña</h4>
    </div>
	<div class="modal-body">
	    	<div class="form-group">
	    		<s:textfield label="Ingresa tu correo electrónico para que tu clave sea enviada." id="emailrec" name="email" cssClass="form-control"/>
	    	</div>
   	</div>
    <div class="modal-footer">
	  	  <div style="text-align:left;">
	  	  		<s:submit cssClass="btn btn-primary" value="Enviar Correo"/>&nbsp;&nbsp;
	   	  </div>
	      		<button type="button" class="btn btn-default" id="cancelar" data-dismiss="modal">Cancelar</button>
    </div>
    </s:form>
  </div>
</div>
</div>


	
	
