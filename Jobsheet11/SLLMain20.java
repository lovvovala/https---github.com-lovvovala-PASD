package Jobsheet11;
import java.util.Scanner;
public class SLLMain20 {
    public static void main(String[] args) {
        SingleLinkedList20 sll = new SingleLinkedList20();
        Scanner sc = new Scanner(System.in);

        Mahasiswa20 mhs1 = new Mahasiswa20("21212200", "Alvaro", "C", 3.0);
        Mahasiswa20 mhs2 = new Mahasiswa20("21212202", "Cintia", "B", 3.2);
        Mahasiswa20 mhs3 = new Mahasiswa20("21212201", "Bimon", "A", 3.8);
        Mahasiswa20 mhs4 = new Mahasiswa20("21212204", "Dirga", "A", 3.5);

        sll.print();
        sll.addFirst(mhs4);
        sll.print();
        sll.addLast(mhs1);
        sll.print();
        sll.insertAfter("Dirga", mhs3);
        sll.insertAt(2, mhs2);
        sll.print();

        System.out.println("data index 1: ");
        sll.getData(1); 
        
        System.out.println("data mahasiswa an Bimon berada pada index: " + sll.indexOf("Bimon"));
        System.out.println();

        sll.removeFirst();
        sll.removeLast();  
        sll.print();

        sll.removeAt(0);   // Menghapus data di indeks 0
        sll.print();
    }
}