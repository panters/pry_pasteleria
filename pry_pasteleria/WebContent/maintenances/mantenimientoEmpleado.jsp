<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>

<style>
.label{
font-size:0.6em;
color: black;
}
.ui-jqgrid-title{
font-size:1.3em;
}
table{
font-size:1.2em;
}
</style>

<script>
	
	function cleaner(){
		
		$('#txtnom').val('');
		$('#txtape_pa').val('');
		$('#txtape_ma').val('');
		$('#txtdni').val('');
		$('#txtfec_nac').val('');
		$('#txtsexo').val('');
		$('#txtemail').val('');
		$('#txtestado_civil').val('');
		$('#txttelefono').val('');
		$('#txtcelular').val('');
		$('#txtsueldo').val('');
		$('#txtfecha_ingreso').val('');
		$('#txtfecha_salida').val('');
		$('#cborol').val(0);
	}
	
	function abrirVentana(){
		cleaner();	   
	    $('#dialog1').dialog("open");
		$('#txtid').val('nuevo');
		var fregistro=$('#txtfecha_ingreso').parent().parent();
		$(fregistro).hide();
	}
	$.subscribe('cerrarVentana',function(event,data){
		$('#dialog1').dialog("close");
	});
	
	function formatodel(cellvalue,data,options){
		return "<a href=javascript:eliminar('"+cellvalue+"')><span class=\"glyphicon glyphicon-trash\"></span></a>";
	}
	function eliminar(cellvalue){
		$.getJSON("deleteEmployed?empleado.idUsuario="+cellvalue,function(datos){
			$.publish('cargaGrid');
			alert("Registro Eliminado");
		});
	}
	function formatoedit(cellvalue,data,options){
		return "<a href=javascript:editar('"+cellvalue+"')><span class=\"glyphicon glyphicon-pencil\"></span></a>";
	}
	function editar(cellvalue){
		$.getJSON("findEmployed?empleado.idUsuario="+cellvalue,function(datos){
			
			abrirVentana();
			$('#txtnom').val(datos.empleado.nombre);
			$('#txtape_pa').val(datos.empleado.ape_pa);
			$('#txtape_ma').val(datos.empleado.ape_ma);
			$('#txtdni').val(datos.empleado.dni);
			$('#txtfec_nac').val(datos.empleado.fec_nacimiento);
			$('#txtsexo').val(datos.empleado.sexo);
			$('#txtemail').val(datos.empleado.email);
			$('#txtestado_civil').val(datos.empleado.estado_civil);
			$('#txttelefono').val(datos.empleado.telefono);
			$('#txtcelular').val(datos.empleado.celular);
			
			$('#txtsueldo').val(datos.empleado.sueldo);
			$('#txtfecha_ingreso').val(datos.empleado.fecha_ingreso);
			$('#txtfecha_salida').val(datos.empleado.fecha_salida);
			$('#cborol').val(datos.empleado.rol.idRol);
			
			$('#txtid').val(datos.empleado.idUsuario);
			//muestra el campo fecha de ingreso para editarlo 
			var fr=$('#txtfecha_ingreso').parent().parent();
			$(fr).show();
		});
	}
	
</script>

<s:url id="URL_ListEmployeds" action="listEmployed"/>

<sjg:grid 
gridModel="empleados" 
caption="Listado de Empleados"
dataType="json"
href="%{URL_ListEmployeds}"
reloadTopics="cargaGrid"
width="1400">
	<sjg:gridColumn name="idUsuario" title="Codigo"/>
	<sjg:gridColumn name="nombre" title="Nombre"/>
	<sjg:gridColumn name="ape_pa" title="Apellido Paterno"/>
	<sjg:gridColumn name="ape_ma" title="Apellido Materno"/>
	<sjg:gridColumn name="dni" title="DNI"/>
	<sjg:gridColumn name="fec_nacimiento" title="Fecha Nacimiento"/>
	<sjg:gridColumn name="sexo" title="Sexo"/>
	<sjg:gridColumn name="email" title="Correo"/>
	<sjg:gridColumn name="estado_civil" title="Estado Civil"/>
	<sjg:gridColumn name="telefono" title="Telefono"/>
	<sjg:gridColumn name="celular" title="Celular"/>
	<sjg:gridColumn name="rol.descripcion" title="Rol" width="230"/>
	<sjg:gridColumn name="fecha_ingreso" title="Ingreso"/>
	<sjg:gridColumn name="sueldo" title="Sueldo"/>
	<sjg:gridColumn name="fecha_salida" title="Fecha Fin contrato"/>
	<sjg:gridColumn name="idUsuario" formatter="formatoedit" title="Editar" width="40"/>
	<sjg:gridColumn name="idUsuario" formatter="formatodel" title="Eliminar" width="40"/>
	
</sjg:grid>


<sj:a button="true" onclick="abrirVentana()">Nuevo</sj:a>

<sj:dialog id="dialog1" modal="true" width="500" height="620"  title="Datos del Empleado" autoOpen="false">
	<s:form id="frmdatos" action="saveEmployed">
			
			<div>
				<s:hidden    name="empleado.idUsuario" id="txtid"/>
				<s:textfield name="empleado.nombre" id="txtnom" label="Nombre"/>
				<s:textfield name="empleado.ape_pa" id="txtape_pa" label="Apellido Paterno"/>
				<s:textfield name="empleado.ape_ma" id="txtape_ma" label="Apellido Materno"/>
				<s:textfield name="empleado.dni" id="txtdni" label="DNI"/>
				<s:textfield name="empleado.fec_nacimiento" id="txtfec_nac" label="Nacimiento"/>
				<s:textfield name="empleado.sexo" id="txtsexo" label="Sexo"/>
				<s:textfield name="empleado.email" id="txtemail" label="Email"/>
				<s:textfield name="empleado.estado_civil" id="txtestado_civil" label="Estado Civil"/>
				<s:textfield name="empleado.telefono" id="txttelefono" label="Telefono"/>
				<s:textfield name="empleado.celular" id="txtcelular" label="Celular"/>
				
				
				<s:textfield name="empleado.fecha_ingreso" id="txtfecha_ingreso" label="Fecha Ingreso"/>
				<s:textfield name="empleado.sueldo" id="txtsueldo" label="Sueldo"/>
				<s:textfield name="empleado.fecha_salida" id="txtfecha_salida" label="Fecha Fin contrato"/>
				
				
			</div>
			<div>
			<s:url id="URL_ListRoles" action="listRol"/>
				<sj:select id="cborol" label="Rol"
				list="roles"
				listKey="idRol"
				listValue="descripcion"
				href="%{URL_ListRoles}"
				headerKey="0"
				headerValue="--Seleccione--" 
				name="empleado.rol.idRol" />
			</div>
			<sj:submit value="Grabar" button="true" 
			 onCompleteTopics="cerrarVentana,cargaGrid" targets="divresult"/>
		
	</s:form>
</sj:dialog>
	
<div id="divresult"></div>

