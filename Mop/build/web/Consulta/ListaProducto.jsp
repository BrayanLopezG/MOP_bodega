<%-- 

    Document   : Producto
    Created on : 06-12-2022, 09:25:47 AM
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
        <title>Bodega</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="card">
                <div class="card-header">
                    <div class="d-flex justify-content-center">
                        <h1>Bodega</h1>
                    </div>
                </div>
                <div class="card-body">
                    <div class="d-flex justify-content-center">
                        <form class="form-inline" action="Controlador?menu=buscarproductobodega" method="POST">
                            <div class="input-group mb-3">
                                <input type="search" id="txtbuscar" name="txtbuscar" class="form-control" placeholder="Buscar Producto">
                                <div class="input-group-append">
                                    <input class="btn btn-outline-success" type="submit"  value="Buscar">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Medida</th>
                                    <th>Cantidad</th>
                                    <th>Departamento</th>
                                    <th>Bodega</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="productos" items="${producto}">
                                    <tr>
                                        <td><c:out value="${productos.descripcion}"></c:out></td>
                                        <td><c:out value="${productos.pdescripcion_medida}"></c:out></td>
                                        <td><c:out value="${productos.cantidad}"></c:out></td>
                                        <td><c:out value="${productos.departamento}"></c:out></td>
                                        <td><c:out value="${productos.pnombre_bodega}"></c:out></td>
                                            <td>
                                                <a href="Controlador?menu=detalleproducto&nom=<c:out value="${productos.descripcion}"></c:out>&medi=<c:out value="${productos.pdescripcion_medida}"></c:out>" class="btn btn-outline-info">Ver Detalle</a>
                                            </td>
                                        </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center">
                        <a href="Controlador?menu=generarinforme" class="btn btn-outline-info">Generar Informe</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
