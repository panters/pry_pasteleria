<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<script src="js/mytemplates/cartAdmin.js"></script>

<style type="text/css">

.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
input[type=number]{
	width:60px;
	}
.table{
background-color: white;
}	

@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	} 
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-primary{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
</style>

<!-- ------------------------------------------------------------- -->

<section class="content-header">
		 <h1>
            Carrito de Compras
          </h1>
    </section>     

  	 
	<section class="content">
	<div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title"></h3>
                </div><!-- /.box-header -->
                <div class="box-body">

<div class="container  col-lg-12" id="stepone" >

	<table id="cart" class="table table-hover table-condensed">
	  <thead>
	    <tr class="primary">
	      <th style="width:50%">Producto</th>
	      <th style="width:10%">Precio</th>
	      <th style="width:8%">Cantidad</th>
	      <th style="width:22%" class="text-center">Subtotal</th>
	      <th style="width:10%"></th>
	    </tr>
	  </thead>
        
	  <tbody>
	  </tbody> 


	 <tfoot>
		<tr class="visible-xs">
			<td class="text-center"><strong>Total S/.</strong><strong class="txtTotal">0.00</strong></td>
		</tr>
		<tr>		    
			<td><a  href="catalogoAdmin.action" class="btn btn-primary">Agregar Productos</a></td>
			<td colspan="2" class="hidden-xs"></td>
			<td class="hidden-xs text-center"><strong id="TotalPedido">Total S/.</strong><strong class="txtTotal">0.00</strong></td>
			<td><a  id="continuarSteptwo"  href="#" class="btn btn-success btn-block"><!--Checkout-->Continuar con Pedido</a></td>
		</tr>
	 </tfoot>
  </table> 
</div>
	
	
<!------------------------------------------------------------------- -- -->
<div class="modal fade" id="myModalBusqueda" role="dialog" ria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
  <s:form id="form" action="saveCustomer"  theme="bootstrap" cssClass="well form-vertical">
    <div class="modal-header">
    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    	<h4>Buscar Cliente</h4>
    </div>

	       <div class="modal-body">
	         <table id="view" class="table table-striped table-hover dt-responsive" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>Codigo</th>
			                <th>Nombre</th>
			                <th>A.Paterno</th>
			                <th>A.Materno</th>
			                <th>Dni</th>
<!-- 				        <th>Nacimiento</th>
			                <th>Sexo</th>
			                <th>Email</th>
     		                <th>E.Civil</th>
			                <th>Telefono</th>
			                <th>Celular</th> -->
			            </tr>
			        </thead>
			        
			    </table>
	       
	       </div>


      <div class="modal-footer">
  	  <div style="text-align:left;">
  	  </div>
   	  	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
      </div>
    </s:form>
  </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->

</div>
<!------------------------------------------------------------------- -- -->
<div class="container col-lg-12" id="setptwo">
<s:form id="formRegPedido" theme="bootstrap" action="registerOrder" acceptcharset="UTF-8" method="post">
<table class="table" id="cartDetail">
   <thead>
	  <tr>
	  	<th>Codigo</th>
	    <th>Producto</th>
	    <th>Agazajado</th>
	    <th>Dedicatoria</th>
	    <th>Fecha Requerimiento</th>
	    </tr>
  </thead>
  <tbody>
  </tbody>
</table>  
<s:textfield id="cliente" name="idcliente"/>
 <div style="text-align:right;margin-right:0px;">
   <a id="volver" class="btn btn-primary" href="#">Volver</a>
   <a class="btn btn-success" href="#" id="btnbuscar">Asignar Cliente</a>
  <s:submit id="regPedido" cssClass="btn btn-success" value="Realizar Pedido"/>
</div>

</s:form>
</div>
     </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
</section><!-- /.content -->	
<!------------------------------------------------------------------- -- -->


<br></br>
<br></br>
<br></br>
