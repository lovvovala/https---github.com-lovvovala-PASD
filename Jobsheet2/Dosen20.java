package Jobsheet2;

public class Dosen20 {
    String idDosen;
    String nama;
    boolean statusAktif;
    int tahunBergabung;
    String BidangKeahlian;

    public Dosen20() {
    }

    public Dosen20(String idDosen, String nama, boolean statusAktif, int tahunBergabung, String BidangKeahlian) {
        this.idDosen = idDosen;
        this.nama = nama;
        this.statusAktif = statusAktif;
        this.tahunBergabung = tahunBergabung;
        this.BidangKeahlian = BidangKeahlian;
    }

    void tampilkanInfo() {
        System.out.println("ID Dosen       : " + idDosen);
        System.out.println("Nama           : " + nama);
        System.out.println("Status Aktif   : " + (statusAktif ? "Aktif" : "Tidak Aktif"));
        System.out.println("Tahun Bergabung: " + tahunBergabung);
        System.out.println("Bidang Keahlian: " + BidangKeahlian);
    }

    void setStatusAktif(boolean status) {
        statusAktif = status;
    }

    int hitungMasaKerja(int tahunSekarang) {
        return tahunSekarang - tahunBergabung;
    }

    void ubahBidangKeahlian(String bidangBaru) {
        BidangKeahlian = bidangBaru;
    }
}

