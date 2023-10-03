
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="jspf/head.jsp" %>
        <title>Registrar Usuario</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="shortcut icon" href="Imagenes/3201052.png" type="image/x-icon">
    </head>
    <body>
        <div class="container-sm container2">
            <div class="caja-grande">
                <div>
                    <% if(request.getAttribute("error") != null){ %>
                    <div class="alert alert-danger">
                        <%= request.getAttribute("error") %>
                    </div>
                    <% }%>
                </div>
                <div class="titulo">
                    <h1 class="h1">REGISTRO DE USUARIOS</h1>
                </div>
                <form id="formulario-login" action="ControladorPersona" method="post" class="row g-3">
                    <div class="caja-mediana"> 
                        <div class="cajitas1">
                            <input type="hidden" name="fIdPersona" value="0">
                            <select name="fTipoDocumento" class="cajitas2" required>
                                <option selected disabled value="">Seleccione el tipo de Documento</option>
                                <option value="Cedula de Ciudadania">Cédula de Ciudadanía</option>
                                <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                                <option value="Cédula de Extranjería">Cédula de Extranjería</option>
                            </select>
                        </div>
                        <div class="cajitas1">
                            <input onkeyup="validarDocumento()"   class="cajitas2" id="fDocumento" name="fDocumento" type="number" placeholder="Número de documento" required>
                            <div id="cajaValidarD" class="cajaInvalida"></div>
                        </div>
                        <div class="cajitas1">
                            <input id="validationCustom01" class="cajitas2" name="fNombre" type="text" placeholder="Nombre Completo" required>
                        </div>
                        <div class="cajitas1">
                            <input id="validationCustom02" class="cajitas2" name="fTelefono" type="number" placeholder="Telefono" required>
                        </div>
                        <div class="cajitas1">
                            <input onkeyup="validarCorreo()" class="cajitas2" id="fCorreo" name="fCorreo" type="email" placeholder="Correo"  required>
                            <div id="cajaValidarC" class="cajaInvalida"></div>
                        </div>
                        <div class="cajitas1">
                            <input id="password" class="form-control cajitas2" name="fPassword" type="password" placeholder="Contraseña" required >
                        </div>
                        <div class="cajitas1">
                            <input id="password-confirmation" class="form-control cajitas2" name="fConfirmacionPassword" type="password"  placeholder="Confirmación Contraseña" required>
                            <div id="mensaje"></div>
                            <script>
                                let password = document.getElementById("password");
                                let passwordConfirmation = document.getElementById("password-confirmation");
                                let mensaje = document.getElementById("mensaje");
                                passwordConfirmation.addEventListener("keyup", () => {
                                    if (password.value == passwordConfirmation.value) {
                                        mensaje.innerHTML = "Las contraseñas coinciden";
                                        mensaje.style.color = "#00dc06";
                                    } else {
                                        mensaje.innerHTML = "Las contraseñas no coinciden";
                                        mensaje.style.color = "#b50000";
                                    }
                                });
                            </script>
                        </div>
                        <div class="botton-login">
                            <button class="btn-login btn" type="submit" name="fEnviar" value="Registrar">Registrarme</button>
                        </div>
                        <div class="volverLogin">
                            <div class="inicio">
                                <a href="index.jsp">Iniciar Sesión</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="js/registro.js"></script>
    </body>
</html>
