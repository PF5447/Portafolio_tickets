/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Invitado
 */
public class AgregarFuncionarioServlet extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, ClassNotFoundException, UnsupportedEncodingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String rut = request.getParameter("rut_administrador");
            String nombre = request.getParameter("nombre_administrador");
            String correo = request.getParameter("email_administrador");
            String sexo = request.getParameter("sexo_administrador");
            String id_funcionario = request.getParameter("id_administrador");
            String turnos_id_turnos = request.getParameter("turno_administrador");
            String perfil_id_perfil = request.getParameter("perfil_administrador");
            
            FuncionarioController fun = new FuncionarioController();
            
            
            if (fun.agregarFuncionario(rut, nombre, correo, sexo, id_funcionario, turnos_id_turnos, perfil_id_perfil)) {
                           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarFuncionarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarFuncionarioServlet at " + "Proceso Exitoso!" + "</h1>");
            out.println("</body>");
            out.println("</html>"); 
            }else{
            
                        out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarFuncionarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarFuncionarioServlet at " + "Proceso Fallido!" + "</h1>");
            out.println("</body>");
            out.println("</html>"); 
            
            }
            
            /* TODO output your page here. You may use following sample code. */

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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
