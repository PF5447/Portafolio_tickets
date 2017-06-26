<%-- 
    Document   : gestion_usuarios
    Created on : 24-05-2017, 23:35:00
    Author     : bcn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<script type='text/javascript' src='js/jquery.js'></script>
        
	<link href='css/bootstrap.min.css' rel='stylesheet'>
	<link href='css/estilo_menu.css' rel='stylesheet'>
	<title>Gestion Funcionarios</title>
</head>
<div id="wrapper" class="active">
      
      <!-- Sidebar -->
            <!-- Sidebar -->
      <div id="sidebar-wrapper">
        <ul id="sidebar_menu" class="sidebar-nav">
             <li class="sidebar-brand"><a id="menu-toggle" href="#">Menu</a></li>
        </ul>
            <ul class="sidebar-nav" id="sidebar">     
              <li><a href="Totem.jsp">Modo Totem<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
              <li><a href="verificacion_funcionario.jsp">Personas<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
              <li><a href="gestion_usuarios.jsp">Usuarios<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
        
                           
            </ul>
      </div>
          
      <!-- Page content -->
      <div id="page-content-wrapper">
        <!-- Keep all page content within the page-content inset div! -->
        <div class="page-content inset">
            <div class="row">
              <div class="col-md-12">
                    
                <hr>
		<h2>Gestion de Usuario</h2>
                <p class='text-muted' id="mensaje_superior">Solo para creación de administradores y cajeros</p>
                <hr id="separador_inferior">
		<div class='container'>
			<div class='form-group'>
                            	
                            <h3 id="p_rut_funcionario">Rut funcionario</h3>
                                <input class="form-control" type='text' id='rut_administrador_user' placeholder="ingrese un RUT" required>
                                <br>
                                <input class="btn btn-success" type='button' id='user_verificacion' value='Buscar Funcionario' placeholder="rut funcionario">
                               
                                <script type="text/javascript">
                                    $(document).ready(function() {
                                            $('#user_verificacion').click(function(event) {
                                                    var nombreVar = $('#rut_administrador_user').val();
                                                    if (nombreVar==="") {
                                                        alert('Debe incluir al menos una entrada');
                                                        return false;
                                                     }
                                                    // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                                                    $.get('UsuarioServlet', {
                                                            rut : nombreVar

                                                    }, function(responseText) {
                                                        if (responseText==="false") {
                                                            alert("Funcionario No Existe, debe crear un funcionario primero");
                                                    }else{
                                                        
                                                        $('#tabla').html(responseText);
                                                        $('#user_verificacion').hide();
                                                        $('#rut_administrador_user').hide();
                                                        $('#separador_inferior').hide();
                                                        $('#mensaje_superior').hide();
                                                        $('#p_rut_funcionario').hide();
                                                        $('#user_delete').hide();
                                                    }    
                                                        
                                                    });
                                            });
                                    });
                                </script>
                                <input class="btn btn-danger" type='button' id='user_delete' value='Eliminar Usuario'>
                                
                                    <script type="text/javascript">
                                                                    
                                    $(document).ready(function() {
                                            $('#user_delete').click(function(event) {
                                                    var nombreVar = $('#rut_administrador_user').val();
                                                    if (nombreVar==="") {
                                                        alert("Campo Vacio, usuario no válido");
                                                        return false;
                                                    }
                                                    // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                                                    $.get('EliminarUsuario', {
                                                            id : nombreVar

                                                    }, function(respuesta) {
                                                           if(respuesta==="eliminado"){
                                                               alert('usuario eliminado');
                                                           }else{
                                                               alert('usuario no existe en los registros');
                                                           }
                                                            
                                                    });
                                            });
                                    });
                                </script>
                                
                                
                                <div id="tabla"></div>
                        </div>
                            </div>

                            <hr>

                  
                  
              </div>                 
            </div>
        </div>
      </div>
    </div>
      

</html>
