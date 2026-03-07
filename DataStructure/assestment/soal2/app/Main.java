package assestment.soal2.app;
import java.util.Scanner;

import assestment.soal2.model.Mahasiswa;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Mahasiswa m1 = new Mahasiswa("Budi", "101", "Informatika", 2.8);

        m1.tampilkanInfo();
        m1.cekKelulusan();

        System.out.print("Masukkan IPK baru: ");
        double ipkBaru = input.nextDouble();

        m1.updateIpk(ipkBaru);

        System.out.println("\nSetelah Update:");
        m1.tampilkanInfo();
        m1.cekKelulusan();
    }
}