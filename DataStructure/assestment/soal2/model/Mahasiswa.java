package assestment.soal2.model;

public class Mahasiswa {

    private String nama;
    private String nim;
    private String jurusan;
    private double ipk; // encapsulation

    // Constructor
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter IPK
    public double getIpk() {
        return ipk;
    }

    // Setter IPK
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Method update IPK
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }

    // Method cek kelulusan
    public void cekKelulusan() {
        if (ipk >= 3.00) {
            System.out.println("Status : Lulus");
        } else {
            System.out.println("Status : Belum Lulus");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        System.out.println("IPK  : " + ipk);
    }
}