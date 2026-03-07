// deklarasi package untuk aplikasi utama
package assestment1.soal1.app;
// importing Mahasiswa class dari package model
import assestment1.soal1.model.Mahasiswa;

// kelas utama untuk menjalankan aplikasi
public class Main {
    // metode utama yang dieksekusi saat program dijalankan
    public static void main(String[] args) { //
        // Membuat objek Mahasiswa dengan data yang berbeda
        Mahasiswa data1 = new Mahasiswa("Chafiedz", "101", "Informatika", 3.7);
        Mahasiswa data2 = new Mahasiswa("Renata", "102", "Sistem Informasi", 2.9);
        Mahasiswa data3 = new Mahasiswa("Farhan", "103", "Teknik Komputer", 3.2);
        Mahasiswa data4 = new Mahasiswa("Jessy", "104", "Informatika", 3.8);
        Mahasiswa data5 = new Mahasiswa("Doni", "105", "Sistem Informasi", 2.7);
        // Menampilkan informasi setiap mahasiswa
        data1.tampilkanInfo();
        data2.tampilkanInfo();
        data3.tampilkanInfo();
        data4.tampilkanInfo();
        data5.tampilkanInfo();
    }
}