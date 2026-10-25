/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import model.Buku;
import model.Transaksi;
import util.InputUtil;

/**
 *
 * @author zefrialrizkullah
 */

public class PerpustakaanController {

    // ARRAY 1D
    private final String[] kategori = {
        "Pemrograman",
        "Matematika",
        "Jaringan Komputer",
        "Basis Data"
    };

    private final String[] hari = {
        "Senin",
        "Selasa",
        "Rabu",
        "Kamis",
        "Jumat",
        "Sabtu",
        "Minggu"
    };

    private final int[][] statistikPeminjaman = new int[kategori.length][hari.length];
    private final String[][][] lokasiBuku = new String[2][3][4];
    private final ArrayList<Buku> daftarBuku = new ArrayList<>();
    private final Stack<Transaksi> riwayatTransaksi = new Stack<>();
    private final Queue<String> antreanMahasiswa = new LinkedList<>();

    public PerpustakaanController() {
        isiDataAwal();
    }

    private void isiDataAwal() {
        tambahDataAwal(
            new Buku(
                "B001",
                "Pemrograman Java",
                "Pemrograman",
                5,
                1, 1, 1
            )
        );

        tambahDataAwal(
            new Buku(
                "B002",
                "Matematika Diskrit",
                "Matematika",
                4,
                1, 1, 2
            )
        );

        tambahDataAwal(
            new Buku(
                "B003",
                "Jaringan Komputer Dasar",
                "Jaringan Komputer",
                3,
                1, 2, 1
            )
        );

        tambahDataAwal(
            new Buku(
                "B004",
                "Basis Data",
                "Basis Data",
                6,
                2, 1, 1
            )
        );
    }

    private void tambahDataAwal(Buku buku) {
        daftarBuku.add(buku);

        lokasiBuku
            [buku.getLantai() - 1]
            [buku.getRak() - 1]
            [buku.getPosisi() - 1] = buku.getId();
    }

    public void tampilKategori() {

        System.out.println("\n=== KATEGORI BUKU ===");

        for (int i = 0; i < kategori.length; i++) {
            System.out.println(
                (i + 1) + ". " + kategori[i]
            );
        }
    }

    private int pilihKategori() {

        tampilKategori();

        int pilihan = InputUtil.inputAngka(
            "Pilih kategori: ",
            1,
            kategori.length
        );

        return pilihan - 1;
    }

    private int cariIndeksKategori(String namaKategori) {

        for (int i = 0; i < kategori.length; i++) {

            if (kategori[i].equalsIgnoreCase(namaKategori)) {
                return i;
            }
        }

        return -1;
    }

    // =====================================================
    // ARRAYLIST BUKU
    // =====================================================

    public void menuBuku() {

        int pilihan;

        do {

            System.out.println("\n=== KELOLA BUKU ===");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Update Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("0. Kembali");

            pilihan = InputUtil.inputAngka(
                "Pilih menu: ",
                0,
                4
            );

            switch (pilihan) {
                case 1:
                    tampilBuku();
                    break;
                case 2:
                    tambahBuku();
                    break;
                case 3:
                    updateBuku();
                    break;
                case 4:
                    hapusBuku();
                    break;
                case 0:
                    break;
            }

        } while (pilihan != 0);
    }

    public void tampilBuku() {

        System.out.println("\n=== DAFTAR BUKU ===");

        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }

        for (Buku buku : daftarBuku) {
            System.out.println(buku);
        }
    }

    private Buku cariBuku(String id) {

        for (Buku buku : daftarBuku) {

            if (buku.getId().equalsIgnoreCase(id)) {
                return buku;
            }
        }

        return null;
    }

    private void tambahBuku() {

        System.out.println("\n=== TAMBAH BUKU ===");

        String id = InputUtil.inputIdBuku(
            "ID Buku: "
        );

        if (cariBuku(id) != null) {
            System.out.println(
                "ID buku sudah digunakan."
            );
            return;
        }

        String judul = InputUtil.inputTeks(
            "Judul buku: "
        );

        int indeksKategori = pilihKategori();

        int stok = InputUtil.inputAngka(
            "Stok buku: ",
            0,
            999
        );

        System.out.println("\nTentukan lokasi buku.");

        int lantai = InputUtil.inputAngka(
            "Lantai (1-2): ",
            1,
            2
        );

        int rak = InputUtil.inputAngka(
            "Rak (1-3): ",
            1,
            3
        );

        int posisi = InputUtil.inputAngka(
            "Posisi (1-4): ",
            1,
            4
        );

        if (lokasiBuku
                [lantai - 1]
                [rak - 1]
                [posisi - 1] != null) {

            System.out.println(
                "Lokasi tersebut sudah ditempati buku lain."
            );

            return;
        }

        Buku buku = new Buku(
            id,
            judul,
            kategori[indeksKategori],
            stok,
            lantai,
            rak,
            posisi
        );

        daftarBuku.add(buku);

        lokasiBuku
            [lantai - 1]
            [rak - 1]
            [posisi - 1] = id;

        System.out.println(
            "Buku berhasil ditambahkan."
        );
    }

    private void updateBuku() {

        System.out.println("\n=== UPDATE BUKU ===");

        tampilBuku();

        String id = InputUtil.inputIdBuku(
            "Masukkan ID buku: "
        );

        Buku buku = cariBuku(id);

        if (buku == null) {
            System.out.println(
                "Buku tidak ditemukan."
            );
            return;
        }

        System.out.println(
            "\nData saat ini:"
        );

        System.out.println(buku);

        String judulBaru = InputUtil.inputTeks(
            "Judul baru: "
        );

        int kategoriBaru = pilihKategori();

        int stokBaru = InputUtil.inputAngka(
            "Stok baru: ",
            0,
            999
        );

        System.out.println(
            "\nLokasi baru:"
        );

        int lantaiBaru = InputUtil.inputAngka(
            "Lantai (1-2): ",
            1,
            2
        );

        int rakBaru = InputUtil.inputAngka(
            "Rak (1-3): ",
            1,
            3
        );

        int posisiBaru = InputUtil.inputAngka(
            "Posisi (1-4): ",
            1,
            4
        );

        String isiLokasi =
            lokasiBuku
                [lantaiBaru - 1]
                [rakBaru - 1]
                [posisiBaru - 1];

        if (isiLokasi != null
                && !isiLokasi.equals(buku.getId())) {

            System.out.println(
                "Lokasi sudah ditempati buku lain."
            );

            return;
        }

        // Kosongkan lokasi lama
        lokasiBuku
            [buku.getLantai() - 1]
            [buku.getRak() - 1]
            [buku.getPosisi() - 1] = null;

        // Update data
        buku.setJudul(judulBaru);
        buku.setKategori(kategori[kategoriBaru]);
        buku.setStok(stokBaru);
        buku.setLantai(lantaiBaru);
        buku.setRak(rakBaru);
        buku.setPosisi(posisiBaru);

        // Isi lokasi baru
        lokasiBuku
            [lantaiBaru - 1]
            [rakBaru - 1]
            [posisiBaru - 1] = buku.getId();

        System.out.println(
            "Data buku berhasil diperbarui."
        );
    }

    private void hapusBuku() {

        System.out.println("\n=== HAPUS BUKU ===");

        tampilBuku();

        String id = InputUtil.inputIdBuku(
            "Masukkan ID buku: "
        );

        Buku buku = cariBuku(id);

        if (buku == null) {
            System.out.println(
                "Buku tidak ditemukan."
            );
            return;
        }

        lokasiBuku
            [buku.getLantai() - 1]
            [buku.getRak() - 1]
            [buku.getPosisi() - 1] = null;

        daftarBuku.remove(buku);

        System.out.println(
            "Buku berhasil dihapus."
        );
    }

    // =====================================================
    // ARRAY 3D
    // =====================================================

    public void tampilLokasiBuku() {

        System.out.println(
            "\n=== LOKASI PENYIMPANAN BUKU ==="
        );

        for (int lantai = 0;
             lantai < lokasiBuku.length;
             lantai++) {

            for (int rak = 0;
                 rak < lokasiBuku[lantai].length;
                 rak++) {

                for (int posisi = 0;
                     posisi < lokasiBuku[lantai][rak].length;
                     posisi++) {

                    String id =
                        lokasiBuku[lantai][rak][posisi];

                    System.out.print(
                        "Lantai " + (lantai + 1)
                        + " | Rak " + (rak + 1)
                        + " | Posisi " + (posisi + 1)
                        + " | "
                    );

                    if (id == null) {
                        System.out.println("KOSONG");
                    } else {

                        Buku buku = cariBuku(id);

                        if (buku != null) {
                            System.out.println(
                                id + " - " + buku.getJudul()
                            );
                        }
                    }
                }
            }
        }
    }

    // =====================================================
    // QUEUE
    // =====================================================

    public void menuAntrean() {

        int pilihan;

        do {

            System.out.println(
                "\n=== ANTREAN PEMINJAMAN ==="
            );

            System.out.println(
                "1. Tambah Mahasiswa ke Antrean"
            );

            System.out.println(
                "2. Tampilkan Antrean"
            );

            System.out.println(
                "3. Layani Mahasiswa"
            );

            System.out.println(
                "0. Kembali"
            );

            pilihan = InputUtil.inputAngka(
                "Pilih menu: ",
                0,
                3
            );

            switch (pilihan) {

                case 1:
                    tambahAntrean();
                    break;

                case 2:
                    tampilAntrean();
                    break;

                case 3:
                    layaniMahasiswa();
                    break;

                case 0:
                    break;
            }

        } while (pilihan != 0);
    }

    private void tambahAntrean() {

        String nama = InputUtil.inputNama(
            "Nama mahasiswa: "
        );

        for (String mahasiswa : antreanMahasiswa) {

            if (mahasiswa.equalsIgnoreCase(nama)) {
                System.out.println(
                    "Mahasiswa tersebut sudah berada dalam antrean."
                );
                return;
            }
        }

        antreanMahasiswa.offer(nama);

        System.out.println(
            nama + " berhasil masuk antrean."
        );
    }

    private void tampilAntrean() {

        System.out.println(
            "\n=== DAFTAR ANTREAN ==="
        );

        if (antreanMahasiswa.isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }

        int nomor = 1;

        for (String mahasiswa : antreanMahasiswa) {

            System.out.println(
                nomor + ". " + mahasiswa
            );

            nomor++;
        }
    }

    // =====================================================
    // PROSES PEMINJAMAN
    // QUEUE + ARRAYLIST + ARRAY 1D + ARRAY 2D
    // + ARRAY 3D + STACK
    // =====================================================

    private void layaniMahasiswa() {

        if (antreanMahasiswa.isEmpty()) {
            System.out.println(
                "Tidak ada mahasiswa dalam antrean."
            );
            return;
        }

        String mahasiswa = antreanMahasiswa.peek();

        System.out.println(
            "\nMahasiswa yang sedang dilayani: "
            + mahasiswa
        );

        tampilBuku();

        String idBuku = InputUtil.inputIdBuku(
            "Masukkan ID buku yang dipinjam: "
        );

        Buku buku = cariBuku(idBuku);

        if (buku == null) {
            System.out.println(
                "Buku tidak ditemukan. Mahasiswa tetap berada di antrean."
            );
            return;
        }

        if (buku.getStok() <= 0) {
            System.out.println(
                "Stok buku habis. Mahasiswa tetap berada di antrean."
            );
            return;
        }

        int indeksHari = pilihHari();

        int indeksKategori =
            cariIndeksKategori(buku.getKategori());

        if (indeksKategori == -1) {
            System.out.println(
                "Kategori buku tidak valid."
            );
            return;
        }

        System.out.println(
            "\nLokasi buku:"
        );

        System.out.println(
            "Lantai " + buku.getLantai()
            + ", Rak " + buku.getRak()
            + ", Posisi " + buku.getPosisi()
        );

        // Peminjaman berhasil
        buku.kurangiStok();

        statistikPeminjaman
            [indeksKategori]
            [indeksHari]++;

        Transaksi transaksi =
            new Transaksi(
                mahasiswa,
                buku.getId(),
                buku.getJudul(),
                buku.getKategori(),
                indeksKategori,
                indeksHari,
                hari[indeksHari]
            );

        riwayatTransaksi.push(transaksi);

        // Mahasiswa keluar dari antrean
        antreanMahasiswa.poll();

        System.out.println(
            "\nPeminjaman berhasil."
        );

        System.out.println(
            mahasiswa
            + " meminjam "
            + buku.getJudul()
        );

        System.out.println(
            "Sisa stok: " + buku.getStok()
        );
    }

    private int pilihHari() {

        System.out.println("\n=== PILIH HARI ===");

        for (int i = 0; i < hari.length; i++) {
            System.out.println(
                (i + 1) + ". " + hari[i]
            );
        }

        int pilihan = InputUtil.inputAngka(
            "Pilih hari: ",
            1,
            hari.length
        );

        return pilihan - 1;
    }

    // =====================================================
    // STACK
    // =====================================================

    public void menuTransaksi() {

        int pilihan;

        do {

            System.out.println(
                "\n=== RIWAYAT TRANSAKSI ==="
            );

            System.out.println(
                "1. Tampilkan Semua Transaksi"
            );

            System.out.println(
                "2. Lihat Transaksi Terakhir"
            );

            System.out.println(
                "3. Batalkan Transaksi Terakhir"
            );

            System.out.println(
                "0. Kembali"
            );

            pilihan = InputUtil.inputAngka(
                "Pilih menu: ",
                0,
                3
            );

            switch (pilihan) {

                case 1:
                    tampilTransaksi();
                    break;

                case 2:
                    transaksiTerakhir();
                    break;

                case 3:
                    batalkanTransaksi();
                    break;

                case 0:
                    break;
            }

        } while (pilihan != 0);
    }

    private void tampilTransaksi() {

        System.out.println(
            "\n=== RIWAYAT TRANSAKSI ==="
        );

        if (riwayatTransaksi.isEmpty()) {
            System.out.println(
                "Belum ada transaksi."
            );
            return;
        }

        for (int i = riwayatTransaksi.size() - 1;
             i >= 0;
             i--) {

            System.out.println(
                riwayatTransaksi.get(i)
            );
        }
    }

    private void transaksiTerakhir() {

        if (riwayatTransaksi.isEmpty()) {
            System.out.println(
                "Belum ada transaksi."
            );
            return;
        }

        System.out.println(
            "Transaksi terakhir:"
        );

        System.out.println(
            riwayatTransaksi.peek()
        );
    }

    private void batalkanTransaksi() {

        if (riwayatTransaksi.isEmpty()) {
            System.out.println(
                "Tidak ada transaksi yang dapat dibatalkan."
            );
            return;
        }

        Transaksi transaksi =
            riwayatTransaksi.pop();

        Buku buku =
            cariBuku(transaksi.getIdBuku());

        if (buku != null) {
            buku.tambahStok();
        }

        int kategoriIndex =
            transaksi.getIndeksKategori();

        int hariIndex =
            transaksi.getIndeksHari();

        if (statistikPeminjaman
                [kategoriIndex]
                [hariIndex] > 0) {

            statistikPeminjaman
                [kategoriIndex]
                [hariIndex]--;
        }

        System.out.println(
            "Transaksi berhasil dibatalkan."
        );

        System.out.println(transaksi);

        if (buku != null) {
            System.out.println(
                "Stok buku dikembalikan menjadi: "
                + buku.getStok()
            );
        }
    }

    // =====================================================
    // ARRAY 2D
    // =====================================================

    public void tampilStatistik() {

        System.out.println(
            "\n=== STATISTIK PEMINJAMAN ==="
        );

        System.out.printf(
            "%-20s",
            "Kategori"
        );

        for (String namaHari : hari) {
            System.out.printf(
                "%10s",
                namaHari.substring(0, 3)
            );
        }

        System.out.println();

        for (int i = 0;
             i < statistikPeminjaman.length;
             i++) {

            System.out.printf(
                "%-20s",
                kategori[i]
            );

            for (int j = 0;
                 j < statistikPeminjaman[i].length;
                 j++) {

                System.out.printf(
                    "%10d",
                    statistikPeminjaman[i][j]
                );
            }

            System.out.println();
        }
    }
}