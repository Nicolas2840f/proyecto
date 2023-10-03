<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="WEB-INF/jspf/head.jsp" %>
        <title>Login</title>
        <script defer src="js/login.js"></script>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="shortcut icon" href="Imagenes/acceso_318-164354.avif" type="image/x-icon">
    </head>
    <body>
        <div class="container-sm container2">
            <div class="caja-grande">
                <div id="mensaje1">
                    <% if (request.getAttribute("errorIngreso") != null) { %>
                    <div class="alert alert-danger">
                        <strong>Error:</strong> <%= request.getAttribute("errorIngreso") %>
                    </div>
                    <% } %>
                </div>
                <div id="mensaje1">
                    <% if (request.getAttribute("sessionClose") != null) { %>
                    <div class="alert alert-success">
                        <%= request.getAttribute("sessionClose") %>
                    </div>
                    <% } %>
                </div>
                <div class="imagen">
                    <img class="imagen-login img-fluid" src="Imagenes/585e4be1cb11b227491c3398.png" alt="Img User">
                </div>
                <form id="formulario-login" action="ControladorLogin" method="post">
                    <div class="caja-mediana"> 
                        <div id="mensaje"></div>
                        <select id="validationCustom04" name="fTipoDocumento" class="form-select cajitas" aria-label="Default select example">
                            <option selected disabled>Seleccione el tipo de Documento</option>
                            <option value="Cedula de Ciudadania">Cédula de Ciudadanía</option>
                            <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                            <option value="Cédula de Extranjería">Cédula de Extranjería</option>
                        </select>  
                        <input id="documento-login" class="form-control cajitas" name="fDocumento" type="number" placeholder="Número de documento" required>
                        <input id="contraseña-login" class="form-control cajitas" name="fPassword" type="password"  placeholder="Contraseña" required>
                        <div class="registrar">
                            <div class="mb-4 form-check boton-checked">
                                <input name="recorder" type="checkbox" class="checkbox form-check-" id="exampleCheck1">
                                <label class="form-check-label recorder" for="exampleCheck1"  id="recorder">Recuerdáme</label>
                            </div>
                            <div class=" mb-4 registro">
                                <a href="ControladorMenu?opcion=Registrar">Registrese!</a>
                            </div>
                        </div>
                        <div class="botton-login">
                            <button class="btn-login btn" type="submit" name="fEnviar" value="Ingresar">LOGIN</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>