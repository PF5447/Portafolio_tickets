<%@page import="connection.ConnectionDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script type="text/javascript" src=""></script>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0" >


	<link href="css/bootstrap.min.css" rel="stylesheet">
	<title>Ticket Pro</title>
</head>
<body>
	<div class="container">
	<div id=titulo>
		<h1>Ticket Pro</h1>
		
	</div>
	<div id=login>
	<fieldset>
		<legend>Login</legend>
                <form id=formulario method="post" action="./LoginServlet">
			<div id="entradas_formulario">
				
				<div class="form-group">
					<p>Nombre Usuario</p>
					<input class="form-control" type="text" name="login_usuario" maxlength="50">
				</div>
				
				<div class="form-group">
					<p>Contraseña</p>
					<input class="form-control" type="password" name="login_pasword" maxlength="50">
				</div>

			</div>
			<div cals="form-group">
				<input class="btn btn-primary" type="submit" name="submit_formulario" value="Ingresar">
			</div>
		</form>
	</fieldset>
	</div>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
<footer>
	
</footer>
</html>

