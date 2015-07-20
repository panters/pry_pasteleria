<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="templateAdmin/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />    
    <!-- FontAwesome 4.3.0 -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons 2.0.0 -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />    
    <!-- Theme style -->
    <link href="templateAdmin/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
    <link href="templateAdmin/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="templateAdmin/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="templateAdmin/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="templateAdmin/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
   
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="templateAdmin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
	
	
	<link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.0/animate.min.css" media="all" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.standalone.css">
	
	
	<%-- <script src="templateAdmin/plugins/jQuery/jQuery-2.1.4.min.js"></script> --%>
	
	<sj:head />
	<script src="js/jquery.idle.js"></script>
	<script src="js/jquery.bootstrap-growl.js"></script>
	<script src="js/bootstrap-growl.min.js"></script>	
	<script src="js/datatables/jquery.dataTables.min.js"></script>
	<script src="js/datatables/dataTables.responsive.js"></script>
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/datatables/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="css/datatables/dataTables.responsive.css">
	<link rel="stylesheet" type="text/css" href="css/datatables/dataTables.bootstrap.css">
  
   
    <script src="js/validacion.js"></script>
    </head>
  <body class="skin-blue sidebar-mini">
    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        <a href="#" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>A</b>LT</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Admin</b>PAS</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                      
			<!--  -->
            <li class="dropdown user user-menu">
            
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="templateAdmin/dist/img/user1-128x128.jpg" class="user-image" alt="User Image"/>
                  <span class="hidden-xs">${session.user.nombre}&nbsp;${session.user.ape_pa}&nbsp;${session.user.ape_ma}</span>
                </a>
                  
                <ul class="dropdown-menu">
                   
                  <li class="user-header">
                    <img src="templateAdmin/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                    <p>
                      Alexander Pierce - Web Developer
                      <small>Miembro desde Nov. 2012</small>
                    </p>
                  </li>
                  
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </li>
                   
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="#" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>

			

			<!-- Control Sidebar Toggle Button -->
              <li>
                <a href="logoutAdmin.action">Cerrar Sessi&oacute;n&nbsp;</a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      
      
      
      
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="templateAdmin/dist/img/user1-128x128.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>${session.user.nombre}&nbsp;${session.user.ape_pa}</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- sidebar menu: : style can be found in sidebar.less -->
          
          <tiles:insertAttribute name="menu"/>
      
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
   <div class="content-wrapper">
   
   <tiles:insertAttribute name="body"/>
   
      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.0
        </div>
        <strong>Copyright &copy; 2014-2015.</strong> Todos los Derechos Reservados.
      </footer>
      
      <!-- Control Sidebar -->      

      <div class='control-sidebar-bg'></div>


    </div><!-- ./wrapper -->
  
  
    <!-- jQuery 2.1.4 -->
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    
    <script src="js/jquery.validation.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/messages_es.js"></script>
    <script src="js/main.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
      
     $.widget.bridge('uibutton', $.ui.button);
      
     $(document).idle({
         onIdle: function(){
           //alert('Inactivo un 2 segundos!');
           window.location.href="lockscreen.action";
         },
         onActive: function(){
        	 //alert('Active!');
         },
         onHide: function(){
        	 //alert('Hidden!');
         },
         onShow: function(){
           // Add a slight pause so you can see the change
           setTimeout(function(){
        	   //alert('Visible!');
           }, 250);
         },
         idle:60*1000
       });
     
     $(document).ready(function(){

    	 var patron = /^\d*$/;
         var date=new Date();
         var month = date.getMonth()+1;
         var day = date.getDate();
         var year=date.getFullYear();
    	     	 
      
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
      
	
     }); 
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="templateAdmin/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>    
    <!-- datepickers -->
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/bootstrap-datepicker.es.min.js"></script>
    
    <!-- Morris.js charts -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="templateAdmin/plugins/morris/morris.min.js" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="templateAdmin/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="templateAdmin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
    <script src="templateAdmin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="templateAdmin/plugins/knob/jquery.knob.js" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="templateAdmin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="templateAdmin/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='templateAdmin/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="templateAdmin/dist/js/app.min.js" type="text/javascript"></script>    
    
    <!-- AdminLTE dashboard demo (This is only for demo purposes)
    <script src="templateAdmin/dist/js/pages/dashboard.js" type="text/javascript"></script>    
     -->
    <!-- AdminLTE for demo purposes -->
    <script src="templateAdmin/dist/js/demo.js" type="text/javascript"></script>
  </body>
</html>
