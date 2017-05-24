/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bcn
 */
@WebServlet(name = "AdministracionAvanzada", urlPatterns = {"/AdministracionAvanzada"})
public class AdministracionAvanzadaServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<meta charset='utf-8'>");
out.println("<script type='text/javascript' src=''></script>");
out.println("<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0' >");
out.println("<link href='css/bootstrap.min.css' rel='stylesheet'>");
out.println("<title>Ticket Pro</title>");
out.println("</head>");
out.println("<body>");
out.println("<div class='container'>");
out.println("<div id=titulo>");
out.println("<h1>Administracion Avanzada</h1>");
out.println("		<a href='./LoginServlet'>Volver</a>");
out.println("	</div>");
out.println("		<hr>");
out.println("		<h2>Gestion de Perfiles</h2>");
out.println("		<div class='container'>");
out.println("			<div class='form-group'>");
out.println("				<p>Id Perfil</p>");
out.println("				<input type='text' name='rut_administrador'>");
out.println("				<input type='button' name='boton_verificacion_perfil' value='Verificar Disponibilidad'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Nombre Perfil</p>");
out.println("				<input type='text' name='nombre_administrador_perfil'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				");
out.println("				<input class='btn btn-primary' type='button' name='boton_administracion_avanzada_crear_perfil' value='Guardar'>");
out.println("				<input class='btn btn-warning' type='button' name='boton_administracion_avanzada_modificar_perfil' value='Modificar'>");
out.println("				<input class='btn btn-danger' type='button' name='boton_administracion_avanzada_eliminar_perfil' value='Eliminar'>");
out.println("			</div>");
out.println("		</div>");
out.println("		<hr>");
out.println("		<h2>Gestion de Turnos</h2>");
out.println("		<hr>");
out.println("		<div class='container'>");
out.println("			<div class='form-group'>");
out.println("				<p>Id turno</p>");
out.println("				<input type='text' name='id_administrador_turno'>");
out.println("				<input type='button' name='boton_verificacion' value='Verificar Turno'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Nombre Turno</p>");
out.println("				<input type='text' name='nombre_administrador_turno'>");
out.println("			</div>");
out.println("			<p class='text-muted'>Para ingresar el Tiempo en un correcto formato debe usar Google Chrome.</p>");
out.println("			<div class='form-group'>");
out.println("				<p>Hora inicio</p>");
out.println("				<input type='time' name='time_administrador_turno_inicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Hora fin</p>");
out.println("				<input type='time' name='time_administrador_turno_fin'>");
out.println("			</div>");
out.println("			<div class='containter'>");
out.println("			<input class='btn btn-primary' type='button' name='boton_administracion_crear_turnos' value='Crear Turno'>");
out.println("			<input class='btn btn-warning' type='button' name='boton_administracion_modificar_turnos' value='Modificar Turno'>");
out.println("			<input class='btn btn-danger' type='button' name='boton_administracion_eliminar_turnos' value='Eliminar Turno'>");
out.println("			</div>");
out.println("			<hr>");
out.println("		</div>");
out.println("		<h2>Gestion de Servicios</h2>");
out.println("		<hr>");
out.println("		<div class='container'>");
out.println("			<div class='form-group'>");
out.println("				<p>Id Servicio</p>");
out.println("				<input type='text' name='id_servicio'>");
out.println("				<input type='button' name='boton_verificacion' value='Verificar Funcionario'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Nombre Servicio</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<p class='text-muted'>Para ingresar el Tiempo en un correcto formato debe usar Google Chrome.</p>");
out.println("			<div class='form-group'>");
out.println("				<p>Hora inicio</p>");
out.println("				<input type='time' name='time_administrador_servicio_inicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Hora fin</p>");
out.println("				<input type='time' name='time_administrador_servicio_fin'>");
out.println("			</div>");
out.println("			<div class='containter'>");
out.println("			<input class='btn btn-primary' type='button' name='boton_administracion_crear_servicio' value='Crear Servicio'>");
out.println("			<input class='btn btn-warning' type='button' name='boton_administracion_modificar_servicio' value='Modificar Servicio'>");
out.println("			<input class='btn btn-danger' type='button' name='boton_administracion_eliminar_servicio' value='Eliminar Servicio'>");
out.println("			</div>");
out.println("			<hr>");
out.println("		</div>");
out.println("		<h2>Gestion de Tickets</h2>");
out.println("		<hr>");
out.println("		<div class='container'>");
out.println("			<div class='form-group'>");
out.println("				<p>Generar tickets</p>");
out.println("				<input type='number' name='qty_tickets' placeholder='Ingrese Cantidad'>");
out.println("				<input type='button' name='boton_verificacion' value='Generar Tickets'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Asignar Vale</p>");
out.println("				<p class='text-muted'>Ingresar id de Funcionario</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Creado por:</p>");
out.println("				<p class='text-muted'>Traer dato desde la sesion(id funcionario)</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<p>Estado</p>");
out.println("			<div class='form-group'>");
out.println("				<select name='select_administrador_estado_user'>");
out.println("					<option>Cobrado</option>");
out.println("					<option>Sin cobrar</option>");
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Bloqueado por:</p>");
out.println("				<p class='text-muted'>Id de quien hizo el bloqueo</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Fecha de Bloqueo:</p>");
out.println("				<p class='text-muted'>Trae la Fecha de bloqueo, ojo bloqueo</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Detalles de Bloqueo:</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<p>Tipo Ticket</p>");
out.println("				<select class='form-group' name='select_administrador_estado_user'>");
out.println("					<option>Normal</option>");
out.println("					<option>Especial Visitas</option>");
out.println("					<option>Adicional</option>");
out.println("				</select>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Detalles de Especiales:</p>");
out.println("				<p class='text-muted'>Solo si se emitira un vale especial</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Detalles de Adicional:</p>");
out.println("				<p class='text-muted'>Solo si se emitira un vale Adicional</p>");
out.println("				<input type='text' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<div class='form-group'>");
out.println("				<p>Valor de tickets:</p>");
out.println("				<input type='numbrer' name='nombre_servicio'>");
out.println("			</div>");
out.println("			<input class='btn btn-primary' type='button' name='boton_administracion_crear_servicio' value='Crear Servicio'>");
out.println("			<input class='btn btn-warning' type='button' name='boton_administracion_modificar_servicio' value='Modificar Servicio'>");
out.println("			<input class='btn btn-danger' type='button' name='boton_administracion_eliminar_servicio' value='Eliminar Servicio'>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
