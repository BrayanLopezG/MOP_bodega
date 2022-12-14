<%-- 
    Document   : login
    Created on : 02-12-2022, 09:00:11 AM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Inicio Sesion</title>
    </head>
    <body>
        <div class="container">
            <br>
            <div class="d-flex justify-content-center">
                <div class="card" style="width: 500px;">
                    <div class="card-header">
                        <h1 style="text-align: center;">Inciar Sesion</h1>
                        <div class="d-flex justify-content-center">
                            <img src="img/vialidad.jpg" alt="logo">
                        </div>
                        <div class="card-body">
                            <form action="Validar" method="POST">
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input class="form-control" id="txtusuario" name="txtusuario" type="text" placeholder="Ingresar Usuario">
                                    <br>
                                    <label>Contraseña</label>
                                    <input class="form-control" id="txtcontra" name="txtcontra" type="password" placeholder="Ingresar Contraseña">
                                    <br>
                                    <div style="text-align: center;">
                                        <button type="submit" name="accion" value="ingresar" class="btn btn-lg btn-outline-primary">Ingresar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
