<%-- 
    Document   : Producto
    Created on : 09-12-2022, 11:57:38 AM
    Author     : usuario
--%>


<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Medida"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.MedidaDAO"%>
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
        <header>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <a class="navbar-brand" href="#"><img src="img/vialidad.jpg" alt="Logo" style="width: 40px;"></a>
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
        <div class="container">
            <form action="Controlador?accion=nuevoproducto" method="POST">
                <div class="row">
                    <div class="col">
                        <br>
                        <h3>Agregar Producto</h3>
                        <br>
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="txtdescripcion" name="txtdescripcion" placeholder="Descripcion del Producto">
                            <div class="input-group-append">
                                <select id="medida" class="custom-select">
                                    <%
                                        MedidaDAO medidadao = new MedidaDAO();
                                        List<Medida> listamedida = medidadao.listaMedida();
                                        Iterator<Medida> iteratormedida = listamedida.iterator();
                                        Medida medida = null;
                                        while (iteratormedida.hasNext()) {
                                            medida = iteratormedida.next();
                                    %>
                                    <option value="<%= medida.getId_medida()%>"><%= medida.getDescripcion()%></option>
                                    <%}%>
                                </select>
                            </div>
                                <input type="text" class="form-control" id="txtfacturaid" name="txtfacturaid" value="${idfactura}" disabled>
                            <input type="text" class="form-control" id="txtcantidad" name="txtcantidad" placeholder="Cantidad">
                            <div class="input-group-append">
                                <button class="btn btn-outline-success" type="submit">Agregar +</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
