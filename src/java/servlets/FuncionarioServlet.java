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
        String id_fun = request.getParameter("rut");
        System.out.println(id_fun);
        PerfilController perfiles = new  PerfilController();
        TurnoController turnos = new TurnoController();
        
        FuncionarioController controlador_funcionario = new FuncionarioController();
        
        try (PrintWriter out = response.getWriter()) {
            try {
                /* TODO output your page here. You may use following sample code. */
                if(controlador_funcionario.validarFuncionario(id_fun)){
                    out.println("<p>El funcionario ya se encuentra enrolado</p>");
                }else if(id_fun.equals("")){
                    out.println("<p>No ha ingresado un rut valido.</p>");
                }
                else {
                    out.println("<p>El funcionario no está enrolado, puede crear uno en el siguiente formulario</p>");
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

                }
                //  out.println("<h1>Servlet FuncionarioServlet soy el servlet " + request.getContextPath() + "</h1>");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {
        
            String id_fun = request.getParameter("rut");
            FuncionarioController controlador_funcionario = new FuncionarioController();
            
            try {
            processRequest(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            

            
            if(controlador_funcionario.validarFuncionario(id_fun)){
                out.println("<p>El funcionario está</p>");
            }           
            else {
                out.println("<p>El funcionario no está</p>");
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
        processRequest(request, response);
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
