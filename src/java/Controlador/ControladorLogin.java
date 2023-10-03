package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author ncast
 */
@WebServlet(urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession miSession = request.getSession();
        if (miSession.getAttribute("Rol") != null) {
            if (miSession.getAttribute("Rol").equals("Usuario")) {
                request.getRequestDispatcher("WEB-INF/vistaPrincipal3.jsp").forward(request, response);
            } else if (miSession.getAttribute("Rol").equals("Celador")) {
                request.getRequestDispatcher("WEB-INF/vistaPrincipal.jsp").forward(request, response);
            } else if (miSession.getAttribute("Rol").equals("Encargado")) {
                request.getRequestDispatcher("WEB-INF/vistaPrincipal2.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipoDocumento = request.getParameter("fTipoDocumento");
        String documento = request.getParameter("fDocumento");
        String contraseña = request.getParameter("fPassword");
        String accion = request.getParameter("fEnviar");

        Persona unaPersona = new Persona();
        unaPersona.setTipoDocumento(tipoDocumento);
        unaPersona.setDocumentoPersona(documento);
        unaPersona.setContraseñaPersona(contraseña);

        String mensaje = "";
        switch (accion) {
            case "Ingresar":
                boolean verificado = unaPersona.verificar();
                if (verificado) {

                    HttpSession miSession = request.getSession();
                    miSession.setAttribute("Nombre", unaPersona.getNombrePersona());
                    miSession.setAttribute("Documento", unaPersona.getDocumentoPersona());
                    miSession.setAttribute("Telefono", unaPersona.getTelefonoPersona());
                    miSession.setAttribute("Correo", unaPersona.getCorreoPersona());
                    miSession.setAttribute("Rol", unaPersona.getRolPersona());

                    mensaje = "Ingresado Correctamente";
                    if (unaPersona.getRolPersona().equals("Usuario")) {
                        System.out.println("Entraste como user");
                        request.getRequestDispatcher("WEB-INF/vistaPrincipal3.jsp?msj=" + mensaje).forward(request, response);
                    } else if (unaPersona.getRolPersona().equals("Celador")) {
                        System.out.println("Entraste como celador");
                        request.getRequestDispatcher("WEB-INF/vistaPrincipal.jsp?msj=" + mensaje).forward(request, response);
                    } else if (unaPersona.getRolPersona().equals("Encargado")) {
                        System.out.println("Entraste como encargado");
                        request.getRequestDispatcher("WEB-INF/vistaPrincipal2.jsp?msj=" + mensaje).forward(request, response);

                    }

                } else {
                    mensaje = "Credenciales Incorrectas";
                    request.setAttribute("errorIngreso", mensaje);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        break;

    

case "Regresar":
                HttpSession miSession = request.getSession();
                miSession.invalidate();
                
                mensaje = "Sesión cerrada correctamente";
                request.setAttribute("sessionClose", mensaje);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
