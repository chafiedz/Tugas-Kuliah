package Cashier;

public class Pelanggan {
    public String nomorAntrian;
    public String namaPelanggan;
    public double totalBelanja;
    public Pelanggan next; // untuk Queue
    public Pelanggan prev; // untuk Stack

    public Pelanggan(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian  = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja  = totalBelanja;
        this.next          = null;
        this.prev          = null;
    }
}
