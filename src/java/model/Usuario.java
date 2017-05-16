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
public class Usuario {
    
    String idUsuario;
    String user;
    String pass;
    String codigo;
    String grupo_Id_Grupo;
    String funcionario_Id_Funcionario;

    public Usuario() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGrupo_Id_Grupo() {
        return grupo_Id_Grupo;
    }

    public void setGrupo_Id_Grupo(String grupo_Id_Grupo) {
        this.grupo_Id_Grupo = grupo_Id_Grupo;
    }

    public String getFuncionario_Id_Funcionario() {
        return funcionario_Id_Funcionario;
    }

    public void setFuncionario_Id_Funcionario(String funcionario_Id_Funcionario) {
        this.funcionario_Id_Funcionario = funcionario_Id_Funcionario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", user=" + user + ", pass=" + pass + ", codigo=" + codigo + ", grupo_Id_Grupo=" + grupo_Id_Grupo + ", funcionario_Id_Funcionario=" + funcionario_Id_Funcionario + '}';
    }
    
    
    
}
