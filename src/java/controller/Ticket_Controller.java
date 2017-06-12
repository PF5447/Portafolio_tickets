/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionDB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import model.Ticket;

/**
 *
 * @author Invitado
 */
public class Ticket_Controller {
    
    public boolean agregarTicket(String id_ticket,String status
    ,String block_by,String created_by,String status_1,String block_datails,String tipo,String sepacial_details,String aditional_details,int valor,String funcionario_id_funcionario) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
   

        ConnectionDB conexion = new ConnectionDB();
        boolean validador = false;
  
        
                     
        try {
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            String query = "insert into TICKET VALUES('"+id_ticket+"','SYSDATE','SYSDATE','"+status+"','"+block_by+"','"+created_by+"','"+status_1+"','SYSDATE','"+block_datails+"','"+tipo+ "','"+sepacial_details+"','"+aditional_details+"',"+valor+",'"+funcionario_id_funcionario+"')";
            System.out.println(query);
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                validador = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            validador = true;
            ex.printStackTrace();
            
        }
        
        
        
        return validador;
    }

    public boolean agregarTicket(String idFuncionario) throws IOException {
       
        boolean validador = false;
        
        try {
            
            
            ConnectionDB conexion = new ConnectionDB();
            
            //se genera una serie en base a la fecha y hora actuales
            LocalDateTime serie = LocalDateTime.now().plusHours(1);
            
            //variable encargada de los rangos de horarios.
            LocalTime now = LocalTime.now().plusHours(1);
            
            String id_ticket = serie.toString().replace(".","").replace("-","").replace(":","").replace("T","");
            String status = "Emitido";
            String status_1 = "No Canjeado";
            FuncionarioController fun_con = new FuncionarioController();
            Funcionario funcionario = fun_con.retornarFuncionarioID(idFuncionario);
            String block_by = funcionario.getRut();
            String created_by = funcionario.getNombre();
            String block_datails = "Bloqueo por emision rutinaria";
            String tipo="";
            String hora_fin = "";
            
            
            //Rangos de horarios para las minutas.
            if (now.isAfter(LocalTime.of(8, 0, 0)) && now.isBefore(LocalTime.of(10, 0, 0))) {
                tipo = "Desayuno";
                hora_fin = "10:00:00";
            }else if (now.isAfter(LocalTime.of(12, 0, 0)) && now.isBefore(LocalTime.of(15, 0, 0))){
                tipo = "Almuerzo";
                hora_fin = "15:00:00";
            }else if (now.isAfter(LocalTime.of(17, 0, 0)) && now.isBefore(LocalTime.of(19, 0, 0))){
                tipo = "Once";
                hora_fin = "19:00:00";
            }else if (now.isAfter(LocalTime.of(21, 0, 0)) && now.isBefore(LocalTime.of(23, 0, 0))){
                tipo = "Cena";
                hora_fin = "23:00:00";
            }else{
                return false;
            }
                    
            String especial_details = "Emision regular";
            String aditional_details = "Emision regular";
            
            
            String funcionario_id_funcionario = funcionario.getIdFuncionario();
            
            String valor = "";
            
            switch (funcionario.getPerfil_Id_Perfil()) {
                case "ADM":
                    valor="4000";
                    break;
                case "GR":
                    valor="5000";
                    break;
                case "MT":
                    valor="3000";
                    break;
                case "OP":
                    valor="3000";
                    break;
                default:
                    break;
            }
            
            
            try {
                Connection nueva_conexion = conexion.getConnection();
                
            
                
                
                
                String query = "insert into TICKET VALUES('"+id_ticket+"',TO_CHAR( SYSDATE, 'HH24:MI:SS' ),'"+hora_fin+"','"+status+"','"+block_by+"','"+created_by+"','"+status_1+"',TO_CHAR( SYSDATE),'"+block_datails+"','"+tipo+ "','"+especial_details+"','"+aditional_details+"',"+valor+",'"+funcionario_id_funcionario+"')";
                System.out.println(query);
                PreparedStatement ps = nueva_conexion.prepareStatement(query);
                //ResultSet resultados = consulta.executeQuery(query);
                ps.executeUpdate();
                
                Writer writer = null;
 
                try {
                    String impresion = String.format("################## Ticket Pro ################## %nTicket Id=%-20s %nTipo=%-20s %nNombre=%-20s %nValor=%-20s %n################################################",id_ticket,tipo,funcionario.getNombre(),valor);
                    File file = new File("D:\\"+id_ticket+".txt");
                    writer = new BufferedWriter(new FileWriter(file));
                    writer.write(impresion);
                    validador = true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (writer != null) {
                        writer.close();
                    }
                }
     
            } catch (ClassNotFoundException | SQLException ex) {
                
                ex.printStackTrace();
                
            }
                
            
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ticket_Controller.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return validador;
    }
 
    public boolean actualizarTicket(String idFuncionario) throws IOException {
       
        boolean validador = false;
        
        try {
            
            
            ConnectionDB conexion = new ConnectionDB();
            
            //se genera una serie en base a la fecha y hora actuales
            LocalDateTime serie = LocalDateTime.now().plusHours(1);
            
            //variable encargada de los rangos de horarios.
            LocalTime now = LocalTime.now().plusHours(1);
            
            //String id_ticket = serie.toString().replace(".","").replace("-","").replace(":","").replace("T","");
            String status = "GENERADO";
            String status_1 = "No Canjeado";
            FuncionarioController fun_con = new FuncionarioController();
            Funcionario funcionario = fun_con.retornarFuncionarioID(idFuncionario);
            String block_by = funcionario.getRut();
            String created_by = funcionario.getNombre();
            String block_datails = "Bloqueo por emision rutinaria";
            String tipo="";
            String hora_fin = "";
            
            
            //Rangos de horarios para las minutas.
            if (now.isAfter(LocalTime.of(8, 0, 0)) && now.isBefore(LocalTime.of(10, 0, 0))) {
                tipo = "Desayuno";
                hora_fin = "10:00:00";
            }else if (now.isAfter(LocalTime.of(12, 0, 0)) && now.isBefore(LocalTime.of(15, 0, 0))){
                tipo = "Almuerzo";
                hora_fin = "15:00:00";
            }else if (now.isAfter(LocalTime.of(17, 0, 0)) && now.isBefore(LocalTime.of(19, 0, 0))){
                tipo = "Once";
                hora_fin = "19:00:00";
            }else if (now.isAfter(LocalTime.of(21, 0, 0)) && now.isBefore(LocalTime.of(23, 0, 0))){
                tipo = "Cena";
                hora_fin = "23:00:00";
            }else{
                return false;
            }
                    
            String especial_details = "Emision regular";
            String aditional_details = "Emision regular";
            
            
            String funcionario_id_funcionario = funcionario.getIdFuncionario();
            
            String valor = "";
            
            switch (funcionario.getPerfil_Id_Perfil()) {
                case "ADM":
                    valor="4000";
                    break;
                case "GR":
                    valor="5000";
                    break;
                case "MT":
                    valor="3000";
                    break;
                case "OP":
                    valor="3000";
                    break;
                default:
                    break;
            }
            
            
            try {
                Connection nueva_conexion = conexion.getConnection();
                
                
                String idTicket = retornaIdTicket();
                //TO_CHAR( SYSDATE, 'HH24:MI:SS' )
                //TO_CHAR( SYSDATE)
                String query = "UPDATE TICKET SET "
                        + "HORA_INICIO = TO_CHAR('HH24:MI:SS'),"
                        + "HORA_FIN    = '"+hora_fin+"',"
                        + "STATUS      = '"+status+"',"
                        + "BLOCK_BY    = '"+block_by+"',"
                        + "CREATED_BY = '"+created_by+"',"
                        + "STATUS_1    = '"+status_1+"',"
                        + "BLOCK_DATE  = TO_CHAR( SYSDATE),"
                        + "TIPO        = '"+tipo+"',"
                        + "SEPACIAL_DETAILS = '"+especial_details+"',"
                        + "ADITIONAL_DETAILS = '"+aditional_details+"',"
                        + "VALOR = '"+valor+"',"
                        + "FUNCIONARIO_ID_FUNCIONARIO = '"+funcionario_id_funcionario+"'"
                        + "WHERE ID_TICKET = '"+idTicket+"'";
                System.out.println(query);
                PreparedStatement ps = nueva_conexion.prepareStatement(query);
                //ResultSet resultados = consulta.executeQuery(query);
                ps.executeUpdate();
                
                Writer writer = null;
 
                try {
                    String impresion = String.format("################## Ticket Pro ################## %nTicket Id=%-20s %nTipo=%-20s %nNombre=%-20s %nValor=%-20s %n################################################","pruebas_format",tipo,funcionario.getNombre(),valor);
                    File file = new File("D:\\prueba.txt");
                    writer = new BufferedWriter(new FileWriter(file));
                    writer.write(impresion);
                    validador = true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (writer != null) {
                        writer.close();
                    }
                }
     
            } catch (ClassNotFoundException | SQLException ex) {
                
                ex.printStackTrace();
                
            }
                
            
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Ticket_Controller.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return validador;
    }
   
    public Ticket devolverTicket() throws SQLException, ClassNotFoundException{
          
        
        ConnectionDB conexion = new ConnectionDB();
        Ticket ticket = null;
       
                
        try {
            
            Statement consulta = conexion.getConnection().createStatement();
            String query = "SELECT to_CHAR(min(TO_NUMBER(ID_TICKET))) FROM ticket where STATUS = 'EMITIDO';";
            ResultSet resultados = consulta.executeQuery(query);
            ticket = new Ticket();
            while(resultados.next()){
                ticket.setHoraInicio(resultados.getString("HORA_INICIO"));
                ticket.setHoraFin(resultados.getString("HORA_FIN"));
                ticket.setStatus(resultados.getString("STATUS"));
                ticket.setBlockBy(resultados.getString("BLOCK_BY"));
                ticket.setCreatedBy(resultados.getString("CREATED_BY"));
                ticket.setStatus_1(resultados.getString("status_1"));
                ticket.setBlock_date(resultados.getString("BLOCK_DATE"));
                ticket.setBlock_Details(resultados.getString("BLOC_DETAILS"));
                ticket.setTipo(resultados.getString("TIPO"));
                ticket.setEspecialDetails(resultados.getString("SEPACIAL_DETAILS"));
                ticket.setAditionalDetails(resultados.getString("ADITIONAL_DETAILS"));
                ticket.setValor(resultados.getInt("VALOR"));
                ticket.setFuncionario_Id_Funcionario(resultados.getString("FUNCIONARIO_ID_FUNCIONARIO"));
               
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return ticket;
     
    }


public String retornaIdTicket() throws SQLException, ClassNotFoundException{
                ConnectionDB conexion = new ConnectionDB();
                
                String id = "";
                           
                
                Statement consulta = conexion.getConnection().createStatement();
                String query = "SELECT to_CHAR(min(TO_NUMBER(ID_TICKET))) AS MINIMO FROM ticket where STATUS = 'EMITIDO'";
                System.out.println(query);
                ResultSet resultados = consulta.executeQuery(query);
                while (resultados.next()) {
                            id = resultados.getString("MINIMO");
                        }
                
                return id;
}    
    
}
