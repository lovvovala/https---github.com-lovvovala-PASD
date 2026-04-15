package CM1;

public class Mahasiswa {
    // Deklarasi atribut
   String nim;
   String nama;
   String prodi;

    // Konstruktor
    Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // Method untuk menampilkan informasi mahasiswa
    void tampilMahasiswa() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}
