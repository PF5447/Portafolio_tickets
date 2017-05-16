/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;

/**
 *
 * @author felipe
 */
public class Turnos {
    
    String idTurnos;
    String nombre;
    Time hora_Inicio;
    Time hora_Fin;

    public Turnos() {
    }

    public String getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(String idTurnos) {
        this.idTurnos = idTurnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getHora_Inicio() {
        return hora_Inicio;
    }

    public void setHora_Inicio(Time hora_Inicio) {
        this.hora_Inicio = hora_Inicio;
    }

    public Time getHora_Fin() {
        return hora_Fin;
    }

    public void setHora_Fin(Time hora_Fin) {
        this.hora_Fin = hora_Fin;
    }

    @Override
    public String toString() {
        return "Turnos{" + "idTurnos=" + idTurnos + ", nombre=" + nombre + ", hora_Inicio=" + hora_Inicio + ", hora_Fin=" + hora_Fin + '}';
    }
    
    
}
