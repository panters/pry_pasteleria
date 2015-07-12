<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>
<!DOCTYPE html>
<html>
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
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="templateAdmin/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="templateAdmin/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="templateAdmin/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="templateAdmin/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <!-- Date Picker -->
    <link href="templateAdmin/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="templateAdmin/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="templateAdmin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />

	<%-- <script src="templateAdmin/plugins/jQuery/jQuery-2.1.4.min.js"></script> --%>
	<sj:head />
	<script src="js/jquery.bootstrap-growl.js"></script>
	<script src="js/bootstrap-growl.min.js"></script>	
	<script src="js/datatables/jquery.dataTables.min.js"></script>
	<script src="js/datatables/dataTables.responsive.js"></script>
	<script src="js/datatables/dataTables.bootstrap.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/datatables/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="css/datatables/dataTables.responsive.css">
	<link rel="stylesheet" type="text/css" href="css/datatables/dataTables.bootstrap.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
  <body class="skin-blue sidebar-mini">
    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        <a href="index2.html" class="logo">
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
              <!-- Messages: style can be found in dropdown.less-->

              <!-- Notifications: style can be found in dropdown.less -->
           
              <!-- Tasks: style can be found in dropdown.less -->
       
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image"/>
                  <span class="hidden-xs">${session.user.nombre}&nbsp;${session.user.ape_pa}&nbsp;${session.user.ape_ma}</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                    <p>
                      Alexander Pierce - Web Developer
                      <small>Member since Nov. 2012</small>
                    </p>
                  </li>
                  <!-- Menu Body -->
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
                  <!-- Menu Footer-->
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
              <!-- Co

              ntrol Sidebar Toggle Button -->

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
              <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>${session.user.nombre}&nbsp;${session.user.ape_pa}</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>Mantenimiento</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="mproduct.action"><i class="fa fa-circle-o"></i>Producto</a></li>
                <li><a href="mcobertura.action"><i class="fa fa-circle-o"></i> Cobertura</a></li>
                <li><a href="mdough.action"><i class="fa fa-circle-o"></i> Masa</a></li>
                <li><a href="mfilling.action"><i class="fa fa-circle-o"></i> Relleno</a></li>
                <li><a href="mcategory.action"><i class="fa fa-circle-o"></i> Categoria</a></li>
                <li><a href="mcustomer.action"><i class="fa fa-circle-o"></i> Clientes</a></li>
                <li><a href="memployed.action"><i class="fa fa-circle-o"></i> Empleados</a></li>
                <li><a href="mrol.action"><i class="fa fa-circle-o"></i> Roles</a></li>

              </ul>
            </li>

            <li>
              <a href="seguimiento.action">
                <i class="fa fa-files-o"></i>
                <span>Seguimiento de Pedido</span>
              </a>
            </li>

            <li>
              <a href="catalogoAdmin.action">
                <i class="fa fa-th"></i> <span>Catálogo</span> 
              </a>
            </li>
      

            <li>
              <a href="carritoAdmin.action">
                <i class="fa fa-laptop"></i>
                <span>Realizar Pedido</span>
              </a>
            </li>


       </ul>
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
        <strong>Copyright &copy; 2014-2015</a>.</strong> Todos los Derechos Reservados.
      </footer>
      
      <!-- Control Sidebar -->      
      <aside class="control-sidebar control-sidebar-dark">                
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">

          <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class='control-sidebar-menu'>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                    <p>Will be 23 on April 24th</p>
                  </div>
                </a>
              </li>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-user bg-yellow"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>
                    <p>New phone +1(800)555-1234</p>
                  </div>
                </a>
              </li>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>
                    <p>nora@example.com</p>
                  </div>
                </a>
              </li>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-file-code-o bg-green"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>
                    <p>Execution time 5 seconds</p>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3> 
            <ul class='control-sidebar-menu'>
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Custom Template Design
                    <span class="label label-danger pull-right">70%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                  </div>                                    
                </a>
              </li> 
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Update Resume
                    <span class="label label-success pull-right">95%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                  </div>                                    
                </a>
              </li> 
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Laravel Integration
                    <span class="label label-waring pull-right">50%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                  </div>                                    
                </a>
              </li> 
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Back End Framework
                    <span class="label label-primary pull-right">68%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                  </div>                                    
                </a>
              </li>               
            </ul><!-- /.control-sidebar-menu -->         

          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">            
            <form method="post">
              <h3 class="control-sidebar-heading">General Settings</h3>
              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Report panel usage
                  <input type="checkbox" class="pull-right" checked />
                </label>
                <p>
                  Some information about this general settings option
                </p>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Allow mail redirect
                  <input type="checkbox" class="pull-right" checked />
                </label>
                <p>
                  Other sets of options are available
                </p>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Expose author name in posts
                  <input type="checkbox" class="pull-right" checked />
                </label>
                <p>
                  Allow the user to show his name in blog posts
                </p>
              </div><!-- /.form-group -->

              <h3 class="control-sidebar-heading">Chat Settings</h3>

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Show me as online
                  <input type="checkbox" class="pull-right" checked />
                </label>                
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Turn off notifications
                  <input type="checkbox" class="pull-right" />
                </label>                
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Delete chat history
                  <a href="javascript::;" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                </label>                
              </div><!-- /.form-group -->
            </form>
          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
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
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/bootstrap-datepicker.es.min.js"></script>
    <script>
      
     $.widget.bridge('uibutton', $.ui.button);
      
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
			alert('Escritura deshabilitada, utilize el DatePicker para la fecha');
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
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js" type="text/javascript"></script>
    <script src="templateAdmin/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="templateAdmin/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="templateAdmin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="templateAdmin/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='templateAdmin/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="templateAdmin/dist/js/app.min.js" type="text/javascript"></script>    
    
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="templateAdmin/dist/js/pages/dashboard.js" type="text/javascript"></script>    
    
    <!-- AdminLTE for demo purposes -->
    <script src="templateAdmin/dist/js/demo.js" type="text/javascript"></script>
  </body>
</html>