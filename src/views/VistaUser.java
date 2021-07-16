package views;

import model.Client;
import model.Transfer;

public class VistaUser {
    public static void main(String[] args) {
        Client customer1 = new Client("Marco");
        Client customer2 = new Client("Raúl");
        String response = customer1.getNombre();
        String response1 = customer2.getNombre();
        System.out.println(response);
        System.out.println(response1);
        System.out.println(customer1.getWallet().saveMoney(200000));
        System.out.println(customer1.getWallet().saveMoney(200000));
        System.out.println(customer1.getWallet().getSaldo());
        System.out.println(customer1.getWallet().takeMoney(199000));
        System.out.println(customer2.getWallet().getSaldo());
        String response2 = customer1.getWallet().compararCuenta(customer2.getWallet());
        System.out.println(response2);
        Transfer transfer1 = new Transfer(100000);
        /*String response = transfer1.getWallet();*/
        customer1.getWallet().displayMovimientos();



    }
}
