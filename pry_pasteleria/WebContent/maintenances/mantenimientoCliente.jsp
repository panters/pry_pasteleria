<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		//limpiar fields
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
	}
	
	function abrirVentana(){
		cleaner();
		$('#dialog1').dialog("open");
		$('#txtid').val('nuevo');
	}

	$.subscribe('cerrarVentana',function(event,data){
		$('#dialog1').dialog("close");
	});

	function formatodel(cellvalue,data,options){
		return "<a href=javascript:eliminar('"+cellvalue+"')><span class=\"glyphicon glyphicon-trash\"></span></a>";
	}
	function eliminar(cellvalue){
		$.getJSON("deleteCustomer?cliente.idUsuario="+cellvalue,function(datos){
			$.publish('cargaGrid');
			alert("Registro Eliminado");
		});
	}
	function formatoedit(cellvalue,data,options){
		return "<a href=javascript:editar('"+cellvalue+"')><span class=\"glyphicon glyphicon-pencil\"></span></a>";
	}
	function editar(cellvalue){
		$.getJSON("findCustomer?cliente.idUsuario="+cellvalue,function(datos){
			abrirVentana();
			$('#txtnom').val(datos.cliente.nombre);
			$('#txtape_pa').val(datos.cliente.ape_pa);
			$('#txtape_ma').val(datos.cliente.ape_ma);
			$('#txtdni').val(datos.cliente.dni);
			$('#txtfec_nac').val(datos.cliente.fec_nacimiento);
			$('#txtsexo').val(datos.cliente.sexo);
			$('#txtemail').val(datos.cliente.email);
			$('#txtestado_civil').val(datos.cliente.estado_civil);
			$('#txttelefono').val(datos.cliente.telefono);
			$('#txtcelular').val(datos.cliente.celular);
			$('#txtid').val(datos.cliente.idUsuario);
		});
	}
	

</script>

<s:url id="URL_ListCustomers" action="listCustomer"/>

<sjg:grid 
id="gridClientes"
gridModel="clientes" 
caption="Listado de Clientes"
dataType="json"
href="%{URL_ListCustomers}"
reloadTopics="cargaGrid"
onSelectRowTopics="rowselectCliente"
width="1100">
	<sjg:gridColumn name="idUsuario" title="Codigo" index="stridUsuario"/>
	<sjg:gridColumn name="nombre" title="Nombre" index="strnombre" editable="true"/>
	<sjg:gridColumn name="ape_pa" title="Apellido Paterno" index="strapepa" editable="true"/>
	<sjg:gridColumn name="ape_ma" title="Apellido Materno" index="strapema" editable="true"/>
	<sjg:gridColumn name="dni" title="DNI" index="strdni"/>
	<sjg:gridColumn name="fec_nacimiento" title="Fecha Nacimiento"/>
	<sjg:gridColumn name="sexo" title="Sexo"/>
	<sjg:gridColumn name="email" title="Correo"/>
	<sjg:gridColumn name="estado_civil" title="Estado Civil"/>
	<sjg:gridColumn name="telefono" title="Telefono"/>
	<sjg:gridColumn name="celular" title="Celular"/>
	<sjg:gridColumn name="fecha_registro" title="Registro"/>
	<sjg:gridColumn name="idUsuario" formatter="formatoedit" title="Editar" width="40"/>
	<sjg:gridColumn name="idUsuario" formatter="formatodel" title="Eliminar" width="40"/>
	
	
	
</sjg:grid>


<sj:a button="true" onclick="abrirVentana()">Nuevo</sj:a>

<sj:dialog id="dialog1" modal="true" width="450" height="550"  title="Datos del Cliente" autoOpen="false">
	<s:form id="frmdatos" action="saveCustomer">
			
			<div>
				<s:hidden    name="cliente.idUsuario" id="txtid"/>
				<s:textfield name="cliente.nombre" id="txtnom"  label="Nombre"/>
				<s:textfield name="cliente.ape_pa" id="txtape_pa" label="Apellido Paterno"/>
				<s:textfield name="cliente.ape_ma" id="txtape_ma" label="Apellido Materno"/>
				<s:textfield name="cliente.dni" id="txtdni" label="DNI"/>
				<s:textfield name="cliente.fec_nacimiento" id="txtfec_nac" label="Nacimiento"/>
				<s:textfield name="cliente.sexo" id="txtsexo" label="Sexo"/>
				<s:textfield name="cliente.email" id="txtemail" label="Email"/>
				<s:textfield name="cliente.estado_civil" id="txtestado_civil" label="Estado Civil"/>
				<s:textfield name="cliente.telefono" id="txttelefono" label="Telefono"/>
				<s:textfield name="cliente.celular" id="txtcelular" label="Celular"/>
			</div>
			<sj:submit value="Grabar" button="true" 
			 onCompleteTopics="cerrarVentana,cargaGrid" targets="divresult"/>
		
	</s:form>
</sj:dialog>
	
<div id="divresult"></div>
