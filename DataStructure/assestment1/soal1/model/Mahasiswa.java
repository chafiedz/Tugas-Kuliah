// deklarasi package untuk Mahasiswa
package assestment1.soal1.model;
// kelas Mahasiswa dengan atribut nama, nim, jurusan, dan ipk
public class Mahasiswa {
    String nama;
    String nim;
    String jurusan;
    double ipk;

    // Constructor untuk inisialisasi data
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK     : " + ipk);
        System.out.println("---------------------------");
    }
}