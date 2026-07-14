package perpustakaan;

import java.util.Scanner;

public class Menu {
    private LinkedList daftarBuku;
    private Scanner scanner;

    public Menu() {
        daftarBuku = new LinkedList();
        scanner    = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        System.out.println("\n===== SISTEM DATA BUKU =====");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Lihat Semua Buku");
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
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    break;

                case 2:
                    daftarBuku.hapusBuku();
                    break;

                case 3:
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String kodeCari = scanner.nextLine();
                    daftarBuku.cariBuku(kodeCari);
                    break;

                case 4:
                    daftarBuku.tampilkanSemuaBuku();
                    break;

                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}