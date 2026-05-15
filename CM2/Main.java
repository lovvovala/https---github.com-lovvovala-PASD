package CM2;
import java.util.Scanner;

public class Main {
    Node headAntrean, tailAntrean;
    Node headPesanan, tailPesanan;
    int counterAntrean = 1;

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

    // Method untuk melayani antrean pembeli
    public void layaniAntrean(int kode, String menu, int harga) {
        if (headAntrean == null) {
            System.out.println("Tidak ada antrean untuk dilayani.");
            return;
        }

        // Ambil pembeli terdepan
        Node dilayani = headAntrean;
        Pembeli p = (Pembeli) dilayani.data;
        
        // Simpan ke daftar pesanan
        Pesanan pes = new Pesanan(kode, menu, harga);
        Node newNodePesanan = new Node(pes);
        if (headPesanan == null) {
            headPesanan = tailPesanan = newNodePesanan;
        } else {
            tailPesanan.next = newNodePesanan;
            newNodePesanan.prev = tailPesanan;
            tailPesanan = newNodePesanan;
        }

        System.out.println(p.namaPmbl + " telah memesan " + menu);

        // Hapus dari antrean pembeli
        headAntrean = headAntrean.next;
        if (headAntrean != null) headAntrean.prev = null;
        else tailAntrean = null;
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
            Node curr = headPesanan;
            while (curr != null && curr.next != null) {
                Pesanan p1 = (Pesanan) curr.data;
                Pesanan p2 = (Pesanan) curr.next.data;
                if (p1.namaPesanan.compareToIgnoreCase(p2.namaPesanan) > 0) {
                    Object temp = curr.data;
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
        Node curr = headPesanan;
        while (curr != null) {
            Pesanan p = (Pesanan) curr.data;
            System.out.printf("%-15d | %-20s | %-10d\n", p.kodePesanan, p.namaPesanan, p.harga);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Main resto = new Main();
        Scanner sc = new Scanner(System.in);
        int pilih;

        // Data awal melalui konstruktor untuk efisiensi
        resto.tambahAntrean("Ainra", "08224500000");
        resto.tambahAntrean("Danra", "08224511111");
        resto.tambahAntrean("Sanri", "08224522222");

        do {
            System.out.println("\n===== SISTEM ANTRIAN ROYAL DELISH =====");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
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
                    int kode = sc.nextInt(); sc.nextLine();
                    System.out.print("Nama Pesanan : ");
                    String menu = sc.nextLine();
                    System.out.print("Harga        : ");
                    int harga = sc.nextInt();
                    resto.layaniAntrean(kode, menu, harga);
                    break;
                case 4:
                    resto.laporanPesanan();
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
