package CM1;

public class Pemijaman {
    Mahasiswa m;
    Buku b;
    int lamaPinjam, terlambat, denda;
    int batasPinjam = 5;

    Pemijaman(Mahasiswa m, Buku b, int lamaPinjam) {
        this.m = m;
        this.b = b;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    void hitungDenda() {
        terlambat = (lamaPinjam > batasPinjam) ? lamaPinjam - batasPinjam : 0;
        denda = terlambat * 2000;
    }

    void tampilPeminjaman() {
       System.out.printf("| %-7s | %-8s | %-20s | %-6d | %-9d | %-7d |\n", 
        m.nim, m.nama, b.judul, lamaPinjam, terlambat, denda);
    }
}
