function isNumberKey(evt)
{
   var keyCode = (evt.which) ? evt.which : evt.keyCode;
   if (keyCode != 46 && keyCode > 31 && (keyCode < 48 || keyCode > 57))
      return false;

   return true;
}

function isAlphabeticKey(evt)
{
    var keyCode = (evt.which) ? evt.which : evt.keyCode;
    if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32)     
    	return false;
    
        return true;
}

/*validaciones*/
function validarEdad(value, e){
	var texto = String.fromCharCode(e.keyCode);
	var rpta= validarSoloNumerosEnteros(e);
	
	//revisar si esta entre 1 y 110
	if(rpta){
		var x ;
		
		if(value== ""){		x = parseInt(texto);  }
		else{	x = parseInt(value)*10 +parseInt(texto); }
		
		if(x>=1 && x<=110){		return true;	}
		else{					return false;	}
	//no viene numero lo cancelo	
	}else{
		return false;	
	}
}

function validarEntero(e) { 
tecla = (document.all) ? e.keyCode : e.which; 
if (tecla==8 || tecla==0 || tecla==9) return true; 
patron = /[0123456789]/; // Solo acepta n�meros
te = String.fromCharCode(tecla);
return patron.test(te); 
}	
var punto=false;
var c=0;
function validarPrecio(e) { 
tecla = (document.all) ? e.keyCode : e.which; 
if (tecla==8 || tecla==0 || tecla==9) return true; 
patron = /[0123456789.]/; // Solo acepta n�meros y puntos
te = String.fromCharCode(tecla);
if(te=="."){
	if(punto==false){
		punto=true;
		return patron.test(te);	
	}    	
	return false;
}else{
	if(punto==true){
		c+=1;
		if(c>=3){
			return false;
		}
	}
	return patron.test(te);	
}     
}		
function validarLetra(e) { 
tecla = (document.all) ? e.keyCode : e.which; 
if (tecla==8 || tecla==0 || tecla==9) return true; 
patron = /[abcdefghijklmnopqrstuvwxyz ]/;// Solo letras
te = String.fromCharCode(tecla); 
return patron.test(te);
}

function validarLetraNumero(e) { 
tecla = (document.all) ? e.keyCode : e.which; 
if (tecla==8 || tecla==0 || tecla==9 || tecla==20) return true;     
patron = /[abcdefghijklmnopqrstuvwxyz 0123456789 ABCDEFGHIJKLMNOPQRSTUVWXYZ]/;// Solo letras
te = String.fromCharCode(tecla); 
return patron.test(te);
}

function validarEmail(e) { 
	tecla = (document.all) ? e.keyCode : e.which; 
	if (tecla==8 || tecla==0 || tecla==9) return true; 
	patron = /[abcdefghijklmnopqrstuvwxyz 1234567890._@ ]/;// Solo letras
	te = String.fromCharCode(tecla); 
	return patron.test(te);
}