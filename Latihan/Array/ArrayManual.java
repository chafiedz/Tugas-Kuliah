package Latihan.Array;

public class ArrayManual {

    public static void main(String[] args) {

        int[] nilai = new int[5];

        nilai[0] = 75;
        nilai[1] = 70;
        nilai[2] = 95;
        nilai[3] = 64;
        nilai[4] = 85;

        System.out.println("Isi array:");

        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Index " + i + " = " + nilai[i]);
        }

        int total = 0;

        for (int i = 0; i < nilai.length; i++) {
            total = total + nilai[i];
        }

        double rataRata = (double) total / nilai.length;

        System.out.println("Total nilai: " + total);
        System.out.println("Rata-rata: " + rataRata);

        int cari = 90;
        boolean ditemukan = false;

        for (int i = 0; i < nilai.length; i++) {
            if (nilai[i] == cari) {
                ditemukan = true;
                System.out.println("Nilai ditemukan di index: " + i);
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Nilai tidak ditemukan");
        }
    }
}