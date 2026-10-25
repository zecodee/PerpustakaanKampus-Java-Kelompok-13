/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import controller.PerpustakaanController;
import util.InputUtil;

/**
 *
 * @author zefrialrizkullah
 */

public class Main {

    public static void main(String[] args) {
        PerpustakaanController perpustakaan = new PerpustakaanController();

        int pilihan;

        do {
            System.out.println();
            System.out.println("========================================");
            System.out.println("  SISTEM MANAJEMEN PERPUSTAKAAN KAMPUS  ");
            System.out.println("========================================");

            System.out.println(
                "1. Kelola Data Buku"
            );

            System.out.println(
                "2. Lihat Kategori Buku"
            );

            System.out.println(
                "3. Lihat Lokasi Buku"
            );

            System.out.println(
                "4. Antrean dan Peminjaman"
            );

            System.out.println(
                "5. Riwayat Transaksi"
            );

            System.out.println(
                "6. Statistik Peminjaman"
            );

            System.out.println(
                "0. Keluar"
            );

            pilihan = InputUtil.inputAngka(
                "Pilih menu: ",
                0,
                6
            );

            switch (pilihan) {

                case 1:
                    perpustakaan.menuBuku();
                    break;

                case 2:
                    perpustakaan.tampilKategori();
                    break;

                case 3:
                    perpustakaan.tampilLokasiBuku();
                    break;

                case 4:
                    perpustakaan.menuAntrean();
                    break;

                case 5:
                    perpustakaan.menuTransaksi();
                    break;

                case 6:
                    perpustakaan.tampilStatistik();
                    break;

                case 0:
                    System.out.println(
                        "Program selesai. Terima kasih."
                    );
                    break;
            }

        } while (pilihan != 0);
    }
}