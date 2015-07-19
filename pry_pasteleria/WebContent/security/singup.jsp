<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>

<link href="css/styles_reg.css" media="all" rel="stylesheet">

<style>
#registrar{
display: block;
width: 100%;
font-size: 18px;
letter-spacing: 0.4em;
border-radius: 0px 0px 4px 4px;
border: 0px none;
padding: 20px 0px 22px;
background-color: #F7A2CB;
color: #FFF;
height: 65px;
font-weight: 500;
transition: all 0.4s ease 0s;
margin-right: -415px;
margin-top: -65px;
}
</style>

<script>
$(document).ready(function(){
	
	var picker=$("#nacimiento");
	
	picker.keypress(function(e){
		e.preventDefault();
	});
	
    picker.datepicker({
        language: "es"                 
    });

	
	$('#formRegCli').submit(function(e){
		e.preventDefault();
		 //detenemos el evento para validar el form
		   var $form=$(this);
		   if (! $form.valid()) {
				return false;
			  //si no es valido no hacemos nada
			}else{
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
				return false;
			   }
	});	
	
});


</script>

<div class="form-header">
	<h1>REGISTRO DE CLIENTE</h1>
</div>
<form class="form animate-form" id="formRegCli" >

	<table width="800" id="table_registro">

		<tr>
			<td width="400px">

				<div class="form-group">
					<label class="control-label sr-only" for="email">Correo</label>
					<input class="form-control" id="email" name="email" placeholder="Correo electronico" type="text">
				</div>

				<div class="form-group">
					<label class="control-label sr-only" for="password">Contrase&ntilde;a</label>
					<input class="form-control" id="password" name="password" placeholder="Contraseña" type="password">
				</div>


				<div class="form-group">
					<label class="control-label sr-only" for="password">Contrase&ntilde;a</label>
					<input class="form-control" id="password" name="password" placeholder="Confirmar Contrase&ntilde;a" type="password">
				</div>

				<div class="form-group">
					<label class="control-label sr-only" for="username">Nombre Completo</label>
					<input class="form-control" id="username" name="nombre" placeholder="Nombre Completo" type="text"> 
				</div>

				<div class="form-group">
					<label class="control-label sr-only" for="email">Apellido Paterno</label>
					<input class="form-control" id="apellidop" name="ape_pa" placeholder="Apellido Paterno" type="text"> 
				</div>

				<div class="form-group">
					<label class="control-label sr-only" for="email">Apellido Materno</label>
					<input class="form-control" id="apellidom" name="ape_ma" placeholder="Apellido Materno" type="text"> 
				</div>
                
                  
				<div class="form-group submit">
					<a href="logueo.action" style="background-color: #7E506C;">CANCELAR</a>
				</div> <!------------------------------------------>
			</td>
			<td width="80px"></td>
			<td width="400px">

                <div class="form-group" style="margin-top: -59px;">
					<div class="input-group">
						<!--  <div class="radio"> -->
							Seleccione Estado Civil:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="estado" value="C">Casado</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio"
								name="estado" value="S">Soltero</label>
						<!--  </div> -->
					</div>
				</div>

                <div class="form-group">
					<label class="control-label sr-only" for="email">Documento DNI</label> 
					<input class="form-control" id="documento" name="dni" placeholder="Documento DNI" type="text"> 
				</div>

				<div class="form-group">
					<div class="input-group">
						<!--  <div class="radio"> -->
							Seleccione Sexo:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="sexo" value="M">Masculino</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio"
								name="sexo" value="F">Femenino</label>
						<!--  </div>  -->
					</div>
				</div>


				<div class="form-group">
					<label class="control-label sr-only" for="email">Telefono</label>
					<input class="form-control" id="telefono" name="telefono" placeholder="Telefono" type="text"> 
				</div>

				<div class="form-group">
					<label class="control-label sr-only" for="email">Celular</label>
					<input class="form-control" id="celular" name="celular" placeholder="Celular" type="text">
				</div>


 				<div class="form-group">
					<label class="control-label sr-only" for="nacimiento">Fecha Nacimiento</label>
					<input class="form-control" id="nacimiento" name="fec_nacimiento" placeholder="Fecha Nacimiento" type="text" autocomplete="off">
				</div> 
				
					
				<div class="form-group submit">
					<s:submit id="registrar" cssStyle="background-color: #A1477E;" value="REGISTRAR"  />
				</div>

			</td>
		</tr>

	</table>
	
</form>
<div>
	<h1></h1>
</div>
