
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Recepcion" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="jspf/head.jsp" %>
        <link rel="icon" href="Imagenes/5472736.png">
        <link rel="stylesheet" href="css/styles1.css">
        <title>Estadísticas de Ingreso</title>
    </head>
    <jsp:useBean id="unaRecepcion" scope="request" class="Modelo.Recepcion" />
    <jsp:useBean id="unComputador" scope="request" class="Modelo.Computador" />
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
            <h1 style="width: 100%">Tabla de Ingreso</h1>
            <br>
            <table class="table table-striped table-bordered tabla">
                <tr>
                    <th> Fecha</th>
                    <th> Documento Celador</th>
                    <th> Nombre Celador</th>
                    <th> Hora de Ingreso</th>
                    <th style="width: 14%"> Computador</th>
                    <th> Hora de Salida</th>
                    <th style="width: 15%"> Opción</th>
                </tr>
                <%
                    ArrayList<Recepcion> listaRecepcion = unaRecepcion.listar();
                    boolean registrosExistentes = !listaRecepcion.isEmpty();
                %>
                <% 
                    if(registrosExistentes){
                %>

                <c:forEach items="${unaRecepcion.listar()}" var="registro">
                    <tr>
                    <form id="fModificarAprendices" action="ControladorRecepcion" method="post">
                        <td><input type="hidden" name="fIdRecepcion" value="${registro.idRecepcion}">
                            <input type="date" name="fFechaRecepcion" value="${registro.fechaRecepcion}">
                        </td>
                        <td>
                            <input type="number" name="fDocumento" value="${registro.documentoCelador}">
                        </td>
                        <td>
                            <input type="text" name="fNombre" value="${registro.nombreCelador}">
                        </td>
                        <td>
                            <input type="time" name="fHoraEntrada" value="${registro.horaEntrada}">
                        </td>
                        <td>
                            <select name="fIdComputador">
                                <c:forEach items="${unComputador.listar()}" var="computador">
                                    <c:forEach items="${unaPersona.listar()}" var="persona">
                                        <c:if test="${computador.idPersona == persona.idPersona}">
                                            <option value="${computador.idComputador}"<c:if test="${computador.idComputador == registro.idComputador}">selected</c:if>>${computador.marcaComputador} - ${persona.nombrePersona}</option>
                                        </c:if>
                                    </c:forEach>
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
                    <form id="fIngresarAprendiz" action="ControladorRecepcion" method="post">
                        <td><input type="hidden" name="fIdRecepcion" value="0">
                            <input type="date" name="fFechaRecepcion">
                        </td>
                        <td>
                            <input type="number" name="fDocumento">
                        </td>
                        <td>
                            <input type="text" name="fNombre">
                        </td>
                        <td>
                            <input type="time" name="fHoraEntrada">
                        </td>
                        <td>
                            <select name="fIdComputador">
                                <c:forEach items="${unComputador.listar()}" var="computador">
                                    <c:forEach items="${unaPersona.listar()}" var="persona">
                                        <c:if test="${persona.idPersona == computador.idPersona}">
                                            <option value="${computador.idComputador}">${computador.marcaComputador} - ${persona.nombrePersona}</option>
                                        </c:if>
                                    </c:forEach>
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