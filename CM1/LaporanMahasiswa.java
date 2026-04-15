package CM1;

public class LaporanMahasiswa {
    Mahasiswa m;
    int totalPinjam;
    int totalDenda;
    int totalTerlambat;

    LaporanMahasiswa(Mahasiswa m) {
        this.m = m;
        this.totalPinjam = 0;
        this.totalDenda = 0;
        this.totalTerlambat = 0;
    }

    void hitunglaporan(Pemijaman[] pemijamanArray) {
        for (Pemijaman p : pemijamanArray) {
            if (p.m.nim.equals(m.nim)) {
                totalPinjam++;
                totalDenda += p.denda;
                totalTerlambat += p.terlambat;
            }
        }
    }

    void tampilLaporan() {
        System.out.printf("NIM: %s | Nama: %s | Total Pinjam: %d | Total Denda: Rp %d | Terlambat: %dx\n",
                m.nim,
                m.nama,
                totalPinjam,
                totalDenda,
                totalTerlambat);
    }
}
