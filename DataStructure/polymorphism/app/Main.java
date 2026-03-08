package Kuliah.polymorphism.app;

import Kuliah.polymorphism.payment.*;
import java.util.Scanner;

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

        Pembayaran pembayaran;

        if (pilihan == 1) {
            pembayaran = new CreditCard();
        } 
        else if (pilihan == 2) {
            pembayaran = new EWallet();
        } 
        else {
            pembayaran = new Transfer();
        }

        pembayaran.bayar(jumlah);

        input.close();
    }
}