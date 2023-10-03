<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="jspf/head.jsp"%>
        <link rel="icon" href="Imagenes/153629.png">
        <link rel="stylesheet" href="css/estilos1.css">
        <title>Ingreso de User</title>
    </head>

    <body>
        <div class="Encabezado">
            <div class="nombreUser">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person"
                     viewBox="0 0 12 20">
                <path
                    d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z" />
                </svg>
                <h2>${sessionScope.Nombre}</h2>
            </div>
            <nav class="lista">
                <ul>
                    <li><a href="#">
                            <p>Información</p></a></li>
                    <li><a href="#">
                            <p>Bandeja de Tareas</p>
                        </a></li>
                    <li><a href="#">
                            <p>LMS SENA</p>
                        </a></li>
                    <li>
                        <form action="ControladorLogin" method="post">
                            <button type="submit" name="fEnviar" value="Regresar">Salir</button>
                        </form>
                    </li>
                </ul>
            </nav>
        </div>
        <%@include file="jspf/cuerpo.jsp" %>
    </body>

</html>
