<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
        <script type="text/javascript" src="js/jquery.js"></script>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0" >
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/estilos.css">
	
        <title>Ticket Pro</title>
</head>
<body>
	<div class="container">
            <div class="row">
                <div class="col-md-offset-5 col-md-3">
                    <div class="form-login">
                        <h4>Bienvenido a Ticket Pro</h4>
                            <legend>Login</legend>
                                <input type="text" id="login_usuario" class="form-control input-sm chat-input" placeholder="username">
                                <br>
                                <input type="password" id="login_password"  class="form-control input-sm chat-input" placeholder="password">
                                <br>
                                <div class="wrapper">
                                <span class="group-btn">
                                    <input class="btn btn-primary btn-md" type="button" id="submit_formulario" value="Login"><i class="fa fa-sign-in"></i>
                                </span>
                                </div>
                                </div>
                                             
                                           

                                
                                    
                                    
                            
                            <script type="text/javascript">
                                $(Document).ready(function() {
                                        $('#submit_formulario').click(function() {
                                              var usuario = $('#login_usuario').val();
                                              var password = $('#login_password').val();
                                        $.ajax({
                                            type : 'POST',
                                            url : 'LoginServlet',
                                            data :{user : usuario ,pass : password},

                                                success : function (data){
                                                var respuesta = data;

                                                if (respuesta==="true") {
                                                    location.href = "verificacion_funcionario.jsp"; 
                                                }else{
                                                    alert('Contraseña o Nombre de usuario invalido');
                                                }

                                            }


                                        });

                                });
                                });


                            </script>
	</div>
        </div>
        </div>
	</div>
	
	
</body>

</html>

