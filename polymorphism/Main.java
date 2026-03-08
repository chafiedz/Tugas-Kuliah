package Kuliah.polymorphism;

import java.util.Scanner;
// Contoh sederhana penerapan polymorphism dalam sistem pembayaran
// Superclass
class Pembayaran {

    public void bayar(double jumlah) {
        System.out.println("Memproses pembayaran sebesar: " + jumlah);
    }
}

// Subclass Kartu Kredit
// Setiap jenis pembayaran memiliki implementasi yang berbeda untuk metode bayar, namun tetap menggunakan interface yang sama, yaitu metode bayar() dari superclass Pembayaran. Ini adalah contoh nyata dari polymorphism, di mana objek pembayaran dapat merujuk ke berbagai jenis pembayaran (Kartu Kredit, E-Wallet, Transfer) dan memanggil metode bayar() yang sesuai dengan jenis pembayaran yang dipilih.
class CreditCard extends Pembayaran {

    @Override
    // Override digunakan untuk menunjukkan bahwa metode bayar() ini menggantikan metode bayar() yang ada di superclass Pembayaran. Ini memastikan bahwa ketika kita memanggil metode bayar() pada objek pembayaran, implementasi yang benar akan dipanggil sesuai dengan jenis pembayaran yang dipilih.
    public void bayar(double jumlah) {
        System.out.println("Pembayaran menggunakan Kartu Kredit");
        jumlah += jumlah * 0.02; // Tambahkan biaya admin 2%
        System.out.println("Total pembayaran: " + jumlah);
    }
}

// Subclass E-Wallet
class EWallet extends Pembayaran {

    @Override
    public void bayar(double jumlah) {
        System.out.println("Pembayaran menggunakan E-Wallet");
        jumlah += jumlah * 0.01; // Tambahkan biaya admin 1%
        System.out.println("Total pembayaran: " + jumlah);
    }
}

// Subclass Transfer Bank
class Transfer extends Pembayaran {

    @Override
    public void bayar(double jumlah) {
        System.out.println("Pembayaran menggunakan Transfer Bank");
        jumlah = jumlah + 2500; // Tambahkan biaya transfer 2500
        System.out.println("Total pembayaran: " + jumlah);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM PEMBAYARAN ===");
        System.out.println("1. Kartu Kredit");
        System.out.println("2. E-Wallet");
        System.out.println("3. Transfer Bank");

        System.out.print("Pilih metode pembayaran: ");
        int pilihan = input.nextInt();

        System.out.print("Masukkan jumlah pembayaran: ");
        double jumlah = input.nextDouble();
        // polymorphism: objek pembayaran dapat merujuk ke berbagai jenis pembayaran
        Pembayaran pembayaran;
        // memilih jenis pembayaran berdasarkan input pengguna
        if (pilihan == 1) {
            pembayaran = new CreditCard();
        } 
        else if (pilihan == 2) {
            pembayaran = new EWallet();
        } 
        else {
            pembayaran = new Transfer();
        }
        // memanggil metode bayar() yang sesuai dengan jenis pembayaran yang dipilih
        pembayaran.bayar(jumlah);

        input.close();
    }
}
