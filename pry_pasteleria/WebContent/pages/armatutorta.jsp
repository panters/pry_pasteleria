<%@ taglib uri="/struts-tags" prefix="s"%>
<link href="css/jquery-ui.css" media="all" rel="stylesheet">

<style>
  h1 { padding: .2em; margin: 0; }
  #products { float:left; width: 500px; margin-right: 2em; }
  #cart { width: 800px; float: left; margin-top: 1em; }
  /* style the list to maximize the droppable hitarea */
  /*#cart ol { margin: 0; padding: 1em 0 1em 3em; }*/
  .fruts{display: inline-block;}
  
   .drop-area {
      background-color: #F9BC52;
  }
  
  
  </style>

<script>
	var cotizacion = 0;

$(document).ready(function() {

	var cakebuilder=$('#armador');
	var cfrutas = $('#cfrutas');
	var cadornos = $('#cadornos');
	var cvela=$('#velas');
	var cmoldes=$('#cmasas');
	var ui;

	$.getJSON('listInsumos', function(data) {
		var data = data.insumos;
		cfrutas.html('');
		cadornos.html('');
		cvela.html('');
		cmoldes.html('');
		cakebuilder.html('');
		
		var imagen;
		for (var i = 0; i < data.length; i++) {
			switch (data[i].tipo) {
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
	
	
	$('#imprimir').click(function(){
		
		var printcontent=document.getElementById('cart').innerHTML;
		var original=document.body.innerHTML;

		document.body.innerHTML=printcontent;
		window.print();

		document.body.innerHTML=original;
	});
	
	
	  $("#btnSave").click(function() { 
		  
	        html2canvas($("#armador"), {
	            onrendered: function(canvas) {
	                theCanvas = canvas;
	                document.body.appendChild(canvas);

	                // Convert and download as image 
	                Canvas2Image.saveAsPNG(canvas); 
	                
	                var img = canvas.toDataURL("image/png");
	                //$('body').append('<img src="'+img+'"/>');
	                
	                //$("#img-out").append(canvas);
	                // Clean up 
	                //document.body.removeChild(canvas);
	            }
	        });
	    });
	
	
	
	
  });
</script>




<div style="margin-left:5%;margin-right:5%;">
<div id="products" style="width:40%;">
  <h1 class="ui-widget-header">Ingredientes:</h1>
  <div id="catalog">
    <h2><a href="#">Masas</a></h2>
    <div>
      <ul id="cmasas">
        <li>Lolcat Shirt</li>
        <li>Cheezeburger Shirt</li>
        <li>Buckit Shirt</li>
      </ul>
    </div>
    <h2><a href="#">Frutas</a></h2>
    <div>
      <ul id="cfrutas">
        <li>Zebra Striped</li>
        <li>Black Leather</li>
        <li>Alligator Leather</li>
      </ul>
    </div>
    <h2><a href="#">Adornos</a></h2>
    <div>
      <ul id="cadornos">
        <li>iPhone</li>
        <li>iPod</li>
        <li>iPad</li>
      </ul>
    </div>
  </div>
</div>
 
<div id="cart" style="width:50%;">
  <h1 class="ui-widget-header">Arma Tu Torta&nbsp;&nbsp;&nbsp;&nbsp;S/.<label id="sum"style="font-size:40px;">0.00</label></h1>
  <div class="ui-widget-content">
      <div id="armador" class="placeholder" style="width:100%;height:100%;">Arrasta Aqui..!</div>
      <div id="img-out"></div>
  </div>
  <button id="imprimir" class="btn btn-lg btn-primary">Enviar</button>
  <input type="button" id="btnSave" value="Save PNG"/>
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
