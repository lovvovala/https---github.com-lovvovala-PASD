package Jobsheet5Sort;

public class Mahasiswa20 {
    String nim;
    String nama;
    String kelas;
    double ipk;
    Mahasiswa20() {
    }
    Mahasiswa20 (String name, String nim, String kls, double ip) {
        this.nama = name;
        this.nim = nim;
        this.kelas = kls;
        this.ipk = ip;
    }

    void tampilInformasi() {
        System.out.println("NIM : " + nim);
        System.out.println("Nama : " + nama);
        System.out.println("Kelas : " + kelas);
        System.out.println("IPK : " + ipk);
    }

}
