package com.mycompany.banco;
/**
 *
 * @author Nayeli Avilés
 */
public class Ahorro extends Cuenta{
    private float Ahorro_meta;
    
    public Ahorro(int numero, String titular, float saldo_actual, char estado, float ahorrometa, float ahorro_meta) {
        super(numero, titular, saldo_actual, estado, ahorrometa);
        Ahorro_meta = ahorro_meta;
    }

    public float getAhorro_meta() {
        return Ahorro_meta;
    }

    public void setAhorro_meta(float ahorro_meta) {
        Ahorro_meta = ahorro_meta;
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("AHORRO META: "+this.getAhorro_meta());
    }
    public float generarInteres(){
        float valor_interes;
        valor_interes=this.getSaldo_actual()*0.05f/100;
        return valor_interes;
    }
}

