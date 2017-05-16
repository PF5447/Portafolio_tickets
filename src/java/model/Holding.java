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
public class Holding {
    
    String idHolding;
    String nombreHolding;
    String empresa_RutTributario;

    public Holding() {
    }

    public String getIdHolding() {
        return idHolding;
    }

    public void setIdHolding(String idHolding) {
        this.idHolding = idHolding;
    }

    public String getNombreHolding() {
        return nombreHolding;
    }

    public void setNombreHolding(String nombreHolding) {
        this.nombreHolding = nombreHolding;
    }

    public String getEmpresa_RutTributario() {
        return empresa_RutTributario;
    }

    public void setEmpresa_RutTributario(String empresa_RutTributario) {
        this.empresa_RutTributario = empresa_RutTributario;
    }

    @Override
    public String toString() {
        return "Holding{" + "idHolding=" + idHolding + ", nombreHolding=" + nombreHolding + ", empresa_RutTributario=" + empresa_RutTributario + '}';
    }
    
}
