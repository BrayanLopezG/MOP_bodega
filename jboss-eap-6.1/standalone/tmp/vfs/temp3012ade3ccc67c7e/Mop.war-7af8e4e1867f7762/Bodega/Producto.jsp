<%-- 
    Document   : Producto
    Created on : 09-12-2022, 11:57:38 AM
    Author     : usuario
--%>


<%@page import="Modelo.Bodega"%>
<%@page import="Modelo.BodegaDAO"%>
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
            <form action="Controlador?menu=nuevoproducto" method="POST">
                <div class="row">
                    <div class="col-12">
                        <h3>Agregar Producto</h3>
                        <br>
                        <div class="row">
                            <div class="col-6">
                                <p>Seleccionar bodega</p>
                                <select id="bodega" name="bodega" class="custom-select">
                                    <%
                                        BodegaDAO bdao = new BodegaDAO();
                                        List<Bodega> listabodega = bdao.listaBodega();
                                        Iterator<Bodega> iteratorbodega = listabodega.iterator();
                                        Bodega bodega = null;
                                        while (iteratorbodega.hasNext()) {
                                            bodega = iteratorbodega.next();
                                    %>
                                    <option value="<%= bodega.getId_bodega()%>"><%= bodega.getNombre_bodega()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="col-6">
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
                                <select id="medida" name="medida" class="custom-select">
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
            <br>
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
                            <c:forEach var="producto" items="${listar}">
                                <tr>
                                    <td><c:out value="${producto.idproducto}"></c:out></td>
                                    <td><c:out value="${producto.descripcion}"></c:out></td>
                                    <td><c:out value="${producto.cantidad}"></c:out></td>
                                    <td><c:out value="${producto.facturaid}"></c:out></td>
                                    <td><c:out value="${producto.bodegaid}"></c:out></td>
                                    <td><c:out value="${producto.medida_id}"></c:out></td>
                                        <td>
                                            <a href="Controlador?menu=eliminar&id=${producto.idproducto}" role="button" class="btn btn-outline-danger">Eliminar</a>
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
