/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author felipe
 */
public class Sucursales {
    
   String idSucursal;
   String direccion;
   String telefono;
   String correo;
   String funcionario_id_Funcionarios;

    public Sucursales() {
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFuncionario_id_Funcionarios() {
        return funcionario_id_Funcionarios;
    }

    public void setFuncionario_id_Funcionarios(String funcionario_id_Funcionarios) {
        this.funcionario_id_Funcionarios = funcionario_id_Funcionarios;
    }

    @Override
    public String toString() {
        return "Sucursales{" + "idSucursal=" + idSucursal + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", funcionario_id_Funcionarios=" + funcionario_id_Funcionarios + '}';
    }
   
   
    
}
