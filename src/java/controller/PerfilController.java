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
 * @author bcn
 */
public class PerfilController {
    
    public ArrayList<String> traerTurnos() throws ClassNotFoundException, SQLException{
    
        ConnectionDB conexion = new ConnectionDB();
        ArrayList<String> perfiles = new ArrayList<>();
        
        
        
        try {
            
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            ResultSet resultados = consulta.executeQuery("SELECT nombre FROM perfil");
            
            while(resultados.next()){
                perfiles.add(resultados.getString("nombre"));
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return perfiles;
    
    }
    
    
}
