package model;

public class Transaction {
    private int amount;
    private String fecha;
    /**
     * Tipo de transacción: 1. Ingreso de dinero 2. Retiro de dinero
     */
    private int type;
    private String description;

    /**
     * Método que construye un objeto de la clase Transactio <br>
     * @param amount valor del movimiento
     * @param fecha fecha en la cual se realiza el movimiento
     * @param type tipo de movimiento 1== ingreso, 2== retiro
     * @param description descripción del movimiento
     */
    public Transaction(int amount, String fecha, int type, String description) {
        super();
        this.amount = amount;
        this.fecha = fecha;
        this.type = type;
        this.description = description;
    }

    /**
     * 
     * @return Retorna el valor del movimiento
     */
    public int getAmount() {
        return amount;
    }

    /**
     * 
     * @return Retorna la fecha del movimiento
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * 
     * @return Retorna el tipo de movimiento
     */
    public int getType() {
        return type;
    }

    /**
     * 
     * @return Retorna la descripción del movimiento
     */
    public String getDescription() {
        return description;
    }

    public String toString(){
        return "Monto: $"+amount+ " Fecha: "+fecha+ ", Tipo de movimiento: "+((type==1)?"Ingreso":"Egreso")+ ", Descripción: "+description;
    }

}