/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
		$('.boton_fun').click(function(event) {
			var nombreVar = $('.entrada_fun').val();
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.get('FuncionarioServlet', {
				rut : nombreVar
				
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});

$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("active");
});