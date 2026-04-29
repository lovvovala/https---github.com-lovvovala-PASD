package Jobsheet10.P2Jobsheet10;
public class AntrianLayanan {
    Mahasiswa[] data;
    int front, rear, size, max;

    public AntrianLayanan(int max) {
        this.max = max;
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahAntrian(Mahasiswa m) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambahkan mahasiswa" );
            return;
        } else {
            rear = (rear + 1) % max;
            data[rear] = m;
            size++;
            System.out.println(m.nama + " berhasil ditambahkan ke antrian");
        }
    }

    public Mahasiswa layaniAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return null;
        } else {
            Mahasiswa m = data[front];
            front = (front + 1) % max;
            size--;
            return m;
        }
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println("Mahasiswa terdepan: ");
            System.out.println("Nama - NIM - Prodi - Kelas");
            data[front].tampilkanData();
        }
    }

    public void tampilkanSemua(){
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println("Daftar Mahasiswa dalam Antrian: ");
            System.out.println("Nama - NIM - Prodi - Kelas");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void lihatAkhir() {
    if (isEmpty()) {
        System.out.println("Antrian masih kosong");
    } else {
        System.out.println("Antrian paling belakang:");
        data[rear].tampilkanData();
    }
}
}