<%-- 
    Document   : NuevoProducto
    Created on : 06-12-2022, 10:19:09 AM
    Author     : usuario
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.BodegaDAO"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Bodega"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <a class="navbar-brand" href="#">Logo</a>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="bodega" data-toggle="dropdown">Bodega</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="Controlador?accion=ingreso">Ingreso</a>
                            <a class="dropdown-item" href="Controlador?accion=salida">Salida</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=proveedor" id="proveedores">Proveedores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=consultar" id="consulta">Consultar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?accion=login">Iniciar Sesion</a>
                    </li>
                </ul>
            </nav>
        </header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <br>
                    <h3>Datos Factura</h3>
                    <form action="Controlador?accion=buscarproveedor" method="POST">
                        <div class="input-group mb-3">
                            <input type="text" class="sm-form-control" id="txtrut" name="txtrut" placeholder="Rut Proveedor">
                            <div class="input-group-append">
                                <input class="btn btn-outline-success" type="submit" value="Buscar">
                                <a href="Controlador?accion=proveedor" class="btn btn-outline-secondary" role="button">Agregar</a>
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <h3>Completar Datos Factura</h3>
                                <label>Numero Factura</label>
                                <input class="form-control" id="txtnrofactura" name="txtnrofactura" type="text" placeholder="Ingresar Numero Factura">
                                <label>Orden de Compra</label>
                                <input class="form-control" id="txtcompra" name="txtcompra" type="text" placeholder="Ingresar Orden de Compra">
                                <div class="col_one_third col_last c-azul">
                                    <label>Fecha Factura</label>
                                    <input class="form-control" id="txtfecha" name="txtfecha" type="date">
                                </div>
                                <br>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="factura">
                                    <label class="custom-file-label" for="customFile">Adjuntar Factura</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
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
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <br>
                    <h1 style="text-align: center">Agregar Producto</h1>
                    <br>
                    <div class="row">
                        <div class="col-6">
                            <label>Producto</label>
                            <input class="form-control" id="txtdescripcion" name="txtdescripcion" type="text" placeholder="Ingresar nombre del producto">
                            <label>Estado</label>
                            <input class="form-control" id="txtestado" name="txtestado" type="text" placeholder="Ingresar estado de producto">
                            <label>Cantidad</label>
                            <input class="form-control" id="txtcantidad" name="txtcantidad" type="text" placeholder="Ingresar cantidad">
                            <div class="col_one_third col_last c-azul">
                                <label>Fecha Producto</label>
                                <input class="form-control" id="txtfechaproducto" name="txtfechaproducto" type="date">
                            </div>
                            <br>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <label>Seleccionar Bodega</label>
                                <select class="form-control" id="bodega">
                                    <%
                                        BodegaDAO bodegadao = new BodegaDAO();
                                        List<Bodega> listabodega = bodegadao.listaBodega();
                                        Iterator<Bodega> iter = listabodega.iterator();
                                        Bodega bodega = null;
                                        while (iter.hasNext()) {
                                            bodega = iter.next();
                                    %>
                                    <option value="<%= bodega.getId_bodega()%>"><%= bodega.getNombre_bodega()%></option>
                                    <%}%>
                                </select>
                                <label>Seleccionar Medida</label>
                                <select class="form-control" id="medida">
                                    <option>1</option>
                                </select>
                                <label>Selecccionar Volumen</label>
                                <select class="form-control">
                                    <option>1</option>
                                </select>
                                <br>
                                <div style="text-align: center">
                                    <button type="submit" class="btn btn-outline-primary">Registrar</button>
                                    <a href="Controlador?accion=atras" class="btn btn-outline-secondary" role="button">Atras</a>
                                </div>
                            </div>
                        </div>
                    </div>                
                </div>
            </div>
        </div>                         
    </body>
</html>
