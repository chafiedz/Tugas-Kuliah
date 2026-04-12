import java.util.Random;

public class Comparison {

    // Ukuran data yang akan diu — dimulai dari 1000 elemen 
    private static final int[] DATA_SIZES = { 1000, 2000, 5000, 7000, 11000 };

    private static final String GARIS_TEBAL = "=".repeat(50);
    private static final String GARIS_TIPIS = "-".repeat(50);

    // =========================================================================
    // MAIN Method
    // =========================================================================
    public static void main(String[] args) {
        tampilkanDemoFungsional();
        tampilkanBenchmark();
    }

    // =========================================================================
    // BAGIAN 1 — Demo fungsional dengan data kecil (8 elemen)
    // Menunjukkan traversal, pencarian, penyisipan, penghapusan
    // =========================================================================
    private static void tampilkanDemoFungsional() {
        int[] data = { 64, 25, 12, 22, 11, 90, 45, 78 };

        // ── ArrayOperations ──────────────────────────────────────────────────
        System.out.println("\n" + GARIS_TEBAL);
        System.out.println("  DEMO — ArrayOperations");
        System.out.println(GARIS_TEBAL);

        ArrayOperations ao = new ArrayOperations(20);
        for (int v : data)
            ao.append(v);

        System.out.println("\n  [1] TRAVERSAL — isi array awal:");
        ao.traversal();

        System.out.println("\n  [2] PENYISIPAN — insert(5, 93):");
        ao.insert(5, 93);
        ao.traversal();

        System.out.println("\n  [3] PENCARIAN LINEAR — linearSearch(45):");
        long t1 = System.nanoTime();
        int li = ao.linearSearch(45);
        long t2 = System.nanoTime();
        System.out.println("      Ditemukan di indeks : " + li);
        System.out.println("      Waktu eksekusi      : " + (t2 - t1) + " ns");

        System.out.println("\n  [4] SORTING sebelum Binary Search:");
        ao.sort();
        ao.traversal();

        System.out.println("\n  [5] PENCARIAN BINARY — binarySearch(45):");
        long t3 = System.nanoTime();
        int bi = ao.binarySearch(45);
        long t4 = System.nanoTime();
        System.out.println("      Ditemukan di indeks ke : " + bi);
        System.out.println("      Waktu eksekusi      : " + (t4 - t3) + " ns");

        System.out.println("\n  [6] PENGHAPUSAN — delete(99):");
        ao.delete(99);
        ao.traversal();

        // ── ArrayListOperations ───────────────────────────────────────────────
        System.out.println("\n" + GARIS_TEBAL);
        System.out.println("  DEMO — ArrayListOperations");
        System.out.println(GARIS_TEBAL);

        ArrayListOperations al = new ArrayListOperations();
        for (int v : data)
            al.add(v);

        System.out.println("\n  [1] TRAVERSAL — isi ArrayList awal:");
        al.traversal();

        System.out.println("\n  [2] PENYISIPAN — addAt(5, 93):");
        al.addAt(5, 93);
        al.traversal();

        System.out.println("\n  [3] PENCARIAN — search(45):");
        long t5 = System.nanoTime();
        int si = al.search(45);
        long t6 = System.nanoTime();
        System.out.println("      Ditemukan di indeks : " + si);
        System.out.println("      Waktu eksekusi      : " + (t6 - t5) + " ns");

        System.out.println("\n  [4] SORTING — Collections.sort():");
        al.sort();
        al.traversal();

        System.out.println("\n  [5] PENGHAPUSAN — remove(99):");
        al.remove(99);
        al.traversal();
    }

    // =========================================================================
    // BAGIAN 2 — Benchmark perbandingan execution time
    // Menggunakan System.nanoTime() untuk setiap operasi
    // =========================================================================
    private static void tampilkanBenchmark() {

        cetakJudul("TABEL PERBANDINGAN WAKTU EKSEKUSI — PENYISIPAN DI TENGAH");
        cetakHeaderTabel("Array  insert() + arraycopy", "ArrayList  addAt()");
        for (int n : DATA_SIZES)
            cetakBarisTabel(n, ukurArrayInsert(n), ukurArrayListInsert(n));

        cetakJudul("TABEL PERBANDINGAN WAKTU EKSEKUSI — PENGHAPUSAN");
        cetakHeaderTabel("Array  delete() + arraycopy", "ArrayList  remove()");
        for (int n : DATA_SIZES)
            cetakBarisTabel(n, ukurArrayDelete(n), ukurArrayListDelete(n));

        cetakJudul("TABEL PERBANDINGAN WAKTU EKSEKUSI — LINEAR SEARCH");
        cetakHeaderTabel("Array  linearSearch()", "ArrayList  indexOf()");
        for (int n : DATA_SIZES)
            cetakBarisTabel(n, ukurArrayLinear(n), ukurArrayListLinear(n));

        cetakJudul("TABEL PERBANDINGAN — BINARY SEARCH vs LINEAR SEARCH");
        cetakHeaderTabel("Array  binarySearch()", "ArrayList  indexOf()");
        for (int n : DATA_SIZES)
            cetakBarisTabel(n, ukurArrayBinary(n), ukurArrayListLinear(n));

        cetakJudul("TABEL PERBANDINGAN WAKTU EKSEKUSI — SORTING");
        cetakHeaderTabel("Array  BubbleSort  O(n²)", "ArrayList  TimSort  O(n log n)");
        for (int n : DATA_SIZES)
            cetakBarisTabel(n, ukurArraySort(n), ukurArrayListSort(n));

        // ── Tabel Kompleksitas Algoritma ──────────────────────────────────────
        System.out.println("\n" + GARIS_TEBAL);
        System.out.println("  RINGKASAN KOMPLEKSITAS ALGORITMA");
        System.out.println(GARIS_TEBAL);
        System.out.printf("  %-28s  %-18s  %-18s%n",
                "Operasi", "Array", "ArrayList");
        System.out.println("  " + GARIS_TIPIS);
        Object[][] kompleksitas = {
                { "Akses by index", "O(1)", "O(1)" },
                { "Append (tambah akhir)", "O(1)*", "O(1)*" },
                { "Insert di tengah/awal", "O(n)", "O(n)" },
                { "Delete", "O(n)", "O(n)" },
                { "Linear Search", "O(n)", "O(n)" },
                { "Binary Search", "O(log n)**", "O(log n)**" },
                { "Sort — BubbleSort", "O(n²)", "—" },
                { "Sort — TimSort", "—", "O(n log n)" },
                { "Resize kapasitas", "Manual", "Otomatis" },
        };
        for (Object[] r : kompleksitas)
            System.out.printf("  %-28s  %-18s  %-18s%n", r[0], r[1], r[2]);

        System.out.println("\n  *  amortized");
        System.out.println("  ** hanya berlaku jika data sudah terurut");
        System.out.println("\n" + GARIS_TEBAL);

        // ── Analisis Kesimpulan ───────────────────────────────────────────────
        System.out.println("\n" + GARIS_TEBAL);
        System.out.println("  ANALISIS & KESIMPULAN");
        System.out.println(GARIS_TEBAL);
        System.out.println();
        System.out.println("  1. PENYISIPAN & PENGHAPUSAN");
        System.out.println("     Array  : Menggunakan System.arraycopy() sehingga lebih efisien");
        System.out.println("              di tingkat memori, namun kapasitas tetap atau (fixed size).");
        System.out.println("     ArrayList : Lebih fleksibel karena resize otomatis (flexible), namun ada");
        System.out.println("              overhead boxing Integer dan reallokasi memori.");
        System.out.println();
        System.out.println("  2. PENCARIAN");
        System.out.println("     Linear Search  : Keduanya O(n), Array sedikit lebih cepat");
        System.out.println("                      karena akses nya langsung ke memori.");
        System.out.println("     Binary Search  : Jauh lebih cepat O(log n) vs O(n),");
        System.out.println("                      namun data harus diurutkan terlebih dahulu.");
        System.out.println();
        System.out.println("  3. SORTING");
        System.out.println("     BubbleSort O(n²) : Sangat lambat pada data besar (>5000 elemen).");
        System.out.println("     TimSort O(n log n): Collections.sort() jauh lebih efisien,");
        System.out.println("                         perbedaan makin nyata di 10.000-50.000 elemen.");
        System.out.println();
        System.out.println("  4. REKOMENDASI PENGGUNAAN");
        System.out.println("     Gunakan Array    : Ukuran data tetap, akses by-index cepat,");
        System.out.println("                        perfoma , dan binary search diperlukan.");
        System.out.println("     Gunakan ArrayList: Ukuran data dinamis, sering tambah/hapus,");
        System.out.println("                        kemudahan penggunaan lebih diutamakan.");
        System.out.println(GARIS_TEBAL + "\n");
    }

    // =========================================================================
    // BENCHMARK HELPERS — menggunakan System.nanoTime()
    // =========================================================================

    // Setiap method ini akan mengukur waktu eksekusi untuk operasi tertentu pada ukuran data n
    private static long ukurArrayInsert(int n) {
        ArrayOperations ao = new ArrayOperations(n + 1);
        for (int v : acak(n))
            ao.append(v);
        long t = System.nanoTime();
        ao.insert(n / 2, 99999); // sisipkan di tengah
        return System.nanoTime() - t;
    }

    // Untuk delete, kita hapus elemen yang ada di tengah agar pergeseran maksimal
    private static long ukurArrayListInsert(int n) {
        ArrayListOperations al = new ArrayListOperations();
        for (int v : acak(n))
            al.add(v);
        long t = System.nanoTime();
        al.addAt(n / 2, 99999);
        return System.nanoTime() - t;
    }

    // Untuk delete, hapus elemen yang ada di tengah agar pergeseran maksimal
    private static long ukurArrayDelete(int n) {
        int[] d = acak(n);
        ArrayOperations ao = new ArrayOperations(n);
        for (int v : d)
            ao.append(v);
        long t = System.nanoTime();
        ao.delete(d[n / 2]);
        return System.nanoTime() - t;
    }

    // Untuk delete, hapus elemen yang ada di tengah agar pergeseran maksimal
    private static long ukurArrayListDelete(int n) {
        int[] d = acak(n);
        ArrayListOperations al = new ArrayListOperations();
        for (int v : d)
            al.add(v);
        long t = System.nanoTime();
        al.remove(d[n / 2]);
        return System.nanoTime() - t;
    }

    // Untuk linear search, cari elemen yang ada di akhir agar waktu eksekusi maksimal
    private static long ukurArrayLinear(int n) {
        int[] d = acak(n);
        ArrayOperations ao = new ArrayOperations(n);
        for (int v : d)
            ao.append(v);
        long t = System.nanoTime();
        ao.linearSearch(d[n - 1]); // worst-case: elemen terakhir
        return System.nanoTime() - t;
    }

    // Untuk linear search, cari elemen yang ada di akhir agar waktu eksekusi maksimal
    private static long ukurArrayListLinear(int n) {
        int[] d = acak(n);
        ArrayListOperations al = new ArrayListOperations();
        for (int v : d)
            al.add(v);
        long t = System.nanoTime();
        al.search(d[n - 1]); // worst-case: elemen terakhir
        return System.nanoTime() - t;
    }

    // Untuk binary search, harus mengurutkan data terlebih dahulu, lalu cari elemen yang ada di akhir agar waktu eksekusi maksimal
    private static long ukurArrayBinary(int n) {
        ArrayOperations ao = new ArrayOperations(n);
        for (int v : acak(n))
            ao.append(v);
        ao.sort();
        int target = ao.getRawArray()[n - 1];
        long t = System.nanoTime();
        ao.binarySearch(target);
        return System.nanoTime() - t;
    }

    // ArrayList tidak memiliki binary search built-in, jadi bandingkan dengan linear search untuk data yang sudah diurutkan
    private static long ukurArraySort(int n) {
        ArrayOperations ao = new ArrayOperations(n);
        for (int v : acak(n))
            ao.append(v);
        long t = System.nanoTime();
        ao.sort();
        return System.nanoTime() - t;
    }

    // ArrayList menggunakan Collections.sort() yang berbasis TimSort, jadi ukur waktu sorting nya langsung
    private static long ukurArrayListSort(int n) {
        ArrayListOperations al = new ArrayListOperations();
        for (int v : acak(n))
            al.add(v);
        long t = System.nanoTime();
        al.sort();
        return System.nanoTime() - t;
    }

    // =========================================================================
    // UTILITY
    // =========================================================================

    /** Generate array acak dengan seed tetap agar hasil konsisten */
    private static int[] acak(int n) {
        Random rnd = new Random(42);
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = rnd.nextInt(100_000);
        return d;
    }

    /** Format nanosecond ke ns / µs / ms yang mudah dibaca */
    private static String format(long ns) {
        if (ns < 1_000)
            return ns + " ns ";
        if (ns < 1_000_000)
            return String.format("%.2f us", ns / 1_000.0);
        return String.format("%.2f ms", ns / 1_000_000.0);
    }

    private static void cetakJudul(String judul) {
        System.out.println("\n" + GARIS_TEBAL);
        System.out.println("  " + judul);
        System.out.println(GARIS_TEBAL);
    }

    private static void cetakHeaderTabel(String kolom2, String kolom3) {
        System.out.printf("  %-14s  %-26s  %-26s  %s%n",
                "Ukuran Data", kolom2, kolom3, "Lebih Cepat");
        System.out.println("  " + GARIS_TIPIS);
    }

    private static void cetakBarisTabel(int n, long t1, long t2) {
        String menang = (t1 <= t2) ? "Array" : "ArrayList";
        System.out.printf("  %-14d  %-26s  %-26s  %s%n",
                n, format(t1), format(t2), menang);
    }
}