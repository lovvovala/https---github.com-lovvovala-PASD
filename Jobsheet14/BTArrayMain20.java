package Jobsheet14;

public class BTArrayMain20 {
    public static void main(String[] args) {
        BTArray20 bta = new BTArray20();


        System.out.println("=== PENGUJIAN METHOD ADD() ARRAY ===");
        // Memasukkan data satu per satu menggunakan method add() baru
        bta.add(new Mhs20("244160121", "Ali", "A", 3.57));
        bta.add(new Mhs20("244160185", "Candra", "C", 3.41));
        bta.add(new Mhs20("244160221", "Badar", "B", 3.75));
        bta.add(new Mhs20("244160220", "Dewi", "B", 3.35));
        bta.add(new Mhs20("244160131", "Devi", "A", 3.48));
        bta.add(new Mhs20("244160205", "Ehsan", "D", 3.61));
        bta.add(new Mhs20("244160170", "Fizi", "B", 3.86));

        System.out.println("\n================================================");
        System.out.println("Inorder Traversal Mahasiswa (Kiri -> Root -> Kanan):");
        System.out.println("================================================");
        bta.traverseInOrder(0);

        System.out.println("\n================================================");
        System.out.println("PreOrder Traversal Mahasiswa (Root -> Kiri -> Kanan):");
        System.out.println("================================================");
        bta.traversePreOrder(0);
    }
}
