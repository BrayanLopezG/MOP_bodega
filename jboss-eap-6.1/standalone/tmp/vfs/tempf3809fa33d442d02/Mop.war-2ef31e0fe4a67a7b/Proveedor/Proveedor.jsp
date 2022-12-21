<%-- 
    Document   : Proveedor
    Created on : 06-12-2022, 01:05:07 PM
    Author     : usuario
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Proveedor"%>
<%@page import="Modelo.ProveedorDAO"%>
<%@page import="Conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Proveedores</title>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <form action="Controlador?menu=nuevoproveedor" method="POST">
                        <div class="card">
                            <div class="card-header">
                                <h3 style="text-align: center;">Datos Proveedor</h3>
                            </div>
                            <div class="card-body">
                                <label>Rut</label>
                                <input class="form-control" id="txtrutproveedor" name="txtrutproveedor" type="text" placeholder="Ingresar Rut Proveedor">
                                <label>Nombre</label>
                                <input class="form-control" id="txtnombreproveedor" name="txtnombreproveedor" type="text" placeholder="Ingresar Nombre Proveedor">
                                <label>Telefono</label>
                                <input class="form-control" id="txttelefono" name="txttelefono" type="text" placeholder="Ingresar Telefono Proveedor">
                                <label>Direccion</label>
                                <input class="form-control" id="txtdireccion" name="txtdireccion" type="text" placeholder="Ingresar Direccion Proveedor">
                            </div> 
                            <div class="card-footer" style="text-align: center;">
                                <input type="submit" value="Registrar" class="btn btn-outline-primary">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-8">
                    <br>
                    <div class="d-flex justify-content-center">
                        <form class="form-inline" action="Controlador?menu=buscar" method="POST">
                            <div class="input-group mb-3">
                                <input type="search" id="txtbuscar" name="txtbuscar" class="sm-form-control" placeholder="Buscar">
                                <div class="input-group-append">
                                    <input class="btn btn-outline-success" type="submit"  value="Buscar">
                                </div>
                            </div>
                        </form>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Rut Proveedor</th>
                                <th>Nombre</th>
                                <th>Telefono</th>
                                <th>Direccion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="proveedor" items="${lista}">
                                <tr>
                                    <td><c:out value="${proveedor.id_proveedor}"/></td>
                                    <td><c:out value="${proveedor.rut_proveedor}"/></td>
                                    <td><c:out value="${proveedor.nombre_proveedor}"/></td>
                                    <td><c:out value="${proveedor.telefono_proveedor}"/></td>
                                    <td><c:out value="${proveedor.direccion_proveedor}"/></td>
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>    
                </div>
            </div>
        </div>
    </body>

</html>
