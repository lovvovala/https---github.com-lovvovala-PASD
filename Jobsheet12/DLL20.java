package Jobsheet12;

public class DLL20 {
    Node20 head;
    Node20 tail;

    public DLL20() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mhs20 data) {
        Node20 newNode = new Node20(data, null, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mhs20 data) {
        Node20 newNode = new Node20(data, null, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    public void InsertAfter(String keyNim, Mhs20 data) {
        Node20 current = head;
        while (current != null) {
            System.out.println("Mencari: " + current.data.nim);

            if (current.data.nim.equals(keyNim)) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("NIM " + keyNim + " tidak ditemukan.");
            return;
        }
        Node20 newNode = new Node20(data, null, null);

        // jika current adalah tail, node baru ditambahkan di akhir
        if (current == tail) {
            newNode.prev = current;
            current.next = newNode;
            tail = newNode;
        } else { // node baru disisipkan di tengah
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        } else {
            Node20 current = head;
            while (current != null) {
                current.data.tampil();
                current = current.next;
            }
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
        } else {
            Node20 current = tail;
            System.out.println("Cetak dari belakang:");
            while (current != null) {
                current.data.tampil();
                current = current.prev;
            }
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }

        Mhs20 dataDihapus = head.data;

        if (head == tail) { 
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data yang dihapus: ");
        dataDihapus.tampil();
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        Mhs20 dataDihapus = tail.data;
        if (head == tail) { 
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data yang dihapus: ");
        dataDihapus.tampil();
    }
}

