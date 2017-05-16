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
import model.Funcionario;

/**
 *
 * @author felipe
 */
public class FuncionarioController {
    
    public boolean agregarFuncionario(String rut,String nombre,String correo,String sexo
    ,String idFuncionario,String turnos_Id_Turno,String perfil_Id_Perfil) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
   

        ConnectionDB conexion = new ConnectionDB();
        boolean validador = false;
        
        
                     
        try {
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            String query = "insert into FUNCIONARIO VALUES('"+rut+"','"+nombre+"','"+correo+"','"+sexo+"','"+idFuncionario+"','"+turnos_Id_Turno+"','"+perfil_Id_Perfil+"')";
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
    
    public boolean validarFuncionario(String rut) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
        ConnectionDB conexion = new ConnectionDB();
        Funcionario funcionario = new Funcionario();
        boolean resultado = false;
                
        try {
            
            Statement consulta = conexion.getConnection().createStatement();
            String query = "SELECT rut FROM persona WHERE rut="+"'"+rut.trim()+"'";
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                funcionario.setRut(resultados.getString("rut"));
                resultado=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            resultado=false;
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return resultado;
    }

    
public boolean eliminarFuncionario(String rut) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
   

        ConnectionDB conexion = new ConnectionDB();
        boolean validador = false;
        
        if (validarFuncionario(rut)) {
                     
        try {
            Connection nueva_conexion = conexion.getConnection();
            Statement consulta = nueva_conexion.createStatement();
            String query = "delete from FUNCIONARIO where rut ="+rut+"'";
            System.out.println(query);
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                validador = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            validador = false;
            ex.printStackTrace();
        }finally{
            conexion.getConnection().close();
        }
        
        }
        
        return validador;
    }

    public boolean actualizarFuncionario(String rut,String nombre,String correo,String sexo
    ,String idFuncionario,String turnos_Id_Turno,String perfil_Id_Perfil) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException{
        
        ConnectionDB conexion = new ConnectionDB();
        Funcionario funcionario = new Funcionario();
        boolean resultado = false;
                
        try {
            
            Statement consulta = conexion.getConnection().createStatement();
            String query = "update funcionario set rut='"+rut+"',nombre='"+nombre+"',correo='"+correo+"',sexo='"+sexo+"',id_funcionario='"+idFuncionario+"',turnos_id_turno='"+turnos_Id_Turno+"',perfil_id_perfil='"+perfil_Id_Perfil+"' WHERE rut="+"'"+rut.trim()+"'";
            ResultSet resultados = consulta.executeQuery(query);
            
            while(resultados.next()){
                funcionario.setRut(resultados.getString("rut"));
                resultado=true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            resultado=false;
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
        
        
        return resultado;
    }
    
}
