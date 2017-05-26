/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function() {
		$("#submit_formulario").click(function(event) {
			var userVar = $("#login_usuario").val();
                        var userPass = $("#login_pasword").val();
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.get('LoginServlet', {
				user : userVar,
                                pass : userPass
				
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});

