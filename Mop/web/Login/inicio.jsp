<%-- 

    Document   : index
    Created on : 30-11-2022, 01:03:52 PM
    Author     : usuario
--%>

<%@page import="Modelo.UsuarioDAO"%>
<%@page import="Modelo.Usuario"%>
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
        <title>usuario</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <a class="navbar-brand" href="#">Logo</a>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Solicitud</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Producto</a>
                    </li>

                    <!-- Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Bodega</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Link 1</a>
                            <a class="dropdown-item" href="#">Link 2</a>
                            <a class="dropdown-item" href="#">Link 3</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=login">Iniciar sesion</a>
                </ul>
            </nav>
        </header>
        <div class="container">
            <h1>Usuarios</h1>
            <br>
        </div>
        <div class="container">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Cargo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${lista}">
                        <tr>
                            <td> <c:out value = "${usuario.idusuario}"/></td>
                            <td> <c:out value = "${usuario.nombre_usuario}"/></td>
                            <td> <c:out value = "${usuario.perfil_id}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>