package assestment1.soal3.model;

// Kelas Mahasiswa untuk menyimpan data mahasiswa dan melakukan operasi terkait
public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    // Constructor untuk inisialisasi data mahasiswa
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter untuk ipk
    public double getIpk() {
        return ipk;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Update IPK
    public void updateIpk(double ipkBaru) {
        this.ipk = ipkBaru;
    }

    // Update nama
    public void updateNama(String namaBaru) {
        this.nama = namaBaru;
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