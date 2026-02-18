package Jobsheet2;

public class MataKuliahMain20 {
    public static void main(String[] args) {
        MataKuliah20 mk1 = new MataKuliah20();
        mk1.kodeMK = "SI123";
        mk1.nama = "Pemrograman Berorientasi Objek";
        mk1.sks = 3;
        mk1.jumlahJam = 48;

        mk1.tampilkanInfo();
        mk1.ubahSks(4);
        mk1.tambahJam(16);
        mk1.tampilkanInfo();

        MataKuliah20 mk2 = new MataKuliah20("TI456", "Struktur Data", 3, 48);
        mk2.kurangiJam(8);
        mk2.tampilkanInfo();
    }
}
