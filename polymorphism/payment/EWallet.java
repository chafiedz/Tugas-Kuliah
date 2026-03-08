package Kuliah.polymorphism.payment;

public class EWallet extends Pembayaran {

    @Override
    public void bayar(double jumlah) {
        System.out.println("Pembayaran menggunakan E-Wallet");
        System.out.println("Total pembayaran: " + jumlah);
    }
}