package CM1;

public class Buku {
    // Deklarasi atribut
    String kodeBuku;
    String judul;
    int tahunTerbit;
    
    // Konstruktor
    Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    // Method untuk menampilkan informasi buku
    void tampilBuku() {
       System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}
