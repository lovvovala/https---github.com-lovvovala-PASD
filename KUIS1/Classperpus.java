package KUIS1;

public class Classperpus {
    public ClassBuku[] daftarBuku = new ClassBuku[5];
    public ClassMhs[] daftarMhs = new ClassMhs[2];
    public int jumlahBuku = 0;
    public int jumlahMhs = 0;

    public void tambahBuku(ClassBuku buku) {
        daftarBuku[jumlahBuku] = buku;
        jumlahBuku++;
    }

    public void tambahMhs(ClassMhs mhs) {
        daftarMhs[jumlahMhs] = mhs;
        jumlahMhs++;
    }

    public void pinjamBuku(String nim, String kodeBuku) {
        ClassMhs mhs = null;
        ClassBuku buku = null;

        for (int i = 0; i < jumlahMhs; i++) {
            if (daftarMhs[i].nim.equals(nim)) {
                mhs = daftarMhs[i];
                break;
            }
        }

        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].kodeBuku.equals(kodeBuku)) {
                buku = daftarBuku[i];
                break;
            }
        }

        if (mhs != null && buku != null) {
            if (!buku.statusPeminjaman && mhs.jumlahBukuDipinjam < 2) {
                mhs.bukuDipinjam[mhs.jumlahBukuDipinjam] = buku;
                mhs.jumlahBukuDipinjam++;
                buku.statusPeminjaman = true;
                System.out.println(mhs.nama + " berhasil meminjam " + buku.judulBuku);
            } else {
                System.out.println("Buku tidak tersedia atau mahasiswa sudah meminjam 2 buku.");
            }
        } else {
            System.out.println("Mahasiswa atau buku tidak ditemukan.");
        }
    }

    public void kembalikanBuku(String nim, String kodeBuku) {
        ClassMhs mhs = null;
        for (int i = 0; i < jumlahMhs; i++) {
            if (daftarMhs[i].nim.equals(nim)) {
                mhs = daftarMhs[i];
                break;
            }
        }

        if (mhs != null) {
            for (int i = 0; i < mhs.jumlahBukuDipinjam; i++) {
                if (mhs.bukuDipinjam[i].kodeBuku.equals(kodeBuku)) {
                    
                    mhs.bukuDipinjam[i].statusPeminjaman = false;

                   
                    mhs.bukuDipinjam[i] = mhs.bukuDipinjam[mhs.jumlahBukuDipinjam - 1];
                    mhs.bukuDipinjam[mhs.jumlahBukuDipinjam - 1] = null;
                    mhs.jumlahBukuDipinjam--;

                    System.out.println("Buku berhasil dikembalikan!");
                    return;
                }
            }
            System.out.println("Buku dengan kode tersebut tidak ditemukan di daftar pinjam mahasiswa.");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    public void tampilkanPeminjaman() {
        System.out.println("\n===== DAFTAR PEMINJAMAN BUKU =====");
        boolean adaPeminjam = false;

        for (int i = 0; i < jumlahMhs; i++) {
            ClassMhs m = daftarMhs[i];

            if (m.jumlahBukuDipinjam > 0) {
                adaPeminjam = true;
                System.out.println("Mahasiswa: " + m.nama);
                System.out.println("Buku yang dipinjam:");

                for (int j = 0; j < m.jumlahBukuDipinjam; j++) {
                    System.out.println("- " + m.bukuDipinjam[j].judulBuku);
                }
                System.out.println("---------------------------");
            }
        }

        if (!adaPeminjam) {
            System.out.println("Saat ini tidak ada buku yang sedang dipinjam.");
        }
    }

    public void tampilkanBukuTersedia() {
        System.out.println("\n===== DAFTAR BUKU TERSEDIA =====");
        boolean adaBuku = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (!daftarBuku[i].statusPeminjaman) {
                System.out.println("Kode: " + daftarBuku[i].kodeBuku + " | Judul: " + daftarBuku[i].judulBuku);
                adaBuku = true;
            }
        }
        if (!adaBuku) {
            System.out.println("Maaf, semua buku sedang dipinjam.");
        }
    }

}
