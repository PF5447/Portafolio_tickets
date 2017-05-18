/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Turnos;

/**
 *
 * @author Invitado
 */
public class TurnoController {
    
public ArrayList<String> traerTurnos() throws ClassNotFoundException, SQLException{
    
        ConnectionDB conexion = new ConnectionDB();
        ArrayList<String> turnos = new ArrayList<>();
        
        
        
        try {
            Connection con = conexion.getConnection();
            Statement stms = con.createStatement();
                    
            
            ResultSet resultados = stms.executeQuery("SELECT * FROM TURNOS");
            
            while(resultados.next()){
     
                turnos.add(resultados.getString("ID_TURNO"));
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("cague!");
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return turnos;
    
    }
    
    
}
