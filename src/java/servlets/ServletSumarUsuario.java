/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import controller.MailController;
import controller.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author bcn
 */
public class ServletSumarUsuario extends HttpServlet {

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
            
            
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String recuperar = request.getParameter("recuperar");
            String grupo = request.getParameter("grupo");
            String funcionario_id_funcionario = request.getParameter("id_funcionario");
            String estado = request.getParameter("estado");
            UserController usr = new UserController();
            FuncionarioController fun_con = new FuncionarioController();
            Funcionario fun = fun_con.retornarFuncionarioID(funcionario_id_funcionario);
            
            
            
            
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                
                if (usr.agregarUser( funcionario_id_funcionario,user, pass, recuperar, grupo, funcionario_id_funcionario,estado)) {
                    
                    
                        MailController mail = new MailController();
                        mail.setUsername("f.inostrozam@alumnos.duoc.cl");
                        mail.setPassWord("elodia.....");
                        mail.setTo(fun.getCorreo());
                        mail.setSubject("Recuperacion de Contraseña Ticket pro");
                        mail.setMessage("Estimado, guarde este mensaje que es para recuperar su contraseña de usuario \n Contraseña de Recuperación :  "+recuperar);
                        mail.SendMail();
                        out.print("true");
                        
                        
                    
                }else{
                    out.print("false");
                    
                }
                
                
                
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ServletSumarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletSumarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
