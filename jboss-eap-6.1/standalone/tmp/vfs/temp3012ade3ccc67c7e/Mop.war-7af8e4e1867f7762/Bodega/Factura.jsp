<%-- 
    Document   : NuevoProducto
    Created on : 06-12-2022, 10:19:09 AM
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
        <title>Factura</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="card">
                <div class="card-header">
                    <div class="d-flex justify-content-between">
                        <h3>Nueva Factura</h3>
                        <img src="img/vialidad.jpg" alt="Logo" style="width: 80px;">
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <div class="d-flex justify-content-center">
                                <form action="Controlador?menu=listarproveedor" method="POST">
                                    <div class="d-flex justify-content-center">
                                        <h3>Buscar Proveedor</h3>
                                    </div>
                                    <div>
                                        <div class="input-group mb-3">
                                            <input type="text" class="sm-form-control" id="txtrut" name="txtrut" placeholder="Rut Proveedor">
                                            <div class="input-group-append">
                                                <input class="btn btn-outline-success" type="submit" value="Buscar">
                                                <a href="Controlador?menu=proveedor" class="btn btn-outline-secondary" role="button">Agregar</a>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="form-group">
                                <c:forEach var="proveedor" items="${lista}">
                                    <h3>Informacion Proveedor</h3>
                                    <label>Codigo Proveedor</label>
                                    <input class="form-control" id="txtid" name="txtid" value="<c:out value="${proveedor.id_proveedor}"/>" disabled>
                                    <label>Nombre</label>
                                    <input class="form-control" id="txtnombre" name="txtnombre" value="<c:out value="${proveedor.nombre_proveedor}"/>" disabled>
                                    <label>Telefono</label>
                                    <input class="form-control" id="txttelefono" name="txttelefono" value="<c:out value="${proveedor.telefono_proveedor}"/>" disabled>
                                    <label>Direccion</label>
                                    <input class="form-control" id="txtdireccion" name="txtdireccion" value="<c:out value="${proveedor.direccion_proveedor}"/>" disabled>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="col-6">
                            <br><br><br><br>
                            <div class="form-group">
                                <form action="Controlador?menu=nuevafactura&accion=lista" method="POST" enctype="multipart/form-data">
                                    <h3>Completar Informacion de Factura</h3>
                                    <label>Numero Factura</label>
                                    <input class="form-control" id="txtnrofactura" name="txtnrofactura" type="text" placeholder="Ingresar Numero Factura">
                                    <label>Orden de Compra</label>
                                    <input class="form-control" id="txtcompra" name="txtcompra" type="text" placeholder="Ingresar Orden de Compra">
                                    <div class="col_one_third col_last c-azul">
                                        <label>Fecha Factura</label>
                                        <input class="form-control" id="txtfecha" name="txtfecha" type="date">
                                    </div>
                                    <label>Adjuntar Factura</label>
                                    <input type="file" class="form-control-file border" id="factura" name="factura">
                                    <br>
                                    <button type="submit" class="btn btn-outline-primary">Siguiente</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
