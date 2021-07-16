package model;

public class Transfer {
    private Wallet wallet;

    public Transfer(int valor) {
        super();
        wallet = new Wallet();
    }

    public Wallet gWallet() {
        return wallet;
    }
    
}
