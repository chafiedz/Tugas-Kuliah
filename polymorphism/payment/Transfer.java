package Kuliah.polymorphism.payment;

public class Transfer extends Pembayaran {

    @Override
    public void bayar(double jumlah) {
        System.out.println("Pembayaran menggunakan Transfer Bank");
        jumlah += jumlah * 0.01; // Tambahkan biaya admin 1%
        System.out.println("Total pembayaran: " + jumlah);
    }
}