package Jobsheet5Sort;

import java.util.Scanner;

public class MahasiswaDemo20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = sc.nextInt();
        MaPres20 m = new MaPres20(jumMhs);
        sc.nextLine(); 
        for (int i = 0; i < jumMhs; i++) {
            System.out.print("NIM: ");
            String nim = sc.nextLine();
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("Kelas: ");
            String kelas = sc.nextLine();
            System.out.print("IPK: ");
            double ipk = sc.nextDouble();
            System.out.println("=============================================");
            sc.nextLine(); 
            m.tambah(new Mahasiswa20(nim, nama, kelas, ipk));
        }
        
        m.tampil();
        System.out.println("=============================================");
        System.out.println("Pecarian data");
        System.out.println("=============================================");
        System.out.print("Masukkan IPK yang dicari: ");
        double cari = sc.nextDouble();
        double posisi2 = m.findBinarySearch(cari, 0, m.listMhs.length - 1);
        
        sc.nextLine();

        System.out.println("Menggunakan Sequential Search");
        int pos = m.sequentialSearching(cari);
        m.tampilPosisi(String.valueOf(cari), pos);
        m.tampilDataSearch(cari, pos);
        System.out.println("=============================================");
        System.out.println("Menggunakan Binary Search");
        System.out.println("==============================================");
        m.tampilPosisi(String.valueOf(cari), (int) posisi2);
        m.tampilDataSearch(cari, (int) posisi2);

    }
}
