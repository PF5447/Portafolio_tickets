<?php
        session_start();
        
        if ($_SERVER["REQUEST_METHOD"]=="POST") {
            if (isset($_POST["usuario"])) {
                 $_SESSION["usuario"] = $_POST["usuario"];
                 header("location: listar.php");
            }
}
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Birth Day Zone</title>
        
    </head>
    <body>
        <div id="cabecera">
            <h1 id="titlo_h1">Zona Cumpleaños</h1>
            <h2 id="subtitulo_h2">Nombre Empresa</h2>
            <div id="imgen">
                <img src="http://lorempixel.com/180/100/" >
            </div>
            
        </div>
        <div id="contenido">
      
            
            <form name="login" action="listar.php" method="POST">
                <fieldset>
                    <legend>Login</legend>
                    
                    <input id="user" type="text" placeholder="Nmbre Usuario"/><br>
                    <input id="contrasena" type="password" placeholder="Pass"/><br>
                    <input type="submit"/>
                    
                </fieldset>
            
            </form>
            
        </div>    
        
        
    </body>
    
        
        
    
</html>

