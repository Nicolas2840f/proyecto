/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Recepcion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author ncast
 */
@WebServlet(name = "ControladorRecepcion", urlPatterns = {"/ControladorRecepcion"})
public class ControladorRecepcion extends HttpServlet {

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
            out.println("<title>Servlet ControladorAlmacen</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAlmacen at " + request.getContextPath() + "</h1>");
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("fIdRecepcion");
        String fecha = request.getParameter("fFechaRecepcion");
        String documentoCelador = request.getParameter("fDocumento");
        String nombreCelador = request.getParameter("fNombre");
        String horaEntrada = request.getParameter("fHoraEntrada");
        String idComputador = request.getParameter("fIdComputador");
        String horaSalida = request.getParameter("fHoraSalida");
        String accion = request.getParameter("fEnviar");

        int idRecepcion = 0;
        try {
            idRecepcion = Integer.parseInt(id);
        } catch (NumberFormatException ex) {

        }

        LocalDate fechaRecepcion = LocalDate.now();
        try {
            fechaRecepcion = LocalDate.parse(fecha);
        } catch (DateTimeParseException dt) {

        }

        LocalTime horaEntradaRecepcion = LocalTime.now();
        try {
            horaEntradaRecepcion = LocalTime.parse(horaEntrada);
        } catch (DateTimeParseException ex) {

        }

        int idComputadores = 0;
        try {
            idComputadores = Integer.parseInt(idComputador);
        } catch (NumberFormatException ex) {

        }

        LocalTime horaSalidaRecepcion = LocalTime.now();
        try {
            horaSalidaRecepcion = LocalTime.parse(horaSalida);
        } catch (DateTimeParseException ex) {

        }

        Recepcion unaRecepcion = new Recepcion();
        unaRecepcion.setIdRecepcion(idRecepcion);
        unaRecepcion.setFechaRecepcion(fechaRecepcion);
        unaRecepcion.setDocumentoCelador(documentoCelador);
        unaRecepcion.setNombreCelador(nombreCelador);
        unaRecepcion.setHoraEntrada(horaEntradaRecepcion);
        unaRecepcion.setIdComputador(idComputadores);
        unaRecepcion.setHoraSalida(horaSalidaRecepcion);

        System.out.println(unaRecepcion.getIdComputador());
        String mensaje = "";
        switch (accion) {
            case "Ingresar":
                unaRecepcion.insertar();
                mensaje = "Registro insertado correctamente";
                request.getRequestDispatcher("/WEB-INF/Recepcion.jsp?msj=" + mensaje).forward(request, response);
                break;
            case "Modificar":
                unaRecepcion.modificar();
                mensaje = "Registro modificado correctamente";
                request.getRequestDispatcher("/WEB-INF/Recepcion.jsp?msj=" + mensaje).forward(request, response);
                break;
            case "Eliminar":
                unaRecepcion.eliminar();
                mensaje = "Registro eliminado correctamente";
                request.getRequestDispatcher("/WEB-INF/Recepcion.jsp?msj=" + mensaje).forward(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
