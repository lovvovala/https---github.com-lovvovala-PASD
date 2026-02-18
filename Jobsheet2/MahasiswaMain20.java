package Jobsheet2;

public class MahasiswaMain20 {
    public static void main(String[] args) {
        Mahasiswa20 mhs1 = new Mahasiswa20();
        mhs1.nama = "Muhammad Ali Farhan";
        mhs1.nim = "2241720171";
        mhs1.kelas = "SI 2J";
        mhs1.ipk = 3.55;

        mhs1.tampilkanInfo();
        mhs1.ubahKelas("SI 2K");
        mhs1.ubahIpk(3.60);
        mhs1.tampilkanInfo();

        Mahasiswa20 mhs2 = new Mahasiswa20("Annisa Nabila", "2141720160", "TI 2L", 3.25);
        mhs2.ubahIpk(3.30);
        mhs2.tampilkanInfo();

        Mahasiswa20 mhsRachmah = new Mahasiswa20("Rachmah Nur Chotimah", "254107060052", "SIB 1A", 3.89);
        mhsRachmah.tampilkanInfo();

    }

}
