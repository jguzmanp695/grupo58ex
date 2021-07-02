package model;

public class Wallet {
    
    public static final int CAPACIDAD_MAXIMA = 1000000;
    private int saldo;
    private boolean tieneLimite;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
    }
    
    public int getSaldo(){
        return saldo;
    }

    public boolean getTieneLimite(){
        return tieneLimite;
    }

    public void setTieneLimite(boolean newTieneLimite){
        this.tieneLimite = newTieneLimite;
    }
    
    public String saveMoney(int value){
        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite){
            return "No se puede superar el límite " + CAPACIDAD_MAXIMA;
        }
        saldo += value; // saldo = saldo + value
        return "Transacción exitosa, nuevo saldo " + saldo;
    }

    public String takeMoney(int value){
        if (saldo < value){
            return "Saldo insuficiente";
        }
        saldo -= value; // saldo = saldo - value
        return "Transancción exitosa, nuevo saldo " + saldo;
    }

    public String breakLimite(){
        if (saldo >= 10000){
            saldo -= 10000;
            setTieneLimite(false); //tieneLimite = false
            return "Se ha cambiado el límite ahora puede ahorrar a la medida";
        }
        //tieneLimite = false;
        return "No se puede romper el límite de ahorro, saldo insuficiente";
    }
}
