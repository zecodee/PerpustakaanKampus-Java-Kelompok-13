/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author zefrialrizkullah
 */

public class InputUtil {

    private static final Scanner INPUT = new Scanner(System.in);

    public static String inputNama(String pesan) {
        while (true) {
            System.out.print(pesan);
            String nama = INPUT.nextLine().trim();

            if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
                continue;
            }

            if (!nama.matches("[A-Za-z ]+")) {
                System.out.println(
                    "Nama hanya boleh berisi huruf dan spasi."
                );
                continue;
            }

            if (nama.length() < 3) {
                System.out.println(
                    "Nama minimal terdiri dari 3 karakter."
                );
                continue;
            }

            return nama;
        }
    }

    public static String inputTeks(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = INPUT.nextLine().trim();

            if (teks.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                continue;
            }

            return teks;
        }
    }

    public static int inputAngka(
            String pesan,
            int minimal,
            int maksimal) {

        while (true) {
            System.out.print(pesan);
            String data = INPUT.nextLine().trim();

            try {
                int angka = Integer.parseInt(data);

                if (angka < minimal || angka > maksimal) {
                    System.out.println(
                        "Masukkan angka "
                        + minimal + " sampai " + maksimal + "."
                    );
                    continue;
                }

                return angka;

            } catch (NumberFormatException e) {
                System.out.println(
                    "Input harus berupa angka."
                );
            }
        }
    }

    public static String inputIdBuku(String pesan) {
        while (true) {
            System.out.print(pesan);

            String id = INPUT.nextLine()
                    .trim()
                    .toUpperCase();

            if (!id.matches("B\\d{3}")) {
                System.out.println(
                    "Format ID harus B diikuti 3 angka. Contoh B001."
                );
                continue;
            }

            return id;
        }
    }
}