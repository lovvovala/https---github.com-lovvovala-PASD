package JOBSHEET5;
import java.util.Scanner;
public class MainFaktorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka untuk menghitung faktorial: ");
        int nilai = input.nextInt();
        Faktorial fk = new Faktorial();
        System.out.println("Nilai faktotial " +nilai+ "menggunakan BF: "+fk.faktorialBF(nilai));
        System.out.println("Nilai faktotial " +nilai+ "menggunakan DC: "+fk.faktorialDC(nilai));
    }
}
