/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ncast
 */
@WebServlet(name = "ControladorPersona", urlPatterns = {"/ControladorPersona"})
public class ControladorPersona extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorPersona</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPersona at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("fIdPersona");
        String tipoDocumento = request.getParameter("fTipoDocumento");
        String documento = request.getParameter("fDocumento");
        String nombre = request.getParameter("fNombre");
        String telefono = request.getParameter("fTelefono");
        String correo = request.getParameter("fCorreo");
        String contraseña = request.getParameter("fPassword");
        String contraseñaCon = request.getParameter("fConfirmacionPassword");
        String accion = request.getParameter("fEnviar");

        int idPersona = 0;
        try {
            idPersona = Integer.parseInt(id);
        } catch (NumberFormatException ex) {

        }
        Persona unaPersona = new Persona();
        unaPersona.setIdPersona(idPersona);
        unaPersona.setTipoDocumento(tipoDocumento);
        unaPersona.setDocumentoPersona(documento);
        unaPersona.setNombrePersona(nombre);
        unaPersona.setTelefonoPersona(telefono);
        unaPersona.setCorreoPersona(correo);
        unaPersona.setContraseñaPersona(contraseña);

        String mensaje = "";
        String respuesta = "";
        switch (accion) {
            case "Registrar":
                if (contraseña.equals(contraseñaCon)) {
                    boolean correoValido = !unaPersona.validarCorreo();
                    boolean documentoValido = !unaPersona.validarDocumento();
                    if (correoValido) {
                        if (documentoValido) {
                            unaPersona.insertar();
                            mensaje = "Persona insertada con éxito";
                            request.setAttribute("sessionClose", mensaje);
                            request.getRequestDispatcher("index.jsp?msj=" + mensaje).forward(request, response);
                        } else {
                            mensaje = "El documento registrado ya está en uso";
                            request.setAttribute("error", mensaje);
                            request.getRequestDispatcher("ControladorMenu?opcion=Registrar").forward(request, response);
                        }

                    } else {
                        mensaje = "El correo registrado ya está en uso";
                        request.setAttribute("error", mensaje);
                        request.getRequestDispatcher("ControladorMenu?opcion=Registrar").forward(request, response);
                    }

                } else {
                    mensaje = "Las contraseñas no coinciden";
                    request.setAttribute("error", mensaje);
                    request.getRequestDispatcher("ControladorMenu?opcion=Registrar").forward(request, response);
                }
                break;

            case "Modificar":
                unaPersona.modificar();
                mensaje = "Persona modificada con éxito";
                break;
            case "Eliminar":
                unaPersona.eliminar();
                mensaje = "Persona eliminada con éxito";
                break;
            case "ValidarDocumento":
                respuesta = String.valueOf(unaPersona.validarDocumento());
                response.setContentType("text/plain");
                response.getWriter().write(respuesta);
                break;
            case "ValidarCorreo":
                respuesta = String.valueOf(unaPersona.validarCorreo());
                response.setContentType("text/plain");
                response.getWriter().write(respuesta);
                System.out.println(respuesta);
                break;
            default:
                System.out.println("No entro a ningun case");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
