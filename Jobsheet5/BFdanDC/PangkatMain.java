package Jobsheet5.BFdanDC;
import java.util.Scanner;
public class PangkatMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen: ");
        int elemen = sc.nextInt();

        Pangkat [] png = new Pangkat[elemen];
        for (int i = 0; i < elemen; i++) {
            System.out.print("Masukkan nilai basis untuk elemen ke-" + (i + 1) + ": ");
            int basis= sc.nextInt();
            System.out.print("Masukkan nilai pangkat untuk elemen ke-" + (i + 1) + ": ");
            int pangkat= sc.nextInt();
            png[i] = new Pangkat(basis, pangkat);
        }

      System.out.println("\nHasil Perhitungan Pangkat dengan Brute Force:");
        for (Pangkat p : png) {
            System.out.println(p.nilai + " pangkat " + p.pangkat + " = " + p.pangkatBF(p.nilai, p.pangkat));
        }

        System.out.println("\nHasil Perhitungan Pangkat dengan Divide and Conquer:");
        for (Pangkat p : png) {
            System.out.println(p.nilai + " pangkat " + p.pangkat + " = " + p.pangkatDC(p.nilai, p.pangkat));
        }
    }
}
