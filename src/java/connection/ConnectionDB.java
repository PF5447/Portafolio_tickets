/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Invitado
 */
public class ConnectionDB {
    
    //Nombre de servidor
    private static final String SERVERNAME = "localhost:1521:XE";
    //Credenciales de acceso
    private static final String user = "administrador";
    private static final String pass = "1234"; 
    
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        Connection new_connection = null;
        Properties propiedades_conexion = new Properties();
        propiedades_conexion.put("user", user);
        propiedades_conexion.put("password", pass);
        Class.forName("oracle.jdbc.OracleDriver");
        new_connection = DriverManager.getConnection("jdbc:oracle:thin:@"+SERVERNAME,propiedades_conexion);
        System.out.println("Conexion exitosa...");
        
        return new_connection;
    }
    
}
