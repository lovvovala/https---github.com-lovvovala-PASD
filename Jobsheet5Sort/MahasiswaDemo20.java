package Jobsheet5Sort;

import java.util.Scanner;

public class MahasiswaDemo20 {
    public static void main(String[] args) {
        MaPres20 m = new MaPres20();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("NIM: ");
            String nim = sc.nextLine();
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("Kelas: ");
            String kelas = sc.nextLine();
            System.out.print("IPK: ");
            double ipk = sc.nextDouble();
            sc.nextLine(); 
            m.tambah(new Mahasiswa20(nim, nama, kelas, ipk));
        }
        System.out.println("Data sebelum sorting:");
        m.tampil();

        m.bubbleSort();

        System.out.println("Data setelah sorting berdasarkan IPK (BS) (DESC):");
        m.tampil();

        m.selectionSort();
        System.out.println("Data setelah sorting berdasarkan IPK (SS) (ASC):");
        m.tampil();

        m.insertionSort();
        System.out.println("Data setelah sorting berdasarkan IPK (IS) (ASC):");
        m.tampil();

    }
}
