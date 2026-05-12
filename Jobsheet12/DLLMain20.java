package Jobsheet12;

import java.util.Scanner;

public class DLLMain20 {

    public static void main(String[] args) {
        DLL20 dll = new DLL20();
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== MENU DOUBLE LINKED LIST ===");
            System.out.println("1. Tambah Mahasiswa di Awal");
            System.out.println("2. Tambah Mahasiswa di Akhir");
            System.out.println("3. Sisipkan data di tengah (setelah NIM)");
            System.out.println("4. Hapus Data di awal");
            System.out.println("5. Hapus Data di akhir");
            System.out.println("6. Tampilkan data");
            System.out.println("7. Tampilkan data dari belakang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    Mhs20 mhsAwal = inputMhs(sc);
                    dll.addFirst(mhsAwal);
                    break;
                case 2:
                    Mhs20 mhsAkhir = inputMhs(sc);
                    dll.addLast(mhsAkhir);
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang dicari : ");
                    String keyNim = sc.nextLine();

                    System.out.println("=== Masukkan Data Baru ===");
                    Mhs20 dataBaru = inputMhs(sc);
                    dll.InsertAfter(keyNim, dataBaru);
                    break;
                case 4:
                    dll.removeFirst();
                    break;
                case 5:
                    dll.removeLast();
                    break;
                case 6:
                    dll.print();
                    break;
                case 7:
                    dll.printReverse();
                    break;  
                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilihan != 0);
        sc.close();
    }

    public static Mhs20 inputMhs(Scanner sc) {
        System.out.print("Masukkan NIM   : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama  : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("Masukkan IPK   : ");
        double ipk = sc.nextDouble();
        sc.nextLine(); 

        return new Mhs20(nim, nama, kelas, ipk);
    }

}
