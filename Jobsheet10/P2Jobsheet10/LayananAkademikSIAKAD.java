package Jobsheet10.P2Jobsheet10;
import java.util.Scanner;
public class LayananAkademikSIAKAD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLayanan a = new AntrianLayanan(5);
        int pilih;
        do {
            System.out.println("\n=== Menu Layanan Akademik ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Layani Mahasiswa");
            System.out.println("3. Lihat Mahasiswa Terdepan");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Jumlah Antrian dalam Antrian");
            System.out.println("6. Cek Antrian paling belakang");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("NIM\t: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama\t: ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi\t: ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas\t: ");
                    String kelas = sc.nextLine();
                    Mahasiswa m = new Mahasiswa(nim, nama, prodi, kelas);
                    a.tambahAntrian(m);
                    break;
                case 2:
                    Mahasiswa dilayani = a.layaniAntrian();
                    if (dilayani != null) {
                        System.out.println("Memproses mahasiswa " );
                        dilayani.tampilkanData();
                        System.out.printf("Mahasiswa %s telah diproses\n", dilayani.nama);
                    }
                    break;
                case 3:
                    a.lihatTerdepan();
                    break;
                case 4:
                    a.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Jumlah antrian saat ini: " + a.getSize());
                    break;
                case 6:
                    a.lihatAkhir();
                    break;
                case 0:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilih != 0);

        sc.close();
    }
}
