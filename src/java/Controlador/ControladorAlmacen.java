/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Almacen;
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
@WebServlet(name = "ControladorAlmacen", urlPatterns = {"/ControladorAlmacen"})
public class ControladorAlmacen extends HttpServlet {

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

        String id = request.getParameter("fIdAlmacen");
        String fecha = request.getParameter("fFechaAlmacen");
        String documentoEncargado = request.getParameter("fDocumento");
        String nombreEncargado = request.getParameter("fNombre");
        String horaEntrada = request.getParameter("fHoraEntrada");
        String idObjeto = request.getParameter("fIdObjeto");
        String idPersona = request.getParameter("fIdPersona");
        String horaSalida = request.getParameter("fHoraSalida");
        String accion = request.getParameter("fEnviar");

        int idAlmacen = 0;
        try {
            idAlmacen = Integer.parseInt(id);
        } catch (NumberFormatException ex) {

        }

        LocalDate fechaAlmacen = LocalDate.now();
        try {
            fechaAlmacen = LocalDate.parse(fecha);
        } catch (DateTimeParseException dt) {

        }

        LocalTime horaEntradaAlmacen = LocalTime.now();
        try {
            horaEntradaAlmacen = LocalTime.parse(horaEntrada);
        } catch (DateTimeParseException ex) {

        }

        int idObjetos = 0;
        try {
            idObjetos = Integer.parseInt(idObjeto);
        } catch (NumberFormatException ex) {

        }
        int idPersonas = 0;
        try {
            idPersonas = Integer.parseInt(idPersona);
        } catch (NumberFormatException ex) {

        }

        LocalTime horaSalidaAlmacen = LocalTime.now();
        try {
            horaSalidaAlmacen = LocalTime.parse(horaSalida);
        } catch (DateTimeParseException ex) {

        }

        Almacen unAlmacen = new Almacen();
        unAlmacen.setIdAlmacen(idAlmacen);
        unAlmacen.setFechaAlmacen(fechaAlmacen);
        unAlmacen.setDocumentoEncargado(documentoEncargado);
        unAlmacen.setNombreEncargado(nombreEncargado);
        unAlmacen.setHoraEntrada(horaEntradaAlmacen);
        unAlmacen.setIdObjeto(idObjetos);
        unAlmacen.setIdPersona(idPersonas);
        unAlmacen.setHoraSalida(horaSalidaAlmacen);

        String mensaje = "";
        switch (accion) {
            case "Ingresar":
                unAlmacen.insertar();
                mensaje = "Registro insertado correctamente";
                request.getRequestDispatcher("WEB-INF/Almacen.jsp?msj=" + mensaje).forward(request, response);
                break;
            case "Modificar":
                unAlmacen.modificar();
                mensaje = "Registro modificado correctamente";
                request.getRequestDispatcher("WEB-INF/Almacen.jsp?msj=" + mensaje).forward(request, response);
                break;
            case "Eliminar":
                unAlmacen.eliminar();
                mensaje = "Registro eliminado correctamente";
                request.getRequestDispatcher("WEB-INF/Almacen.jsp?msj=" + mensaje).forward(request, response);
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
