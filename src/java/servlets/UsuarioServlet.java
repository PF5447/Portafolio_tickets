/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import controller.GrupoController;
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
public class UsuarioServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String idFuncionario = request.getParameter("rut");
        FuncionarioController fun = new FuncionarioController();
        GrupoController gru = new GrupoController();
        
        
        
        try (PrintWriter out = response.getWriter()) {
           
            if (fun.validarFuncionario(idFuncionario)) {
                
                out.print("<p>Funcionario existente, puede crear usuario</p>");
                out.println("		<h2>Gestion de Usuario</h2>");
                out.println("		<p class='text-muted'>Solo para creación de administradores y cajeros</p>");
                out.println("		<hr>");
                out.println("		<div class='container'>");
                out.println("				<form action='./ServletSumarUsuario' method='POST' >");
                out.println("			<div class='form-group'>");
                out.println("				<p>Id Usuario</p>");
                out.println("				<input type='text' name='ID_administrador_user'>");              
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>User</p>");
                out.println("				<input type='text' name='USER_administrador'>");
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>Contraseña</p>");
                out.println("				<input type='password' name='PASS_administrador_usuario'>");
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>Repita contraseña</p>");
                out.println("				<input type='password' name='PASSv2_administrador_usuario'>");
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>Codigo Salt</p>");
                out.println("				<input type='password' name='pass_administrador_salt'>");
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>Grupo</p>");
                out.println("				<select name='grupo_id_user'>");
                for (String perfil: gru.traerGrupos()) {out.println("<option>"+perfil+"</option>");      }
                out.println("				</select>");
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>ID Funcionario</p>");
                out.println("				<input type='password' name='id_funcionario_launch'>");
                out.println("			</div>");
                out.println("			<div class='form-group'>");
                out.println("				<p>Estado</p>");
                out.println("				<p class='text-muted'>Al momento de bloquear un usuario deshabilita al funcionario</p>");
                out.println("				<select name='select_administrador_estado_user'>");
                out.println("					<option>Bloqueado</option>");
                out.println("					<option>Desbloqueado</option>");
                out.println("				</select>");
                out.println("			</div>");
                out.println("			<input class='btn btn-danger' type='submit' name='boton_administracion_agregar_user' value='Agregar Usuario'>");
                out.println("			<hr>");
                out.println("				</form>");
                out.println("		</div>");
                out.println("	</div>");
                out.println("	<script src='js/jquery.js'></script>");
                out.println("	<script src='js/bootstrap.min.js'></script>");
                out.println("</body>");
                out.println("<footer>");
                out.println("</footer>");
                out.println("</html>"); 

            }else{
            
                out.print("<p>Funcionario no existe, primero debe enrolarse.</p>");
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
