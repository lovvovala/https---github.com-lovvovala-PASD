package Jobsheet9;

import java.util.Scanner;

public class SuratDemo20 {
    public static void main(String[] args) {
        StackSurat20 stack = new StackSurat20(10);
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("Menu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat Izin Berdasarkan Nama Mahasiswa");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan ID Surat: ");
                    String idSurat = sc.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Masukkan Jenis Izin (S/I): ");
                    char jenis = sc.nextLine().charAt(0);
                    System.out.print("Masukkan Durasi (hari): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();
                    Surat20 surat = new Surat20(idSurat, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    System.out.printf("Surat izin dari %s berhasil diajukan\n", nama);
                    break;
                case 2:
                    Surat20 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Memproses surat izin dari " + diproses.namaMahasiswa);
                        System.out.printf("Surat izin dari %s telah diproses\n", diproses.namaMahasiswa);
                    }
                    break;
                case 3:
                    Surat20 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Surat izin terakhir diajukan oleh " + lihat.namaMahasiswa);
                    }
                    break;
                case 4:
                    System.out.print("Masukkan Nama Mahasiswa yang ingin dicari: ");
                    String namaCari = sc.nextLine();
                    stack.cariSurat(namaCari);
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}
