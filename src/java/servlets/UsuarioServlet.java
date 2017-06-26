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
import model.Funcionario;

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
            
            response.setContentType("text/html;charset=UTF-8");
            
            String rut = request.getParameter("rut");
            FuncionarioController fun_con = new FuncionarioController();
            GrupoController gru = new GrupoController();
            Funcionario fun = fun_con.retornarFuncionario(rut);
            
            
            
            try (PrintWriter out = response.getWriter()) {
                
                if (fun_con.validarFuncionario(rut)) {
                    
                    
                    out.println("		<p class='text-muted'>Solo para creación de administradores y cajeros</p>");
                    out.println("		<hr>");
                    out.println("		<div class='container'>");
                    
                    out.println("			<div class='form-group'>");
                    out.println("				<p>Rut funcionario</p>");
                    out.println("				<input type='text' id='ID_administrador_user' value='"+rut+"' readonly >");
                    out.println("			</div>");
                    out.println("			<div class='form-group'>");
                    out.println("				<p>User</p>");
                    out.println("				<input type='text' id='USER_administrador'>");
                    out.println("			</div>");
                    out.println("			<div class='form-group'>");
                    out.println("				<p>Contraseña</p>");
                    out.println("				<input type='password' id='PASS_usuario'>");
                    out.println("			</div>");
                    
                   
                    
                    out.println("			<div class='form-group'>");
                    out.println("				<p>Repita contraseña</p>");
                    out.println("				<input type='password' id='PASS2_usuario'>");
                    out.println("			</div>");
                   
                     out.println("			<div class='form-group'>");
                    out.println("				<p>Codigo de recuperación de contraseña</p>");
                    out.println("				<input type='text' id='CODE_recuperar'>");
                    out.println("			</div>");
                    
                    
                    out.println("			<div class='form-group'>");
                    out.println("				<p>Grupo</p>");
                    out.println("				<select id='SELECT_grupo'>");
                    for (String perfil: gru.traerGrupos()) {out.println("<option>"+perfil+"</option>");      }
                    out.println("				</select>");
                    out.println("			</div>");
                    
                    out.println("			<div class='form-group'>");
                    out.println("				<p>Estado</p>");
                    out.println("				<select id='SELECT_estado'>");
                    out.println("<option>ACTIVO</option>");
                    out.println("<option>INACTIVO</option>");
                    out.println("				</select>");
                    out.println("			</div>");
                    
                    out.println("			<div class='form-group'>");
                    out.println("				<p>ID Funcionario este codigo es usado para cobrar colacion</p>");
                    out.println("				<input type='text' id='id_funcionario' value='"+fun.getIdFuncionario()+"' readonly>");
                    out.println("			</div>");
                    out.println("			<div class='form-group'>");
                    
                    out.println("			</div>");
                    
                    out.println("			<input class='btn btn-success' type='button' id='boton_administracion_agregar_user' value='Agregar Usuario'>");
                    out.println("			<img src='img/ajax-loader.gif' id='cargando' >");
                    
                    //Seccion de script que debe enviar datos a servlet para agregar nuevo user por jquery
                    out.println("			<script type='text/javascript'>");
                    out.println(" $(document).ready(function() {	$('#cargando').hide();		");
                    out.println("$('#boton_administracion_agregar_user').click(function(event) {			");
                    out.println("			var userVar = $('#USER_administrador').val();");
                    out.println("			var passVar = $('#PASS_usuario').val();");
                    out.println("			var pass2Var = $('#PASS2_usuario').val();");
                    out.println("			var recuperaVar = $('#CODE_recuperar').val();");
                    out.println("			var grupoVar = $('#SELECT_grupo').val();");
                    out.println("			var estado = $('#SELECT_estado').val();");
                    out.println("			var idFuncionarioVar = $('#id_funcionario').val();");
                    
                    //Comienza if para validar entradas
                    out.println("			if (userVar===\"\" || passVar===\"\" || pass2Var===\"\" || recuperaVar===\"\" ) {");
                    out.println("			");
                    out.println("			alert(\"Campo Vacio, error! \");");
                    out.println("			 return false;");
                    out.println("			 }else if(passVar!==pass2Var){");
                    out.println("			alert(\"Contraseñas no coinciden, error! \");");
                    out.println("			return false;}");
                    out.println("			");
//termina if        
                    out.println("			$('#cargando').show();");
                    out.println("			 $.get('ServletSumarUsuario', {");
                    out.println("			 user : userVar,");
                    out.println("			 pass : passVar,");
                    out.println("			 recuperar : recuperaVar,");
                    out.println("			 grupo : grupoVar,");
                    out.println("			 id_funcionario : idFuncionarioVar");
                    out.println("			}, function(responseText) {");
                    out.println("			       if(responseText===\"true\"){alert('Usuario agregado exitosamente'); $('#cargando').hide(); }else{alert('Usuario no agregado, Funcionario ya Tiene Usuario!'); $('#cargando').hide();}                        ");
                    out.println("			                               ");
                    out.println("			                               ");
                    out.println("			                               ");
                    out.println("			});");
                    out.println("			");
                    out.println("			});");
                    out.println("			});");
                    out.println("			</script>");
                    
                    out.println("			<hr>");
                    
                    out.println("		</div>");
                    out.println("	</div>");
                    out.println("	<script src='js/jquery.js'></script>");
                    out.println("	<script src='js/bootstrap.min.js'></script>");
                    out.println("</body>");
                    out.println("<footer>");
                    out.println("</footer>");
                    out.println("</html>");
                    
                }else{
                    
                    out.print("false");
                }
                
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
