package Lab.personal;

public class Array {
    private int[] array;
    private int size;
    private int capacity;

    public Array(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    // Traversal: menampilkan isi array
    public void traverse() {
        System.out.print("Array [" + size + " elemen]: [");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Linear Search: O(n)
    public int linearSearch(int target) {
        for (int i = 0; i < size; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search: O(log n) — array harus sudah terurut
    public int binarySearch(int target) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Penyisipan di indeks tertentu: O(n)
    public boolean insert(int index, int value) {
        if (size >= capacity) {
            System.out.println("Array penuh! Tidak dapat menyisipkan.");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid.");
            return false;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
        return true;
    }

    // Tambah di akhir: O(1)
    public boolean append(int value) {
        return insert(size, value);
    }

    // Penghapusan berdasarkan nilai: O(n)
    public boolean delete(int value) {
        int index = linearSearch(value);
        if (index == -1) {
            System.out.println("Nilai " + value + " tidak ditemukan.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    // Sorting (bubble sort) — diperlukan sebelum binary search
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int[] getRawArray() {
        int[] result = new int[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }
}
