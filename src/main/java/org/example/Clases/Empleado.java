package org.example.Clases;

public class Empleado{
    String nombres;
    String apellidos;
    String documento;
    int diasTrabajados;
    double salarioBasico;
    double comisiones;
    int horasExtrasDiurnas;
    int horasExtrasNocturnas;
    boolean subsidioTransporte;

    public Empleado(String nombres, String apellidos, String documento, int diasTrabajados, double salarioBasico,double comisiones, int horasExtrasDiurnas, int horasExtrasNocturnas,  boolean subsidioTransporte){
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.documento=documento;
        this.diasTrabajados=diasTrabajados;
        this.salarioBasico=salarioBasico;
        this.comisiones=comisiones;
        this.horasExtrasDiurnas=horasExtrasDiurnas;
        this.horasExtrasNocturnas=horasExtrasNocturnas;
        this.subsidioTransporte=subsidioTransporte;
    }
}

