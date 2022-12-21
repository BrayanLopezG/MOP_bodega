<%-- 
    Document   : Solicitud
    Created on : 14-12-2022, 12:18:52 PM
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
        <title>Solicitud</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <h4 style="text-align: center;">Solicitud</h4>
                        </div>
                        <div class="card-body">
                            <c:forEach var="Pseleccionado" items="${seleccionado}">
                                <label>Descripcion</label>
                                <input class="form-control" id="txtproducto" name="txtproducto" value="${Pseleccionado.descripcion}">
                                <label>Medida</label>
                                <input class="form-control" id="txtmedida" name="txtmedida" value="${Pseleccionado.pdescripcion_medida}">
                                <label>Bodega</label>
                                <input class="form-control" id="txtbodega" name="txtbodega" value="${Pseleccionado.pnombre_bodega}">
                                <br>
                                <div class="d-flex justify-content-between">
                                    <label style="margin-left: 25px;">Cantidad</label>
                                    <label style="margin-right: 40px;">Stock</label>
                                </div>
                                <div class="d-flex justify-content-between">
                                    <input class="form-control" id="txtcantidad" name="txtcantidad">
                                    <input style="margin-left: 10px;" class="form-control" id="txtstock" name="txtstock" value="${Pseleccionado.cantidad}">
                                </div>
                            </c:forEach>
                        </div>
                        <div class="card-footer">
                            <div class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-outline-primary">Solicitar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-8">
                    <div class="d-flex justify-content-center">
                        <form class="form-inline" action="Controlador?menu=buscarproducto" method="POST">
                            <div class="input-group mb-3">
                                <input type="search" id="txtbuscar" name="txtbuscarproducto" class="sm-form-control" placeholder="Buscar">
                                <div class="input-group-append">
                                    <input class="btn btn-outline-success" type="submit"  value="Buscar">
                                </div>
                            </div>
                        </form>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Medida</th>
                                <th>Cantidad</th>
                                <th>Bodega</th>
                                <th>Opcion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="producto" items="${producto}">
                                <tr>
                                    <td><c:out value="${producto.descripcion}"></c:out></td>
                                    <td><c:out value="${producto.pdescripcion_medida}"></c:out></td>
                                    <td><c:out value="${producto.cantidad}"></c:out></td>
                                    <td><c:out value="${producto.pnombre_bodega}"></c:out></td>
                                        <td>
                                            <a href="Controlador?menu=productoseleccionado&id=<c:out value="${producto.idproducto}"></c:out>" class="btn btn-outline-info">Seleccionar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>       
    </body>
</html>
