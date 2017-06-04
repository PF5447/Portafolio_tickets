<%-- 
    Document   : Totem
    Created on : 25-05-2017, 14:23:49
    Author     : bcn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<script type='text/javascript' src='js/jquery.js'></script>
        <script type='text/javascript' src='js/peticion_funcionarios.js'></script>
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
              <li><a>Grupos<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
              <li><a>Perfiles<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
              <li><a>Tickets<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
              <li><a>Turnos<span class="sub_icon glyphicon glyphicon-link"></span></a></li>
                           
            </ul>
      </div>
          
      <!-- Page content -->
      <div id="page-content-wrapper">
        <!-- Keep all page content within the page-content inset div! -->
        <div class="page-content inset">
          <div class="row">
              <div class="col-md-12">

                 <div class='container'>
			<div class='form-group'>
                                <p>Huella digital</p>
				<input type='text' id='totem_serie'><br>

				<input type='button' id='boton_verificacion' value='Imprimir Ticket'>
                                  <script type="text/javascript">
                                    $(document).ready(function() {
                                            $('#boton_verificacion').click(function() {
                                                    var serieFuncionario = $('#totem_serie').val();

                                                    // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                                                    $.get('TotemServlet', {
                                                            serie : serieFuncionario

                                                    }, function(responseText) {
                                                            
                                                            if (responseText==='false') {
                                                                alert('Lo Sentimos Aun no puedes solicitar Tickets \nHorarios:\n -Desayuno : 08:00:00 - 10:00:00\n -Almuerzo: 12:00:00 - 15:00:00\n -Once: 17:00:00 - 19:00:00\n -Cena: 21:00:00 - 23:00:00');
    
                                                            }else{
                                                                $('#tabla').html(responseText);
                                                            }
                                                            
                                                    });
                                            });
                                    });
                                </script>
	
                            </div>
                        </div>
                  
                  
                <div id="tabla"></div>
                </div>
        </div>
                  
                  
            </div>
          </div>
        </div>
      </div>
      
</div>



</html>

