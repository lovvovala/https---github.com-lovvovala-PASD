package CM1;

import java.lang.reflect.Method;
//agar dapat menerima inputan
import java.util.Scanner;

public class perpusmain {
    // Deklarasi array untuk menyimpan data mahasiswa, buku, dan peminjaman
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

    // Array untuk menyimpan data peminjaman
    static Pemijaman[] pemijamanArray = new Pemijaman[0];

    public static Pemijaman[] tambahPeminjaman(Pemijaman[] pemijamanArray, Mahasiswa[] mhsArray, Buku[] bukuArray,
            Scanner sc) { // Method untuk menambah data
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        // Mencari mahasiswa berdasarkan NIM
        Mahasiswa mhs = null;
        for (Mahasiswa m : mhsArray) {
            if (m.nim.equals(nim)) {
                mhs = m;
                break;
            }
        }
        if (mhs == null) {
            System.out.println("NIM tidak ditemukan!");
            return pemijamanArray;
        }

        // Mencari buku berdasarkan kode
        System.out.print("Masukkan Kode Buku: ");
        String kode = sc.nextLine();
        Buku buku = null;
        for (Buku b : bukuArray) {
            if (b.kodeBuku.equals(kode)) {
                buku = b;
                break;
            }
        }
        if (buku == null) {
            System.out.println("Kode buku tidak ditemukan!");
            return pemijamanArray;
        }

        // Meminta input lama pinjam
        System.out.print("Masukkan Lama Pinjam: ");
        int lama = sc.nextInt();
        sc.nextLine();
        Pemijaman baru = new Pemijaman(mhs, buku, lama);
        baru.hitungDenda();
        Pemijaman[] newArray = new Pemijaman[pemijamanArray.length + 1]; // Membuat array baru dengan ukuran 1 lebih
                                                                         // besar dari array lama

        // Menyalin data dari array lama ke array baru
        for (int i = 0; i < pemijamanArray.length; i++) {
            newArray[i] = pemijamanArray[i];
        }
        newArray[pemijamanArray.length] = baru; // Menambahkan data baru ke posisi terakhir array baru
        System.out.println("Data peminjaman berhasil ditambahkan!");
        return newArray;
    }

    // Method untuk mengurutkan peminjaman berdasarkan denda terbesar menggunakan
    // insertion sort
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
    }

    // Method untuk mencari peminjaman berdasarkan NIM menggunakan binary search
    static void cariNIM(String nimCari) {
        Pemijaman[] arr = new Pemijaman[pemijamanArray.length];
        for (int i = 0; i < pemijamanArray.length; i++) {
            arr[i] = pemijamanArray[i];
        }
        for (int i = 1; i < arr.length; i++) {
            Pemijaman temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].m.nim.compareTo(temp.m.nim) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
        int low = 0, high = arr.length - 1;
        int ditemukanIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].m.nim.equals(nimCari)) {
                ditemukanIndex = mid;
                break;
            }

            if (arr[mid].m.nim.compareTo(nimCari) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (ditemukanIndex == -1) {
            System.out.println("Data tidak ditemukan!");
            return;
        }

        System.out.println("[Binary Search] Data ditemukan:");

        int i = ditemukanIndex;
        while (i >= 0 && arr[i].m.nim.equals(nimCari)) {
            i--;
        }
        i++;
        while (i < arr.length && arr[i].m.nim.equals(nimCari)) {
            arr[i].tampilPeminjaman();
            i++;
        }
    }

    // Method untuk menampilkan header tabel peminjaman agar lebih rapi
    static void tampilHeader() {
        System.out.println("==================================================================================");
        System.out.printf("| %-7s | %-8s | %-20s | %-6s | %-9s | %-7s |\n",
                "NIM", "NAMA", "JUDUL BUKU", "LAMA", "TERLAMBAT", "DENDA");
        System.out.println("==================================================================================");
    }

    // main method untuk menjalankan program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// untuk menerima input pilihan menu
        int pilihan;
        // menggunakan switch case untuk menu interaktif
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa\n2. Tampilkan Buku\n3. Tampilkan Peminjaman");
            System.out.println(
                    "4. Urutkan (Denda Terbesar)\n5. Cari Berdasarkan NIM\n6. Input Peminjaman\n7. Statistik Peminjaman\n8. Laporan Mahasiswa\n0. Keluar");
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
                    tampilHeader(); // Menampilkan header sebelum menampilkan data peminjaman
                    for (Pemijaman p : pemijamanArray) { // Untuk menampilkan data peminjaman dengan format yang rapi
                        p.tampilPeminjaman();
                    }
                    break;
                case 4:
                    urutDenda(); // sorting dulu
                    System.out.println("\nSETELAH DIURUTKAN (DENDA TERBESAR):");
                    tampilHeader();
                    for (Pemijaman p : pemijamanArray) {
                        p.tampilPeminjaman();
                    }
                    System.out.println(
                            "==================================================================================");
                    break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = sc.nextLine();
                    tampilHeader();
                    cariNIM(nimCari);
                    break;
                case 6:
                    pemijamanArray = tambahPeminjaman(pemijamanArray, mahasiswaArray, bukuArray, sc);
                    break;
                case 7:
                    int totalDenda = 0;
                    int terlambat = 0;
                    int tepatWaktu = 0;

                    for (Pemijaman p : pemijamanArray) {
                        totalDenda += p.denda;

                        // pakai logika lama pinjam > 5 hari
                        if (p.lamaPinjam > 5) {
                            terlambat++;
                        } else {
                            tepatWaktu++;
                        }
                    }

                    System.out.println("=== STATISTIK PEMINJAMAN ===");
                    System.out.println("Total Denda Keseluruhan: " + totalDenda);
                    System.out.println("Jumlah peminjaman Terlambat: " + terlambat);
                    System.out.println("Jumlah peminjaman Tepat Waktu: " + tepatWaktu);
                    break;
                case 8:
                    System.out.println("=== LAPORAN MAHASISWA ===");
                    for (Mahasiswa m : mahasiswaArray) {
                        LaporanMahasiswa laporan = new LaporanMahasiswa(m);
                        laporan.hitunglaporan(pemijamanArray);
                        laporan.tampilLaporan();
                    }
                    break;
                default:
                    System.out.println("Keluar dari program.");
            }
            System.out.println();
        } while (pilihan != 0);

        sc.close();// Menutup scanner setelah selesai digunakan
    }
}

// link github:
// https://github.com/lovvovala/https---github.com-lovvovala-PASD/tree/main/CM1
