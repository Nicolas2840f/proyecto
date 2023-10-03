<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="jspf/head.jsp" %>
    <title>Computadores Registrados</title>
    <link rel="icon" href="Imagenes/4449619.png">
    <link rel="stylesheet" href="css/styles1.css">
</head>
<jsp:useBean id="unComputador" scope="request" class="Modelo.Computador" />
<jsp:useBean id="unaPersona" scope="request" class="Modelo.Persona" />
<body>
    <div class="header col-s-12 col-12">
        <img class="imagen1" src="Imagenes/Logo-3-04.png" alt="Sena">
    </div>
    <div class="container">
        <h1 class="titulo">Computadores Registrados</h1>
        <table class="table table-striped table-bordered tabla">
            <thead>
                <tr>
                    <th>Marca</th>
                    <th>Color</th>
                    <th>Complemento</th>
                    <th>Dueño</th>
                    <th>Opcion</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${unComputador.listar()}" var="computador">
                    <tr>
                        <form action="ControladorComputador" method="post">
                            <td><input type="hidden" name="fIdComputador" value="${computador.idComputador}">
                                <input type="text" name="fMarcaComputador" value="${computador.marcaComputador}"></td>
                            <td><input type="text" name="fColorComputador" value="${computador.colorComputador}"></td>
                            <td><input type="text" name="fComplementoComputador" value="${computador.complementoComputador}"></td>
                            <td>
                                <select name="fIdPersona">
                                    <c:forEach items="${unaPersona.listar()}" var="persona">
                                        <option value="${persona.idPersona}" <c:if test="${persona.idPersona == computador.idPersona}">selected</c:if>>${persona.nombrePersona}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <button type="submit" class="Regresar" name="fEnviar" value="Modificar">Modificar</button>
                                <button type="submit" class="Regresar" name="fEnviar" value="Eliminar">Eliminar</button>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="ControladorLogin" method="get">
            <div class="boton">
                <button type="submit" class="Regresar">Regresar al inicio</button>
            </div>
        </form>
    </div>
</body>
</html>
