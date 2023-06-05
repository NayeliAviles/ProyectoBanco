package com.mycompany.banco;
import java.util.Scanner;
/**
 *
 * @author Nayeli Avilés 
 */
public class Banco {
    public static int posicion = 0;

    public static void crearCuentaAhorro(Scanner entrada, Cuenta []cta){
        int dc = -1; int num_cta;String titular_cta; float saldo_actual; float ah_meta; char estado;
        int ind = 0;
        do{
            System.out.println("\n   CREACION DE CUENTAS DE AHORRO   ");
            System.out.println("-------------------------------------");
            System.out.print("INGRESE NUMERO CUENTA: ");
            num_cta = entrada.nextInt();
            System.out.print("INGRESE TITULAR CUENTA: ");
            titular_cta = entrada.next();
            System.out.print("INGRESE SALDO ACTUAL: ");
            saldo_actual = entrada.nextFloat();
            System.out.print("INGRESE AHORRO META: ");
            ah_meta = entrada.nextFloat();
            estado = 'A';
            cta[ind]= new  Ahorro(num_cta, titular_cta, saldo_actual, estado, ah_meta, ah_meta);
            ind++;
            System.out.println("DATOS GRABADOS CORRECTAMENTE...");
            System.out.print("DIGITE [1] PARA CONTINUAR - DIGITE [2] PARA SALIR AL MENU: ");
            dc = entrada.nextInt();
            System.out.println(dc);
        }while(dc == 1);
    }

    public static void crearCuentaCorriente(Scanner entrada, Cuenta []cta){
        int dc = -1; int num_cta; String titular_cta; float saldo_actual; char estado; String of_cred;
        int ind=0;
        do{
            System.out.println("\n   CREACION DE CUENTAS CORRIENTE   ");
            System.out.println("-------------------------------------");
            System.out.print("INGRESE NUMERO CUENTA: ");
            num_cta = entrada.nextInt();
            System.out.print("INGRESE TITULAR CUENTA: ");
            titular_cta = entrada.next();
            System.out.print("INGRESE SALDO ACTUAL: ");
            saldo_actual = entrada.nextFloat();
            System.out.print("INGRESE OFICIAL DE CREDITO: ");
            of_cred=entrada.next();
            estado = 'A';
            cta[ind]= new  Corriente(num_cta, titular_cta, saldo_actual, estado, 0, of_cred);
            ind++;
            System.out.println("DATOS GRABADOS CORRECTAMENTE...........");
            System.out.print("DIGITE [1] PARA CONTINUAR - DIGITE [2] PARA SALIR AL MENU: ");
            dc = entrada.nextInt();
        }while(dc == 1);
    }

    public static void consultarSaldos(Cuenta [] cta){
        System.out.println("\n   CONSULTANDO SALDOS DE LAS CUENTAS   ");
        for(int i=0; i<cta.length;i++){
            System.out.println("TIPO CUENTA: " + cta[i].getClass().getSimpleName() + "  TITULAR: " + 
                    cta[i].getTitular() + " SALDO: " + cta[i].getSaldo_actual());
        }
    }

    public static void generarInteres(Cuenta [] cta){
        System.out.println("\nGENERANDO INTERES DE LAS CUENTAS.....");
        for(int i = 0; i < cta.length;i++){
            System.out.println("TIPO CUENTA: " + cta[i].getClass().getSimpleName() + " TITULAR: " + cta[i].getTitular() + " INTERES: "+cta[i].generarInteres());
            cta[i].setSaldo_actual(cta[i].getSaldo_actual() + cta[i].generarInteres());
            System.out.println("SALDO ACTUAL ACTUALIZADO: " + cta[i].getSaldo_actual());
        }
    }

    public static void depositarAhorro(Cuenta [] cta){
        Scanner entrada = new Scanner(System.in); float valor_deposito;
        int numero_cuenta, indice = 0, posicion = -1; boolean encontrado = false;
        System.out.println("\n   DEPOSITO DE CUENTA DE AHORRO   ");
        System.out.println("------------------------------------");
        System.out.print("INGRESE NUMERO DE CUENTA: ");
        numero_cuenta = entrada.nextInt();
        while(indice < cta.length && encontrado == false){
            if(cta[indice].getNumero() == numero_cuenta){
                posicion = indice;
                encontrado = true;
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: " + cta[posicion].getTitular());
            System.out.print("INGRESAR LA CANTIDAD DEL DEPOSITO: ");
            valor_deposito = entrada.nextFloat();
            cta[posicion].setSaldo_actual(valor_deposito + cta[posicion].getSaldo_actual());
            System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
            System.out.println("\nEXITOSAMENTE SE HA REALIZADO SU DEPOSITO..\n");
        }
        else{
            System.out.println("\nLA CUENTA NO EXISTE...\n");
        }
    }
    
    public static void depositarCorriente(Cuenta [] cta){
        Scanner entrada = new Scanner (System.in); float deposito_corriente;
        int num_cuenta_corriente, indice = 0 , posicion_corriente=-1; boolean encontrado_corriente= false; 
        System.out.println("\n   DEPOSITO DE CUENTA CORRIENTE   ");
        System.out.println("----------------------------------");
        System.out.print("INGRESE NUMERO DE CUENTA: ");
        num_cuenta_corriente= entrada.nextInt();
        while(indice<cta.length && encontrado_corriente == false){
            if(cta[indice].getNumero() == num_cuenta_corriente){
                posicion_corriente = indice;
                encontrado_corriente = true;
            }
            indice++;
        }
        if(encontrado_corriente == true){
            System.out.println ("TITULAR: " + cta[posicion].getTitular());
            System.out.print("INGRESAR LA CANTIDAD DEL DEPOSITO: ");
            deposito_corriente = entrada.nextFloat();
            cta[posicion].setSaldo_actual(deposito_corriente + cta[posicion_corriente].getSaldo_actual());
            System.out.println("SALDO ACTUALIZADO: " + cta[posicion].getSaldo_actual());
            System.out.println("\nEXITOSAMENTE SE HA REALIZADO SU DEPOSITO...");
        }
        else{
            System.out.println("\nLA CUENTA NO EXISTE...");
        }
    }
    
    public static void retirarAhorro(Cuenta [] cta){
        Scanner entrada = new Scanner(System.in); int retiroDeposito;
        int numeroCuenta, indice = 0, posicion = -1; boolean encontrado = false; 
        System.out.println("\n   RETIRO DE LA CUENTA AHORRO   ");
        System.out.println("----------------------------------");
        System.out.print("INGRESE NUMERO DE CUENTA: ");
        numeroCuenta = entrada.nextInt();
        while(indice<cta.length && encontrado == false){
            if(cta[indice].getNumero()==numeroCuenta){
                posicion = indice; 
                encontrado = true; 
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: "+cta[posicion].getTitular());
            System.out.print("INGRESE LA CANTIDAD A RETIRAR:  ");
            retiroDeposito = entrada.nextInt();
            if((retiroDeposito<0)&(retiroDeposito<cta[posicion].getSaldo_actual())|(retiroDeposito<=cta[posicion].getAhorrometa())){
                System.out.println("ERROR..NO SE HA REALIZADO EL RETIRO...");
            }else{
                cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual()-retiroDeposito);
                System.out.println("SALDO : "+cta[posicion].getSaldo_actual());
                System.out.println("\nEXITOSAMENTE SE HA REALIZADO SU RETIRO...");
            }
        }
    }
    
    public static void retirarCorriente(Cuenta [] cta){
        Scanner leer = new Scanner(System.in);
        int num_Cuenta, indice = 0; boolean encontrado = false; float val_retiro;
        System.out.println("\n   RETIRO DE LA CUENTA CORRIENTE   ");
        System.out.println("------------------------------------");
        System.out.print("INGRESE NUMERO DE CUENTA: ");
        num_Cuenta = leer.nextInt();
        while(indice < cta.length && encontrado == false){
            if(cta[indice].getNumero() == num_Cuenta){
                posicion = indice;
                encontrado = true;
            }
            indice++;
        }
        if(encontrado == true){
            System.out.println("TITULAR: " + cta[posicion].getTitular());
            
            if(cta[posicion].getSaldo_actual() < 1000){
                System.out.println("ERROR..SU CUENTA ESTA DESHABILITADA NO PUEDE REALIZAR SU RETIRO...");
                cta[posicion].setEstado('I');
                System.out.println("ESTADO DE CUENTA: " + cta[posicion].getEstado() + " [INACTIVA]");
            }else if(cta[posicion].getSaldo_actual() >= 1000){
                System.out.println("ESTADO DE CUENTA: " + cta[posicion].getEstado() + " [ACTIVA]");
                System.out.print("INGRESE LA CANTIDAD A RETIRAR: ");
                val_retiro = leer.nextFloat();
                if(val_retiro <= 0){
                    System.out.println("ES IMPOSIBLE RETIRAR UNA CANTIDAD NEGATIVA.."
                        + "NI IGUAL A 0...");
                }else if(val_retiro > cta[posicion].getSaldo_actual()){
                    System.out.println("ES IMPOSIBLE REALIZAR UN RETIRO DE UNA CANTIDAD MAYOR"
                        + " A LA DE SU CUENTA...");
                }else if(val_retiro < cta[posicion].getSaldo_actual()){
                    cta[posicion].setSaldo_actual(cta[posicion].getSaldo_actual() - val_retiro);
                    System.out.println("SALDO ACTUAL: " + cta[posicion].getSaldo_actual());
                    System.out.println("\nEXITOSAMENTE SE HA REALIZADO SU RETIRO...");
                }
            }
            
        }else{
            System.out.println("\nCUENTA NO EXISTENTE!!");
        }
    }
    
    public static void menuPrincipal(Scanner entrada, Cuenta [] cta){
        System.out.println("\n   MENU PRINCIPAL   ");
        System.out.println("-------------------------");
        System.out.println("1. APERTURAR CUENTA AHORRO");
        System.out.println("2. APERTURAR CUENTA CORRIENTE");
        System.out.println("3. DEPOSITO CUENTA DE AHORRO");
        System.out.println("4. DEPOSITO CUENTA CORRIENTE");
        System.out.println("5. RETIRAR CUENTA AHORRO");
        System.out.println("6. RETIRAR CUENTA CORRIENTE");
        System.out.println("7. CONSULTAR SALDOS DE CUENTAS");
        System.out.println("8. GENERAR INTERES");
        System.out.println("9. SALIR");
        System.out.print("DIGITE UNA OPCION: ");
        int opcion = entrada.nextInt();
        switch(opcion){
            case 1: crearCuentaAhorro(entrada, cta); menuPrincipal(entrada, cta);break;
            case 2: crearCuentaCorriente(entrada, cta);menuPrincipal(entrada, cta);break;
            case 3: depositarAhorro(cta); menuPrincipal(entrada, cta);break;
            case 4: depositarCorriente(cta);menuPrincipal(entrada, cta);break;
            case 5: retirarAhorro(cta);menuPrincipal(entrada, cta);break;
            case 6: retirarCorriente(cta);menuPrincipal(entrada, cta);break;
            case 7: consultarSaldos(cta);menuPrincipal(entrada, cta);break;
            case 8: generarInteres(cta); menuPrincipal(entrada, cta);break;
        }
    }
  
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int MAX = 2;
        Cuenta [] cta = new Cuenta[MAX];
        menuPrincipal(entrada, cta);    
    }
}
