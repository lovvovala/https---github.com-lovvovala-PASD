package Jobsheet11.Tugas;
import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLInkedList qll = new QueueLInkedList();
        int pilihan;
        do {
           System.out.println("\n=== MENU ANTRIAN LAYANAN MAHASISWA ===");
            System.out.println("1. Daftarkan Mahasiswa (Enqueue)");
            System.out.println("2. Panggil/Layani Mahasiswa (Dequeue)");
            System.out.println("3. Tampilkan Antrian Terdepan & Terakhir");
            System.out.println("4. Tampilkan Semua Antrian");
            System.out.println("5. Tampilkan Jumlah Antrian");
            System.out.println("6. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Masukkan Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Kelas : ");
                    String kelas = sc.nextLine();
                    
                    Mhs m = new Mhs(nim, nama, kelas);
                    qll.enqueue(m);
                    break;
                case 2:
                    qll.dequeue();
                    break;
                case 3:
                    qll.tampilTerdepanDanTerakhir();
                    break;
                case 4:
                    qll.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Jumlah mahasiswa yang mengantre saat ini: " + qll.getJumlahAntrean() + " orang.");
                    break;
                case 6:
                    qll.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan antrian. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih antara 1-6.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}
