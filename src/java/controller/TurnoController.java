/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funcionario;
import model.Turnos;

/**
 *
 * @author Invitado
 */
public class TurnoController {
    
    public ArrayList<String> traerTurnos() throws ClassNotFoundException, SQLException{
    
        ConnectionDB conexion = new ConnectionDB();
        ArrayList<String> turnos = new ArrayList<>();
        Turnos resultado = new Turnos();
                
        try {
            
            Statement consulta = conexion.getConnection().createStatement();
            String query = "SELECT nombre FROM turnos'";
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                turnos.add(resultados.getString("nombre"));
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return turnos;
    
    }
    
}
