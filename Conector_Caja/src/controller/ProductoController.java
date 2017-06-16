/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connection.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Producto;

/**
 *
 * @author bcn
 */
public class ProductoController {
    
    public ArrayList<Producto> getProductos() throws ClassNotFoundException, SQLException{
        
        ArrayList<Producto> productos = new ArrayList();
        ConnectionDB conexion = new ConnectionDB();
        Producto producto = new Producto();
    
        
        
        try {
            Connection con = conexion.getConnection();
            Statement stms = con.createStatement();
                    
            
            ResultSet resultados = stms.executeQuery("SELECT * FROM PRODUCTO");
            
            while(resultados.next()){
     
                producto.setIdProducto(resultados.getString("ID_PRODUCTO"));
                producto.setNombreProducto(resultados.getString("NOMBRE"));
                producto.setValorProducto(resultados.getInt("VALOR"));
                productos.add(producto);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
           
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
         
        return productos;
    }
    
    
    public Producto getProducto(String id) throws ClassNotFoundException, SQLException{
        
        Producto producto = new Producto();
        ConnectionDB conexion = new ConnectionDB();
         
        try {
            Connection con = conexion.getConnection();
            Statement stms = con.createStatement();
                    
            
            ResultSet resultados = stms.executeQuery("SELECT * FROM PRODUCTO WHERE ID_PRODUCTO ='"+id+"'");
            
            while(resultados.next()){
     
                producto.setIdProducto(resultados.getString("ID_PRODUCTO"));
                producto.setNombreProducto(resultados.getString("NOMBRE"));
                producto.setValorProducto(resultados.getInt("VALOR"));
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
           
            ex.printStackTrace();
            
        }finally{
            conexion.getConnection().close();
        }
         
        
        
        return producto;
    }
    
    public void poblarGrid(ArrayList<Producto> productos) {
        
        
        
    }
    
    public void agregarProducto(Producto producto){
    
    }
    
    
}
