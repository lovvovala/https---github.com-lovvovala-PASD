package Jobsheet2;

public class DosenMain20 {
    public static void main(String[] args) {
        Dosen20 dosen1 = new Dosen20();
        dosen1.idDosen = "D001";
        dosen1.nama = "Dr. Ahmad"; 
        dosen1.statusAktif = true;
        dosen1.tahunBergabung = 2010;
        dosen1.BidangKeahlian = "Pemrograman";

        dosen1.tampilkanInfo();
        System.out.println("Masa Kerja: " + dosen1.hitungMasaKerja(2025) + " tahun");
        dosen1.ubahBidangKeahlian("Sistem Informasi");
        dosen1.setStatusAktif(false);
        dosen1.tampilkanInfo();

    }
}
