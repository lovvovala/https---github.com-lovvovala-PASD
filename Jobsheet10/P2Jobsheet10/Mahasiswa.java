package Jobsheet10.P2Jobsheet10;
public class Mahasiswa {
    String nama;
    String nim;
    String prodi;
    String kelas;

    Mahasiswa(String nama, String nim, String prodi, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    public void tampilkanData() {
        System.out.println(nama + " - " + nim + " - " + prodi + " - " + kelas);
    }

    Mahasiswa[] data;
    int front, rear, size, max;

}

    
