<%-- 
    Document   : ListaSolicitud
    Created on : 20-12-2022, 12:40:38 PM
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
            <div class="row">
                <div class="col-8">
                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Numero Solicitud</th>
                                        <th>Run Destinatario</th>
                                        <th>Destinatario</th>
                                        <th>Fecha</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="solicitudes" items="${listasolicitudes}">
                                        <tr>
                                            <td><c:out value="${solicitudes.nro_solicitud}"></c:out></td>
                                            <td><c:out value="${solicitudes.nombre}"></c:out></td>
                                            <td><c:out value="${solicitudes.run}"></c:out></td>
                                            <td><c:out value="${solicitudes.fecha}"></c:out></td>
                                                <td>
                                                    <a href="Controlador?menu=detallesolicitud&solicitud=<c:out value="${solicitudes.idsolicitud}"></c:out>" class="btn btn-outline-info">Ver Detalle</a>
                                                </td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <div class="d-flex justify-content-between">
                                <h3>Detalle Solicitud</h3>
                                <img src="img/vialidad.jpg" alt="Logo" style="width: 70px;">
                            </div>
                        </div>
                        <div class="card-body">
                            <label>Numero de Solicitud: ${participantes.getNro_solicitud()}</label>
                            <br>
                            <label>RUN: ${participantes.getRun()}</label>
                            <br>
                            <label>Destinatario: ${participantes.getNombre()}</label>
                            <br>
                            <label>Fecha: ${participantes.getFecha()}</label>
                            <br>
                            <label>Provincia: ${participantes.getDescripcionprovincia()}</label>
                            <br>
                            <label>Productos Solicitados</label>
                            <c:forEach var="detalleS" items="${detalle}">
                                <label>Producto: <c:out value="${detalleS.descripcionproducto}"></c:out> Cantidad: <c:out value="${detalleS.cantidad}"></c:out> Medida: <c:out value="${detalleS.descripcionmedida}"></c:out></label>
                                    <br>
                            </c:forEach>
                            <label>RUN Responsable: ${participantes.getUsuario_run()}</label>
                            <br>
                            <label>Responsable: ${participantes.getUsuario_nombre()} ${participantes.getUsuario_apellido()}</label>
                            <br>
                            <label>Bodega: ${participantes.getDescripcionbodega()}</label>
                            <br>
                        </div>
                        <div class="card-footer">
                            <div class="d-flex justify-content-center">
                                <a href="Controlador?menu=pdf&solicitud=${participantes.getNro_solicitud()}" class="btn btn-outline-info">Generar PDF</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
