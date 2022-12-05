<%-- 
    Document   : registrar
    Created on : 02-12-2022, 09:29:55 AM
    Author     : usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.PerfilUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Registrar</title>
    </head>
    <body>
        <div class="container">
            <h1>Nuevo Bodeguero</h1>
            <div class="from-group">
                <form action="Controlador?accion=guardar" method="POST">
                    <label>Usuario:</label>
                    <input class="form-control" id="txtusuario" name="txtusuario" type="text" placeholder="Ingresar Usuario">
                    <label>Contraseña:</label>
                    <input class="form-control" id="txtcontra" name="txtcontra" type="password" placeholder="Ingresar Contraseña">
                    <label>Repetir Contraseña:</label>
                    <input class="form-control" id="txtcontra2" name="txtcontra2" type="password" placeholder="Repetir Contraseña">                         
                    <label>Cargo:</label>
                    <select name="perfilU" class="custom-select">
                        <option selected> Seleccionar </option>
                        <option value="1">Administrador</option>
                        <option value="2">Bienes</option>
                        <option value="3">Prevención de Riesgo</option>
                    </select>
                    <br>
                    <br>
                    <button type="submit" class="btn btn-primary">Registrar</button>
                    <a href="Controlador?accion=atras" class="btn btn-secondary" role="button">Atras</a>
                </form>
            </div>
        </div>
    </body>
</html>