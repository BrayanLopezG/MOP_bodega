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
                            <input type="submit" name="accion" value="Agregar +" class="btn btn-outline-success">
                        </div>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="col-12">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Codigo Producto</th>
                                <th>Descripcion</th>
                                <th>Cantidad</th>
                                <th>Codigo Factura</th>
                                <th>Bodega</th>
                                <th>Medida</th>
                                <th>Configuracion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <a>Modificar</a>
                                    <a>Eliminar</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
