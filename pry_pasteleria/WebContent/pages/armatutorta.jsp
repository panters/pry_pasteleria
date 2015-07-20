<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="css/jquery-ui.css" media="all" rel="stylesheet">

<style>
  h1 { padding: .2em; margin: 0; }
  #products { float:left; width: 500px; margin-right: 2em; }
  #cart { width: 800px; float: left; }
  /* style the list to maximize the droppable hitarea */
  /*#cart ol { margin: 0; padding: 1em 0 1em 3em; }*/
  
  .ui-accordion .ui-accordion-content {
    padding: 1em 2.2em;
    border-top: 0px none;
    overflow: auto;
    display: block;
    height: 200px;
  }
  
  .ui-widget-content {
    border: 1px solid #B93078;
    background: #EEE url("images/ui-bg_highlight-soft_100_eeeeee_1x100.png") repeat-x scroll 50% top;
    color: #333;
    height: 410px;
  }
  
  .ui-widget-header {
    border: 1px solid #E03C98;
    background: #E03C98 url("images/ui-bg_gloss-wave_35_f6a828_500x100.png") repeat-x scroll 50% 50%;
    color: #FFF;
    font-weight: bold;
    font-size: 20px;
  }
  
  .ui-state-default a, .ui-state-default a:link, .ui-state-default a:visited {
    color: #BF2550;
    text-decoration: none;
   }
  .ui-state-active a, .ui-state-active a:link, .ui-state-active a:visited {
    color: #B31166;
    text-decoration: none;
   }
   .ui-state-active, .ui-widget-content .ui-state-active, .ui-widget-header .ui-state-active {
    border: 1px solid #A82987;
    background: rgba(255, 255, 255, 0.78) url("images/ui-bg_glass_65_ffffff_1x400.png") repeat-x scroll 50% 50%;
    font-weight: bold;
    color: rgba(235, 0, 207, 0.9);
   }
  
  .fruts{display: inline-block;}
  
   .drop-area {
      background-color: #F9BC52;
      background-color: #7937A7;
      background-color: rgba(24, 243, 235, 0.32);
  }
  
  
</style>

<script>
	var cotizacion = 0;

$(document).ready(function() {

	var cakebuilder=$('#armador');
	
	var cbase=$('#cbase');
	var cmoldes=$('#cmasas');
	var cfrutas = $('#cfrutas');
	var cdecoracion=$('#cdecoracion');
	var ccaramelo=$('#ccaramelo');
	var cadornos = $('#cadornos'); //son velas
	
	
	var ui;

	
	var logueado='false';
	var rol=0;
	//Cosultamos al servidor si el usuario esta logueado
	$.get("isLogged.action",function(data){
		rol=data.rol;
		if(rol==2){
			logueado=data.logged;
		}	
	});
	
/*
	$.getJSON('listtipoinsumos',function(data){
		var data=data.tipoinsumos;
		
		for (var i = 0; i < data.length; i++) {
			var ctct=$('#catalog');
			var x='<h2><a href="#">'+data[i]+'</a></h2><div><ul id="'+data[i]+'"></ul></div>';
			ctct.append(x);
		};
		
	});
*/
	
	$.getJSON('listInsumos', function(data) {
		var data = data.insumos;
		
		cbase.html('');
		cmoldes.html('');
	    cfrutas.html('');
		cdecoracion.html('');
		ccaramelo.html('');
		cadornos.html(''); //son velas
		/*
		cfrutas.html('');
		cadornos.html('');
		cvela.html('');
		cmoldes.html('');
		cakebuilder.html('');
		*/
		
		var imagen;
		for (var i = 0; i < data.length; i++) {
			switch (data[i].tipo) {
			case 'base':{
				imagen = '<div class="fruts"><img src="verImagen?imagenName='+ data[i].imagen +'" data-precio="'+ data[i].precio+'" width="350" heigth="184" class="drag"/></div>';
				cbase.append(imagen);
				break;
			 }
			case 'caramelo':{
				imagen = '<div class="fruts"><img src="verImagen?imagenName='+ data[i].imagen +'" data-precio="'+ data[i].precio+'"  class="drag"/></div>';
				ccaramelo.append(imagen);
				break;
			 }
			case 'decoracion':{
				imagen = '<div class="fruts"><img src="verImagen?imagenName='+ data[i].imagen +'" data-precio="'+ data[i].precio+'"  class="drag"/></div>';
				cdecoracion.append(imagen);
				break;
			 }
			case 'fruta':
				imagen = '<div class="fruts"><img src="verImagen?imagenName='+ data[i].imagen +'" data-precio="'+ data[i].precio+'" width="30" heigth="70" class="drag"/></div>';
				cfrutas.append(imagen);
				break;
			case 'vela':
				imagen = '<div class="fruts"><img src="verImagen?imagenName='+ data[i].imagen + '" data-precio="'+ data[i].precio+'" class="drag" /></div>';
				cadornos.append(imagen);
				break;
			case 'masa':
				imagen = '<img src="verImagen?imagenName='+ data[i].imagen + '" data-precio="'+ data[i].precio+'" class="drag" />';
						cmoldes.append(imagen + '<br/>');
				break;
			default:
				imagen = '<img src="verImagen?imagenName='+ data[i].imagen + '" data-precio="'+ data[i].precio+'" width="100" heigth="70" class="drag"/>';
				break;
			}
		}
	});


	$('#catalog').on('mouseover','img',function(e){
		$(this).draggable({
		      helper:'clone',
		      tolerance:'fit',
		      revert: true
		});
	});
	  
	
    $( "#catalog" ).accordion(); 

	$('#armador').droppable({
			accept: '.drag',
             activeClass: "drop-area",
             drop: function (e, ui) {
            	 $('#eliminame').text('');
                 if ($(ui.draggable)[0]!=null) {
                     x = ui.helper.clone();
                     ui.helper.remove();
                     x.draggable({
                         helper: 'original',
                         cursor: 'move',
                         revert:'invalid',
                         //containment: '#droppable',
                         tolerance: 'fit',
                         drop: function (event, ui) {
                             $(ui.draggable).remove();
                         }
                     });
                     //aumentar tamñao
                     
                     x.addClass('remove');
                     x.addClass('existe');
                     var el = $("<span><a href='Javascript:void(0)' class=\"xicon delete\" title=\"Remove\">X</a></span>");
                     $(el).insertAfter($(x.find('img')));
                     x.appendTo('#armador');
                     $('.delete').on('click', function () {
                         $(this).parent().parent('span').remove();
                     });
                     $('.delete').parent().parent('span').dblclick(function () {
                         $(this).remove();
                     });
                 }
                 
               if(!$(ui.draggable).hasClass('existe')){
            	   var price = parseInt($(ui.draggable).attr('data-precio'));
            		cotizacion += price;
            		$('#sum').text(parseFloat(cotizacion).toFixed(2));
               }
               
                 
             }
	});
    
    
	$('body').on('dblclick','.existe',function(){
		$(this).hide(1000);
		var x=parseInt($(this).attr('data-precio'));
		cotizacion-=x;
		$('#sum').text(parseFloat(cotizacion).toFixed(2));
	});
	
	/*
	$('#imprimir').click(function(){
		
		var printcontent=document.getElementById('cart').innerHTML;
		var original=document.body.innerHTML;

		document.body.innerHTML=printcontent;
		window.print();

		document.body.innerHTML=original;
	});
	*/
	
	  $("#btnSave").click(function() { 
		  
	        html2canvas($("#armador"), {
	            onrendered: function(canvas) {
	                theCanvas = canvas;
	                //document.body.appendChild(canvas);

	                // Convert and download as image 
	                //hace que se descgar:
	                	//Canvas2Image.saveAsPNG(canvas); 
	                
	                var img = canvas.toDataURL("image/png");
	                
	                $('#iac').val(canvas.toDataURL("image/png"));
	                $('#pc').val(cotizacion);
	                $('#formCotizar').submit();
	                
	                
	                //$("#img-out").append(canvas);
	                // Clean up 
	                //document.body.removeChild(canvas);
	            }
	        });
	    });
	
	$('#formCotizar').submit(function(e){
    	e.preventDefault();
    	$.ajax({
    		type: 'POST',
            url: $(this).attr('action'),
            data: $(this).serialize(),
            success: function(data) {
            	
            	if (logueado=='false')
        			window.location.href="logueo.action";
        		else{
        			$.growl(
    						{
    							title:" <strong>Cotización&nbsp;</strong> ",
    							message:"enviada correctamente..!",
    							icon:"glyphicon glyphicon-thumbs-up"
    						},{
    							type:'success'
    					   });
        			setTimeout(function(){window.location.href="catalogo.action"},2000);
        		}
            	
            }
    	});
    	return false;
    });
	
	
  });
</script>

<form method="POST" enctype="multipart/form-data" action="sendCotizacion.action" id="formCotizar" style="display:none;">
    <input type="hidden" name="imagen" id="iac" value="" />
    <input type="hidden" name="cotiprice" id="pc" value="" />
</form>

<div style="margin-left:5%;margin-right:5%;">
<div id="products" style="width:40%;">
  <h1 class="ui-widget-header">Ingredientes:</h1>
  <div id="catalog">
  	<h2><a href="#">Base</a></h2>
    <div>
      <ul id="cbase">
      </ul>
    </div>
    
    <h2><a href="#">Masas</a></h2>
    <div>
      <ul id="cmasas">
      </ul>
    </div>
    <h2><a href="#">Frutas</a></h2>
    <div>
      <ul id="cfrutas">
      </ul>
    </div>
    <h2><a href="#">Decoracion</a></h2>
    <div>
      <ul id="cdecoracion">
      </ul>
    </div>
    
    <h2><a href="#">Caramelos</a></h2>
    <div>
      <ul id="ccaramelo">
      </ul>
    </div>
    
    <h2><a href="#">Velas</a></h2>
    <div>
      <ul id="cadornos">
      </ul>
    </div>
    
  </div>
</div>
 
<div id="cart" style="width:50%;">
  <h1 class="ui-widget-header">Arma Tu Torta&nbsp;&nbsp;&nbsp;&nbsp;S/.<label id="sum"style="font-size:20px;">0.00</label></h1>
  <div class="ui-widget-content">
      <div id="armador" class="placeholder" style="width:100%;height:100%;"><label id="eliminame">Arrasta Aqui..!</label></div>
      <div id="img-out"></div>
  </div>
  <!-- <button id="imprimir" class="btn btn-lg btn-primary">Enviar</button> -->
  <input type="button" id="btnSave" value="Enviar" class="btn btn-lg btn-primary" style="background-color: #7A035B;"/>
</div>
</div>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
<br></br>
