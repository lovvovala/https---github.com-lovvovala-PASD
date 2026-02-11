package Jobsheet1;

import java.util.Scanner;

public class HitungIP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Inisialisasi data mata kuliah
        String[] matkul = {
            "Pancasila", 
            "Konsep Teknologi Informasi", 
            "Critical Thinking dan Problem Solving",
            "Matematika Dasar", 
            "Bahasa Inggris", 
            "Dasar Pemrograman", 
            "Praktikum Dasar Pemrograman", 
            "Keselamatan dan Kesehatan Kerja"
        };
        double[] nilaiAngka = new double[matkul.length];
        String[] nilaiHuruf = new String[matkul.length];
        double[] bobotNilai = new double[matkul.length];
        int[] sks = {2, 2, 2, 3, 2, 2, 3, 2};

        System.out.println("Program Menghitung IP Semester");
        System.out.println("============================================================");

        // 3. Input nilai angka dan langsung konversi 
        for (int i = 0; i < matkul.length; i++) {
            System.out.print("masukkan nilai Angka untuk MK " + matkul[i] + ": ");
            nilaiAngka[i] = input.nextDouble();

            // Logika Konversi sesuai Tabel 
            if (nilaiAngka[i] > 80 && nilaiAngka[i] <= 100) {
                nilaiHuruf[i] = "A"; bobotNilai[i] = 4.0;
            } else if (nilaiAngka[i] > 73) {
                nilaiHuruf[i] = "B+"; bobotNilai[i] = 3.5;
            } else if (nilaiAngka[i] > 65) {
                nilaiHuruf[i] = "B"; bobotNilai[i] = 3.0;
            } else if (nilaiAngka[i] > 60) {
                nilaiHuruf[i] = "C+"; bobotNilai[i] = 2.5;
            } else if (nilaiAngka[i] > 50) {
                nilaiHuruf[i] = "C"; bobotNilai[i] = 2.0;
            } else if (nilaiAngka[i] > 39) {
                nilaiHuruf[i] = "D"; bobotNilai[i] = 1.0;
            } else {
                nilaiHuruf[i] = "E"; bobotNilai[i] = 0.0;
            }
        }
        double totalNilaiSKS = 0;
        int totalSKS = 0;
        
        System.out.println("\n=============================================================================================");
        System.out.println("hasil Konversi Nilai");
        System.out.println("=============================================================================================");
        System.out.printf("%-40s %-12s %-12s %-12s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");

        for (int i = 0; i < matkul.length; i++) {
            System.out.printf("%-40s %-12.2f %-12s %-12.2f\n", matkul[i], nilaiAngka[i], nilaiHuruf[i], bobotNilai[i]);
            totalNilaiSKS += (bobotNilai[i] * sks[i]);
            totalSKS += sks[i];
        }

        double ipSemester = totalNilaiSKS / totalSKS;
        System.out.println("=============================================================================================");
        System.out.printf("IP : %.2f\n", ipSemester);

    }
    
}
