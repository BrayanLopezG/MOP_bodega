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
                    <div class="col">
                        <br>
                        <h3>Agregar Producto</h3>
                        <br>
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
                        <div class="input-group mb-3">
                            <br>
                            <input type="text" class="form-control" id="txtdescripcion" name="txtdescripcion" placeholder="Descripcion del Producto">
                            <div class="input-group-append">
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
                            <input type="text" class="form-control" id="txtfacturaid" name="txtfacturaid" value="${factura.getOrden_compra()}" disabled>
                            <input type="text" class="form-control" id="txtcantidad" name="txtcantidad" placeholder="Cantidad">
                            <input type="submit" name="accion" value="Agregar" class="btn btn-outline-success">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-outline-secondary">
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
                            <c:forEach var="producto" items="${listar}">
                                <tr>
                                    <td><c:out value="${producto.id_producto}"></c:out></td>
                                    <td><c:out value="${producto.descripcion}"></c:out></td>
                                    <td><c:out value="${producto.cantidad}"></c:out></td>
                                    <td><c:out value="${producto.facturaid}"></c:out></td>
                                    <td><c:out value="${producto.bodegaid}"></c:out></td>
                                    <td><c:out value="${producto.medida_id}"></c:out></td>
                                    <td>
                                        <a href="Controlador?menu=modificar&id=${producto.id_producto}" role="button" class="btn btn-outline-warning">Modificar</a>
                                        <a href="Controlador?menu=eliminar&id=${producto.id_producto}" role="button" class="btn btn-outline-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="d-flex justify-content-start">
                <a href="" class="btn btn-outline-primary">Finalizar</a>
            </div>
        </div>
    </body>
</html>
