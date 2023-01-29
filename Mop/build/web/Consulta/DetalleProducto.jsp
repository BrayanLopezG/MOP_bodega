<%-- 
    Document   : DetalleProducto
    Created on : 28-01-2023, 12:53:52 PM
    Author     : Brayan
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
                        <h4>Detalle del Producto</h4>
                    </div>
                </div>
                <div class="card-body">
                    <div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Medida</th>
                                    <th>Cantidad</th>
                                    <th>Departamento</th>
                                    <th>Bodega</th>
                                    <th>Numero de Factura</th>
                                    <th>Orden de Compra</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="productos" items="${producto}">
                                    <tr>
                                        <td><c:out value="${productos.idproducto}"></c:out></td>
                                        <td><c:out value="${productos.descripcion}"></c:out></td>
                                        <td><c:out value="${productos.pdescripcion_medida}"></c:out></td>
                                        <td><c:out value="${productos.cantidad}"></c:out></td>
                                        <td><c:out value="${productos.departamento}"></c:out></td>
                                        <td><c:out value="${productos.pnombre_bodega}"></c:out></td>
                                        <td><c:out value="${productos.nro_factura}"></c:out></td>
                                        <td><c:out value="${productos.orden_compra}"></c:out></td>
                                        </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center">
                        <a href="Controlador?menu=generardetalle" class="btn btn-outline-info">Generar Informe</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
