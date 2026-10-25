/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Buku {
    private String id;
    private String judul;
    private String kategori;
    private int stok;
    private int lantai;
    private int rak;
    private int posisi;

    public Buku(String id, String judul, String kategori, int stok,
                int lantai, int rak, int posisi) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.stok = stok;
        this.lantai = lantai;
        this.rak = rak;
        this.posisi = posisi;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public int getLantai() {
        return lantai;
    }

    public int getRak() {
        return rak;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }

    public void setRak(int rak) {
        this.rak = rak;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }

    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        }
    }

    public void tambahStok() {
        stok++;
    }

    @Override
    public String toString() {
        return id + " | " + judul
                + " | " + kategori
                + " | Stok: " + stok
                + " | Lantai " + lantai
                + ", Rak " + rak
                + ", Posisi " + posisi;
    }
}