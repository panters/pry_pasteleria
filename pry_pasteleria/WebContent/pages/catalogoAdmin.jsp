<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<script src="js/mytemplates/galleryAdmin.js"></script>
<s:if test="hasActionMessages()">
	<s:actionmessage id="messageSucces" />
	<script>
		var msj = $('#messageSucces li span').text();
		$('#messageSucces').remove();
		$.growl(
			{
				title:" <strong>! Bienvenido</strong> a Tortas Encantadas: ",
				message:msj+" <strong>!</strong>",
				icon:"glyphicon glyphicon-thumbs-up"
			},{
				type:'success'
			}
		  );
	</script>
</s:if>

<section class="content-header">
		 <h1>
            Catálogo de Producto 
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

 <div class="row col-xs-12  col-sm-12  col-md-12  col-lg-12">
	
		
		<div class="col-xs-12  col-sm-2  col-md-2  col-lg-2">
			<s:form id="formFiltros" theme="bootstrap" method="post" action="filterProduct">
	    			<s:url id="URL_ListCategorys" action="listCategory"/>
					<sj:select cssClass="form-control"
					id="cbocategoria" 
					label="Categoria :"
					list="categorias"
					listKey="idCategoria"
					listValue="descripcion"
					href="%{URL_ListCategorys}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.categoria.idCategoria" />
	    	 
			 
	    		<s:url id="URL_ListCoverages" action="listCoverage"/>
				<sj:select cssClass="form-control" 
					id="cbocobertura" 
					label="Cobertura :"
					list="coberturas"
					listKey="idCobertura"
					listValue="descripcion"
					href="%{URL_ListCoverages}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.cobertura.idCobertura" />
	    	 
	    		<s:url id="URL_ListDoughs" action="listDough"/>
				<sj:select cssClass="form-control"
					id="cbomasa" 
					label="Masa :"
					list="masas"
					listKey="idMasa"
					listValue="descripcion"
					href="%{URL_ListDoughs}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.masa.idMasa" />
	    	 
	    		<s:url id="URL_ListFillings" action="listFilling"/>
				<sj:select cssClass="form-control"
					id="cborelleno" 
					label="Relleno :"
					list="rellenos"
					listKey="idRelleno"
					listValue="descripcion"
					href="%{URL_ListFillings}"
					headerKey="0"
					headerValue="--Seleccione--" 
					name="producto.relleno.idRelleno" />
			<br/>					   
			<s:submit value="Consultar Producto" cssClass="btn btn-primary col-xs-12"/>
		</s:form>
		</div><!-- fin filtros -->
		<div class="panelalex col-xs-12  col-sm-10  col-md-10  col-lg-10">	

		</div> <!-- Fin panel--> 
	
</div>  <!-- Fin Row -->

     </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!-- /.col -->
          </div><!-- /.row -->
        </section><!-- /.content -->

<!------------------------------------------------ -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="myModalLabel">Modal title</h3>
			</div>

		 <s:form theme="bootstrap"  action="addToCarrito" method="post" acceptcharset="UTF-8" id="formComprar" cssClass="form animate-form">
		 	<s:hidden id="idProducto" name="orderDetail.producto.idProducto"/>
		 	<s:hidden id="pdescripcion" name="orderDetail.producto.descripcion"/>
		 	<s:hidden id="pprecio" name="orderDetail.producto.precio"/>
		 	<s:hidden id="pimagen" name="orderDetail.producto.image_resource"/>
		 	<s:hidden id="pcobertura" name="orderDetail.producto.cobertura.descripcion"/>
		 	<s:hidden id="pmasa" name="orderDetail.producto.masa.descripcion"/>
		 	<s:hidden id="prelleno" name="orderDetail.producto.relleno.descripcion"/>
		 	
			<div class="modal-body">
				<div class="alex col-xs-12 col-sm-5 col-md-5 col-lg-5">
					<img src="">
				</div>
				
				<div class="alex col-xs-12 col-sm-7 col-md-7 col-lg-7">
					<table class="detaAC">
						<tr>
							<td>Cantidad</td>
							<td><s:textfield type="number" name="orderDetail.cantidad" min="1" max="7" /></td>
						</tr>
						<!-- 
						<tr>
							<td>Nombre Agazajado:</td>
							<td>
								<div class="form-group has-feedback">
								<s:textfield id="agazajado"  cssClass="form-control" name="orderDetail.nombre_agasajado"/>
								<span	class="glyphicon glyphicon-ok form-control-feedback"></span>
								</div>
							</td>
						</tr>
						
						<tr>
							<td>Dedicatoria:</td>
							<td>
							<div class="form-group has-feedback">
							<s:textfield id="dedicatoria"  cssClass="form-control" name="orderDetail.dedicatoria"/>
							<span	class="glyphicon glyphicon-ok form-control-feedback"></span>
							</div>
							</td>
						</tr>
						<tr>
							<td>Fecha de Entrega:</td>
							<td>
								<div class="form-group has-feedback">
								<div class="input-group date">
								<s:textfield id="fecha"  cssClass="form-control" name="orderDetail.fec_requerimiento"/>
									<span class="input-group-addon"><i class="glyphicon glyphicon-th"></i>
									</span>
								</div>
								</div>
							</td>
						</tr>
						 -->
						<tr>
							<td><font size="5">Precio:</font></td>
							<td><font size="6">S/.</font><font size="6" id="price">60.00</font></td>
						</tr>
					</table>
				</div>

			</div>

			<div class="modal-footer alexito">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<s:submit value="Agregar al Carrito" cssClass="btn btn-primary"/>
			</div>
			
		</s:form>
		</div>
	</div>
</div>
  
