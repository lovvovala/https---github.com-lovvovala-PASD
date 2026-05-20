package CM2;

import java.util.Scanner;

public class Main {
    Node headAntrean, tailAntrean;
    NodePesanan headPesanan, tailPesanan;
    int counterAntrean = 1;
    int totalPendapatan = 0;

    // Method untuk menambah antrean pembeli
    public void tambahAntrean(String nama, String hp) {
        Pembeli p = new Pembeli(nama, hp);
        Node newNode = new Node(p, counterAntrean++);
        if (headAntrean == null) {
            headAntrean = tailAntrean = newNode;
        } else {
            tailAntrean.next = newNode;
            newNode.prev = tailAntrean;
            tailAntrean = newNode;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + newNode.nomorAntrean);
    }

    // Method untuk mencetak antrian pembeli
    public void cetakAntrean() {
        if (headAntrean == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-12s | %-15s | %-12s\n", "No Antrian", "Nama", "No HP");
        System.out.println("----------------------------------------------");
        Node curr = headAntrean;
        while (curr != null) {
            Pembeli p = (Pembeli) curr.data;
            System.out.printf("%-12d | %-15s | %-12s\n", curr.nomorAntrean, p.namaPmbl, p.noHp);
            curr = curr.next;
        }
    }

    // Method untuk melayani antrean pembeli sekaligus input pesanan (Gabungan FIFO
    // & DLL)
    public void layaniAntrean(int kode, String menu, int harga) {
        if (headAntrean == null) {
            System.out.println("Tidak ada antrean untuk dilayani.");
            return;
        }

        // 1. Ambil data pembeli paling depan (FIFO)
        Node dilayani = headAntrean;
        Pembeli p = (Pembeli) dilayani.data;

        // 2. GABUNG DI SINI: Tambah ke daftar pesanan menggunakan NodePesanan (Tugas
        // 2B)
        Pesanan pes = new Pesanan(kode, menu, harga);
        NodePesanan newPesanan = new NodePesanan(tailPesanan, pes, null);

        if (headPesanan == null) {
            headPesanan = tailPesanan = newPesanan;
        } else {
            tailPesanan.next = newPesanan; // Hubungkan maju
            tailPesanan = newPesanan; // Geser ekor list pesanan ke node baru
        }

        // 3. Akumulasi total pendapatan ke variabel global
        totalPendapatan += harga;

        // Tampilkan siapa yang dilayani
        System.out.println(p.namaPmbl + " telah memesan " + menu);

        // 4. Hapus antrean pembeli yang berada di paling depan
        if (headAntrean == tailAntrean) {
            headAntrean = tailAntrean = null;
        } else {
            headAntrean = headAntrean.next;
            headAntrean.prev = null;
        }
    }

    // Method untuk menampilkan akumulasi total pendapatan
    public void tampilTotalPendapatan() {
        System.out.println("Total Pendapatan : Rp" + totalPendapatan);
    }

    // Method untuk menampilkan laporan pesanan
    public void laporanPesanan() {
        if (headPesanan == null) {
            System.out.println("Belum ada pesanan masuk.");
            return;
        }

        // Sorting manual (Bubble Sort pada Linked List) berdasarkan Nama Pesanan
        boolean swapped;
        do {
            swapped = false;
            NodePesanan curr = headPesanan;
            while (curr != null && curr.next != null) {
                Pesanan p1 = (Pesanan) curr.data;
                Pesanan p2 = (Pesanan) curr.next.data;
                if (p1.namaPesanan.compareToIgnoreCase(p2.namaPesanan) > 0) {
                    Pesanan temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);

        System.out.println("\nLAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("----------------------------------------------");
        System.out.printf("%-15s | %-20s | %-10s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
        System.out.println("----------------------------------------------");
        NodePesanan curr = headPesanan;
        while (curr != null) {
            Pesanan p = (Pesanan) curr.data;
            System.out.printf("%-15d | %-20s | %-10d\n", p.kodePesanan, p.namaPesanan, p.harga);
            curr = curr.next;
        }
    }

    // Tugas 2C — Method hapusPesanan(int kodePesanan) menggunakan Double Linked
    // List
    public void hapusPesanan(int kodePesanan) {
        if (headPesanan == null) {
            System.out.println("Daftar pesanan masih kosong.");
            return;
        }

        NodePesanan current = headPesanan;
        boolean ditemukan = false;

        // 1. Mencari pesanan berdasarkan kodePesanan
        while (current != null) {
            if (current.data.kodePesanan == kodePesanan) {
                ditemukan = true;
                break;
            }
            current = current.next;
        }

        // 2. Jika ketemu, lakukan proses penghapusan node dari Double Linked List
        if (ditemukan) {
            // Kurangi total pendapatan global sebelum datanya dihapus dari memori
            totalPendapatan -= current.data.harga;

            System.out.println("Pesanan '" + current.data.namaPesanan + "' dengan kode " + kodePesanan
                    + " berhasil dihapus dari laporan.");

            // Kondisi A: Jika node yang dihapus adalah HEAD (paling depan)
            if (current == headPesanan) {
                headPesanan = headPesanan.next;
                if (headPesanan != null) {
                    headPesanan.prev = null;
                } else {
                    tailPesanan = null; // Jika list menjadi benar-benar kosong
                }
            }
            // Kondisi B: Jika node yang dihapus adalah TAIL (paling belakang)
            else if (current == tailPesanan) {
                tailPesanan = tailPesanan.prev;
                tailPesanan.next = null;
            }
            // Kondisi C: Jika node yang dihapus berada di TENGAH-TENGAH
            else {
                current.prev.next = current.next; // Update pointer next milik tetangga kiri
                current.next.prev = current.prev; // Update pointer prev milik tetangga kanan
            }
        } else {
            // 3. Jika kode tidak ditemukan
            System.out.println("Kode pesanan " + kodePesanan + " tidak ditemukan.");
        }
    }

    // Tugas 3A — Sequential Search untuk mencari pembeli berdasarkan nama
    public void cariPembeli(String nama) {
        if (headAntrean == null) {
            System.out.println("Antrian pembeli masih kosong.");
            return;
        }

        Node current = headAntrean;
        boolean ditemukan = false;

        System.out.println("\n--- Hasil Pencarian Pembeli ---");
        while (current != null) {
            Pembeli p = (Pembeli) current.data; // Casting Object ke Pembeli

            // Mencocokkan nama tanpa memedulikan huruf besar/kecil
            if (p.namaPmbl.equalsIgnoreCase(nama)) {
                System.out.println("Pembeli Ditemukan pada nomor antrean: " + current.nomorAntrean);
                System.out.println("Nama  : " + p.namaPmbl);
                System.out.println("No HP : " + p.noHp);
                ditemukan = true;
                break; // Hentikan pencarian jika sudah ketemu
            }
            current = current.next;
        }

        if (!ditemukan) {
            System.out.println("Pembeli dengan nama '" + nama + "' tidak ditemukan.");
        }
        System.out.println("-------------------------------");
    }

    // Tugas 3B — Mengurutkan antrean pembeli berdasarkan nama (Ascending) via
    // Selection Sort
    public void sortAntrian() {
        if (headAntrean == null || headAntrean.next == null) {
            System.out.println("Antrian kosong atau hanya berisi 1 data, tidak perlu diurutkan.");
            return;
        }

        Node i = headAntrean;
        while (i != null) {
            Node minNode = i;
            Node j = i.next;

            while (j != null) {
                Pembeli pMin = (Pembeli) minNode.data; //
                Pembeli pJ = (Pembeli) j.data; //

                // Membandingkan nama pembeli secara alfabetis (Ascending)
                if (pJ.namaPmbl.compareToIgnoreCase(pMin.namaPmbl) < 0) {
                    minNode = j; // Tandai node dengan nama yang lebih kecil
                }
                j = j.next;
            }

            // Jika ditemukan node yang lebih kecil, tukar data dan nomor antreannya
            if (minNode != i) {
                // Tukar data objek Pembeli
                Object tempObj = i.data;
                i.data = minNode.data;
                minNode.data = tempObj;

                // Tukar nomor antreannya agar nomornya tetap melekat pada orang yang sama
                int tempNo = i.nomorAntrean;
                i.nomorAntrean = minNode.nomorAntrean;
                minNode.nomorAntrean = tempNo;
            }
            i = i.next;
        }

        System.out.println("Antrian pembeli berhasil diurutkan berdasarkan nama!");
        cetakAntrean(); // Langsung tampilkan antrean yang sudah rapi terurut
    }

    public static void main(String[] args) {
        Main resto = new Main();
        Scanner sc = new Scanner(System.in);
        int pilih;

        // Data awal melalui konstruktor untuk efisiensi
        resto.tambahAntrean("Alif", "08115200001");
        resto.tambahAntrean("Bagas", "08115200002");
        resto.tambahAntrean("Cahya", "08115200003");

        do {
            System.out.println("\n===== SISTEM ANTRIAN ROYAL DELISH =====");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Hitung Total Pendapatan");
            System.out.println("6. Hapus Pesanan dari Laporan");
            System.out.println("7. Cari Pembeli berdasarkan Nama");
            System.out.println("8. Urutkan Antrian Pembeli berdasarkan Nama");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();
                    resto.tambahAntrean(nama, hp);
                    break;
                case 2:
                    resto.cetakAntrean();
                    break;
                case 3:
                    System.out.print("Kode Pesanan : ");
                    int kode = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nama Pesanan : ");
                    String menu = sc.nextLine();
                    System.out.print("Harga        : ");
                    int harga = sc.nextInt();
                    resto.layaniAntrean(kode, menu, harga);
                    break;
                case 4:
                    resto.laporanPesanan();
                    break;
                case 5:
                    resto.tampilTotalPendapatan();
                    break;
                case 6:
                    System.out.print("Masukkan Kode Pesanan yang ingin dihapus: ");
                    int kPesanan = sc.nextInt();
                    sc.nextLine();
                    resto.hapusPesanan(kPesanan);
                    break;
                case 7:
                    System.out.print("Masukkan nama pembeli yang ingin dicari: ");
                    String namaCari = sc.nextLine();
                    resto.cariPembeli(namaCari);
                    break;
                case 8:
                    resto.sortAntrian();
                    break;
                case 0:
                    System.out.println("Keluar program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
        sc.close();
    }
}
