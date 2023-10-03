/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

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
@WebServlet(name = "ControladorMenu", urlPatterns = {"/ControladorMenu"})
public class ControladorMenu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        switch (opcion) {
            case "Registrar":
                request.getRequestDispatcher("WEB-INF/registroUser.jsp").forward(request, response);
                break;
            case "Computador":
                request.getRequestDispatcher("WEB-INF/formularioComputador.jsp").forward(request, response);
                break;
            case "Computadores":
                request.getRequestDispatcher("WEB-INF/Computadores.jsp").forward(request, response);
                break;
            case "Recepcion":
                request.getRequestDispatcher("WEB-INF/Recepcion.jsp").forward(request, response);
                break;
            case "Almacen":
                request.getRequestDispatcher("WEB-INF/Almacen.jsp").forward(request, response);
                break;
            case "Objeto":
                request.getRequestDispatcher("WEB-INF/formularioObjeto.jsp").forward(request, response);
                break;
            case "Objetos":
                request.getRequestDispatcher("WEB-INF/Objetos.jsp").forward(request, response);
                break;
                
            default:
                throw new AssertionError();
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
        processRequest(request, response);
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
