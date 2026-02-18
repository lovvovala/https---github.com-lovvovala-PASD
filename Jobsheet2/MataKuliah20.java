package Jobsheet2;

public class MataKuliah20 {
    String kodeMK;
    String nama;
    int sks;
    int jumlahJam;

    public MataKuliah20() {
    }

    public MataKuliah20(String kodeMK, String nama, int sks, int jumlahJam) {
        this.kodeMK = kodeMK;
        this.nama = nama;
        this.sks = sks;
        this.jumlahJam = jumlahJam;
    }

    void tampilkanInfo() {
        System.out.println("Kode MK : " + kodeMK);
        System.out.println("Nama    : " + nama);
        System.out.println("SKS     : " + sks);
        System.out.println("Jam     : " + jumlahJam);
    }

    void ubahSks(int sksBaru) {
        sks = sksBaru;
    }

    void tambahJam(int jamBaru) {
        jumlahJam += jamBaru;
    }

    void kurangiJam(int jamKurang) {
        jumlahJam -= jamKurang;
    }
}
