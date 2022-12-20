<%-- 
    Document   : index
    Created on : 02-12-2022, 11:23:46 AM
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelo.UsuarioDAO"%>
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
        <title>MOP Vialidad</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-info">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="navbar-brand" href="#"><img src="img/vialidad.jpg" alt="Logo" style="width: 40px;"></a>           
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <button style="margin-left: 10px; border: none;" class="dropdown-toggle btn btn-outline-light" type="button" id="dropdownbuttonbodega" data-toggle="dropdown">Bodega</button>
                                <div class="dropdown-menu" aria-labelledby="dropdownbuttonbodega">
                                    <a class="dropdown-item" href="Controlador?menu=ingreso&id=${usuario.getIdusuario()}" target="bodega">Ingresar Producto</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="Controlador?menu=salida&id=${usuario.getIdusuario()}" target="bodega">Salida Producto</a>    
                                </div>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=proveedor&accion=lista" target="bodega">Proveedor</a>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <button style="margin-left: 10px; border: none;" class="dropdown-toggle btn btn-outline-light" type="button" id="dropdownbuttonbodega" data-toggle="dropdown">Consultar Bodega</button>
                                <div class="dropdown-menu" aria-labelledby="dropdownbuttonbodega">
                                    <a class="dropdown-item" href="Controlador?menu=consultaproducto&id=${usuario.getIdusuario()}" target="bodega">Productos</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="Controlador?menu=consultasolicitud&id=${usuario.getIdusuario()}" target="bodega">Solicitudes</a>    
                                </div>
                            </div>
                        </li>
                        <c:if test="${usuario.descripcion_perfil == 'Administrador'}">
                            <li class="nav-item">
                                <div class="dropdown">
                                    <button style="margin-left: 10px; border: none;" class="dropdown-toggle btn btn-outline-light" type="button" id="dropdownbuttonbodega" data-toggle="dropdown">Usuario</button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownbuttonbodega">
                                        <a class="dropdown-item" href="Controlador?menu=usuario" target="bodega">Nuevo Usuario</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="Controlador?menu=listausuario" target="bodega">Lista Usuario</a>   
                                    </div>
                                </div>
                            </li>
                        </c:if>
                    </ul>
                </div>
                <div class="dropdown dropleft float-right">
                    <button style="border: none" class="dropdown-toggle btn btn-outline-light" type="button" id="dropdownbutton" data-toggle="dropdown">${usuario.getNombre()} ${usuario.getApellido()}</button>
                    <div class="dropdown-menu" aria-labelledby="dropdownbutton">
                        <a class="dropdown-item" href="#">${usuario.getNombre_usuario()}</a>
                        <a class="dropdown-item" href="#">${usuario.getDescripcion_perfil()}</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="salir" class="dropdown-item">Salir</button>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
        <div class="container">
            <div class="m-4" style="height: 700px; width: 1000px;">
                <iframe name="bodega" style="height: 100%; width: 100%; border: none;"></iframe>
            </div>
        </div>
    </body>
</html>
