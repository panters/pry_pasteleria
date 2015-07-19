<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="UTF-8" />
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
    
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
   
     
    <link href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" media="all" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Raleway:300,500" rel="stylesheet" type="text/css">
   
    <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.0/animate.min.css" media="all" rel="stylesheet">
 	<link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.standalone.css">
 	
	<link href="css/styles_catalogo.css" media="all" rel="stylesheet">
	<link href="css/bootstrap.min.css" media="all" rel="stylesheet">
	<!-- 
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://bootswatch.com/cosmo/bootstrap.min.css"/>
	-->
	 
  	<sj:head jquerytheme="excite-bike" locale="es" jqueryui="true"/>
  	<!-- excite-bike start dot-luv
  	<sj:head jquerytheme="showcase" customBasepath="themes" locale="es" jqueryui="true"/>
  	-->
  	
  	<script src="js/jquery-ui.js"></script>
  	
  	<script src="js/jquery.bootstrap-growl.js"></script>
	<script src="js/bootstrap-growl.min.js"></script>	
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.1/modernizr.min.js"></script>
	
	<script src="js/datatables/jquery.dataTables.min.js"></script>
	<script src="js/datatables/dataTables.responsive.js"></script>
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	
	<script src="js/html2canvas.js"></script>
	<script src="js/canvas2image.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/datatables/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="css/datatables/dataTables.responsive.css">
	<link rel="stylesheet" type="text/css" href="css/datatables/dataTables.bootstrap.css">
	
</head>		

<body>

	<div>
		<div>
			<tiles:insertAttribute name="baner"/>
		</div>
				
		<div>
			<tiles:insertAttribute name="menu"/>
		</div>
		<div>
			<tiles:insertAttribute name="body"/>
		</div>
	</div>



<!---------------------------------------------->
    <script src="js/jquery.validation.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/messages_es.js"></script>
    <script src="js/main.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/bootstrap-datepicker.es.min.js"></script>
     <script>
     // A $( document ).ready() block.
      $( document ).ready(function() {
    	  
   	   var patron = /^\d*$/;
       var date=new Date();
       var month = date.getMonth()+1;
       var day = date.getDate();
       var year=date.getFullYear();
      /*  
	  $('.input-group.date').datepicker({
	        language: "es",
	        startDate: date,
	        datesDisabled:[
	                        day+'/'+month+'/'+year,
	                        day+1+'/'+month+'/'+year
	                      ]                     
	    });
	  */
	  
	  $('body').delegate(".input-group.date", "focusin", function () {
		    $(this).datepicker({
		        language: "es",
		        startDate: date,
		        datesDisabled:[
		                        day+'/'+month+'/'+year,
		                        day+1+'/'+month+'/'+year
		                      ]                     
		    });
		});
	  
	 
	
	//Evita la escritura en los campos de fecha del carrito
	  $('body').delegate(".input-group.date", "keypress", function (e) {
			e.preventDefault();
			//alert('Escritura deshabilitada, utilize el DatePicker para la fecha');
	  });
	
	//Evita el doble click en los campos de fecha del carrito     
	  $('body').delegate(".input-group.date #fechita", "dblclick", function (e) {
			e.preventDefault();
			//alert('Doble Click deshabilitado-previene el registro de fechas anteriores');
	  });
	
	//Evita el doble click en los campos de fecha del carrito     
	  $('body').delegate(".input-group.date #fechita", "click", function (e) {
			e.preventDefault();
			//alert(' Click deshabilitado-previene el registro de fechas anteriores');
	  });
	
	
       $('#detalle').hide();
	 
 });
</script>
</body>
</html>