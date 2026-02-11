package Jobsheet1;
import java.util.Scanner;
public class tugas2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah jadwal kuliah: ");
        int n = sc.nextInt();
        sc.nextLine(); // membersihkan enter

        // Array 2D: baris ke-i, kolom informasi 
        String[][] jadwal = new String[n][4];

        inputJadwal(jadwal); 
        
        System.out.println("\n=== Seluruh Jadwal Kuliah ===");
        tampilkanSemua(jadwal); 

        System.out.print("\nMasukkan hari yang ingin dicari: ");
        String cariHari = sc.nextLine();
        tampilkanBerdasarHari(jadwal, cariHari); 

        System.out.print("\nMasukkan nama matkul yang ingin dicari: ");
        String cariMatkul = sc.nextLine();
        tampilkanBerdasarMatkul(jadwal, cariMatkul); 
    }
    // a. Fungsi Input Data [cite: 525]
    static void inputJadwal(String[][] jdwl) {
        for (int i = 0; i < jdwl.length; i++) {
            System.out.println("Jadwal ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah: ");
            jdwl[i][0] = sc.nextLine();
            System.out.print("Ruang           : ");
            jdwl[i][1] = sc.nextLine();
            System.out.print("Hari            : ");
            jdwl[i][2] = sc.nextLine();
            System.out.print("Jam             : ");
            jdwl[i][3] = sc.nextLine();
        }
    }
    // b. Menampilkan Semua Jadwal 
    static void tampilkanSemua(String[][] jdwl) {
        System.out.printf("%-25s %-15s %-10s %-15s\n", "Mata Kuliah", "Ruang", "Hari", "Jam");
        for (String[] r : jdwl) {
            System.out.printf("%-25s %-15s %-10s %-15s\n", r[0], r[1], r[2], r[3]);
        }
    }
    // c. Cari Berdasarkan Hari 
    static void tampilkanBerdasarHari(String[][] jdwl, String hari) {
        System.out.println("Hasil pencarian hari " + hari + ":");
        for (String[] r : jdwl) {
            if (r[2].equalsIgnoreCase(hari)) {
                System.out.println(r[0] + " | " + r[1] + " | " + r[3]);
            }
        }
    }
    // d. Cari Berdasarkan Nama Matkul 
    static void tampilkanBerdasarMatkul(String[][] jdwl, String matkul) {
        System.out.println("Hasil pencarian matkul " + matkul + ":");
        for (String[] r : jdwl) {
            if (r[0].equalsIgnoreCase(matkul)) {
                System.out.println("Ruang: " + r[1] + ", Hari: " + r[2] + ", Jam: " + r[3]);
            }
        }
    }
}

