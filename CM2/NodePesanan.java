package CM2;

public class NodePesanan {
    Pesanan data;
    NodePesanan prev, next;

    // Pastikan urutannya: (prev, data, next)
    public NodePesanan(NodePesanan prev, Pesanan data, NodePesanan next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}