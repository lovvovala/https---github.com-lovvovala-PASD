package Jobsheet11;

public class Mahasiswa20 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    Mahasiswa20(){

    }

    Mahasiswa20(String nim, String nm, String kls, double ipk){
        this.nim = nim;
        this.nama = nm;
        this.kelas = kls;
        this.ipk = ipk;
    }

    void tampil(){
        System.out.println(nama + "\t" + nim + "\t" + kelas + "\t" + ipk);
    }
}
