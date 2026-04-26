package Cashier;

import java.util.Scanner;

public class Menu {
    private Queue antrian;
    private Stack riwayat;
    private Scanner scanner;

    public Menu() {
        antrian  = new Queue();
        riwayat  = new Stack();
        scanner  = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        System.out.println("\n=== SISTEM KASIR TOKO ===");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Layani Pelanggan");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Lihat Riwayat Transaksi");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    public void jalankan() {
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = scanner.nextDouble();
                    scanner.nextLine();
                    antrian.enqueue(nomor, nama, total);
                    break;

                case 2:
                    Pelanggan dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " +
                            dilayani.nomorAntrian + " (" + dilayani.namaPelanggan + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                    antrian.tampilkanAntrian();
                    break;

                case 4:
                    riwayat.tampilkanRiwayat();
                    break;

                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}