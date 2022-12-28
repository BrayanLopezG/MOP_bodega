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
            <div class="card">
                <div class="card-header">
                    <div class="d-flex justify-content-between">
                        <h3>Solicitud</h3>
                        <img src="img/vialidad.jpg" alt="Logo" style="width: 70px;">
                    </div>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=pedido" method="POST">
                        <div class="row">
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-2">
                                        <label>RUN</label>
                                        <input class="form-control" id="txtrun" name="txtrun" value="${solicitud.getRun()}" type="text">
                                    </div>
                                    <div class="col-2">
                                        <label>Nombre</label>
                                        <input class="form-control" id="txtdestinatario" name="txtdestinatario" value="${solicitud.getNombre()}" type="text">
                                    </div>
                                    <div class="col-4">
                                        <label>Provincia</label>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <select class="custom-select" id="provincia" name="provincia">
                                                    <c:forEach var="provincia" items="${provincia}">
                                                        <option value="<c:out value="${provincia.provinciaid}"></c:out>"><c:out value="${provincia.nom_provincia}"></c:out></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#nuevaprovincia">Agregar +</button>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <label>Bodega</label>
                                        <input class="form-control" id="txtbodega" name="txtbodega" value="${seleccionado.getPnombre_bodega()}" disabled>
                                    </div>
                                    <div class="col-2">
                                        <label>Responsable</label>
                                        <input class="form-control" id="txtusuario" name="txtusuario" value="${usua.getNombre_usuario()}" disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="col-2">
                                <br>
                                <label>Producto</label>
                                <input class="form-control" id="txtproducto" name="txtproducto" value="${seleccionado.getDescripcion()}" disabled>
                            </div>
                            <div class="col-2">
                                <br>
                                <label>Medida</label>
                                <input class="form-control" id="txtmedida" name="txtmedida" value="${seleccionado.getPdescripcion_medida()}" disabled>
                            </div>
                            <div class="col-1">
                                <br>
                                <label>Stock</label>
                                <input class="form-control" value="${seleccionado.getCantidad()}" disabled>
                            </div>
                            <div class="col-1">
                                <br>
                                <label>Cantidad</label>
                                <input class="form-control" id="txtvalor" name="txtvalor" type="number">
                            </div>
                            <div class="col-2">
                                <br>
                                <div class="col_one_third col_last c-azul">
                                    <label>Fecha Solicitud</label>
                                    <br>
                                    <input class="form-control" id="txtfecha" name="txtfecha" type="date">
                                </div>
                            </div>
                            <div class="col-2">
                                <br>
                                <label>Finalizar Registro</label>
                                <button type="submit" class="btn btn-outline-success">Agregar +</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-footer">
                    <div  class="d-flex justify-content-end">
                        <button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#detalle">Mostrar Detalle</button>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="nuevaprovincia">
                <form action="Controlador?menu=nuevaprovincia" method="POST">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 style="text-align: center;">Agregar Medida</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <label>Nueva Medida</label>
                                <input class="form-control" id="txtprovincia" name="txtprovincia" type="text" placeholder="Cargo" >
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-outline-success">Guardar</Button>
                                <button style="margin-left: 10px;" type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal fade" id="detalle">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 style="text-align: center;">Detalle Solicitud</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Item</th>
                                        <th>Codigo</th>
                                        <th>Producto</th>
                                        <th>Medida</th>
                                        <th>Cantidad</th>
                                        <th>Destinatario</th>
                                        <th>Run</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="pedido" items="${pedido}">
                                        <tr>
                                            <td><c:out value="${pedido.idsolicitud}"></c:out></td>
                                            <td><c:out value="${pedido.producto}"></c:out></td>
                                            <td><c:out value="${pedido.descripcionproducto}"></c:out></td>
                                            <td><c:out value="${pedido.descripcionmedida}"></c:out></td>
                                            <td><c:out value="${pedido.cantidad}"></c:out></td>
                                            <td><c:out value="${pedido.nombre}"></c:out></td>
                                            <td><c:out value="${pedido.run}"></c:out></td>
                                                <td>
                                                    <a href="Controlador?menu=quitarpedido&idpedido=<c:out value="${pedido.idsolicitud}"></c:out>" class="btn btn-outline-danger">Quitar</a>
                                                </td>
                                            </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <a href="Controlador?menu=generarsolicitud" class="btn btn-outline-success">Generar Solicitud</a>
                            <button style="margin-left: 10px;" type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="card">
                <div class="card-body">
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
                                <th>Stock</th>
                                <th>Bodega</th>
                                <th>Orden de Compra</th>
                                <th>Opcion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="producto" items="${producto}">
                                <c:if test="${producto.cantidad > 0}">
                                    <tr>
                                        <td><c:out value="${producto.descripcion}"></c:out></td>
                                        <td><c:out value="${producto.pdescripcion_medida}"></c:out></td>
                                        <td><c:out value="${producto.cantidad}"></c:out></td>
                                        <td><c:out value="${producto.pnombre_bodega}"></c:out></td>
                                        <td><c:out value="${producto.orden_compra}"></c:out></td>
                                            <td>
                                                <a href="Controlador?menu=productoseleccionado&id=<c:out value="${producto.idproducto}"></c:out>" class="btn btn-outline-info">Seleccionar</a>
                                            </td>
                                        </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
