package KUIS1;

public class ClassMhs {
    public String nim;
    public String nama;
    public ClassBuku[] bukuDipinjam = new ClassBuku[2];
    public int jumlahBukuDipinjam = 0;

    public ClassMhs(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }
}
