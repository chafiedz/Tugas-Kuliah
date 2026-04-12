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

        // INSERT DI DEPAN
        void insertDepan(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            size++;
            System.out.println("Inserted " + data + " di depan.");
        }

        // INSERT DI BELAKANG
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

        // INSERT DI POSISI TERTENTU
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

        // CARI NILAI
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

        // TAMPILKAN LIST
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

        // BALIK LIST 
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
        int pilihan, nilai;

        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║       MENU LINKED LIST       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Insert di Depan           ║");
            System.out.println("║ 2. Insert di Belakang        ║");
            System.out.println("║ 3. Tampilkan List            ║");
            System.out.println("║ 4. Balik List                ║");
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
                    list.tampilkan();
                    break;
                case 4:
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