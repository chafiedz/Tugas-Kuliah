package assestment1.soal1.app;
import assestment1.soal1.model.Mahasiswa;

public class Main {
    public static void main(String[] args) {

        Mahasiswa data1 = new Mahasiswa("Budi", "101", "Informatika", 3.5);
        Mahasiswa data2 = new Mahasiswa("Siti", "102", "Sistem Informasi", 2.9);
        Mahasiswa data3 = new Mahasiswa("Andi", "103", "Teknik Komputer", 3.2);
        Mahasiswa data4 = new Mahasiswa("Rina", "104", "Informatika", 3.8);
        Mahasiswa data5 = new Mahasiswa("Doni", "105", "Sistem Informasi", 2.7);

        data1.tampilkanInfo();
        data2.tampilkanInfo();
        data3.tampilkanInfo();
        data4.tampilkanInfo();
        data5.tampilkanInfo();
    }
}