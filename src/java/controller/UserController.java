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
    
        public Usuario validarUsuario(String user, String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
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
            String query = "SELECT * FROM persona WHERE NOMBRE="+"'"+user.trim()+"'"+"and "+"HUELLA ="+"'"+pass+"'";
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                usuario.setIdUsuario(resultados.getString("ID_USUARIO"));
                usuario.setUser(resultados.getString("user"));
                usuario.setPass(resultados.getString("PASS"));
                usuario.setCodigo(resultados.getString("CODIGO"));
                usuario.setGrupo_Id_Grupo(resultados.getString("GRUPO_ID_GRUPO"));
                usuario.setFuncionario_Id_Funcionario(resultados.getString("FUNCIONARIO_ID_FUNCIONARIO"));
                validador=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            validador=false;
            ex.printStackTrace();
        }finally{
            conexion.getConnection().close();
        }
        
        
        return usuario;
    }
        
        
    public boolean agregarFuncionario(String id_usuario,String user,String pass,String codigo
    ,String grupo_id_grupo,String funcionario_id_funcionario) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
   

        ConnectionDB conexion = new ConnectionDB();
        boolean validador = false;
        
        
                     
        try {
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            String query = "insert into USUARIO VALUES("+id_usuario+"','"+user+"','"+pass+"','"+codigo+"','"+grupo_id_grupo+"','"+funcionario_id_funcionario+"')";
            System.out.println(query);
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                validador = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            validador = false;
            ex.printStackTrace();
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
