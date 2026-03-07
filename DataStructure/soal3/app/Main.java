package assestment1.soal3.app;
import assestment1.soal3.model.Mahasiswa;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Mahasiswa[] daftar = new Mahasiswa[3];

        // Input data mahasiswa
        for (int i = 0; i < daftar.length; i++) {

            System.out.println("Data Mahasiswa ke-" + (i + 1));

            System.out.print("Nama: ");
            String nama = input.nextLine();

            System.out.print("NIM: ");
            String nim = input.nextLine();

            System.out.print("Jurusan: ");
            String jurusan = input.nextLine();

            System.out.print("IPK: ");
            double ipk = input.nextDouble();
            input.nextLine(); // membersihkan newline

            daftar[i] = new Mahasiswa(nama, nim, jurusan, ipk);
            System.out.println();
        }

        // Menampilkan seluruh data mahasiswa
        System.out.println("\n=== DATA MAHASISWA ===");
        for (Mahasiswa m : daftar) {
            m.tampilkanInfo();
        }
    }
}