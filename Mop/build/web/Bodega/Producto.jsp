<%-- 
    Document   : Producto
    Created on : 09-12-2022, 11:57:38 AM
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
        <title>Producto</title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <div class="d-flex justify-content-between">
                        <h3>Nueva Factura</h3>
                        <img src="img/vialidad.jpg" alt="Logo" style="width: 80px;">
                    </div>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=nuevoproducto" method="POST">
                        <div class="row">
                            <div class="col-12">
                                <div class="row">
                                    <div class="col-4">
                                        <p>Seleccionar bodega</p>
                                        <select id="bodega" name="bodega" class="custom-select">
                                            <c:forEach var="bodega" items="${bodega}">
                                                <option value="<c:out value="${bodega.id_bodega}"></c:out>"><c:out value="${bodega.nombre_bodega}"></c:out></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-4">
                                        <p>Seleccionar Departamento</p>
                                        <select id="departamento" name="departamento" class="custom-select">
                                            <c:forEach var="perfil" items="${perfil}">
                                                <option><c:out value="${perfil.descripcion_perfil}"></c:out></option>
                                            </c:forEach>
                                        </select> 
                                    </div>
                                    <div class="col-4">
                                        <p>Orden de compra</p>
                                        <input type="text" class="form-control" id="txtfactura" name="txtfactura" value="${factura.getOrden_compra()}" disabled>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-3">
                                        <p>Descripcion del Producto</p>
                                        <input type="text" class="form-control" id="txtdescripcion" name="txtdescripcion" placeholder="Descripcion del Producto">
                                    </div>
                                    <div class="col-3">
                                        <p>Seleccionar Medida</p>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <select id="medida" name="medida" class="custom-select">
                                                    <c:forEach var="medida" items="${medida}">
                                                        <option value="<c:out value="${medida.id_medida}"></c:out>"><c:out value="${medida.descripcion}"></c:out></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#nuevamedida">Agregar +</button>
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <p>Indique la Cantidad</p>
                                        <input type="text" class="form-control" id="txtcantidad" name="txtcantidad" placeholder="Cantidad">
                                    </div>
                                    <div class="col-3">
                                        <p>Finalizar Registro</p>
                                        <input type="submit" name="accion" value="Agregar" class="btn btn-outline-success">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <br>
            </div>
            <div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Descripcion</th>
                            <th>Orden de Compra</th>
                            <th>Cantidad</th>
                            <th>Bodega</th>
                            <th>Medida</th>
                            <th>Departamento</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${listar}">
                            <tr>
                                <td><c:out value="${producto.idproducto}"></c:out></td>
                                <td><c:out value="${producto.descripcion}"></c:out></td>
                                <td><c:out value="${producto.orden_compra}"></c:out></td>
                                <td><c:out value="${producto.cantidad}"></c:out></td>
                                <td><c:out value="${producto.pnombre_bodega}"></c:out></td>
                                <td><c:out value="${producto.pdescripcion_medida}"></c:out></td>
                                <td><c:out value="${producto.departamento}"></c:out></td>
                                    <td>
                                        <a href="Controlador?menu=eliminar&id=${producto.idproducto}" class="btn btn-outline-danger">Quitar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal fade" id="nuevamedida">
                <form action="Controlador?menu=nuevamedida" method="POST">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 style="text-align: center;">Agregar Medida</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <label>Nueva Medida</label>
                                <input class="form-control" id="txtmedida" name="txtmedida" type="text" placeholder="Cargo" >
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-outline-success">Guardar</Button>
                                <button style="margin-left: 10px;" type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
