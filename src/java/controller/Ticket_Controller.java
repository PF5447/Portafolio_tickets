/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionDB;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    
    
}
