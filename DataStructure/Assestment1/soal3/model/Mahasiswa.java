package Assestment1.soal3.model;

public class Mahasiswa {

    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    // Constructor untuk inisialisasi objek
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter
    public double getIpk() {
        return ipk;
    }

    // Update IPK
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }

    // Cek kelulusan
    public String cekKelulusan() {
        return (ipk >= 3.00) ? "Lulus" : "Belum Lulus";
    }

    // Hitung predikat akademik
    public String hitungPredikat() {
        if (ipk >= 3.75) {
            return "Cumlaude";
        } else if (ipk >= 3.50) {
            return "Sangat Memuaskan";
        } else if (ipk >= 3.00) {
            return "Memuaskan";
        } else {
            return "Cukup";
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama     : " + nama);
        System.out.println("NIM      : " + nim);
        System.out.println("Jurusan  : " + jurusan);
        System.out.println("IPK      : " + ipk);
        System.out.println("Status   : " + cekKelulusan());
        System.out.println("Predikat : " + hitungPredikat());
        System.out.println("---------------------------");
    }
}