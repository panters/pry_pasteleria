<%@ taglib uri="/struts-tags" prefix="s"%>

<link href="css/styles_reg.css" media="all" rel="stylesheet">

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
					<input class="form-control" id="email" name="text"
						placeholder="Apellido Paterno" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Apellido
						Materno</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-user"></div>
					</div>
					<input class="form-control" id="email" name="text"
						placeholder="Apellido Materno" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Documento
						DNI</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-file"></div>
					</div>
					<input class="form-control" id="email" name="text"
						placeholder="Documento DNI" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<div class="input-group">
						<div class="radio">
							Seleccione Sexo:&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label><input type="radio" name="optradio">Masculino</label>
							&nbsp;&nbsp;&nbsp;&nbsp; <label><input type="radio"
								name="optradio">Femenino</label>
						</div>
					</div>
				</div>

				<div class="form-group submit">
					<a href="logueo.action" style="background-color: #7E506C;">CANCELAR</a>
				</div> <!------------------------------------------>
			</td>
			<td width="80px"></td>
			<td width="400px">


				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Telefono</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-phone-alt"></div>
					</div>
					<input class="form-control" id="email" name="number"
						placeholder="Telefono" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Celular</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-earphone"></div>
					</div>
					<input class="form-control" id="email" name="number"
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

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="password">Departamento</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-list-alt"></div>
					</div>
					<select class="form-control">
						<option value="0">Seleccione Departamento</option>
						<option value="1">Lima</option>
						<option value="2">Anchash</option>
						<option value="3">Apurimac</option>
						<option value="4">Cuzco</option>
						<option value="5">Cajamarca</option>
					</select>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="password">Provincia</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-list-alt"></div>
					</div>
					<select class="form-control">
						<option value="0">Seleccione Provincia</option>
						<option value="1">Lima</option>
						<option value="2">Anchash</option>
						<option value="3">Apurimac</option>
						<option value="4">Cuzco</option>
						<option value="5">Cajamarca</option>
					</select>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="password">Distrito</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-list-alt"></div>
					</div>
					<select class="form-control">
						<option value="0">Seleccione Distrito</option>
						<option value="1">Lima</option>
						<option value="2">Anchash</option>
						<option value="3">Apurimac</option>
						<option value="4">Cuzco</option>
						<option value="5">Cajamarca</option>
					</select>
				</div>

				<div class="form-group has-feedback">
					<label class="control-label sr-only" for="email">Dirección</label>
					<div class="input-group-addon">
						<div class="glyphicon glyphicon-home"></div>
					</div>
					<input class="form-control" id="email" name="text"
						placeholder="Direccion" type="text"><span
						class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>


				<div class="form-group has-feedback">
					<div class="input-group">
						<div class="radio">
							<h4>&nbsp;&nbsp;&nbsp;&nbsp;</h4>
						</div>
					</div>
				</div>

				<div class="form-group submit">
					<input class="btn btn-lg" type="submit" value="REGISTRAR"
						style="background-color: #A1477E;">
				</div>

			</td>
		</tr>

	</table>
</form>
<div>
	<h1></h1>
</div>
