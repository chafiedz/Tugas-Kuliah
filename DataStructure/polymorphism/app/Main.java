// package polymorphism.app;
package polymorphism.app;

import java.util.Scanner;
import polymorphism.payment.CreditCard;
import polymorphism.payment.EWallet;
import polymorphism.payment.Pembayaran;
import polymorphism.payment.Transfer;

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
        } else if (pilihan == 2) {
            pembayaran = new EWallet();
        } else {
            pembayaran = new Transfer();
        }

        pembayaran.bayar(jumlah);

        input.close();
    }
}