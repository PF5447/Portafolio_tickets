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
public class Funcionario {
    
    String rut;
    String nombre;
    String correo;
    String sexo;
    String idFuncionario;
    String turnos_Id_Turnos;
    String perfil_Id_Perfil;

    public Funcionario() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTurnos_Id_Turnos() {
        return turnos_Id_Turnos;
    }

    public void setTurnos_Id_Turnos(String turnos_Id_Turnos) {
        this.turnos_Id_Turnos = turnos_Id_Turnos;
    }

    public String getPerfil_Id_Perfil() {
        return perfil_Id_Perfil;
    }

    public void setPerfil_Id_Perfil(String perfil_Id_Perfil) {
        this.perfil_Id_Perfil = perfil_Id_Perfil;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "rut=" + rut + ", nombre=" + nombre + ", correo=" + correo + ", sexo=" + sexo + ", idFuncionario=" + idFuncionario + ", turnos_Id_Turnos=" + turnos_Id_Turnos + ", perfil_Id_Perfil=" + perfil_Id_Perfil + '}';
    }
    
    
    
    
    
}
