// ❌ LAMA: satu class menanggung segalanya
class OrderSystem {
    static String[] orderIds, customerIds, statuses;
    static void createOrder(...) { ... }
    static void searchOrder(...) { ... }
    static void updateStatus(...) { ... }
    static void addProduct(...) { ... }
    // ratusan baris dalam satu file
}

// ✅ BARU: setiap class punya tanggung jawab tunggal
// --- Domain entities ---
class Customer    { private String id, name, email; ... }
class Product     { private String id, name; private double price; ... }
enum  OrderStatus { CREATED, PAID, SHIPPED, COMPLETED }