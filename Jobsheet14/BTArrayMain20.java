package Jobsheet14;

public class BTArrayMain20 {
    public static void main(String[] args) {
        BTArray20 bta = new BTArray20();
        Mhs20 mhs1 = new Mhs20("244160121", "Ali", "A", 3.57);
        Mhs20 mhs2 = new Mhs20("244160185", "Candra", "C", 3.41);
        Mhs20 mhs3 = new Mhs20("244160221", "Badar", "B", 3.75);
        Mhs20 mhs4 = new Mhs20("244160220", "Dewi", "B", 3.35);

        Mhs20 mhs5 = new Mhs20("244160131", "Devi", "A", 3.48);
        Mhs20 mhs6 = new Mhs20("244160205", "Ehsan", "D", 3.61);
        Mhs20 mhs7 = new Mhs20("244160170", "Fizi", "B", 3.86);

        Mhs20[] dataMhs = { mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null };
        int idxLast = 6;
        bta.populateData(dataMhs, idxLast);
        System.out.println("\nInOrder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);
    }
}
