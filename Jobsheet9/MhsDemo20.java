package Jobsheet9;

import java.util.Scanner;

public class MhsDemo20 {
    public static void main(String[] args) {
        StackTugasMhs20 stack = new StackTugasMhs20(5);
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("Menu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.println("5. Melihat Tugas Terbawah");
            System.out.println("6. Menghitung Jumlah Tugas");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = sc.nextLine();
                    Mahasiswa20 mhs = new Mahasiswa20(nim, nama, kelas);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                    break;
                case 2:
                    Mahasiswa20 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = sc.nextInt();
                        sc.nextLine();
                        dinilai.nilai = nilai;
                        System.out.printf("Nilai tugas %s telah dimasukkan: %d\n", dinilai.nama, dinilai.nilai);
                        String biner = stack.konversiDesimalKeBiner(nilai);
                        System.out.println("Nilai dalam biner: " + biner);
                    }
                    break;
                case 3:
                    Mahasiswa20 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                    }
                    break;
                case 4:
                    System.out.println("=== DAFTAR SEMUA TUGAS ===");
                    System.out.println("NIM\tNama\tKelas");
                    stack.print();
                    break;
                case 5:
                    Mahasiswa20 terbawah = stack.peekBottom();
                    if (terbawah != null) {
                        System.out.println("Tugas yang pertama kali dikumpulkan adalah milik: " + terbawah.nama);
                    }
                    break;
                case 6:
                    int jumlahTugas = stack.getJumlahTugas();
                    System.out.println("Jumlah tugas yang telah dikumpulkan: " + jumlahTugas);
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilih >= 1 && pilih <= 6);
    }
}
