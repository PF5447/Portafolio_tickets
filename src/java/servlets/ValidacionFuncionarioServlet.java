/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import controller.GrupoController;
import controller.PerfilController;
import controller.TurnoController;
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
import model.Funcionario;

/**
 *
 * @author Invitado
 */
public class ValidacionFuncionarioServlet extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            GrupoController gru = new GrupoController();
            PerfilController perfiles = new PerfilController();
            TurnoController turnos = new TurnoController();
            FuncionarioController fun = new FuncionarioController();
            String rut = request.getParameter("rut_administrador");
            boolean validacion = fun.validarFuncionario(rut);
            
            
            if (validacion) {
                
                Funcionario funcionario = fun.retornarFuncionario(rut);
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


out.println("				<form action='./ServletEliminarFuncionario' method='POST' >");
out.println("				<p>Rut</p>");
String run = funcionario.getRut();
out.println("				<input type='text' name='rut_administrador_eliminar' value='"+run+"' readonly>");


out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Nombre</p>");
out.println("				<input type='text' name='nombre_administrador' value='"+funcionario.getNombre()+"' disabled>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Perfil</p>");
out.println("				<select>");
out.print("<option>"+funcionario.getPerfil_Id_Perfil()+"</option>"); 
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Turno</p>");
out.println("				<select>");
out.print("<option>"+funcionario.getTurnos_Id_Turnos()+"</option>"); 
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Sexo</p>");
out.println("				<select>");
out.print("<option>"+funcionario.getSexo()+"</option>"); 
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Correo</p>");
out.println("				<input type='email' value='"+funcionario.getCorreo()+"' disabled>");
out.println("			</div>");

out.println("			<div class='form-group'>");
out.println("				<p>Serie para colacion (id funcionario)</p>");
out.println("				<input type='text' name='nombre_administrador' value='"+funcionario.getIdFuncionario()+"' disabled >");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				'");
out.println("		<a href='./ModificacionServletUsuario'>Modificar usuario</a>");
out.println("				<input class='btn btn-danger' type='submit' name='boton_guardar' value='Eliminar'>");
out.println("			</div>");
out.println("		</div>");
out.println("				</form>");
out.println("		<hr>");







out.println("		<h2>Gestion de Usuario</h2>");
out.println("		<p class='text-muted'>Solo para creación de administradores y cajeros</p>");
out.println("		<hr>");
out.println("		<div class='container'>");
out.println("				<form action='./ServletSumarUsuario' method='POST' >");

out.println("			<div class='form-group'>");
out.println("				<p>Id funcionario</p>");
out.println("				<input type='text' name='ID_administrador_user'>");
out.println("				<input type='button' name='boton_verificacion' value='Verificar Funcionario'>");
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
                
                
                
            }
            else{
            
            
                
                
                
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


out.println("				<form action='./AgregarFuncionarioServlet' method='POST' >");
out.println("				<p>Rut</p>");
out.println("				<input type='text' name='rut_administrador' placeholder='Funcionario no enrolado' >");
out.println("			</div>");

out.println("			<div class='form-group'>");
out.println("				<p>Nombre</p>");
out.println("				<input type='text' name='nombre_administrador'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Perfil</p>");
out.println("				<select name='perfil_administrador'>");
for (String perfil: perfiles.traerTurnos()) {out.println("<option>"+perfil+"</option>");      }
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Turno</p>");
out.println("				<select name='turno_administrador'>");
for(String turno : turnos.traerTurnos()){out.println("<option>"+turno+"</option>");}
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Sexo</p>");
out.println("				<select name=sexo_administrador>");
out.println("					<option>Masculino</option>");
out.println("					<option>Femenino</option>");
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Correo</p>");
out.println("				<input type='email' name='email_administrador'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Serie para colacion (id funcionario)</p>");
out.println("				<input type='text' name='id_administrador'>");
out.println("			</div>");
out.println("			<div class='form-group'>");

out.println("				<input class='btn btn-primary' type='submit' name='boton_guardar' value='Guardar'>");
out.println("			</div>");
out.println("				</form>");
out.println("		</div>");
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidacionFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
