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
public class Roles {
    
    String idRoles;
    String msRol;
    String rol;

    public Roles() {
    }

    public String getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(String idRoles) {
        this.idRoles = idRoles;
    }

    public String getMsRol() {
        return msRol;
    }

    public void setMsRol(String msRol) {
        this.msRol = msRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Roles{" + "idRoles=" + idRoles + ", msRol=" + msRol + ", rol=" + rol + '}';
    }
    
    
    
}
