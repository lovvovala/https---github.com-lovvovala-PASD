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
}
