package Jobsheet5.BFdanDC;

public class Main {
    public static void main(String[] args) {
    Mahasiswa[] daftar = new Mahasiswa[8];
        daftar[0] = new Mahasiswa("Ahmad", 220101001, 2022, 78, 82);
        daftar[1] = new Mahasiswa("Budi", 220101002, 2022, 85, 88);
        daftar[2] = new Mahasiswa("Cindy", 220101003, 2021, 90, 87);
        daftar[3] = new Mahasiswa("Dian", 220101004, 2021, 76, 79);
        daftar[4] = new Mahasiswa("Eko", 220101005, 2023, 92, 95);
        daftar[5] = new Mahasiswa("Fajar", 220101006, 2020, 88, 85);
        daftar[6] = new Mahasiswa("Gina", 220101007, 2023, 80, 83);
        daftar[7] = new Mahasiswa("Hadi", 220101008, 2020, 82, 84);

        NilaiSistem sistem = new NilaiSistem();
        System.out.println("UTS Tertinggi (DC): " + sistem.cariMaxUTS(daftar, 0, 7));
        System.out.println("UTS Terendah (DC): " + sistem.cariMinUTS(daftar, 0, 7));
        System.out.println("Rata-rata UAS (BF): " + sistem.hitungRataRataUAS(daftar));
    }
}
