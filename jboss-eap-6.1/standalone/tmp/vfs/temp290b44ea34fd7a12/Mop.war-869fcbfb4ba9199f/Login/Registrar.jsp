<%-- 
    Document   : registrar
    Created on : 02-12-2022, 09:29:55 AM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <title>Registrar</title>
    </head>
    <body>
        <div class="container">
            <form action="Controlador?menu=guardar" method="POST">
                <div class="card">
                    <div class="card-header bg-light">
                        <div class="d-flex justify-content-between">
                            <h1>Nuevo Usuario</h1>
                            <img src="img/vialidad.jpg" alt="Logo" style="width: 100px">
                        </div>    
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <h3 style="text-align: center">Información de la cuenta</h3>
                                    <label>Usuario:</label>
                                    <input class="form-control" id="txtusuario" name="txtusuario" type="text" placeholder="Ingresar Usuario">
                                    <label>Contraseña:</label>
                                    <input class="form-control" id="txtcontra1" name="txtcontra1" type="password" placeholder="Ingresar Contraseña">
                                    <label>Repetir Contraseña:</label>
                                    <input class="form-control" id="txtcontra2" name="txtcontra2" type="password" placeholder="Repetir Contraseña">                         
                                    <label>Cargo:</label>
                                    <select name="perfil" class="custom-select">
                                        <option selected> Seleccionar </option>
                                        <c:forEach var="perfil" items="${perfil}">
                                            <option value="<c:out value="${perfil.idperfil}"></c:out>"><c:out value="${perfil.descripcion_perfil}"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <h3 style="text-align: center">Información Personal</h3>                                    
                                    <label>Nombre:</label>
                                    <input class="form-control" id="txtnombre" name="txtnombre" type="text" placeholder="Ingresar Nombre del Funcionario">
                                    <label>Apellido:</label>
                                    <input class="form-control" id="txtapellido" name="txtapellido" type="text" placeholder="Ingresar Apellido del Funcionario">
                                    <label>RUN:</label>
                                    <input class="form-control" id="txtrut" name="txtrut" type="text" placeholder="Ingresar RUN del Funcionario">
                                    <label>Bodega</label>
                                    <select name="bodega" class="custom-select">
                                        <option selected> Seleccionar </option>
                                        <c:forEach var="bodega" items="${bodega}">
                                            <option value="<c:out value="${bodega.id_bodega}"></c:out>"><c:out value="${bodega.nombre_bodega}"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer" style="text-align: center;">
                        <button type="submit" class="btn btn-lg btn-outline-primary">Registrar</button>
                    </div>
                </div>
            </form>
        </div>  
    </body>
</html>