/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author felipe
 */
public class Cange {
    String ifCange;
    String cangedBy;
    Date cangeDate;
    String tipo;
    int diferencia;
    String idTicket;
    String idProducto;

    public Cange() {
    }

    public String getIfCange() {
        return ifCange;
    }

    public void setIfCange(String ifCange) {
        this.ifCange = ifCange;
    }

    public String getCangedBy() {
        return cangedBy;
    }

    public void setCangedBy(String cangedBy) {
        this.cangedBy = cangedBy;
    }

    public Date getCangeDate() {
        return cangeDate;
    }

    public void setCangeDate(Date cangeDate) {
        this.cangeDate = cangeDate;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Cange{" + "ifCange=" + ifCange + ", cangedBy=" + cangedBy + ", cangeDate=" + cangeDate + ", tipo=" + tipo + ", diferencia=" + diferencia + ", idTicket=" + idTicket + ", idProducto=" + idProducto + '}';
    }
    
    
}
