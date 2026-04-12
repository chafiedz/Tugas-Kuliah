import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    private ArrayList<Integer> list;

    public ArrayListOperations() {
        this.list = new ArrayList<>();
    }

    // =========================================================================
    // ADD — tambah elemen di akhir array, O(1) amortized
    // =========================================================================
    public void add(int value) {
        list.add(value);
    }

    // =========================================================================
    // ADD AT — tambah elemen di indeks tertentu array, O(n)
    // =========================================================================
    public void addAt(int index, int value) {
        list.add(index, value);
    }

    // =========================================================================
    // REMOVE — hapus elemen berdasarkan nilai, O(n)
    // =========================================================================
    public boolean remove(int value) {
        return list.remove(Integer.valueOf(value));
    }

    // =========================================================================
    // SEARCH — pencarian elemen dengan indexOf, O(n)
    // =========================================================================
    public int search(int value) {
        return list.indexOf(value);
    }

    // =========================================================================
    // SORTING — menggunakan Collections.sort() berbasis TimSort, O(n log n)
    // =========================================================================
    public void sort() {
        Collections.sort(list);
    }

    // =========================================================================
    // traversal — tampilkan isi ArrayList
    // =========================================================================
    public void traversal() {
        System.out.println("  " + list);
    }

    public int getSize() {
        return list.size();
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}