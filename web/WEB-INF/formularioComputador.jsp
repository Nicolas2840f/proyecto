

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="jspf/head.jsp" %>
        <title>Computadores</title>
        <link rel="icon" href="Imagenes/4449619.png">
        <link rel="stylesheet" href="css/styles4.css">
    </head>
    <jsp:useBean id="unaPersona" scope="request" class="Modelo.Persona" />
    <body>
        <div class="encabezado1">
            <div class="titulo1">
                <h1 style="padding-left:20%;">REGISTRO DE COMPUTADOR</h1>
            </div>
            <div class="cajaboton">
                <form action="ControladorLogin" method="GET">
                    <button class="boton2" type="submit"> Volver al inicio</button>
                </form>
            </div>
        </div>
        <div class="container">

            <div class="formulario">
                <div class="encabezado">
                    <div class="texto">
                        <p><b>Instrucciones de Registro:</b>
                        </p>
                        <ul>
                            <h5>Siga cada una de las instrucciones para hacer un correcto registro de su pc y así poder
                                generar el código qr:</h5>
                            <li>Ingrese la marca de su pc </li>
                            <li>Seleccione el color de su pc </li>
                        </ul>
                    </div>
                </div>
                <form id="fIngresarComputador" action="ControladorComputador" method="post" class="needs-validation" novalidate>
                    <label>MARCA</label>
                    <br>
                    <input type="hidden" name="fIdComputador" value="0">
                    <input id="validationCustom01" type="text" class="numerocc" name="fMarcaComputador" required>
                    <div class="invalid-feedback">
                        Por favor seleccione una Marca del portátil.
                    </div>
                    <div>
                        <label>COLOR</label>
                        <br>
                        <select id="validationCustom02" class="identificacion" name="fColorComputador">
                            <option>Negro</option>
                            <option>Blanco</option>
                            <option>Gris</option>
                            <option>Azul Oscuro</option>
                            <option>Rojo Oscuro</option>
                            <option>Otro</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione el color del portátil.
                        </div>
                    </div>
                    <div>
                        <label>COMPLEMENTO</label>
                        <br>
                        <input id="validationCustom03" type="text" class="numerocc" name="fComplementoComputador">
                    </div>
                    <div>
                        <label>DUEÑO</label>
                        <br>
                        <select id="validationCustom04" class="identificacion" name="fIdPersona">
                                <c:forEach items="${unaPersona.listar()}" var="laPersona">
                                    <option value="${laPersona.idPersona}">${laPersona.nombrePersona}</option>
                                </c:forEach>
                        </select>
                        <div class="invalid-feedback">
                            Por favor seleccione el dueño del Portátil.
                        </div>
                    </div>
                    <br>
                    <button type="submit" class="boton1" name="fEnviar" value="Insertar">
                        Registrar Pc
                    </button>
                </form>
            </div>
        </div>
        <script>
            (() => {
                'use strict'

                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                const forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.from(forms).forEach(form => {
                    form.addEventListener('submit', event => {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        } else {
                            alert("Computador Ingresado con éxito");
                        }

                        form.classList.add('was-validated');

                    }, false)
                })
            })()
        </script>
    </body>

</html>
