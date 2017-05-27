/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
		$('.boton_fun').click(function() {
			var nombreVar = $('.entrada_fun').val();
                        
                        if (nombreVar==="") {
                        alert('Debe ingresar al menos un valor.');
                        return false;
                        }    
                    
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.get('FuncionarioServlet', {
				rut : nombreVar
                                 
			}, function(responseText) {
                            if (responseText==="formato_error") {
                alert('Formato de rut Inválido');
            }else if(responseText==="rut_existe"){
                alert('Funcionario ya enrolado!');
            }else{
                $('#tabla').html(responseText);
            }
				
			});
		});
	});

$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("active");
});