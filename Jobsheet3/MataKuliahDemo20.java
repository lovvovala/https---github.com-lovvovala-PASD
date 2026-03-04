package Jobsheet3;

import java.util.Scanner;

public class MataKuliahDemo20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah matakuliah: ");
        int jumlah = input.nextInt();
        input.nextLine(); 
        MataKuliah20[] arrayOfMatakuliah20 = new MataKuliah20[jumlah];

        String kodeMK, nama, dummy;
        int sks, jumlahJam;
        
        for (int i = 0; i < arrayOfMatakuliah20.length; i++) {
            System.out.println("Masukkan data mata kuliah ke-" + (i + 1));
            System.out.print("Kode MK\t: ");
            kodeMK = input.nextLine();
            System.out.print("Nama\t: ");
            nama = input.nextLine();
            System.out.print("SKS\t: ");
            dummy = input.nextLine();
            sks = Integer.parseInt(dummy);
            System.out.print("Jumlah Jam\t: ");
            dummy = input.nextLine();
            jumlahJam = Integer.parseInt(dummy);
            arrayOfMatakuliah20[i] = new MataKuliah20(kodeMK, nama, sks, jumlahJam);
            arrayOfMatakuliah20[i].tambahData(kodeMK, nama, sks, jumlahJam);
            System.out.println("---------------------------------------------");
        }

        for (int i = 0; i < arrayOfMatakuliah20.length; i++) {
            System.out.println("Data Mata Kuliah ke-" + (i + 1));
            arrayOfMatakuliah20[i].cetakInfo();
            System.out.println("---------------------------------------------");
        }
    }
}
