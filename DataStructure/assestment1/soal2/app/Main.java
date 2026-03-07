// deklarasi package untuk Main
package assestment1.soal2.app;
// import Scanner untuk input dari user
import java.util.Scanner;
// import kelas Mahasiswa dari package soal2.model
import assestment1.soal2.model.Mahasiswa;

public class Main {
    // method main sebagai titik awal program
    public static void main(String[] args) {
        
        // membuat objek Scanner untuk membaca input dari user
        Scanner input = new Scanner(System.in);

        // membuat objek Mahasiswa dengan data awal sebelum diupdate
        Mahasiswa m1 = new Mahasiswa("Chafiedz", "101", "Informatika", 2.8);
        Mahasiswa m2 = new Mahasiswa("Daffa", "102", "Informatika", 3.5);
        Mahasiswa m3 = new Mahasiswa("Rizky", "103", "Informatika", 2.5);

        Mahasiswa[] daftar = {m1, m2, m3};

        // Input NIM mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
        String nimCari = input.nextLine();
        boolean ditemukan = false;
        
        for (Mahasiswa mhs : daftar) {
            if (mhs.getNim().equals(nimCari)) {

                System.out.print("Masukkan IPK baru: ");
                double ipkBaru = input.nextDouble();

                mhs.updateIpk(ipkBaru);

                System.out.println("Data berhasil diperbarui!\n");

                System.out.println("=== Data Mahasiswa ===");
                mhs.tampilkanInfo();

                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }

        input.close();
    }
        
}