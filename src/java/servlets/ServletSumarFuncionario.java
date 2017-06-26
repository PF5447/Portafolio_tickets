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
 * @author bcn
 */
public class ServletSumarFuncionario extends HttpServlet {

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
            String rut = request.getParameter("rut");
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("email");
            String sexo = request.getParameter("sexo");
            String idFuncionario = request.getParameter("id");
            String turnos_Id_Turno = request.getParameter("turno");
            String perfil_Id_Perfil = request.getParameter("perfil");
            
            FuncionarioController fun_con = new FuncionarioController();
            
            PrintWriter out = response.getWriter();
            
            
            if (fun_con.agregarFuncionario(rut, nombre, correo, sexo, idFuncionario, turnos_Id_Turno, perfil_Id_Perfil)) {
                out.print("agregado");
                
            }else{
                out.print("false");
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletSumarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
