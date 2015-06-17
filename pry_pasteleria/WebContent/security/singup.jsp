<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>

<link href="css/styles_reg.css" media="all" rel="stylesheet">


<script>
$(document).ready(function(){
	
	$('#registrar').click(function(){
	
		var username1=$('#username').val();
		var apellidop1=$('#apellidop').val();
		var apellidom1=$('#apellidom').val();
		var documento1=$('#documento').val();
		var nacimiento1=$('#nacimiento').val();
		var sexo1=$('input:radio[name=sexo]:checked').val();
		var email1=$('#email').val();
		var estadocivil1=$('input:radio[name=estado]:checked').val();
		var telefono1=$('#telefono').val();
		var celular1=$('#celular').val();
		var password1=$('#password').val();
		
		if($('#username').val().length<1){
			alert("Debe ingresar datos");
		}else{
				
	 	 $.ajax({			
			type:'post',
			url:'saveCustomer',
			datatype:'json',
			data:{username:username1,apellidop:apellidop1,apellidom:apellidom1,documento:documento1,nacimiento:nacimiento1,
				sexo:sexo1,email:email1,estadocivil:estadocivil1,telefono:telefono1,celular:celular1,password:password1},
			success:function(){
				$.growl(
						{
					    title:"<strong>!Usted ha sido</strong>:",
					    message:"<strong>Registrado</strong>",
					    icon:"glyphicon glyphicon-thumbs-up"
			        	},{
			        		type:'success'
			        	}
			       );				
				$(location).attr('href','logueo.action');				
			}
		});
		}
		
	});	
	
});


</script>

<div class="form-header">
	<h1>REGISTRO DE CLIENTE</h1>
</div>
<form class="form animate-form" id="form" onsubmit="return false;">

	<table width="800" id="table_registro">

		<tr>
			<td width="400px">

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Correo
						electrónico</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-envelope"></div>
					</div>
					<input class="form-control" id="email" name="email"
						placeholder="Correo electronico" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="password">Contraseña</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-lock"></div>
					</div>
					<input class="form-control" id="password" name="password"
						placeholder="Contraseña" type="password"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>


				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="password">Contraseña</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-lock"></div>
					</div>
					<input class="form-control" id="password" name="password"
						placeholder="Confirmar ContraseÃ±a" type="password"
						required="true"> <span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="username">Nombre
						Completo</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-user"></div>
					</div>
					<input class="form-control" id="username" name="text"
						placeholder="Nombre Completo" type="text"> <span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Apellido
						Paterno</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-user"></div>
					</div>
					<input class="form-control" id="apellidop" name="text"
						placeholder="Apellido Paterno" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Apellido
						Materno</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-user"></div>
					</div>
					<input class="form-control" id="apellidom" name="text"
						placeholder="Apellido Materno" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
                
                  
				<div class="form-group submit">
					<a href="logueo.action" style="background-color: #7E506C;">CANCELAR</a>
				</div> <!------------------------------------------>
			</td>
			<td width="80px"></td>
			<td width="400px">

                <div class="form-group has-feedback">
					<div class="input-group">
						<div class="radio">
							Seleccione Estado Civil:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="estado" value="C">Casado</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio"
								name="estado" value="S">Soltero</label>
						</div>
					</div>
				</div>

                <div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Documento
						DNI</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-file"></div>
					</div>
					<input class="form-control" id="documento" name="text"
						placeholder="Documento DNI" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<div class="input-group">
						<div class="radio">
							Seleccione Sexo:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="sexo" value="M">Masculino</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio"
								name="sexo" value="F">Femenino</label>
						</div>
					</div>
				</div>


				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Telefono</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-phone-alt"></div>
					</div>
					<input class="form-control" id="telefono" name="number"
						placeholder="Telefono" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Celular</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-earphone"></div>
					</div>
					<input class="form-control" id="celular" name="number"
						placeholder="Celular" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>


 				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="nacimiento">Fecha
						Nacimiento</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-calendar"></div>
					</div>
					<input class="form-control" id="nacimiento" name="text"
						placeholder="Fecha Nacimiento" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div> 
				
				
<%-- 			    <div class="form-group has-feedback">
			      <label class="control-label sr-only" for="nacimiento">Fecha
						Nacimiento</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-calendar"></div>
					</div>
					<input class="form-control input-group date" id="nacimiento" name="text"  
					      placeholder="Fecha Nacimiento" type="text">
						<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
				</div> --%>
				
				<div class="form-group submit">
					<a href="#" id="registrar" style="background-color: #A1477E;">REGISTRAR</a>
				</div>

			</td>
		</tr>

	</table>
	
</form>
<div>
	<h1></h1>
</div>
