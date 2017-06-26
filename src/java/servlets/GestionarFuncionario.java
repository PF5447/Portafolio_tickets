/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.FuncionarioController;
import controller.PerfilController;
import controller.TurnoController;
import controller.Validador;
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
public class GestionarFuncionario extends HttpServlet {

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
            throws ServletException, IOException, UnsupportedEncodingException {
        
            String rut = request.getParameter("rut");
            rut = rut.replace(".","");
            System.out.println(rut);
            Validador valida_rut = new Validador();
            FuncionarioController controlador_funcionario = new FuncionarioController();
        
            try (PrintWriter out = response.getWriter()) {
                
                
                if (valida_rut.ValidarRut(rut)) {
                    
                    /* TODO output your page here. You may use following sample code. */
                    if(controlador_funcionario.validarFuncionario(rut)){
                       
                        Funcionario  funcionario = controlador_funcionario.retornarFuncionario(rut);
                        out.println("<p>Gestion de Funcionrio</p>");
                        out.println("			<p>Rut</p>");
                        out.println("                   <input type='text' id='rut_administrador' value='"+rut+"' readonly>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Nombre</p>");
                        out.println("				<input type='text' id='nombre_administrador' value='"+funcionario.getNombre()+"'>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Perfil</p>");
                        out.println("				<select id='perfil_administrador' >");
                        out.println("<option>"+funcionario.getPerfil_Id_Perfil()+"</option>");      
                        out.println("				</select>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Turno</p>");
                        out.println("				<select id='turno_administrador'>");
                        out.println("<option>"+funcionario.getTurnos_Id_Turnos()+"</option>");
                        out.println("				</select>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Sexo</p>");
                        out.println("				<select id=sexo_administrador>");
                        out.println("					<option>"+funcionario.getSexo()+"</option>");
                        out.println("				</select>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Correo</p>");
                        out.println("				<input type='email' id='email_administrador' value='"+funcionario.getCorreo()+"'>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Serie para colacion (Huella Digital)</p>");
                        out.println("				<input type='text' id='id_administrador'value='"+funcionario.getIdFuncionario()+"'>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<input class='btn btn-danger' type='button' id='boton_eliminar' value='Eliminar'>");
                        out.println("				<input class='btn btn-warning' type='button' id='boton_guardar' value='Modificar'>");                                        
                        out.println("			</div>");
                        
                        out.println("			<script type='text/javascript'>");
                        out.println(" $(document).ready(function() {			");
                        out.println("$('#boton_eliminar').click(function() {			");
                        out.println("			var rutVar = $('#rut_administrador').val();");
                        out.println("			var nombreVar = $('#nombre_administrador').val();");
                        out.println("			var perfilVar = $('#perfil_administrador').val();");
                        out.println("			var turnoVar = $('#turno_administrador').val();");
                        out.println("			var sexoVar = $('#sexo_administrador').val();");
                        out.println("			var emailVar = $('#email_administrador').val();");
                        out.println("			var idVar = $('#id_administrador').val();");
                        
                        //Comienza if para validar entradas
                        out.println("			if (rutVar===\"\" || nombreVar===\"\" || perfilVar===\"\" || turnoVar===\"\" || sexoVar===\"\" || emailVar===\"\" || idVar===\"\" ) {");
                        out.println("			");
                        out.println("			alert(\"Campo Vacio, error! \");");
                        out.println("			 return false;");
                        out.println("			 }");
                        out.println("			");
                        out.println("			");
                        out.println("			");
    //termina if
                        out.println("			 $.get('ServletEliminarFuncionario', {");
                        out.println("			 rut : rutVar,");
                        out.println("			 nombre: nombreVar,");
                        out.println("			 perfil : perfilVar,");
                        out.println("			 turno : turnoVar,");
                        out.println("			 sexo : sexoVar,");
                        out.println("			 email : emailVar,");
                        out.println("			 id : idVar");
                        out.println("			}, function(responseText) {");
                        out.println("			       if(responseText===\"eliminado\"){alert('Funcionario eliminado exitosamente'); location.reload();}else{alert('Funcionario no eliminado');}                        ");
                        out.println("			});");
                        out.println("			});");
                        out.println("			});");
                        out.println("			</script>");

                        out.println("		</div>");
                        
                    }else {
                        out.print("error");
                        
                    }
                    //  out.println("<h1>Servlet FuncionarioServlet soy el servlet " + request.getContextPath() + "</h1>");

                }else{
                    
                    out.print("formato_error");
                }
                
        
        
        
    }   catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    }
}
