$(document).ready(function(){

//Patrones de Validación  personalizados
jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-z]+$/i.test(value);
  }, "Solo letras");
	
	
//Validación de login
  $("#form").validate({
    rules: {
      username: {
        minlength: 3,
        maxlength: 20,
        required: true
      },
      email: {
        email: true,
        required: true
      },
      password: {
        minlength: 5,
        required: true
      },
      payment: {
        required: true
      }
    },messages:{ 
    	email: {
    		email:"Ingrese una direcci\u00F3n de correo v\u00E1lida"
        }
    },
    highlight: function(element) {
      $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");
    },
    unhighlight: function(element) {
      $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
    }
  });

  $('.submit input').click(function() {
    $('#form.animated').removeClass('animated shake');
    if ($("#form").valid()) {
      $("#form").addClass("success");
    } else {
      $("#form").removeClass("success").addClass("invalid");
      $(this).addClass("disabled");
    }

    $("#form.invalid input").on("keyup blur", function() {
      if ($("#form").valid()) {
        $(".submit input").removeClass("disabled");
        $("#form").removeClass("invalid");
      } else {
        $(".submit input").addClass("disabled");
      }
    });
  });
  
////////////////////////////////////////////////////////////////////////  
  
  $("#formComprar").validate({
	    rules: {
	    	"orderDetail.nombre_agasajado": {
	          minlength: 3,
	          maxlength: 20,
	          lettersonly:true,
	          required: true
	        },
	        "orderDetail.dedicatoria": {
	        	 minlength:10,
		         maxlength:20,
		         lettersonly:true,
		         required: true
	        },
	        "orderDetail.fec_requerimiento": {
	          date:true,
	          required: true
	        },
	        "orderDetail.cantidad": {
	          min:1,
		      max:7,
	          required: true
	        }
	      },
	      highlight: function(element) {
	        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
	      },
	      unhighlight: function(element) {
	        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
	        var f=$(element).parent().parent().parent().children().eq(1);
	        if (f.hasClass('input-group-addon')){}	        	
	        else{f.addClass('glyphicon glyphicon-ok');}
	      }
	    });
	    $('input[type=submit]').click(function() {
	    	
	      $('#formComprar.animated').removeClass('animated shake');
	      if ($("#form").valid()) {
	        $("#formComprar").addClass("success");
	      } else {
	        $("#formComprar").removeClass("success").addClass("invalid");
	        $(this).addClass("disabled");
	      }

	      $("#formComprar.invalid input").on("keyup blur", function() {
	        if ($("#formComprar").valid()) {
	          $(".submit input").removeClass("disabled");
	          $("#formComprar").removeClass("invalid");
	        } else {
	          $(".submit input").addClass("disabled");
	        }
	      });
	    });
	  
////////////////////////////////////////////////////////////////////////  
$("#formRegProducto").validate({
    rules: {
    	"producto.descripcion": {
          minlength: 3,
          maxlength: 20,
          lettersonly:true,
          required: true
        },
        "producto.stock": {
        	 minlength:10,
	         maxlength:20,
	         lettersonly:true,
	         required: true
        },
        "producto.precio": {
          date:true,
          required: true
        },
        "archivo": {
          min:1,
	      max:7,
          required: true
        }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{f.addClass('glyphicon glyphicon-ok');}
      }
    });
    $('input[type=submit]').click(function() {
    	
      $('#formRegProducto.animated').removeClass('animated shake');
      if ($("#form").valid()) {
        $("#formRegProducto").addClass("success");
      } else {
        $("#formRegProducto").removeClass("success").addClass("invalid");
        $(this).addClass("disabled");
      }

      $("#formRegProducto.invalid input").on("keyup blur", function() {
        if ($("#formRegProducto").valid()) {
          $(".submit input").removeClass("disabled");
          $("#formRegProducto").removeClass("invalid");
        } else {
          $(".submit input").addClass("disabled");
        }
      });
    });
		  
	////////////////////////////////////////////////////////////////////////  
  
  
  
  
  
  
  
  
  
  
  
  
  
});