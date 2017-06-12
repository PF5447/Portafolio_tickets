/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import controller.Ticket_Controller;
import controller.UserController;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.Usuario;

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
            
            String id = request.getParameter("serie");
            FuncionarioController fun_con = new FuncionarioController();                    
            Funcionario funcionario = fun_con.retornarFuncionarioID(id);
            Ticket_Controller ti_con = new Ticket_Controller();
            
            try {
                response.setContentType("text/html;charset=UTF-8");
                
                try (PrintWriter out = response.getWriter()) {                
                    
                    if (ti_con.actualizarTicket(id)) {
                        
                        out.println("<p> Funcionario : "+funcionario.getNombre()+"</p>");
                        out.println("<p> Rut         : "+funcionario.getRut()+"</p>");
                        out.println("<p> Gracias por Preferir Ticket Pro! Buen Provecho.</p>");
                        
                        
                        
                        
                        
                        
                    }else{
                    
                        out.print("false");
                    }
                    
                    
                }            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TotemServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TotemServlet.class.getName()).log(Level.SEVERE, null, ex);
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
