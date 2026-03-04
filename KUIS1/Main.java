package KUIS1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Classperpus perpus = new Classperpus();
        int pilihan;
        do {
            System.out.println("===== MENU PERPUSTAKAAN =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Tampilkan Peminjaman");
            System.out.println("6. Tampilkan Buku Tersedia");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("===== TAMBAH BUKU =====");
                    System.out.print("Masukkan kode buku: ");
                    String kodeBuku = input.nextLine();
                    System.out.print("Masukkan judul buku: ");
                    String judulBuku = input.nextLine();
                    System.out.print("Masukkan penulis buku: ");
                    String penulisBuku = input.nextLine();
                    perpus.tambahBuku(new ClassBuku(kodeBuku, judulBuku, penulisBuku, false));
                    break;
                case 2:
                    System.out.println("===== TAMBAH MAHASISWA =====");
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimMhs = input.nextLine();
                    System.out.print("Masukkan nama mahasiswa: ");
                    String namaMhs = input.nextLine();
                    perpus.tambahMhs(new ClassMhs(nimMhs, namaMhs));
                    break;
                case 3:
                    System.out.println("===== PINJAM BUKU =====");
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = input.nextLine();
                    System.out.print("Masukkan kode buku: ");
                    String kode = input.nextLine();
                    perpus.pinjamBuku(nim, kode);
                    break;
                case 4:
                    System.out.println("===== KEMBALIKAN BUKU =====");
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimKembali = input.nextLine();
                    System.out.print("Masukkan kode buku: ");
                    String kodeBukuKembali = input.nextLine();
                    perpus.kembalikanBuku(nimKembali, kodeBukuKembali);
                    break;
                case 5:
                    perpus.tampilkanPeminjaman();
                    break;
                case 6:
                    perpus.tampilkanBukuTersedia();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi perpustakaan");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);
    }
}
