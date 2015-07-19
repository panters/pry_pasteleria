<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Lockscreen</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="templateAdmin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="templateAdmin/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
        <!-- jQuery 2.1.4 -->
    <script src="templateAdmin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="js/jquery.bootstrap-growl.js"></script>
	<script src="js/bootstrap-growl.min.js"></script>	
    <!-- Bootstrap 3.3.2 JS -->
    <script src="templateAdmin/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    
  </head>
  <body class="lockscreen">
    <!-- Automatic element centering -->
    <div class="lockscreen-wrapper">
      <div class="lockscreen-logo">
        <a href="Admin.action"><b>Admin</b>LTE</a>
      </div>
      <!-- User name -->
      <div class="lockscreen-name"><s:label name="username" cssStyle="font-size: 1.3em;"/></div>

      <!-- START LOCK SCREEN ITEM -->
      <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
          <img src="templateAdmin/dist/img/user1-128x128.jpg" alt="user image"/>
        </div>
        <!-- /.lockscreen-image -->

<s:if test="hasActionErrors()">
	<s:actionerror id="messagerror" />
	<script>
		var msj = $('#messagerror li span').text();
		$('#messagerror').remove();
		$.growl(
				{
					title:" <strong>Error: </strong></b>",
					message:msj,
					icon:"glyphicon glyphicon-alert"
				},
				{
					type:'danger'
				}
			);
	</script>
</s:if>



        <!-- lockscreen credentials (contains the form) -->
        <form class="lockscreen-credentials" action="reloadSession.action">
          <div class="input-group">
            <input type="password" name="password" class="form-control" placeholder="contraseña" />
            <div class="input-group-btn">
              <button class="btn"><i class="fa fa-arrow-right text-muted"></i></button>
            </div>
          </div>
        </form><!-- /.lockscreen credentials -->

      </div><!-- /.lockscreen-item -->
      <div class="help-block text-center">
        Ingresa tu contraseña para reanudar tu sessi&oacute;n.
      </div>
      <div class='text-center'>
        <a href="Admin.action?newsession=1">O inicia sessi&oacute;n con un usuario diferente.</a>
      </div>
      <div class='lockscreen-footer text-center'>
        Copyright &copy; 2014-2015 <b><a href="http://almsaeedstudio.com" class='text-black'>Grupo uno Calidad</a></b><br>
        Todos los derechos reservados
      </div>
    </div><!-- /.center -->


  </body>
</html>