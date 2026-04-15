package CM1;

public class Pemijaman {
    // Deklarasi atribut
    Mahasiswa m;
    Buku b;
    int lamaPinjam, terlambat, denda;
    int batasPinjam = 5;

    // Konstruktor
    Pemijaman(Mahasiswa m, Buku b, int lamaPinjam) {
        this.m = m;
        this.b = b;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    void tambahPeminjaman() {

    }

    // Method untuk menghitung denda
    void hitungDenda() {
        terlambat = (lamaPinjam > batasPinjam) ? lamaPinjam - batasPinjam : 0;
        denda = terlambat * 2000;
    }


    // Method untuk menampilkan informasi peminjaman
    void tampilPeminjaman() {
       System.out.printf("| %-7s | %-8s | %-20s | %-6d | %-9d | %-7d |\n",  //%-7s untuk string, %-6d untuk integer
        m.nim, m.nama, b.judul, lamaPinjam, terlambat, denda);
    }

   
}
