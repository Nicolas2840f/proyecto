/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Computador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Sena
 */
@WebServlet(name = "ControladorComputador", urlPatterns = {"/ControladorComputador"})
public class ControladorComputador extends HttpServlet {

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
            out.println("<title>Servlet ControladorComputador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorComputador at " + request.getContextPath() + "</h1>");
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

        String id = request.getParameter("fIdComputador");
        String marca = request.getParameter("fMarcaComputador");
        String color = request.getParameter("fColorComputador");
        String complemento = request.getParameter("fComplementoComputador");
        String idPer = request.getParameter("fIdPersona");
        String accion = request.getParameter("fEnviar");

        int idComputador = 0;
        try {
            idComputador = Integer.parseInt(id);
        } catch (NumberFormatException ex) {

        }

        int idPersona = 0;
        try {
            idPersona = Integer.parseInt(idPer);
        } catch (NumberFormatException ex) {

        }

        Computador unComputador = new Computador();
        unComputador.setIdComputador(idComputador);
        unComputador.setMarcaComputador(marca);
        unComputador.setColorComputador(color);
        unComputador.setComplementoComputador(complemento);
        unComputador.setIdPersona(idPersona);
        
        String mensaje = "";
        switch (accion) {
            case "Insertar":
                unComputador.insertar();
                mensaje = "Insertado correctamente";
                request.getRequestDispatcher("WEB-INF/Computadores.jsp?msj=" + mensaje).forward(request, response);
                break;
            case "Eliminar":
                unComputador.eliminar();
                mensaje = "Eliminado correctamente";
                request.getRequestDispatcher("WEB-INF/Computadores.jsp?msj=" + mensaje).forward(request, response);
                break;
            case "Modificar":
                unComputador.modificar();
                mensaje = "Modificado correctamente";
                request.getRequestDispatcher("WEB-INF/Computadores.jsp?msj=" + mensaje).forward(request, response);
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
