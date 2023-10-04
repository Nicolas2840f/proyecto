<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="jspf/head.jsp" %>
        <title>Objetos Sena</title>
        <link rel="icon" href="Imagenes/1280118.png">
        <link rel="stylesheet" href="css/styles4.css">
    </head>
    <body>
        <div class="encabezado1">
            <div class="titulo1">
                <h1 style="padding-left:10%">REGISTRO DE OBJETO</h1>
            </div>
            <div class="cajaboton">
                <form action="ControladorLogin" method="GET">
                    <button type="submit" class="boton2"> Volver al inicio</button>
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
                            <h5>Siga cada una de las instrucciones para hacer un correcto registro del objeto de almacén:
                            </h5>
                            <li>Ingrese el nombre del objeto </li>
                            <li>Escriba una descripción corta del objeto </li>
                        </ul>
                    </div>
                </div>
                <form id="fIngresarObjeto" action="ControladorObjeto" method="post" class="needs-validation" novalidate>
                    <div>
                        <label>Descripcion</label>
                        <br>
                        <input type="hidden" name="fIdObjeto" value="0">
                        <input id="validationCustom01" type="text" class="numerocc" name="fDescripcionObjeto" required>
                        <div class="invalid-feedback">
                            Por favor seleccione una Descripción para el Objeto.
                        </div>
                    </div>
                    <div>
                        <label>Cantidad</label>
                        <br>
                        <input id="validationCustom02" type="text" class="numerocc" name="fCantidadObjeto" required>
                        <div class="invalid-feedback">
                            Por favor seleccione una Cantidad.
                        </div>
                    </div>
                    <br>
                    <button id="botonInsertar" type="submit" class="boton1" name="fEnviar" value="Insertar">
                        Registrar Objeto
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
                        }
                        form.classList.add('was-validated');
                        
                    }, false)
                })
            })()
        </script>
    </body>

</html>
