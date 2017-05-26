/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
		$('#user_verificacion').click(function(event) {
			var idUser = $('#rut_administrador_user').val();
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.get('UsuarioServlet', {
				idUsuario : idUser
				
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
