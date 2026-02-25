package Jobsheet3;

public class MataKuliah20 {
    public String kodeMK;
    public String nama;
    public int sks;
    public int jumlahJam;

    public MataKuliah20(String kodeMK, String nama, int sks, int jumlahJam) {
        this.kodeMK = kodeMK;
        this.nama = nama;
        this.sks = sks;
        this.jumlahJam = jumlahJam;
    }

    public void tambahData(String kode, String nama, int sks, int jumlahJam) {
        this.kodeMK = kode;
        this.nama = nama;
        this.sks = sks;
        this.jumlahJam = jumlahJam;

    }

    public void cetakInfo() {
    System.out.println("Kode       : " + kodeMK);
    System.out.println("Nama       : " + nama);
    System.out.println("SKS        : " + sks);
    System.out.println("Jumlah Jam : " + jumlahJam);
}
}
