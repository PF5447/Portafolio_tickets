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
import model.Usuario;

/**
 *
 * @author felipe
 */
public class UserController {
    
    public boolean agregarUser(String ID_USUARIO,String USER,String PASS,String CODIGO
    ,String GRUPO_ID_GRUPO,String FUNCIONARIO_ID_FUNCIONARIO) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
   

        ConnectionDB conexion = new ConnectionDB();
        boolean validador = false;
  
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] tmp = PASS.getBytes();
        sha.update(tmp);
        PASS = byteArrToString(sha.digest()); 
        
        
                     
        try {
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            String query = "insert into USUARIO VALUES('"+ID_USUARIO+"','"+USER+"','"+PASS+"','"+CODIGO+"','"+GRUPO_ID_GRUPO+"','"+FUNCIONARIO_ID_FUNCIONARIO+"')";
            System.out.println(query);
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                validador = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        
        
        return validador;
    }
    
        public boolean validarUsuario(String user, String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
        ConnectionDB conexion = new ConnectionDB();
        Usuario usuario = new Usuario();
        
        
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] tmp = pass.getBytes();
        sha.update(tmp);
        pass = byteArrToString(sha.digest()); 

        boolean validador = false;
        try {
            //Connection nueva_conexion = conexion.getConnection();
            Statement consulta = conexion.getConnection().createStatement();
            String query = "SELECT * FROM usuario WHERE PASS ="+"'"+pass+"' AND \"user\"='"+user+"'";
            System.out.println(query);
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
   
                validador=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            validador=false;
            ex.printStackTrace();
        }finally{
            conexion.getConnection().close();
        }
        
        
        return validador;
    }
        
        
    
    
    private String byteArrToString(byte[] digest) {
        String res = null;
        StringBuffer sb = new StringBuffer(digest.length*2);
        for (int i = 0; i < digest.length; i++) {
           int j = digest[i] & 0xff;
            if (j<16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(j));
        }
        
        res = sb.toString();
        return res.toUpperCase();
    }    
        
}
