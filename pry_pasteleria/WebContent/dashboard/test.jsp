<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Test Struts2</title>
</head>
<body bgcolor="yellow">
<s:textfield label="Greet " name="mensaje"/>

<s:select label="Estados"  list="estados" 
headerKey="0" headerValue="--Seleccione--" 
listKey="idEstado" listValue="descripcion"/>
<br></br>

<s:select label="Categorias"  list="categorias" 
headerKey="0" headerValue="--Seleccione--" 
listKey="idCategoria" listValue="descripcion"/>
<br></br>

<s:select label="Coberturas"  list="coberturas" 
headerKey="0" headerValue="--Seleccione--" 
listKey="idCobertura" listValue="descripcion"/>
<br></br>

<s:select label="Masas"  list="masas" 
headerKey="0" headerValue="--Seleccione--" 
listKey="idMasa" listValue="descripcion"/>
<br></br>

<s:select label="Rellenos"  list="rellenos" 
headerKey="0" headerValue="--Seleccione--" 
listKey="idRelleno" listValue="descripcion"/>

</body>
</html>