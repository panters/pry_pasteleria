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
		$('#txtdescripcion').val('');
	}

	function abrirVentana(){
		cleaner();
		$('#dialog1').dialog("open");
		$('#txtid').val(0);
	}
	$.subscribe('cerrarVentana',function(event,data){
		$('#dialog1').dialog("close");
	});
	
	
	function formatodel(cellvalue,data,options){
		return "<a href=javascript:eliminar('"+cellvalue+"')><span class=\"glyphicon glyphicon-trash\"></span></a>";
	}
	function eliminar(cellvalue){
		$.getJSON("deleteCoverage?cobertura.idCobertura="+cellvalue,function(datos){
			$.publish('cargaGrid');
			alert("Registro Eliminado");
		});
	}
	function formatoedit(cellvalue,data,options){
		return "<a href=javascript:editar('"+cellvalue+"')><span class=\"glyphicon glyphicon-pencil\"></span></a>";
	}
	function editar(cellvalue){
		$.getJSON("findCoverage?cobertura.idCobertura="+cellvalue,function(datos){
			
			abrirVentana();
			$('#txtdescripcion').val(datos.cobertura.descripcion);
			$('#txtid').val(datos.cobertura.idCobertura);
		});

	}
</script>


<s:url id="URL_ListCoverage" action="listCoverage"/>

<sjg:grid 
gridModel="coberturas" 
caption="Listado de Coberturas"
dataType="json"
href="%{URL_ListCoverage}"
reloadTopics="cargaGrid"
width="1100">
	<sjg:gridColumn name="idCobertura" title="Codigo"/>
	<sjg:gridColumn name="descripcion" title="cobertura"/>
	<sjg:gridColumn name="idCobertura" formatter="formatoedit" title="Editar" width="40"/>
	<sjg:gridColumn name="idCobertura" formatter="formatodel" title="Eliminar" width="40"/>
</sjg:grid>

<sj:a button="true" onclick="abrirVentana()">Nuevo</sj:a>

<sj:dialog id="dialog1" modal="true" width="400" height="400"  title="Datos de Cobertura" autoOpen="false">
	<s:form id="frmdatos" action="createCoverage">
			
			<div>
				<s:hidden    name="cobertura.idCobertura" id="txtid"/>
				<s:textfield name="cobertura.descripcion" id="txtdescripcion" label="Cobertura"/>
			</div>
			<sj:submit value="Grabar" button="true" 
			 onCompleteTopics="cerrarVentana,cargaGrid" targets="divresult"/>
	</s:form>
</sj:dialog>
	
<div id="divresult"></div>
