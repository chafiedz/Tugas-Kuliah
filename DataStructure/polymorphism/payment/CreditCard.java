package Kuliah.polymorphism.payment;

public class CreditCard extends Pembayaran {
    @Override
    public void bayar(double jumlah) {
        System.out.println("Pembayaran menggunakan Kartu Kredit");
        jumlah += jumlah * 0.02; // Tambahkan biaya admin 2%
        System.out.println("Total pembayaran: " + jumlah);
    }
}
