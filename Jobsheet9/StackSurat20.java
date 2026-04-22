package Jobsheet9;

public class StackSurat20 {
    Surat20[] tumpukan;
    int top, size;

    public StackSurat20(int size) {
        tumpukan = new Surat20[size];
        this.size = size;
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat20 s) {
        if (!isFull()) {
            top++;
            tumpukan[top] = s;
        } else {
            System.out.println("Tumpukan surat penuh! Tidak bisa menambahkan surat lagi.");
        }
    }

    public Surat20 pop() {
        if (!isEmpty()) {
            Surat20 s = tumpukan[top];
            top--;
            return s;
        } else {
            System.out.println("Tumpukan surat kosong! Tidak ada surat untuk diambil.");
            return null;
        }
    }

    public Surat20 peek() {
        if (!isEmpty()) {
            return tumpukan[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk dilihat.");
            return null;
        }
    }

     public void cariSurat(String nama) {
        boolean ditemukan = false;
        for (int i = top; i >= 0; i--) {
            if (tumpukan[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat ditemukan:");
                System.out.println("ID Surat: " + tumpukan[i].idSurat);
                System.out.println("Nama Mahasiswa: " + tumpukan[i].namaMahasiswa);
                System.out.println("Kelas: " + tumpukan[i].kelas);
                System.out.println("Jenis Izin: " + tumpukan[i].jenisIzin);
                System.out.println("Durasi: " + tumpukan[i].durasi + " hari");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat dengan nama mahasiswa '" + nama + "' tidak ditemukan.");
        }
        
    }
}
