public class ArrayOperations {
    private int[] array;
    private int size;
    private int capacity;

    public ArrayOperations(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    // =========================================================================
    // TRAVERSAL — menampilkan seluruh isi array
    // =========================================================================
    public void traversal() {
        System.out.print("  [");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // =========================================================================
    // LINEAR SEARCH — O(n)
    // =========================================================================
    public int linearSearch(int target) {
        for (int i = 0; i < size; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }

    // =========================================================================
    // BINARY SEARCH — O(log n), array harus sudah berurutan
    // =========================================================================
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

    // =========================================================================
    // INSERT — penyisipan di indeks tertentu, O(n)
    // Menggunakan System.arraycopy() untuk efisiensi pergeseran elemen
    // =========================================================================
    public boolean insert(int index, int value) {
        if (size >= capacity) {
            System.out.println("  [!] Array sudah full!");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("  [!] Indeks tidak valid.");
            return false;
        }
        // Geser elemen ke kanan menggunakan arraycopy
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
        return true;
    }

    // =========================================================================
    // APPEND — tambah di akhir elemen, O(1)
    // =========================================================================
    public boolean append(int value) {
        return insert(size, value);
    }

    // =========================================================================
    // DELETE — hapus berdasarkan nilai, O(n)
    // Menggunakan System.arraycopy() untuk efisiensi pergeseran elemen
    // =========================================================================
    public boolean delete(int value) {
        int index = linearSearch(value);
        if (index == -1) {
            System.out.println("  [!] Nilai " + value + " tidak ditemukan.");
            return false;
        }
        // Geser elemen ke kiri menggunakan arraycopy
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return true;
    }

    // =========================================================================
    // SORT — bubble sorting, O(n²)
    // =========================================================================
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