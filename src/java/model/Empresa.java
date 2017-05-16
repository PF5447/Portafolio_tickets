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
public class Empresa {
    
    String rutTributario;
    String representanteLegal;
    String direccion;
    String casaMatriz;
    String telefono;
    String idSucursal;

    public Empresa() {
    }

    public String getRutTributario() {
        return rutTributario;
    }

    public void setRutTributario(String rutTributario) {
        this.rutTributario = rutTributario;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCasaMatriz() {
        return casaMatriz;
    }

    public void setCasaMatriz(String casaMatriz) {
        this.casaMatriz = casaMatriz;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "Empresa{" + "rutTributario=" + rutTributario + ", representanteLegal=" + representanteLegal + ", direccion=" + direccion + ", casaMatriz=" + casaMatriz + ", telefono=" + telefono + ", idSucursal=" + idSucursal + '}';
    }
    
    
    
}
