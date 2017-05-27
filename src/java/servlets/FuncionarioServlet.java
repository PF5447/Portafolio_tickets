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
public class FuncionarioServlet extends HttpServlet {

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
            PerfilController perfiles = new  PerfilController();
            TurnoController turnos = new TurnoController();
            Validador valida_rut = new Validador();
            FuncionarioController controlador_funcionario = new FuncionarioController();
            try (PrintWriter out = response.getWriter()) {
                
                
                if (valida_rut.ValidarRut(rut)) {
                    
                    /* TODO output your page here. You may use following sample code. */
                    if(controlador_funcionario.validarFuncionario(rut)){
                        out.print("rut_existe");
                    }else {
                        out.println("<p>El funcionario no esta enrolado, puede crear uno en el siguiente formulario</p>");
                        
                        out.println("				<p>Rut</p>");
                        out.println("				<input type='text' id='rut_administrador' value='"+rut+"' readonly>");
                        out.println("			</div>");
                        out.println("			<div class='form-group'>");
                        out.println("				<p>Nombre</p>");
                        out.println("				<input type='text' id='nombre_administrador'>");
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
                        out.println("				<input class='btn btn-primary' type='submit' id='boton_guardar' value='Guardar'>");
                        out.println("			</div>");
                        
                        out.println("			<script type='text/javascript'>");
                        out.println(" $(document).ready(function() {			");
                        out.println("$('#boton_guardar').click(function(event) {			");
                        out.println("			var rutVar = $('#rut_administrador').val();");
                        /*
                        *Felipe tienes que seguir llenando el formulario para ingresar un funcionario
                        *
                        *
                        */
                        
                        
                        out.println("			var passVar = $('#PASS_usuario').val();");
                        out.println("			var pass2Var = $('#PASS2_usuario').val();");
                        out.println("			var recuperaVar = $('#CODE_recuperar').val();");
                        out.println("			var grupoVar = $('#SELECT_grupo').val();");
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
                        out.println("			 $.get('ServletSumarUsuario', {");
                        out.println("			 user : userVar,");
                        out.println("			 pass : passVar,");
                        out.println("			 recuperar : recuperaVar,");
                        out.println("			 grupo : grupoVar,");
                        out.println("			 id_funcionario : idFuncionarioVar");
                        out.println("			}, function(responseText) {");
                        out.println("			       if(responseText===\"true\"){alert('Usuario agregado exitosamente');}else{alert('Usuario no agregado, Funcionario ya Tiene Usuario!');}                        ");
                        out.println("			                               ");
                        out.println("			                               ");
                        out.println("			                               ");
                        out.println("			});");
                        out.println("			");
                        out.println("			});");
                        out.println("			});");
                        out.println("			</script>");

                        out.println("		</div>");
                        
                    }
                    //  out.println("<h1>Servlet FuncionarioServlet soy el servlet " + request.getContextPath() + "</h1>");

                }else{
                    
                    out.print("formato_error");
                }
                
                
                
                
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
