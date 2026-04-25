package perpustakaan;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Push - Tambah buku di akhir
    public void tambahBuku(String kodeBuku, String judul, String penulis) {
        if (kodeBuku.length() > 5) {
            System.out.println("Kode Buku maksimal 5 karakter!");
            return;
        }

        Node newNode = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Data berhasil ditambahkan!");
    }

    // Pop - Hapus buku terakhir
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (size <= 5) {
            System.out.println("Tidak dapat menghapus! Minimal harus ada 5 buku dalam daftar.");
            return;
        }

        if (head.next == null) {
            System.out.println("Buku '" + head.judul + "' berhasil dihapus.");
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku '" + current.next.judul + "' berhasil dihapus.");
            current.next = null;
        }
        size--;
    }

    // Cari buku berdasarkan kodeBuku
    public void cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode   : " + current.kodeBuku);
                System.out.println("Judul  : " + current.judul);
                System.out.println("Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // Tampilkan semua buku
    public void tampilkanSemuaBuku() {
        if (head == null) {
            System.out.println("Daftar buku kosong.");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku +
                               " | Judul: " + current.judul +
                               " | Penulis: " + current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + size);
    }
}