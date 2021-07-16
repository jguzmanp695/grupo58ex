package model;

import java.util.ArrayList;

public class Wallet {
    
    public static final int CAPACIDAD_MAXIMA = 1000000; int TOPE_TRANSACCION = 200000; float TAZA_TRANSFERENCIA = (20/100);
    private int saldo;
    private boolean tieneLimite;
    private int meta;
    private int transferirDinero;


    /**
     * Listas
     */
    private ArrayList<Transaction> movimientos;

        
    public Wallet() {
        super();
        saldo = 0;
        meta = 0;
        tieneLimite = true;
        transferirDinero = 0;
        movimientos = new ArrayList<>();   /*creación de un objeto a partir de una clase*/
    }
    
    public int getSaldo(){
        return saldo;
    }

    public boolean getTieneLimite(){
        return tieneLimite;
    }

    public boolean establecerMeta(int value){
        if(value == 0){
            meta = value;
            return true;
        }
        if(value < 0 || value <= saldo || value > CAPACIDAD_MAXIMA && tieneLimite){
            return false;
        }
        meta = value;
        return true;
    }
        
    public boolean verificarMeta(){
        if (meta == 0 || meta > saldo){
            return false;
        }
        return true;
    }
    
    public void setTieneLimite(boolean newTieneLimite){
        this.tieneLimite = newTieneLimite;
    }
    
    public String saveMoney(int value){
        if (value > TOPE_TRANSACCION){
            return "No puede ingresar un valor mayor de $" + TOPE_TRANSACCION; //línea para no permitir guardar un valor mayo a $200.000
        }
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite){
            return "No se puede superar el límite " + CAPACIDAD_MAXIMA;
        }
        saldo += value; // saldo = saldo + value
        Transaction ingreso = new Transaction(value, "hoy", 1, "Ingreso de dinero");
        movimientos.add(ingreso);
        if(verificarMeta()){System.out.println("Has cumplido la meta");}
        return "Transacción exitosa, nuevo saldo " + saldo;
    }

    public String takeMoney(int value){
        if (value > saldo){
            return "Saldo insuficiente";
        }
        if (value > TOPE_TRANSACCION){
            return "No puede retirar un valor superior de $" + TOPE_TRANSACCION; //línea para no permitir guardar un valor mayo a $200.000
        }
        saldo -= value; // saldo = saldo - value
        Transaction retiro = new Transaction(value, "hoy", 2, "Retiro de dinero");
        movimientos.add(retiro);
        return "Transancción exitosa, nuevo saldo " + saldo;
    }

    public String breakLimite(){
        if (saldo >= 10000){
            saldo -= 10000;
            setTieneLimite(false); //tieneLimite = false
            Transaction romperLimite = new Transaction(10000, "hoy", 2, "Romper límites");
            movimientos.add(romperLimite);
            return "Se ha cambiado el límite ahora puede ahorrar a la medida";
        }
        //tieneLimite = false;
        return "No se puede romper el límite de ahorro, saldo insuficiente";
    }

    public String compararCuenta(Wallet otraWallet){
        if (saldo == otraWallet.getSaldo()){
            return "Las cuentas tienen el mismo saldo";
        }
        if (saldo > otraWallet.getSaldo()){
            return "La primera cuenta es mayor";
        }
        return "La segunda cuenta es mayor";
    }

    public void displayMovimientos(){
        for (Transaction transaction : movimientos){
            System.out.println(transaction);
        }
    }
}
