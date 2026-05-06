package Jobsheet11.Tugas;

public class QueueLInkedList {
    Queue head;
    Queue tail;
    int size = 0;
    int maxSize = 10;

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size >= maxSize;
    }

    public void enqueue(Mhs m) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambahkan mahasiswa.");
            return;
        }
        Queue ndInput = new Queue(m, null);
        if (isEmpty()) {
            head = tail = ndInput;
        } else {
            tail.next = ndInput; 
            tail = ndInput;     
        }
        size++;
        System.out.println(m.nama + " berhasil masuk ke dalam antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada mahasiswa yang dapat dipanggil.");
            return;
        }
        Mhs dipanggil = head.data;
        head = head.next; 
        size--;
        
        if (head == null) {
            tail = null; 
        }
        
        System.out.print("Melayani mahasiswa: ");
        dipanggil.tampilData();
    }

    public void tampilTerdepanDanTerakhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("\n=== Informasi Batas Antrian ===");
        System.out.print("[TERDEPAN] -> ");
        head.data.tampilData();
        System.out.print("[TERAKHIR] -> ");
        tail.data.tampilData();
        System.out.println("================================\n");
    }

    public int getJumlahAntrean() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("\n=== Daftar Antrian Saat Ini ===");
        Queue temp = head;
        int no = 1;
        while (temp != null) {
            System.out.print(no + ". ");
            temp.data.tampilData();
            temp = temp.next;
            no++;
        }
        System.out.println("===============================\n");
    }
}

