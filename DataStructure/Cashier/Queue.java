package Cashier;

public class Queue {
    private Pelanggan head;
    private Pelanggan tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Enqueue - tambah pelanggan di belakang
    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Pelanggan newNode = new Pelanggan(nomorAntrian, namaPelanggan, totalBelanja);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail      = newNode;
        }
        size++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    // Dequeue - ambil pelanggan dari depan
    public Pelanggan dequeue() {
        if (head == null) {
            System.out.println("Antrian kosong!");
            return null;
        }

        if (size < 5) {
            System.out.println("Tidak dapat melayani! Minimal harus ada 5 pelanggan dalam antrian.");
            return null;
        }

        Pelanggan dilayani = head;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return dilayani;
    }

    // Tampilkan antrian
    public void tampilkanAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian Pelanggan saat ini:");
        Pelanggan current = head;
        int urutan = 1;
        while (current != null) {
            System.out.printf("%d. [%s] %s - Rp%.0f%n",
                urutan, current.nomorAntrian,
                current.namaPelanggan, current.totalBelanja);
            current = current.next;
            urutan++;
        }
        System.out.println("Total antrian: " + size);
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
}