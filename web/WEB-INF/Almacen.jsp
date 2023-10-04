
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Almacen" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="jspf/head.jsp" %>
        <title>Estadísticas del Almacén</title>
        <link rel="icon" href="Imagenes/702455.png">
        <link rel="stylesheet" href="css/styles1.css">
    </head>
    <jsp:useBean id="unAlmacen" scope="request" class="Modelo.Almacen" />
    <jsp:useBean id="unObjeto" scope="request" class="Modelo.Objeto" />
    <jsp:useBean id="unaPersona" scope="request" class="Modelo.Persona" />
    <body>
        <div>
            <% if(request.getAttribute("msj") != null){ %>
            <div class="alert alert-warning">
                <%=request.getAttribute("msj")%>
            </div>
            <%}%>
        </div>
        <div class="header col-s-12 col-12">
            <img class="imagen1" src="Imagenes/Logo-3-04.png" alt="Sena">
        </div>
        <div class="contenedor">
            <h1 style="width: 100%">Tabla de Almacén</h1>
            <br>
            <table class="table table-striped table-bordered tabla">
                <tr>
                    <th> Fecha</th>
                    <th> Documento Encargado</th>
                    <th> Nombre Encargado</th>
                    <th> Hora de Entrada</th>
                    <th style="width: 14%"> Objeto de Almacén</th>
                    <th style="width: 14%"> Persona solicitante</th>
                    <th> Hora de Salida</th>
                    <th style="width: 15%"> Opción</th>
                </tr>
                <%
                    ArrayList<Almacen> listaAlmacen = unAlmacen.listar();
                    boolean registrosExistentes = !listaAlmacen.isEmpty();
                %>
                <% 
                    if(registrosExistentes){
                %>

                <c:forEach items="${unAlmacen.listar()}" var="registro">
                    <tr>
                    <form id="fModificarAlmacen" action="ControladorAlmacen" method="post">
                        <td><input type="hidden" name="fIdAlmacen" value="${registro.idAlmacen}">
                            <input type="date" name="fFechaAlmacen" value="${registro.fechaAlmacen}">
                        </td>
                        <td>
                            <input type="number" name="fDocumento" style="width: 80%" value="${registro.documentoEncargado}">
                        </td>
                        <td>
                            <input type="text" name="fNombre" style="width: 90%" value="${registro.nombreEncargado}">
                        </td>
                        <td>
                            <input type="time" name="fHoraEntrada" value="${registro.horaEntrada}">
                        </td>
                        <td>
                            <select name="fIdObjeto" id="fElObjeto">
                                <c:forEach items="${unObjeto.listar()}" var="objeto">
                                    <option value="${objeto.idObjeto}" <c:if test="${objeto.idObjeto == registro.idObjeto}">selected</c:if>>${objeto.descripcionObjeto}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="fIdPersona" id="fLaPersona">
                                <c:forEach items="${unaPersona.listar()}" var="persona">
                                    <option value="${persona.idPersona}"<c:if test="${persona.idPersona == registro.idPersona}">selected</c:if> >${persona.nombrePersona}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="time" name="fHoraSalida" value="${registro.horaSalida}">
                        </td>
                        <td>
                            <button class="Regresar" type="submit" name="fEnviar" value="Modificar">Modificar</button>
                            <button class="Regresar" type="submit" name="fEnviar" value="Eliminar">Eliminar</button>
                        </td>
                    </form>
                    </tr>
                </c:forEach>
                <%
                    }
                %>
                <c:if test="${!registrosExistentes}">
                    <tr>
                    <form id="fIngresarAlmacen" action="ControladorAlmacen" method="post">
                        <td><input type="hidden" name="fIdAlmacen" value="0">
                            <input type="date" name="fFechaAlmacen">
                        </td>
                        <td>
                            <input type="number" name="fDocumento" style="width: 80%">
                        </td>
                        <td>
                            <input type="text" name="fNombre" style="width: 90%">
                        </td>
                        <td>
                            <input type="time" name="fHoraEntrada">
                        </td>
                        <td>
                            <select name="fIdObjeto" id="fElObjeto">
                                <c:forEach items="${unObjeto.listar()}" var="objeto">
                                    <option value="${objeto.idObjeto}">${objeto.descripcionObjeto}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="fIdPersona" id="fLaPersona">
                                <c:forEach items="${unaPersona.listar()}" var="persona">
                                    <option value="${persona.idPersona}">${persona.nombrePersona}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="time" name="fHoraSalida">
                        </td>
                        <td>
                            <button class="Regresar" type="submit" name="fEnviar" value="Ingresar">Ingresar</button>
                            <button class="Regresar" type="reset" name="fEnviar" value="Limpiar">Limpiar</button>
                        </td>
                    </form>
                    </tr>
                </c:if>
            </table>
        </div>
        <div class="boton">
            <form action="ControladorLogin" method="GET">
                <button type="submit" class="Regresar"> Regresar al inicio</button>
            </form>
        </div>
    </body>

</html>
