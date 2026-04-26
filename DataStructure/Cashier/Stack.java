package Cashier;

public class Stack {
    private Pelanggan top;
    private int size;

    public Stack() {
        top  = null;
        size = 0;
    }

    // Push - simpan transaksi selesai
    public void push(Pelanggan pelanggan) {
        pelanggan.prev = top;
        top            = pelanggan;
        size++;
    }

    // Tampilkan riwayat (LIFO - terbaru di atas)
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        Pelanggan current = top;
        int urutan = 1;
        while (current != null) {
            System.out.printf("%d. [%s] %s - Rp%.0f%n",
                urutan, current.nomorAntrian,
                current.namaPelanggan, current.totalBelanja);
            current = current.prev;
            urutan++;
        }
        System.out.println("Total transaksi: " + size);
    }

    public boolean isEmpty() { return size == 0; }
}