/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import controller.PerfilController;
import controller.TurnoController;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author Invitado
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, NoSuchAlgorithmException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            

            
            PerfilController perfiles = new PerfilController();
            TurnoController turnos = new TurnoController();
            
            
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
out.println("		<h1>Portal de Administración</h1>");
out.println("		<a href='./TotemServlet'>Activar Modo Totem</a>");
out.println("		<br>");
out.println("		<a href='./AdministracionAvanzadaServlet'>Administracion Avanzada</a>");
out.println("	</div>");
out.println("		<hr>");
out.println("		<h2>Gestion de funcionarios</h2>");
out.println("		<div class='container'>");
out.println("			<div class='form-group'>");


out.println("				<form action='./ValidacionFuncionarioServlet' method='POST' >");
out.println("				<p>Rut</p>");
out.println("				<input type='text' name='rut_administrador'>");
out.println("				<input type='submit' name='boton_verificacion' value='Verificar Disponibilidad'>");
out.println("				</form>");

out.println("		<hr>");
out.println("		<h2>Gestion de Usuario</h2>");
out.println("		<p class='text-muted'>Solo para creación de administradores y cajeros</p>");
out.println("		<hr>");
out.println("		<div class='container'>");
out.println("			<div class='form-group'>");
out.println("				<p>Id funcionario</p>");
out.println("				<input type='text' name='rut_administrador_user'>");
out.println("				<input type='button' name='boton_verificacion' value='Verificar Funcionario'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>User</p>");
out.println("				<input type='text' name='rut_administrador'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Contraseña</p>");
out.println("				<input type='password' name='nombre_administrador_usuario'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Repita contraseña</p>");
out.println("				<input type='password' name='pass_administrador_usuario'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Codigo Salt</p>");
out.println("				<input type='password' name='pass_administrador_usuario'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Estado</p>");
out.println("				<p class='text-muted'>Al momento de bloquear un usuario deshabilita al funcionario</p>");
out.println("				<select name='select_administrador_estado_user'>");
out.println("					<option>Bloqueado</option>");
out.println("					<option>Desbloqueado</option>");
out.println("				</select>");
out.println("			</div>");
out.println("			<input class='btn btn-primary' type='button' name='boton_administracion_crear_user' value='Crear Usuario'>");
out.println("			<input class='btn btn-warning' type='button' name='boton_administracion_modificar_user' value='Modificar Usuario'>");
out.println("			<input class='btn btn-danger' type='button' name='boton_administracion_eliminar_user' value='Eliminar Usuario'>");
out.println("			<hr>");
out.println("		</div>");
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
