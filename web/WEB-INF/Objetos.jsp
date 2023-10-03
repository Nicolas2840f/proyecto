<%-- 
    Document   : Objetos
    Created on : 21/09/2023, 7:31:41 a. m.
    Author     : ncast
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="jspf/head.jsp" %>
        <title>Tabla de Objetos</title>
        <link rel="icon" href="Imagenes/1280118.png">
        <link rel="stylesheet" href="css/styles1.css">
    </head>
    <jsp:useBean id="unObjeto" scope="request" class="Modelo.Objeto" />
    <body>
        <div class="header col-s-12 col-12">
            <img class="imagen1" src="Imagenes/Logo-3-04.png" alt="Sena">
        </div>
        <div class="container">
            <h1 class="titulo">Objetos Registrados</h1>
            <table class="table table-striped table-bordered tabla">
                <thead>
                    <tr>
                        <th>Descripcion</th>
                        <th>Cantidad</th>
                        <th>Opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${unObjeto.listar()}" var="objeto">
                        <tr>
                    <form action="ControladorObjeto" method="post">
                        
                        <td><input type="hidden" name="fIdObjeto" value="${objeto.idObjeto}">
                        <input type="text" name="fDescripcionObjeto" value="${objeto.descripcionObjeto}"></td>
                        <td><input type="text" name="fCantidadObjeto" value="${objeto.cantidadObjeto}"></td>
                        <td><button type="submit" class="Regresar" name="fEnviar" value="Modificar">Modificar</button>
                            <button type="submit" class="Regresar" name="fEnviar" value="Eliminar">Eliminar</button>
                        </td>

                    </form>
                    </tr>
                    </tbody>


                </c:forEach>
            </table>
            <div class="boton">
                <form action="ControladorLogin" method="GET">
                    <button type="submit" class="Regresar"> Regresar al
                        inicio</button>
                </form>
            </div>
        </div>
    </body>

</html>