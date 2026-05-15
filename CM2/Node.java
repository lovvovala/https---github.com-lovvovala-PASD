package CM2;

public class Node {
    Object data;
    int nomorAntrean; // khusus untuk antrean pembeli
    Node prev, next;

    Node(Object data) {
        this.data = data;
    }

    Node(Object data, int nomor) {
        this.data = data;
        this.nomorAntrean = nomor;
    }
} 

