<%-- 
    Document   : verificacio_funcionario
    Created on : 24-05-2017, 10:24:41
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
                <div id=titulo>
                    <h1>Portal de Administración</h1>
                    <br>
                </div>
		<hr>
		<h2>Gestion de funcionarios</h2>
		<div class='container'>
			<div class='form-group'>
				
                            <input type='text' class='entrada_fun' name='rut_administrador' placeholder="Ingrese rut a consultar" required="">
                                <input type='button' class='boton_fun' name='boton_verificacion' value='Verificar Disponibilidad'>
				
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
