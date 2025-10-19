import java.util.ArrayList;
import java.util.Scanner;

public class EsTelerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Daftar menu awal
        ArrayList<Menu> daftarMenu = new ArrayList<>();
        daftarMenu.add(new Menu(1, "Es Teler Original", 12000, 10));
        daftarMenu.add(new Menu(2, "Es Alpukat Kocok", 15000, 8));
        daftarMenu.add(new Menu(3, "Es Campur Creamy", 13000, 10));
        daftarMenu.add(new Menu(4, "Es Nangka Susu", 11000, 6));

        ArrayList<Transaksi> riwayatTransaksi = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("\n===== APLIKASI KASIR ES TELER CREAMY TASYA =====");
            System.out.println("1. Lihat Daftar Menu");
            System.out.println("2. Tambah Transaksi");
            System.out.println("3. Lihat Laporan Penjualan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Daftar Menu ---");
                    for (Menu m : daftarMenu) {
                        m.tampilkanMenu();
                    }
                    break;

                case 2:
                    Transaksi transaksi = new Transaksi();
                    char lanjut;
                    do {
                        System.out.println("\n--- Pilih Menu yang Dipesan ---");
                        for (Menu m : daftarMenu) {
                            m.tampilkanMenu();
                        }

                        System.out.print("Masukkan ID menu: ");
                        int id = input.nextInt();
                        System.out.print("Jumlah porsi: ");
                        int jumlah = input.nextInt();

                        if (id > 0 && id <= daftarMenu.size()) {
                            transaksi.tambahPesanan(daftarMenu.get(id - 1), jumlah);
                        } else {
                            System.out.println("ID menu tidak valid!");
                        }

                        System.out.print("Tambah pesanan lagi? (y/n): ");
                        lanjut = input.next().charAt(0);
                    } while (lanjut == 'y' || lanjut == 'Y');

                    transaksi.hitungTotal();
                    transaksi.tampilkanTransaksi();
                    riwayatTransaksi.add(transaksi);
                    break;

                case 3:
                    System.out.println("\n===== LAPORAN PENJUALAN HARIAN =====");
                    double totalPendapatan = 0;
                    int no = 1;
                    for (Transaksi t : riwayatTransaksi) {
                        System.out.printf("Transaksi #%d - Total: Rp%.0f\n", no++, t.getTotalHarga());
                        totalPendapatan += t.getTotalHarga();
                    }
                    System.out.println("-------------------------------------");
                    System.out.printf("Total Pendapatan Hari Ini: Rp%.0f\n", totalPendapatan);
                    break;

                case 0:
                    System.out.println("\nTerima kasih telah menggunakan aplikasi!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        input.close();
    }
}
