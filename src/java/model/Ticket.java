/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author felipe
 */
public class Ticket {
    
    String idTicket;
    Time horaInicio;
    Time horaFin;
    String status;
    Date block_date;
    String block_Details;
    String tipo;
    String especialDetails;
    String aditionalDetails;
    int valor;
    String funcionario_Id_Funcionario;

    public Ticket() {
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBlock_date() {
        return block_date;
    }

    public void setBlock_date(Date block_date) {
        this.block_date = block_date;
    }

    public String getBlock_Details() {
        return block_Details;
    }

    public void setBlock_Details(String block_Details) {
        this.block_Details = block_Details;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecialDetails() {
        return especialDetails;
    }

    public void setEspecialDetails(String especialDetails) {
        this.especialDetails = especialDetails;
    }

    public String getAditionalDetails() {
        return aditionalDetails;
    }

    public void setAditionalDetails(String aditionalDetails) {
        this.aditionalDetails = aditionalDetails;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getFuncionario_Id_Funcionario() {
        return funcionario_Id_Funcionario;
    }

    public void setFuncionario_Id_Funcionario(String funcionario_Id_Funcionario) {
        this.funcionario_Id_Funcionario = funcionario_Id_Funcionario;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", status=" + status + ", block_date=" + block_date + ", block_Details=" + block_Details + ", tipo=" + tipo + ", especialDetails=" + especialDetails + ", aditionalDetails=" + aditionalDetails + ", valor=" + valor + ", funcionario_Id_Funcionario=" + funcionario_Id_Funcionario + '}';
    }
   
    
    
}
