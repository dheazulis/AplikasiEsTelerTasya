import java.util.ArrayList;

public class Transaksi {
    private ArrayList<Menu> daftarPesanan;
    private ArrayList<Integer> jumlahPesanan;
    private double totalHarga;

    public Transaksi() {
        daftarPesanan = new ArrayList<>();
        jumlahPesanan = new ArrayList<>();
        totalHarga = 0;
    }

    public void tambahPesanan(Menu menu, int jumlah) {
        daftarPesanan.add(menu);
        jumlahPesanan.add(jumlah);
        menu.kurangiStok(jumlah);
    }

    public void hitungTotal() {
        totalHarga = 0;
        for (int i = 0; i < daftarPesanan.size(); i++) {
            totalHarga += daftarPesanan.get(i).getHarga() * jumlahPesanan.get(i);
        }
    }

    public void tampilkanTransaksi() {
        System.out.println("\n========== STRUK PEMBELIAN ==========");
        for (int i = 0; i < daftarPesanan.size(); i++) {
            Menu m = daftarPesanan.get(i);
            int jumlah = jumlahPesanan.get(i);
            System.out.printf("%-20s x%d  = Rp%.0f\n", m.getNama(), jumlah, m.getHarga() * jumlah);
        }
        System.out.println("-------------------------------------");
        System.out.printf("Total Pembayaran: Rp%.0f\n", totalHarga);
        System.out.println("=====================================\n");
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}
