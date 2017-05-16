/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bcn
 */
public class TotemServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("	<meta charset='utf-8'>");
out.println("	<script type='text/javascript' src=''></script>");
out.println("	<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0' >");
out.println("	<link href='css/bootstrap.min.css' rel='stylesheet'>");
out.println("	<title>Ticket Pro</title>");
out.println("</head>");
out.println("<body>");
out.println("	<div class='container'>");
out.println("	<div id=titulo>");
out.println("		<h1>Totem Mode</h1>");
out.println("		<hr>");
out.println("	</div>");
out.println("		<div class='form-group'>");
out.println("			Identificador<br>");
out.println("			<input type='text' name='Identificador'>");
out.println("		</div>");
out.println("		<hr>");
out.println("		<a href='redirect.jsp'>Modo administrador</a>");
out.println("	</div>");
out.println("	<script src='js/jquery.js'></script>");
out.println("	<script src='js/bootstrap.min.js'></script>");
out.println("</body>");
out.println("<footer>");
out.println("</footer>");
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
