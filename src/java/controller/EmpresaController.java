/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import connection.ConnectionDB;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Empresa;


/**
 *
 * @author mvall
 */
public class EmpresaController {
    
    public boolean agregarEmpresa (String rutTributario, String representanteLegal, String direccion,  String casaMatriz,  String telefono, String idSucursal)
    throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
    
       ConnectionDB conexion = new ConnectionDB();
        boolean validador = false;
  
        try {
        Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            
        String query = "insert into empresa VALUES('"+rutTributario+"','"+representanteLegal+"','"+direccion+"','"+casaMatriz+"','"+telefono+"','"+idSucursal+"')";
            System.out.println(query);
            ResultSet resultados = consulta.executeQuery(query);
             while(resultados.next()){
                validador = true;
            }
        }   catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }       
        return validador;
    }
    
    
    public boolean validarEmpresa (String rutTributario)
    throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
    ConnectionDB conexion = new ConnectionDB();
    Empresa empresa = new Empresa ();
    boolean resultado = false;
  
        try {
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = conexion.getConnection().createStatement();
            String query = "SELECT rutTributario FROM empresa WHERE rutTributario="+"'"+rutTributario+"'";
            ResultSet resultados = consulta.executeQuery(query);
            
             while(resultados.next()){
                empresa.setRutTributario(resultados.getString("rutTributario"));
                resultado=true;
             }
            
            
            }   catch (ClassNotFoundException | SQLException ex) 
            {
                    ex.printStackTrace();
                    
            }finally{
            conexion.getConnection().close();
        }
    
    
    return resultado;


}
}

