package Jobsheet10;

public class AntrianKRS {
    Mahasiswa[] antrian;
    int front, rear, size, max;
    int totalLulusKRS = 0; // Cetak jumlah yang sudah proses KRS
    final int KAPASITAS_DPA = 30; // Batas masing-masing DPA

    public AntrianKRS(int n) {
        max = n;
        antrian = new Mahasiswa[max];
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == max; }

    public void tambahAntrian(Mahasiswa m) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            antrian[rear] = m;
            size++;
            System.out.println("Mahasiswa " + m.nama + " berhasil masuk antrian.");
        } else {
            System.out.println("Antrian penuh (Max 10)!");
        }
    }

    public void panggilAntrianKRS() {
        if (size >= 2) {
            System.out.println("Memproses KRS untuk 2 mahasiswa terdepan:");
            for (int i = 0; i < 2; i++) {
                Mahasiswa m = antrian[front];
                System.out.print("- "); m.tampilkanData();
                front = (front + 1) % max;
                size--;
                totalLulusKRS++;
            }
        } else if (size == 1) {
            System.out.println("Hanya ada 1 mahasiswa. Memproses 1 mahasiswa:");
            Mahasiswa m = antrian[front];
            m.tampilkanData();
            front = (front + 1) % max;
            size--;
            totalLulusKRS++;
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Daftar Antrian:");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % max;
                antrian[index].tampilkanData();
            }
        }
    }

    public void tampilkan2Terdepan() {
        if (!isEmpty()) {
            int limit = Math.min(size, 2);
            System.out.println("2 Antrian Terdepan:");
            for (int i = 0; i < limit; i++) {
                antrian[(front + i) % max].tampilkanData();
            }
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void tampilkanTerakhir() {
        if (!isEmpty()) {
            System.out.print("Antrian Paling Akhir: ");
            antrian[rear].tampilkanData();
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void cetakStatistik() {
        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
        System.out.println("Jumlah mahasiswa sudah proses KRS: " + totalLulusKRS);
        System.out.println("Sisa kuota mahasiswa belum proses KRS (Target 30): " + (KAPASITAS_DPA - totalLulusKRS));
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }
}
