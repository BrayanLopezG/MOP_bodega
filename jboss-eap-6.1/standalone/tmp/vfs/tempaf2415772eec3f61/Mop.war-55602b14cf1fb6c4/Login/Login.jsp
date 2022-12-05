<%-- 
    Document   : Login
    Created on : 01-12-2022, 08:58:03 AM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Iniciar Session</h1>
        <br>
        <form action= "login" method="POST" autocomplete="off">
            <div>
                <label>Usuario: </label>
                <br>
                <input type="text" placeholder="Nombre de usuario">
                <br>
                <label>Contraseña: </label>
                <br>
                <input type="password" placeholder="Contraseña">
                <br>
                <button id = "ingresar" name = "ingresar"> Ingresar </button>
                <br>
                <button id = "registrar" name ="registrar"> Registrar </button>
            </div>
        </form>
    </body>
</html>
