
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="jspf/head.jsp" %>
        <title>Registrar Usuario</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="shortcut icon" href="Imagenes/3201052.png" type="image/x-icon">
        <script src="js/registro.js" defer></script>
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
                <form id="formulario-registrar" action="ControladorPersona" method="post" class="row g-3">
                    <div class="caja-mediana"> 
                        <div class="cajitas1">
                            <input type="hidden" name="fIdPersona" value="0">
                            <select name="fTipoDocumento" class="cajitas2" id="fTipoDocumento">
                                <option selected disabled value="">Seleccione el tipo de Documento</option>
                                <option value="Cedula de Ciudadania">Cédula de Ciudadanía</option>
                                <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                                <option value="Cédula de Extranjería">Cédula de Extranjería</option>
                            </select>
                            <div id="mensajedoc" class="cajaInvalida"></div>
                        </div>

                        <div class="cajitas1">
                            <input onkeyup="validarDocumento()"   class="cajitas2" id="fDocumento" name="fDocumento" type="number" placeholder="Número de documento">
                            <div id="cajaValidarD" class="cajaInvalida"></div>
                        </div>
                        <div class="cajitas1">
                            <input id="validationCustom01" class="cajitas2" name="fNombre" type="text" placeholder="Nombre Completo">
                            <div id="cajaValidarN" class="cajaInvalida"></div>
                        </div>
                        <div class="cajitas1">
                            <input id="validationCustom02" class="cajitas2" name="fTelefono" type="number" placeholder="Telefono">
                            <div id="cajaValidarT" class="cajaInvalida"></div>
                        </div>
                        <div class="cajitas1">
                            <input onkeyup="validarCorreo()" class="cajitas2" id="fCorreo" name="fCorreo" type="email" placeholder="Correo">
                            <div id="cajaValidarC" class="cajaInvalida"></div>
                        </div>
                        <div class="cajitas1">
                            <input id="password" class="form-control cajitas2" name="fPassword" type="password" placeholder="Contraseña">
                        </div>
                        <div class="cajitas1">
                            <input id="password-confirmation" class="form-control cajitas2" name="fConfirmacionPassword" type="password"  placeholder="Confirmación Contraseña">
                            <div id="mensaje"></div>
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
    </body>
</html>
