/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Objeto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Sena
 */
@WebServlet(name = "ControladorObjeto", urlPatterns = {"/ControladorObjeto"})
public class ControladorObjeto extends HttpServlet {

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
            out.println("<title>Servlet ControladorObjeto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorObjeto at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("fIdObjeto");
        String descripcion = request.getParameter("fDescripcionObjeto");
        String cantidadObjeto = request.getParameter("fCantidadObjeto");
        String accion = request.getParameter("fEnviar");

        int idObjeto = 0;
        try {
            idObjeto = Integer.parseInt(id);
        } catch (NumberFormatException ex) {

        }

        Objeto elObjeto = new Objeto();
        elObjeto.setIdObjeto(idObjeto);
        elObjeto.setDescripcionObjeto(descripcion);
        elObjeto.setCantidadObjeto(cantidadObjeto);

        String mensaje = "";
        switch (accion) {
            case "Insertar":
                elObjeto.insertar();
                mensaje = "Objeto insertado Correctamente";
                request.setAttribute("msj", mensaje);
                request.getRequestDispatcher("WEB-INF/Objetos.jsp").forward(request, response);
                break;
            case "Modificar":
                elObjeto.modificar();
                mensaje = "Objeto modificado Correctamente";
                request.setAttribute("msj", mensaje);
                request.getRequestDispatcher("WEB-INF/Objetos.jsp").forward(request, response);
                break;
            case "Eliminar":
                elObjeto.eliminar();
                mensaje = "Objeto eliminado Correctamente";
                request.setAttribute("msj", mensaje);
                request.getRequestDispatcher("WEB-INF/Objetos.jsp").forward(request, response);
                break;
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
