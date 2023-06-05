package com.mycompany.banco;
/**
 *
 * @author Nayeli Avilés 
 */
abstract public class Cuenta {
    private int numero;
    private String titular; 
    private float saldo_actual;
    private char estado;
    private  float ahorrometa;

    public Cuenta(int numero, String titular, float saldo_actual, char estado, float ahorrometa) {
        this.numero = numero;
        this.titular = titular;
        this.saldo_actual = saldo_actual;
        this.estado = estado;
        this.ahorrometa = ahorrometa;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public float getSaldo_actual() {
        return saldo_actual;
    }
    public void setSaldo_actual(float saldo_actual) {
        this.saldo_actual = saldo_actual;
    }
    public char getEstado() {
        return estado;
    }
    public void setEstado(char estado) {
        this.estado = estado;
    }
    public float getAhorrometa() {
        return ahorrometa;
    }
    public void setAhorrometa(float ahorrometa) {
        this.ahorrometa = ahorrometa;
    }
    public void mostrar(){
        System.out.println("NUMERO CTA    : "+this.getNumero());
        System.out.println("TITULAR       : "+this.getTitular());
        System.out.println("SALDO         : "+this.getSaldo_actual());
        System.out.println("ESTADO        : "+this.getEstado());
    }
    abstract public float generarInteres();
}


