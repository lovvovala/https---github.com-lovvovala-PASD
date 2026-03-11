package Jobsheet5.BFdanDC;
import java.util.Scanner;
public class FaktorialMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nilai n: ");
        int n = sc.nextInt();


        Faktorial fk = new Faktorial();
        System.out.println("Faktorial dengan Brute Force: " + fk.faktorialBF(n));
        System.out.println("Faktorial dengan Divide and Conquer: " + fk.faktorialDC(n));
    }
}
