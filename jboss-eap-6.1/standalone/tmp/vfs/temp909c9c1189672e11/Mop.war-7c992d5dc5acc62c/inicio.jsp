<%-- 
    Document   : index
    Created on : 02-12-2022, 11:23:46 AM
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
            <h1>Hello World!</h1>
        </div>
    </body>
</html>
