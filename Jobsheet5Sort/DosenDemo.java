package Jobsheet5Sort;
import java.util.Scanner;
public class DosenDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen dt = new DataDosen();
        int pilih;
        do {
            System.out.println("\n==== Menu Dosen ====");
            System.out.println("1. Tambah Dosen");
            System.out.println("2. Tampil Dosen");
            System.out.println("3. Sorting Bubble (ASC)");
            System.out.println("4. Sorting Selection (DESC)");
            System.out.println("5. Sorting Insertion (DESC)");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.print("Kode Dosen: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama Dosen: ");
                    String nama = sc.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    char jk = sc.nextLine().charAt(0);
                    boolean jenisKelamin = (jk == 'L' || jk == 'l');
                    System.out.print("Usia: ");
                    int usia = sc.nextInt();
                    sc.nextLine(); 
                    dt.tambah(new Dosen(kode, nama, jenisKelamin, usia));
                    break;
                case 2:
                    dt.tampil();
                    break;
                case 3:
                    dt.SortingBubbleASC();
                    System.out.println("Data telah diurutkan secara ascending berdasarkan usia.");
                    dt.tampil();
                    break;
                case 4:
                    dt.SortingSelectionDESC();
                    System.out.println("Data telah diurutkan secara descending berdasarkan usia.");
                    dt.tampil();
                    break;
                case 5:
                    dt.SortingInsersionDESC();
                    System.out.println("Data telah diurutkan secara descending berdasarkan usia.");
                    dt.tampil();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilih != 5);
    }
}
