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
public class Gprol {
    
    String idRol;
    String grupo_Id_Grupo;
    String roles_Id_Roles;

    public Gprol() {
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getGrupo_Id_Grupo() {
        return grupo_Id_Grupo;
    }

    public void setGrupo_Id_Grupo(String grupo_Id_Grupo) {
        this.grupo_Id_Grupo = grupo_Id_Grupo;
    }

    public String getRoles_Id_Roles() {
        return roles_Id_Roles;
    }

    public void setRoles_Id_Roles(String roles_Id_Roles) {
        this.roles_Id_Roles = roles_Id_Roles;
    }

    @Override
    public String toString() {
        return "Gprol{" + "idRol=" + idRol + ", grupo_Id_Grupo=" + grupo_Id_Grupo + ", roles_Id_Roles=" + roles_Id_Roles + '}';
    }
    
    
    
}
