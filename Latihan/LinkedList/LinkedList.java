import java.util.Scanner;

public class LinkedList {

    // ═══════════════════════════════════════
    // NODE CLASS
    // ═══════════════════════════════════════
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ═══════════════════════════════════════
    // LINKED LIST CLASS
    // ═══════════════════════════════════════
    static class SinglyLinkedList {
        Node head;
        int size;

        SinglyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // INSERT DI DEPAN — O(1)
        void insertDepan(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
            System.out.println("Inserted " + data + " di depan.");
        }

        // INSERT DI BELAKANG — O(n)
        void insertBelakang(int data) {
            Node newNode = new Node(data);
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
            System.out.println("Inserted " + data + " di belakang.");
        }

        // INSERT DI POSISI TERTENTU — O(n)
        void insertPosisi(int data, int posisi) {
            if (posisi < 0 || posisi > size) {
                System.out.println("Posisi tidak valid!");
                return;
            }
            if (posisi == 0) {
                insertDepan(data);
                return;
            }
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < posisi - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
            System.out.println("Inserted " + data + " di posisi " + posisi + ".");
        }

        // HAPUS DARI DEPAN — O(1)
        void hapusDepan() {
            if (head == null) {
                System.out.println("List kosong!");
                return;
            }
            System.out.println("Menghapus " + head.data + " dari depan.");
            head = head.next;
            size--;
        }

        // HAPUS DARI BELAKANG — O(n)
        void hapusBelakang() {
            if (head == null) {
                System.out.println("List kosong!");
                return;
            }
            if (head.next == null) {
                System.out.println("Menghapus " + head.data + " dari belakang.");
                head = null;
                size--;
                return;
            }
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Menghapus " + current.next.data + " dari belakang.");
            current.next = null;
            size--;
        }

        // HAPUS BERDASARKAN NILAI — O(n)
        void hapusNilai(int data) {
            if (head == null) {
                System.out.println("List kosong!");
                return;
            }
            if (head.data == data) {
                hapusDepan();
                return;
            }
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println(data + " tidak ditemukan!");
                return;
            }
            System.out.println("Menghapus nilai " + data + ".");
            current.next = current.next.next;
            size--;
        }

        // CARI NILAI — O(n)
        boolean cari(int data) {
            Node current = head;
            int index = 0;
            while (current != null) {
                if (current.data == data) {
                    System.out.println(data + " ditemukan di indeks " + index + ".");
                    return true;
                }
                current = current.next;
                index++;
            }
            System.out.println(data + " tidak ditemukan.");
            return false;
        }

        // TAMPILKAN LIST — O(n)
        void tampilkan() {
            if (head == null) {
                System.out.println("List kosong.");
                return;
            }
            System.out.print("List [size=" + size + "]: HEAD -> ");
            Node current = head;
            while (current != null) {
                System.out.print("[" + current.data + "]");
                if (current.next != null)
                    System.out.print(" -> ");
                current = current.next;
            }
            System.out.println(" -> NULL");
        }

        // BALIK LIST — O(n)
        void balikList() {
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
            System.out.println("List berhasil dibalik.");
        }
    }

    // ═══════════════════════════════════════
    // MAIN METHOD
    // ═══════════════════════════════════════
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int pilihan, nilai, posisi;

        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║       MENU LINKED LIST       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Insert di Depan           ║");
            System.out.println("║ 2. Insert di Belakang        ║");
            System.out.println("║ 3. Insert di Posisi          ║");
            System.out.println("║ 4. Hapus dari Depan          ║");
            System.out.println("║ 5. Hapus dari Belakang       ║");
            System.out.println("║ 6. Hapus berdasarkan Nilai   ║");
            System.out.println("║ 7. Cari Nilai                ║");
            System.out.println("║ 8. Tampilkan List            ║");
            System.out.println("║ 9. Balik List                ║");
            System.out.println("║ 0. Keluar                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nilai: ");
                    nilai = scanner.nextInt();
                    list.insertDepan(nilai);
                    list.tampilkan();
                    break;
                case 2:
                    System.out.print("Masukkan nilai: ");
                    nilai = scanner.nextInt();
                    list.insertBelakang(nilai);
                    list.tampilkan();
                    break;
                case 3:
                    System.out.print("Masukkan nilai: ");
                    nilai = scanner.nextInt();
                    System.out.print("Masukkan posisi (0 - " + list.size + "): ");
                    posisi = scanner.nextInt();
                    list.insertPosisi(nilai, posisi);
                    list.tampilkan();
                    break;
                case 4:
                    list.hapusDepan();
                    list.tampilkan();
                    break;
                case 5:
                    list.hapusBelakang();
                    list.tampilkan();
                    break;
                case 6:
                    System.out.print("Masukkan nilai yang dihapus: ");
                    nilai = scanner.nextInt();
                    list.hapusNilai(nilai);
                    list.tampilkan();
                    break;
                case 7:
                    System.out.print("Masukkan nilai yang dicari: ");
                    nilai = scanner.nextInt();
                    list.cari(nilai);
                    break;
                case 8:
                    list.tampilkan();
                    break;
                case 9:
                    list.balikList();
                    list.tampilkan();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}