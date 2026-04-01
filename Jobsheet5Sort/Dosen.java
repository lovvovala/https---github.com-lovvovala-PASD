package Jobsheet5Sort;

public class Dosen {
    String kode;
    String nama;
    Boolean jenisKelamin;
    int usia;
    Dosen() {
    }
    Dosen(String kd, String nm, Boolean jk, int us) {
        this.kode = kd;
        this.nama = nm;
        this.jenisKelamin = jk;
        this.usia = us;
    }

    void tampil() {
        System.out.println("Kode Dosen : " + kode);
        System.out.println("Nama Dosen : " + nama);
        System.out.println("Jenis Kelamin : " + (jenisKelamin ? "Laki-laki" : "Perempuan"));
        System.out.println("Usia : " + usia);
    }
}
