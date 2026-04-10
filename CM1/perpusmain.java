package CM1;

import java.util.Scanner;

public class perpusmain {
    static Mahasiswa[] mahasiswaArray = {
            new Mahasiswa("22001", "Andi", "Teknik Informatika"),
            new Mahasiswa("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
    };

    static Buku[] bukuArray = {
            new Buku("B001", "Algoritma", 2020),
            new Buku("B002", "Basis Data", 2019),
            new Buku("B003", "Pemrograman", 2021),
            new Buku("B004", "Fisika", 2024)
    };

    static Pemijaman[] pemijamanArray = {
            new Pemijaman(mahasiswaArray[0], bukuArray[0], 7),
            new Pemijaman(mahasiswaArray[1], bukuArray[1], 3),
            new Pemijaman(mahasiswaArray[2], bukuArray[2], 10),
            new Pemijaman(mahasiswaArray[2], bukuArray[3], 6),
            new Pemijaman(mahasiswaArray[0], bukuArray[1], 4)
    };

    static void urutDenda() {
        for (int i = 1; i < pemijamanArray.length; i++) {
            Pemijaman temp = pemijamanArray[i];
            int j = i - 1;
            while (j >= 0 && pemijamanArray[j].denda < temp.denda) {
                pemijamanArray[j + 1] = pemijamanArray[j];
                j--;
            }
            pemijamanArray[j + 1] = temp;
        }
        System.out.println("Setelah diurutkan (Denda terbesar):");
        for (Pemijaman pinjam : pemijamanArray)
            pinjam.tampilPeminjaman();
    }

    static void cariNIM(String nimCari) {
        for (int i = 1; i < pemijamanArray.length; i++) {
            Pemijaman temp = pemijamanArray[i];
            int j = i - 1;
            while (j >= 0 && pemijamanArray[j].m.nim.compareTo(temp.m.nim) > 0) {
                pemijamanArray[j + 1] = pemijamanArray[j];
                j--;
            }
            pemijamanArray[j + 1] = temp;
        }
        int low = 0, high = pemijamanArray.length - 1;
        boolean ketemu = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (pemijamanArray[mid].m.nim.equals(nimCari)) {
                pemijamanArray[mid].tampilPeminjaman();
                ketemu = true;
                break;
            }
            if (pemijamanArray[mid].m.nim.compareTo(nimCari) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (!ketemu)
            System.out.println("NIM tidak ditemukan.");
    }

    static void tampilHeader() {
        System.out.println("==================================================================================");
        System.out.printf("| %-7s | %-8s | %-20s | %-6s | %-9s | %-7s |\n",
                "NIM", "NAMA", "JUDUL BUKU", "LAMA", "TERLAMBAT", "DENDA");
        System.out.println("==================================================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa\n2. Tampilkan Buku\n3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan (Denda Terbesar)\n5. Cari Berdasarkan NIM\n0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Data Mahasiswa:");
                    for (Mahasiswa m : mahasiswaArray) {
                        m.tampilMahasiswa();
                    }
                    break;
                case 2:
                    System.out.println("Data Buku:");
                    for (Buku b : bukuArray) {
                        b.tampilBuku();
                    }
                    break;
                case 3:
                    System.out.println("Data Peminjaman:");
                    tampilHeader();
                    for (Pemijaman p : pemijamanArray) {
                        p.tampilPeminjaman();
                    }
                    break;
                case 4:
                    tampilHeader();
                    for (Pemijaman p : pemijamanArray) {
                        p.tampilPeminjaman();
                    }
                    urutDenda();
                    break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = sc.nextLine();
                    tampilHeader();
                    cariNIM(nimCari);
                    break;
                default:
                    System.out.println("Keluar dari program.");
            }
            System.out.println();
        } while (pilihan != 0);

        sc.close();
    }
}
