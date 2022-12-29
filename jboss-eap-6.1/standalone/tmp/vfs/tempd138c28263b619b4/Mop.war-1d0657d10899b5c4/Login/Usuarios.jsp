<%-- 
    Document   : Usuarios
    Created on : 16-12-2022, 08:39:42 AM
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Usuarios</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="d-flex justify-content-center">
                <h3>Usuarios Agregados</h3>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>RUN</th>
                        <th>Nombre</th>
                        <th>Usuario</th>
                        <th>Cargo</th>
                        <th>Bodega</th>
                        <th>Configuracion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${listar}">
                        <tr>
                            <td><c:out value="${usuario.rut}"></c:out></td>
                            <td><c:out value="${usuario.nombre}"></c:out> <c:out value="${usuario.apellido}"></c:out></td>
                            <td><c:out value="${usuario.nombre_usuario}"></c:out></td>
                            <td><c:out value="${usuario.descripcion_perfil}"></c:out></td>
                            <td><c:out value="${usuario.unombre_bodega}"></c:out></td>
                            <td>
                                <a href="Controlador?menu=eliminarusaurio&id=${usuario.idusuario}" role="button" class="btn btn-outline-danger">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
