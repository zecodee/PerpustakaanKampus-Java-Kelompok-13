/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Transaksi {
    private String namaMahasiswa;
    private String idBuku;
    private String judulBuku;
    private String kategori;
    private int indeksKategori;
    private int indeksHari;
    private String hari;

    public Transaksi(String namaMahasiswa,
                     String idBuku,
                     String judulBuku,
                     String kategori,
                     int indeksKategori,
                     int indeksHari,
                     String hari) {

        this.namaMahasiswa = namaMahasiswa;
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.kategori = kategori;
        this.indeksKategori = indeksKategori;
        this.indeksHari = indeksHari;
        this.hari = hari;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getKategori() {
        return kategori;
    }

    public int getIndeksKategori() {
        return indeksKategori;
    }

    public int getIndeksHari() {
        return indeksHari;
    }

    public String getHari() {
        return hari;
    }

    @Override
    public String toString() {
        return namaMahasiswa
                + " | " + idBuku
                + " | " + judulBuku
                + " | " + kategori
                + " | " + hari;
    }
}