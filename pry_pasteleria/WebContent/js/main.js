$(document).ready(function(){

//Patrones de Validación  personalizados
jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-z]+$/i.test(value);
  }, "Solo letras");
	
jQuery.validator.addMethod("lettersonlyWithSpace", function(value, element) {
    return this.optional(element) || /^[a-zA-Z\s\u00A0-\uD7FF]+$/.test(value);
}, "S&oacute;lo letras, espacios");

jQuery.validator.addMethod("vigencia", function(value, element) {
	  return this.optional(element) || /^(SI|si|sI|Si|NO|no|No|nO)$/i.test(value);
}, "Ingrese sólo \"Si\" o \"No\" ");

jQuery.validator.addMethod("precio", function(value, element) {
return this.optional(element) || /^\d{0,4}(\.\d{0,2})?$/i.test(value);
}, "Precio inv&aacute;lido utilice formato 0000.00");

$.validator.addMethod("dni", function(value, element) {
	  return this.optional(element) || /^([0-9]{8})$/.test(value);
	}, "DNI no v&aacute;lido");

jQuery.validator.addMethod("telefono", function (value, element) {
    return this.optional(element) || /[0-9]{7}$/.test(value);
}, "Por favor, um telefone v&aacute;lido");

jQuery.validator.addMethod("celular", function (value, element) {
	return this.optional(element) || /[0-9]{9}$/.test(value) || /[0-9]{10,11}$/.test(value);
	}, "Digite un  celular v&aacute;lido.");
/*
jQuery.validator.addMethod("precio", function(value, element) {
	return this.optional(element) || /^S\/.+[0-9]$/i.test(value);
	}, "Precio inv&aacute;lido");
*/

//-------------------------------------------------------------------------

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
//        Validacion de Modal para comprar
////////////////////////////////////////////////////////////////////////  
  $("#formComprar").validate({
	    rules: {
	    	"orderDetail.nombre_agasajado": {
	          minlength: 3,
	          maxlength: 20,
	          lettersonlyWithSpace:true,
	          required: true
	        },
	        "orderDetail.dedicatoria": {
	        	 minlength:10,
		         maxlength:20,
		         lettersonlyWithSpace:true,
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
//         Validacion de Mantenimiento de Productos	    
////////////////////////////////////////////////////////////////////////  
$("#formRegProducto").validate({
    rules: {
    	"producto.descripcion": {
          minlength: 3,
          maxlength:50,
          lettersonlyWithSpace:true,
          required: true
        },
        "producto.stock": {
        	 minlength:1,
	         maxlength:3,
	         min:1,
	         number:true,
	         required: true
        },
        "producto.precio": {
          precio:true,
          required: true
        },
        "producto.categoria.idCategoria":{
        	required: true,
        	min:1
        },
        "producto.cobertura.idCobertura":{
        	required: true,
        	min:1
        },
        "producto.masa.idMasa":{
        	required: true,
        	min:1
        },
        "producto.relleno.idRelleno":{
        	required: true,
        	min:1
        }
      },
      messages:{ 
    	  "producto.categoria.idCategoria": {
      		min:"Selecci&oacute;ne una opci&oacute;n v&aacute;lida."
          },
          "producto.cobertura.idCobertura":{
        	min:"Selecci&oacute;ne una opci&oacute;n v&aacute;lida."
          },
          "producto.masa.idMasa":{
        	min:"Selecci&oacute;ne una opci&oacute;n v&aacute;lida."
          },
          "producto.relleno.idRelleno":{
        	min:"Selecci&oacute;ne una opci&oacute;n v&aacute;lida."
          }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{/**/}
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
//   Validacion de Tipo de Insumo    
////////////////////////////////////////////////////////////////////////  
    $("#FormTipoInsumo").validate({
        rules: {
        	"tipo": {
              minlength: 3,
              maxlength:10,
              lettersonlyWithSpace:true,
              required: true
            }
          },
          messages:{ 
        	  "tipo": {
        	   required:"Descripci&oacute;n de insumo  inv&aacute;lida."
              }
          },
          highlight: function(element) {
            $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
          },
          unhighlight: function(element) {
            $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
            var f=$(element).parent().parent().parent().children().eq(1);
            if (f.hasClass('input-group-addon')){}	        	
            else{/**/}
          }
        });
        $('input[type=submit]').click(function() {
        	
          $('#FormTipoInsumo.animated').removeClass('animated shake');
          if ($("#FormTipoInsumo").valid()) {
            $("#FormTipoInsumo").addClass("success");
          } else {
            $("#FormTipoInsumo").removeClass("success").addClass("invalid");
            $(this).addClass("disabled");
          }

          $("#FormTipoInsumo.invalid input").on("keyup blur", function() {
            if ($("#FormTipoInsumo").valid()) {
              $(".submit input").removeClass("disabled");
              $("#FormTipoInsumo").removeClass("invalid");
            } else {
              $(".submit input").addClass("disabled");
            }
          });
        });
    		  
////////////////////////////////////////////////////////////////////////  
//				Validacion Mantenimiento Insumos
////////////////////////////////////////////////////////////////////////
$("#FormInsumo").validate({
    rules: {
    	"insumo.descripcion": {
          minlength: 3,
          maxlength:50,
          lettersonlyWithSpace:true,
          required: true
        },
        "insumo.precio":{
        	precio:true,
        	required: true
        },
        "insumo.tipo":{
        	required: true,
        	lettersonlyWithSpace:true,
        }
      },
      messages:{ 
    	  "insumo.tipo": {
    		  lettersonlyWithSpace:"Seleccione un tipo v&aacute;lido."
          }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{/**/}
      }
    });
    $('input[type=submit]').click(function() {
    	
      $('#FormInsumo.animated').removeClass('animated shake');
      if ($("#FormInsumo").valid()) {
        $("#FormInsumo").addClass("success");
      } else {
        $("#FormInsumo").removeClass("success").addClass("invalid");
        $(this).addClass("disabled");
      }

      $("#FormInsumo.invalid input").on("keyup blur", function() {
        if ($("#FormInsumo").valid()) {
          $(".submit input").removeClass("disabled");
          $("#FormInsumo").removeClass("invalid");
        } else {
          $(".submit input").addClass("disabled");
        }
      });
    });
////////////////////////////////////////////////////////////////////////        		    
//			Validacion de Mantenimiento Cobertura  
////////////////////////////////////////////////////////////////////////
$("#Registro").validate({
    rules: {
    	"cobertura.descripcion": {
          minlength: 3,
          maxlength:50,
          lettersonlyWithSpace:true,
          required: true
        }

      },
      messages:{ 
    	  "cobertura.descripcion": {
    	   required:"Descripci&oacute;n de Cobertura  inv&aacute;lida."
          }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{/**/}
      }
    });
    $('input[type=submit]').click(function() {
    	
      $('#Registro.animated').removeClass('animated shake');
      if ($("#Registro").valid()) {
        $("#Registro").addClass("success");
      } else {
        $("#Registro").removeClass("success").addClass("invalid");
        $(this).addClass("disabled");
      }

      $("#Registro.invalid input").on("keyup blur", function() {
        if ($("#Registro").valid()) {
          $(".submit input").removeClass("disabled");
          $("#Registro").removeClass("invalid");
        } else {
          $(".submit input").addClass("disabled");
        }
      });
    });  
////////////////////////////////////////////////////////////////////////
//    			Validacion de Mantenimiento Masa  
////////////////////////////////////////////////////////////////////////
$("#RegistroMasa").validate({
    rules: {
    	"masa.descripcion": {
          minlength: 3,
          maxlength:50,
          lettersonlyWithSpace:true,
          required: true
        }

      },
      messages:{ 
    	  "masa.descripcion": {
    	   required:"Descripci&oacute;n de Masa  inv&aacute;lida."
          }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{/**/}
      }
    });
    $('input[type=submit]').click(function() {
    	
      $('#RegistroMasa.animated').removeClass('animated shake');
      if ($("#RegistroMasa").valid()) {
        $("#RegistroMasa").addClass("success");
      } else {
        $("#RegistroMasa").removeClass("success").addClass("invalid");
        $(this).addClass("disabled");
      }

      $("#RegistroMasa.invalid input").on("keyup blur", function() {
        if ($("#RegistroMasa").valid()) {
          $(".submit input").removeClass("disabled");
          $("#RegistroMasa").removeClass("invalid");
        } else {
          $(".submit input").addClass("disabled");
        }
      });
    });  
////////////////////////////////////////////////////////////////////////
//        			Validacion de Mantenimiento Relleno  
////////////////////////////////////////////////////////////////////////
$("#RegistroRelleno").validate({
    rules: {
    	"relleno.descripcion": {
          minlength: 3,
          maxlength:50,
          lettersonlyWithSpace:true,
          required: true
        }

      },
      messages:{ 
    	  "relleno.descripcion": {
    	   required:"Descripci&oacute;n de Relleno  inv&aacute;lida."
          }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{/**/}
      }
    });
    $('input[type=submit]').click(function() {
    	
      $('#RegistroRelleno.animated').removeClass('animated shake');
      if ($("#RegistroRelleno").valid()) {
        $("#RegistroRelleno").addClass("success");
      } else {
        $("#RegistroRelleno").removeClass("success").addClass("invalid");
        $(this).addClass("disabled");
      }

      $("#RegistroRelleno.invalid input").on("keyup blur", function() {
        if ($("#RegistroRelleno").valid()) {
          $(".submit input").removeClass("disabled");
          $("#RegistroRelleno").removeClass("invalid");
        } else {
          $(".submit input").addClass("disabled");
        }
      });
    });    
////////////////////////////////////////////////////////////////////////
//            			Validacion de Mantenimiento Categoria  
////////////////////////////////////////////////////////////////////////
$("#RegistroCategoria").validate({
    rules: {
    	"categoria.descripcion": {
          minlength: 3,
          maxlength:50,
          lettersonlyWithSpace:true,
          required: true
        }

      },
      messages:{ 
    	  "categoria.descripcion": {
    	   required:"Descripci&oacute;n de Categoria  inv&aacute;lida."
          }
      },
      highlight: function(element) {
        $(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
      },
      unhighlight: function(element) {
        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
        var f=$(element).parent().parent().parent().children().eq(1);
        if (f.hasClass('input-group-addon')){}	        	
        else{/**/}
      }
    });
    $('input[type=submit]').click(function() {
    	
      $('#RegistroCategoria.animated').removeClass('animated shake');
      if ($("#RegistroCategoria").valid()) {
        $("#RegistroCategoria").addClass("success");
      } else {
        $("#RegistroCategoria").removeClass("success").addClass("invalid");
        $(this).addClass("disabled");
      }

      $("#RegistroCategoria.invalid input").on("keyup blur", function() {
        if ($("#RegistroCategoria").valid()) {
          $(".submit input").removeClass("disabled");
          $("#RegistroCategoria").removeClass("invalid");
        } else {
          $(".submit input").addClass("disabled");
        }
      });
    });  
////////////////////////////////////////////////////////////////////////
//	Validacion de Mantenimiento Rol
////////////////////////////////////////////////////////////////////////
$("#RegistroRol").validate({
		rules: {
			"rol.descripcion": {
				minlength: 3,
				maxlength:50,
				lettersonlyWithSpace:true,
				required: true
				}
		
			},
		messages:{ 
			"rol.descripcion": {
					required:"Descripci&oacute;n de Rol  inv&aacute;lida."
			}
		},
		highlight: function(element) {
		$(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
		},
		unhighlight: function(element) {
		$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
		var f=$(element).parent().parent().parent().children().eq(1);
		if (f.hasClass('input-group-addon')){}	        	
		else{/**/}
		}
		});
		$('input[type=submit]').click(function() {
		
		$('#RegistroRol.animated').removeClass('animated shake');
		if ($("#RegistroRol").valid()) {
		$("#RegistroRol").addClass("success");
		} else {
		$("#RegistroRol").removeClass("success").addClass("invalid");
		$(this).addClass("disabled");
		}
		
		$("#RegistroRol.invalid input").on("keyup blur", function() {
		if ($("#RegistroRol").valid()) {
		$(".submit input").removeClass("disabled");
		$("#RegistroRol").removeClass("invalid");
		} else {
		$(".submit input").addClass("disabled");
		}
		});
});   

////////////////////////////////////////////////////////////////////////
//		Validacion de Mantenimiento Clientes
////////////////////////////////////////////////////////////////////////
	$("#formCliente").validate({
			rules: {
				"cliente.nombre": {
					minlength: 3,
					maxlength:50,
					lettersonlyWithSpace:true,
					required: true
					},
				"cliente.ape_pa":{
					minlength: 3,
					maxlength:50,
					lettersonlyWithSpace:true,
					required: true	
				},
				"cliente.ape_ma":{
					minlength: 3,
					maxlength:50,
					lettersonlyWithSpace:true,
					required: true
				},
				"cliente.dni":{
					required:true,
					dni:true
				},
				"cliente.fec_nacimiento":{
					required:true,
					date:true
				},
				"cliente.email":{
					email:true,
					required:true
				},
				"cliente.telefono":{
					telefono:true
				},
				"cliente.celular":{
					required:true,
					celular:true
				},
				"cliente.estado_civil":{
					required:true,
					lettersonlyWithSpace:true
				}
					
				},
			messages:{ 
				"cliente.estado_civil": {
					lettersonlyWithSpace:"Seleccione una opci&oacute;n v&aacute;lida."
				}
			},
			highlight: function(element) {
			$(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
			},
			unhighlight: function(element) {
			$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
			var f=$(element).parent().parent().parent().children().eq(1);
			if (f.hasClass('input-group-addon')){}	        	
			else{/**/}
			}
			});
			$('input[type=submit]').click(function() {
			
			$('#formCliente.animated').removeClass('animated shake');
			if ($("#formCliente").valid()) {
			$("#formCliente").addClass("success");
			} else {
			$("#formCliente").removeClass("success").addClass("invalid");
			$(this).addClass("disabled");
			}
			
			$("#formCliente.invalid input").on("keyup blur", function() {
			if ($("#formCliente").valid()) {
			$(".submit input").removeClass("disabled");
			$("#formCliente").removeClass("invalid");
			} else {
			$(".submit input").addClass("disabled");
			}
			});
	});   
////////////////////////////////////////////////////////////////////////
//			Validacion de Mantenimiento Empleados
////////////////////////////////////////////////////////////////////////
		$("#FormEmpleado").validate({
				rules: {
					"empleado.nombre": {
						minlength: 3,
						maxlength:50,
						lettersonlyWithSpace:true,
						required: true
						},
					"empleado.ape_pa":{
						minlength: 3,
						maxlength:50,
						lettersonlyWithSpace:true,
						required: true	
					},
					"empleado.ape_ma":{
						minlength: 3,
						maxlength:50,
						lettersonlyWithSpace:true,
						required: true
					},
					"empleado.dni":{
						required:true,
						dni:true
					},
					"empleado.fec_nacimiento":{
						required:true,
						date:true
					},
					"empleado.email":{
						email:true,
						required:true
					},
					"empleado.telefono":{
						telefono:true
					},
					"empleado.celular":{
						required:true,
						celular:true
					},
					"empleado.estado_civil":{
						required:true,
						lettersonlyWithSpace:true
					},
					"empleado.rol.idRol":{
						required:true,
						min:1
					},
					"empleado.sueldo":{
						precio:true,
						required:true
					}	
				},
				messages:{ 
					"empleado.estado_civil": {
						lettersonlyWithSpace:"Seleccione una opci&oacute;n v&aacute;lida."
					},
					"empleado.rol.idRol":{
						min:"Seleccione una opci&oacute;n v&aacute;lida."
					}
				},
				highlight: function(element) {
				$(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated shake");;
				},
				unhighlight: function(element) {
				$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
				var f=$(element).parent().parent().parent().children().eq(1);
				if (f.hasClass('input-group-addon')){}	        	
				else{/**/}
				}
				});
				$('input[type=submit]').click(function() {
				
				$('#FormEmpleado.animated').removeClass('animated shake');
				if ($("#FormEmpleado").valid()) {
				$("#FormEmpleado").addClass("success");
				} else {
				$("#FormEmpleado").removeClass("success").addClass("invalid");
				$(this).addClass("disabled");
				}
				
				$("#FormEmpleado.invalid input").on("keyup blur", function() {
				if ($("#FormEmpleado").valid()) {
				$(".submit input").removeClass("disabled");
				$("#FormEmpleado").removeClass("invalid");
				} else {
				$(".submit input").addClass("disabled");
				}
				});
		});  
 
////////////////////////////////////////////////////////////////////////
//				Validacion de Registro Clientes
////////////////////////////////////////////////////////////////////////
	$("#formRegCli").validate({
			rules: {
				"nombre": {
					minlength: 3,
					maxlength:50,
					lettersonlyWithSpace:true,
					required: true
					},
				"ape_pa":{
					minlength: 3,
					maxlength:50,
					lettersonlyWithSpace:true,
					required: true	
				},
				"ape_ma":{
					minlength: 3,
					maxlength:50,
					lettersonlyWithSpace:true,
					required: true
				},
				"dni":{
					required:true,
					dni:true
				},
				"fec_nacimiento":{
					required:true,
					date:true
				},
				"email":{
					email:true,
					required:true
				},
				"telefono":{
					telefono:true
				},
				"celular":{
					required:true,
					celular:true
				},
				"estado":{
					required:true,
					lettersonlyWithSpace:true
				},
				"sexo":{
				 required:true
				},
				"password":{
					required:true
				}
					
				},
			messages:{ 
				"password": {
					required:"campo requerido."
				}
			},
			highlight: function(element) {
			$(element).closest(".form-group").removeClass("has-success").addClass("has-error").parents('form.animate-form').addClass("animated wobble");;
			},
			unhighlight: function(element) {
			$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
			var f=$(element).parent().parent().parent().children().eq(1);
			if (f.hasClass('input-group-addon')){}	        	
			else{/**/}
			}
			});
			$('input[type=submit]').click(function() {
			
			$('#formRegCli.animated').removeClass('animated wobble');
			if ($("#formRegCli").valid()) {
			$("#formRegCli").addClass("success");
			} else {
			$("#formRegCli").removeClass("success").addClass("invalid");
			$(this).addClass("disabled");
			}
			
			$("#formRegCli.invalid input").on("keyup blur", function() {
			if ($("#formRegCli").valid()) {
			$(".submit input").removeClass("disabled");
			$("#formRegCli").removeClass("invalid");
			} else {
			$(".submit input").addClass("disabled");
					}
					});
			});   				
  
  
});