<%-- 
    Document   : Solicitud
    Created on : 14-12-2022, 12:18:52 PM
    Author     : usuario
--%>

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
            <div class="row">
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <h4 style="text-align: center;">Solicitud</h4>
                        </div>
                        <div class="card-body">
                            <label>Descripcion</label>
                            <input class="form-control" id="txtproducto" name="txtproducto">
                            <label>Medida</label>
                            <input class="form-control" id="txtmedida" name="txtmedida">
                            <label>Cantidad</label>
                            <input class="form-control" id="txtcantidad" name="txtcantidad">
                            <label>Stock</label>
                            <input class="form-control" id="txtstock" name="txtstock">
                            <label>Bodega</label>
                            <input class="form-control" id="txtbodega" name="txtbodega">
                        </div>
                    </div>
                </div>
                <div class="col-8">
                    <div class="d-flex justify-content-center">
                        <form class="form-inline" action="Controlador?menu=buscarproducto" method="POST">
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
                                <th>Producto</th>
                                <th>Medida</th>
                                <th>Cantidad</th>
                                <th>Bodega</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>

                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>       
    </body>
</html>
