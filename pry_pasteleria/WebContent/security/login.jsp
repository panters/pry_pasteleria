<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="css/styles_account.css" media="all" rel="stylesheet">
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
		/*
		$.bootstrapGrowl("Mensaje: " + msj + "..!", {
			type : 'danger',
			width : 'auto',
			align:'rigth',
			allow_dismiss : false
		});*/
	</script>
</s:if>


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
							<span	class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<div class="input-group-addon">
								<div class="glyphicon glyphicon-lock"></div>
							</div>
							<input class="form-control" id="password" name="password"
								placeholder="Contraseña" type="password"> <span
								class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
						<div style="text-align: left; height: 0px;">
							&nbsp; <a href="recoverPwd.action">Olvidaste tu clave?</a>&nbsp;
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
	
