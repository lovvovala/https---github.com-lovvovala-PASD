package Jobsheet14;

public class BinaryTree20 {
    Node20 root;

    public BinaryTree20() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mhs20 mhs) {
        Node20 newNode = new Node20(mhs);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node20 current = root;
            Node20 parent = null;
            while (true) {
                parent = current;
                if (mhs.ipk < current.mhs.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node20 current = root;
        while (current != null) {
            if (current.mhs.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mhs.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node20 node) {
        if (node != null) {
            node.mhs.tampilkan();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node20 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mhs.tampilkan();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node20 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mhs.tampilkan();
        }
    }

    Node20 getSuccessor(Node20 del) {
        Node20 successor = del.right;
        Node20 successorParent = del;
        while (successor.left!= null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println(" Binary Tree kosong");
            return;
        }
        // cari node (current) yang akan dihapus
        Node20 parent = root;
        Node20 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mhs.ipk == ipk) {
                break;
            } else if (ipk < current.mhs.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        // Penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) { // jika hanya punya 1 anak (kanan)
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) { // jika hanya punya 1 anak (kiri)
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else { // jika punya 2 anak
                Node20 successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }

    //Tugas 1 : Menabahkan Node secara rekursif
    public void addRekursif(Mhs20 mhs) {
        root = addRekursifHelper(root, mhs);
    }

    private Node20 addRekursifHelper(Node20 current, Mhs20 mhs) { // untuk menambahkan node secara rekursif dengan method bantuan/helper
        if (current == null) { // jika posisi kosong
            return new Node20(mhs);
        }
        if (mhs.ipk < current.mhs.ipk) { // jika ipk yang akan ditambahkan lebih kecil dari ipk pada node saat ini, maka akan ditambahkan ke subtree kiri
            current.left = addRekursifHelper(current.left, mhs);
        } else { // jika ipk yang akan ditambahkan lebih besar atau sama dengan ipk pada node saat ini, maka akan ditambahkan ke subtree kanan
            current.right = addRekursifHelper(current.right, mhs);
        }
        return current;
    }

    // Tugas 2 : Mencari Data Mahasiswa dengan ipk terkecil
    public void findMin() {
        if (isEmpty()) {
            System.out.println("Binary Tree kosong");
            return;
        }
        Node20 current = root;
        while (current.left != null) { // untuk mencari node dengan ipk terkecil, kita akan terus menelusuri subtree kiri hingga mencapai node paling kiri
            current = current.left;
        }
        System.out.println("Data mahasiswa dengan ipk terkecil: ");
        current.mhs.tampilkan();
    }
    // Tugas 2 : Mencari Data Mahasiswa dengan ipk terbesar
    public void findMax() {
        if (isEmpty()) {
            System.out.println("Binary Tree kosong");
            return;
        }
        Node20 current = root;
        while (current.right != null) { // untuk mencari node dengan ipk terbesar, kita akan terus menelusuri subtree kanan hingga mencapai node paling kanan
            current = current.right;
        }
        System.out.println("Data mahasiswa dengan ipk terbesar: ");
        current.mhs.tampilkan();
    }

    // Tugas 3 : Mencari Data Mahasiswa dengan ipk di atas Batas Tertentu
    public void findAbove(double batas) {
        if (isEmpty()) {
            System.out.println("Binary Tree kosong");
            return;
        }
        System.out.println("Data mahasiswa dengan ipk di atas " + batas + ": ");
        findAboveHelper(root, batas);
    }
    // method bantuan/helper untuk mencari data mahasiswa dengan ipk di atas batas tertentu secara rekursif
    private void findAboveHelper(Node20 current, double batas) {
        if (current != null) {
            findAboveHelper(current.left, batas);
            if (current.mhs.ipk > batas) {
                current.mhs.tampilkan();
            }
            findAboveHelper(current.right, batas);
        }
    }
}
