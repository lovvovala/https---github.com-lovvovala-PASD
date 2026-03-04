package KUIS1;

public class ClassBuku {
    public String kodeBuku;
    public String judulBuku;
    public String penulis;
    public boolean statusPeminjaman;

    public ClassBuku(String kodeBuku, String judulBuku, String penulis, boolean statusPeminjaman) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.statusPeminjaman = false;
    }
}
