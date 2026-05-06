package Jobsheet11.Tugas;

public class Mhs {
    String nim;
    String nama;
    String kelas;

    public Mhs(String nim, String nama, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
    }

    public void tampilData() {
        System.out.printf("NIM: %-10s | Nama: %-15s | Kelas: %-5s\n", nim, nama, kelas);
    }

}
