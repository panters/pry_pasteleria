<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link href="css/styles_account.css" media="all" rel="stylesheet">

<script>/*
$.growl(
			{
				title:" <strong>Mensaje: </strong></b>",
				message:"Clave envia a"+$('#email').val(),
				icon:"glyphicon glyphicon-thumbs-up"
			},
			{
				type:'info'
			}
		);*/
</script>

<div id="contenedor" width="100%">
	<table width="800px">
		<tr>
			<td width="400">
				<!------------------------------------------------ -->
				<div style="text-align: left; margin-left: 20px;">
					<h1>
						<strong style="color: #954F9A;">Bienvenido a Tortas Encantada</strong>
					</h1>
					<h3>Crear una cuenta en menos de un minuto</h3>
					¿Es su primer pedido? Aprovechese de las ventajas de Tortas
					Encantada al &nbsp;<a href="singup.action">Crear una cuenta</a> . <br></br>
					<h1></h1>
					<br></br>
				</div> <!------------------------------------------------ -->
			</td>
			<td width="300px">
				<div class="wrapper" id="colum2">
					<s:form  action="enviarClave" cssClass="form animate-form"
						id="form" onsubmit="return true;">
						<div class="form-header">
							<h3>RECUPERAR CONTRASEÑA</h3>
						</div>
						<p>Ingresa tu correo electrónico para que tu clave sea enviada.</p>

						<div class="form-group has-feedback">
							<div class="input-group-addon">
								<div class="glyphicon glyphicon-envelope"></div>
							</div>
							<input class="form-control" id="email" name="email" placeholder="Correo Electrónico" type="text">
							<span class="glyphicon glyphicon-ok form-control-feedback"></span>
						</div>
						<div class="form-group submit">
							<s:submit cssClass="btn btn-lg" value="ENVIAR CLAVE"/>
						</div>
					</s:form>
				</div>



			</td>
		</tr>
	</table>
</div>