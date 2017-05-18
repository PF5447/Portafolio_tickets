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

/**
 *
 * @author bcn
 */
public class GrupoController {
    
    public ArrayList<String> traerGrupos() throws ClassNotFoundException, SQLException{
    
        ConnectionDB conexion = new ConnectionDB();
        ArrayList<String> perfiles = new ArrayList<>();
        
        
        
        try {
            Connection con = conexion.getConnection();
            Statement stms = con.createStatement();
                    
            
            ResultSet resultados = stms.executeQuery("SELECT * FROM GRUPO");
            
            while(resultados.next()){
     
                perfiles.add(resultados.getString("ID_GRUPO"));
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
           
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return perfiles;
    
    }
    
    
}
