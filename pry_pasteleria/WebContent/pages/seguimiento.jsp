<%@ taglib uri="/struts-tags" prefix="s"%>
<style type="text/css">
.divcenter {
	text-align: center;
}

.tableCriterios {
	/*margin-left: 15%;
	width:100%*/
}

.tablecenter {
	text-align: center;
	/*width: 70%;*/
	margin: 0 auto;
}

.tablecenter thead th {
	text-align: center;
}

.campos {
	display: inline-block;
}
</style>
<script>

function myColorChange(object) {
	var x = $(object).val();
	if (x == 2) {
		$(object).removeClass('label label-warning');
		$(object).addClass('label label-success');
	} else {
		$(object).removeClass('label label-success');
		$(object).addClass('label label-warning');
	}
}
function ver(e){
	$('#detalle').fadeIn(1500);
	$('#lstPedidos').hide();
}

function eliminar(object){
  $(object).parent().parent().remove();
}
function ocultar(e){
	$('#detalle').hide(500);
	$('#lstPedidos').show();
}

</script>

<div id="lstPedidos" class="panel panel-primary" style="width: 80%; margin: 0 10% 10%;">
<div class="panel-heading">
	<h4 class="panel-title">Listado de Pedidos</h4>
</div>
<div class="panel-body">
<div class="tableCriterios">
	<div class="campos">
		<label>&nbsp;&nbsp;Codigo de Pedido:</label> <input type="text"
			size="20" />
	</div>
	<div class="campos">
		<label>&nbsp;Estado:</label> <select>
			<option>--Seleccione--</option>
			<option>Pendiente</option>
			<option>Cancelado</option>
			<option>Finalizado</option>
		</select>
	</div>
	<div class="campos">
		<label>&nbsp;</label>
	</div>
	<div class="campos">
		<input type="submit" class="btn btn-primary" value="Consultar" />
	</div>
</div>

<br></br>

<div class="divcenter">
<div class="table-responsive">
	<table class="table table-striped table-hover tablecenter">
		<thead>
			<tr class="info">
				<th>#</th>
				<th>Pedido</th>
				<th>Fecha Solicitud</th>
				<th>Monto Total</th>
				<th>Estado</th>
				<th colspan="2">Accion</th>
			</tr>
		</thead>
		<tbody>
			<tr class="info">
				<td>1</td>
				<td>P001891</td>
				<td>10/10/2015</td>
				<td>S/.120.00</td>
				<td><span class="label label-success">Pendiente</span></td>
				<td><a href="#" class="label label-warning" onclick="ver(this)">Ver</a></td>
				<td><a href="#" class="label label-danger" onclick="eliminar(this)">Anular</a></td>
			</tr>
			<tr class="info">
				<td>2</td>
				<td>P001892</td>
				<td>10/10/2015</td>
				<td>S/.120.00</td>
				<td><span class="label label-success">Pendiente</span></td>
				<td><a href="#" class="label label-warning" onclick="ver(this)">Ver</a></td>
				<td><a href="#" class="label label-danger" onclick="eliminar(this)">Anular</a></td>
			</tr>
			<tr class="info">
				<td>3</td>
				<td>P001878</td>
				<td>10/10/2015</td>
				<td>S/.120.00</td>
				<td><span class="label label-danger">Cancelado</span></td>
				<td><a href="#" class="label label-warning" onclick="ver(this)">Ver</a></td>
				<td><a href="#" class="label label-danger" onclick="eliminar(this)">Anular</a></td>
			</tr>
			<tr class="success">
				<td>4</td>
				<td>P001891</td>
				<td>10/10/2015</td>
				<td>S/.120.00</td>
				<td><span class="label label-primary">Finalizado</span></td>
				<td><a href="#" class="label label-warning" onclick="ver(this)">Ver</a></td>
				<td><a href="#" class="label label-danger" onclick="eliminar(this)">Anular</a></td>
			</tr>
			<tr class="info">
				<td>5</td>
				<td>P001891</td>
				<td>10/10/2015</td>
				<td>S/.120.00</td>
				<td><span class="label label-primary">Finalizado</span></td>
				<td><a href="#" class="label label-warning" onclick="ver(this)">Ver</a></td>
				<td><a href="#" class="label label-danger" onclick="eliminar(this)">Anular</a></td>
			</tr>
		</tbody>
	</table>
</div>
</div>

</div>


</div>


<div id="detalle" class="panel panel-primary" style="width: 80%; margin: 0 10% 10%;">
	<div class="panel-heading">
		<h4 class="panel-title">Detalle de Pedido</h4>
	</div>
	<div class="panel-body">
	<div class="table-responsive">
		<table>
			<tr>
				<td><label>&nbsp;&nbsp;Codigo de Pedido:&nbsp;</label></td>
				<td><input type="text" size="20" disabled="disabled" /></td>
				<td><label>&nbsp;Estado:</label></td>
				<td><select>
						<option>--Seleccione--</option>
						<option>Pendiente</option>
						<option>Cancelado</option>
						<option>Finalizado</option>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><label>&nbsp;&nbsp;Fecha Solicitud:</label></td>
				<td><input type="text" size="20" disabled="disabled" /></td>
				<td><label>&nbsp;&nbsp;Dirección Entrega:&nbsp;</label></td>
				<td><input type="text" size="20" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead>
				<tr class="info">
					<th>#</th>
					<th>Producto</th>
					<th>Descripción</th>
					<th>Cantidad</th>
					<th>Precio Unit</th>
					<th>Agasajado</th>
					<th>Dedicatoria</th>
					<th>Fecha entrega</th>
					<th>Importe</th>
					<th>Estado</th>
					<th colspan="2">Acción</th>
				</tr>
			</thead>
			<tbody>
				<tr class="info">
					<td>1</td>
					<td>P001891</td>
					<td>colum content</td>
					<td>2</td>
					<td>S/30.00</td>
					<td>colum content</td>
					<td>colum content</td>
					<td>10/10/2015</td>
					<td>S/.120.00</td>
					<td><select class="label label-warning"
						onchange="myColorChange(this)">
							<option value="1">Proceso</option>
							<option value="2">Despachado</option>
					</select></td>
					<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="#" onclick="eliminar(this)"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
				<tr class="info">
					<td>2</td>
					<td>P001892</td>
					<td>colum content</td>
					<td>2</td>
					<td>S/30.00</td>
					<td>colum content</td>
					<td>colum content</td>
					<td>10/10/2015</td>
					<td>S/.120.00</td>
					<td><select class="label label-warning"
						onchange="myColorChange(this)">
							<option value="1">Proceso</option>
							<option value="2">Despachado</option>
					</select></td>
					<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="#" onclick="eliminar(this)"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
				<tr class="info">
					<td>3</td>
					<td>P001878</td>
					<td>colum content</td>
					<td>2</td>
					<td>S/30.00</td>
					<td>colum content</td>
					<td>colum content</td>
					<td>10/10/2015</td>
					<td>S/.120.00</td>
					<td><select class="label label-warning"
						onchange="myColorChange(this)">
							<option value="1">Proceso</option>
							<option value="2">Despachado</option>
					</select></td>
					<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="#" onclick="eliminar(this)"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
				<tr class="success">
					<td>4</td>
					<td>P001891</td>
					<td>colum content</td>
					<td>2</td>
					<td>S/30.00</td>
					<td>colum content</td>
					<td>colum content</td>
					<td>10/10/2015</td>
					<td>S/.120.00</td>
					<td><select class="label label-warning"
						onchange="myColorChange(this)">
							<option value="1">Proceso</option>
							<option value="2">Despachado</option>
					</select></td>
					<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="#" onclick="eliminar(this)"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
				<tr class="info">
					<td>5</td>
					<td>P001891</td>
					<td>colum content</td>
					<td>2</td>
					<td>S/30.00</td>
					<td>colum content</td>
					<td>colum content</td>
					<td>10/10/2015</td>
					<td>S/.120.00</td>
					<td><select class="label label-warning"
						onchange="myColorChange(this)">
							<option value="1">Proceso</option>
							<option value="2">Despachado</option>
					</select></td>
					<td><a href="#"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="#" onclick="eliminar(this)"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</tbody>
		</table>
	</div>
		
		<div style="text-align: right;">
			<div style="display: inline-block;">
				<s:submit cssClass="btn btn-primary" value="Guardar" />
			</div>
			<div style="display: inline-block;">
				<a class="btn btn-default" href="#" onclick="ocultar()" >Cancelar</a>
			</div>
		</div>
		
	</div>
</div>

<br></br>
<br></br>
<br></br>
