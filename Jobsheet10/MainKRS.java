package Jobsheet10;
import java.util.Scanner;
public class MainKRS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS a = new AntrianKRS(10); 
        int pilih;

        do {
            System.out.println("\n=== SISTEM ANTRIAN KRS DPA ===");
            System.out.println("1. Tambah Antrian Mahasiswa");
            System.out.println("2. Panggil Antrian (Proses 2 Mahasiswa)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Terakhir");
            System.out.println("6. Cetak Statistik (Jumlah & Sisa Kuota)");
            System.out.println("7. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM: "); 
                    String nim = sc.nextLine();
                    System.out.print("Nama: "); 
                    String nama = sc.nextLine();
                    System.out.print("Prodi: "); 
                    String prodi = sc.nextLine();
                    System.out.print("Kelas: "); 
                    String kelas = sc.nextLine();
                    a.tambahAntrian(new Mahasiswa(nim, nama, prodi, kelas));
                    break;
                case 2: 
                    a.panggilAntrianKRS(); 
                    break;
                case 3: 
                    a.tampilkanSemua(); 
                    break;
                case 4: 
                    a.tampilkan2Terdepan(); 
                    break;
                case 5: 
                    a.tampilkanTerakhir(); 
                    break;
                case 6: 
                    a.cetakStatistik(); 
                    break;
                case 7: 
                    a.clear(); 
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem antrian KRS DPA!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilih != 0);
    }
}