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
        Mahasiswa m1 = new Mahasiswa("Budi", "101", "Informatika", 2.8);

        // menampilkan informasi mahasiswa dan status kelulusan sebelum update
        m1.tampilkanInfo();
        m1.cekKelulusan();
        // meminta user untuk memasukkan IPK baru
        System.out.print("Masukkan IPK baru: ");
        // membaca input IPK baru dari user
        double ipkBaru = input.nextDouble();

        // mengupdate IPK mahasiswa dengan nilai baru yang dimasukkan
        m1.updateIpk(ipkBaru);

        // menampilkan informasi mahasiswa dan status kelulusan setelah update
        System.out.println("\nSetelah Update:");
        m1.tampilkanInfo();
        m1.cekKelulusan();
    }
}