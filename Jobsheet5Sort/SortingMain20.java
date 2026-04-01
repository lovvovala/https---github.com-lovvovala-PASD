package Jobsheet5Sort;

public class SortingMain20 {
    public static void main(String[] args) {
        int a[] = { 20, 10, 2, 7, 12 };

        Sorting20 dataurut1 = new Sorting20(a, a.length);
        System.out.println("Data awal 1 : ");
        dataurut1.tampil();
        dataurut1.bubbleSort();
        System.out.println("Data setelah diurutkan dengan Bubble Sort (ASC): ");
        dataurut1.tampil();
        System.out.println("================================");

        int b[] = { 30,20,2,8,14};
        Sorting20 dataurut2 = new Sorting20(b, b.length);
        System.out.println("Data awal 2 : ");
        dataurut2.tampil();
        dataurut2.SelectionSort();
        System.out.println("Data setelah diurutkan dengan Selection Sort (ASC): ");
        dataurut2.tampil();
        System.out.println("================================");

        int c[]= {40,10,4,9,3};
        Sorting20 dataurut3 = new Sorting20(c, c.length);
        System.out.println("Data awal 3 : ");
        dataurut3.tampil();
        dataurut3.insertionSort();
        System.out.println("Data setelah diurutkan dengan Insertion Sort (ASC): ");
        dataurut3.tampil();
        System.out.println("================================");

    }
}
