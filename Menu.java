public class Menu {
    private int id;
    private String nama;
    private double harga;
    private int stok;

    public Menu(int id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
        } else {
            System.out.println("⚠️ Stok tidak cukup untuk " + nama);
        }
    }

    public void tampilkanMenu() {
        System.out.printf("%d. %-20s Rp%.0f | Stok: %d\n", id, nama, harga, stok);
    }
}
