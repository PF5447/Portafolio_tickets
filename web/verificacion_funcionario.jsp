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

                  <div class='container'>
                <div id=titulo>
                    <h1>Portal de Administración</h1>
                    <br>
                </div>
		<hr>
		<h3>Gestion de funcionarios</h3>
		<div class='container'>
			<div class='form-group'>
				
                            <input type='text' class="form-control" id='rut_administrador' placeholder="Formato xxxxxxxx-x" required>
                            <br>
                           
                            <input type='button' class="btn btn-success" id='boton_verificacion' value='Verificar Disponibilidad'>
                             
                             <div id='tabla'></div>
                            <script type="text/javascript">
                                                                    
                                    $(document).ready(function() {
                                            $('#boton_verificacion').click(function(event) {
                                                    var nombreVar = $('#rut_administrador').val();
                                                    
                                                        
                                                        if (nombreVar==="") {
                                                        alert("Campo Vacio, usuario no válido");
                                                        return false;
                                                    }
                                                    // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                                                    $.get('FuncionarioServlet', {
                                                            rut : nombreVar

                                                    }, function(responseText) {
                                                        if (responseText==="rut_existe") {
                                                   
                                                           if (confirm('funcionario ya existe, desea gestionarlo?')) {
                                                               $.get(
                                                                   'GestionarFuncionario',
                                                                    {rut:nombreVar},
                                                                    function(respuesta){
                                                                        if(respuesta==='error'){
                                                                            alert('error');
                                                                        }else{
                                                                            $("#tabla").html(respuesta);
                                                                        }
                                                                        
                                                                        
                                                                        
                                                                    }
                    
                                                                );
                                                               
                                                               
                                                           }else{
                                                               alert('Respondio NO');
                                                               
                                                           }
    

                                                               
                                                               
                                                               
                                                        }else if(responseText==="formato_error"){
                                                                alert('Rut No tiene formato válido');
                                                        }else{
                                                                $("#rut_administrador").hide();
                                                                $("#boton_verificacion").hide();
                                                                $("#tabla").html(responseText);
                                                            
                                                        }
                                                            
                                                    });
                                            });
                                    });
                                </script>
                        </div>
               
                </div>
        </div>
                  
                  
            </div>
          </div>
        </div>
      </div>
      
</div>



</html>
