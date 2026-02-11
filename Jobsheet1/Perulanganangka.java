package Jobsheet1;

import java.util.Scanner;

public class Perulanganangka {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("Program Perulangan Angka Berdasarkan NIM");
        System.out.print("Masukkan NIM : ");
        String nimTeks = input.next();
        int[] nimArray = new int[12];
        for (int i = 0; i < 12; i++) {
            nimArray[i] = Character.getNumericValue(nimTeks.charAt(i));
        }
        int digit1 = nimArray[10]; 
        int digit2 = nimArray[11]; 
        int n = (digit1 * 10) + digit2;
        if (n < 10) {
            n += 10;
        }
        System.out.println("n : " + n);
        System.out.println("--------------------------------");
        for (int i = 1; i <= n; i++) {
            if (i == 10 || i == 15) {
                continue; // Angka 10 dan 15 tidak dicetak
            }

            if (i % 3 == 0) {
                System.out.print("# "); // Kelipatan 3
            } else if (i % 2 == 0) {
                System.out.print(i + " "); // Genap
            } else {
                System.out.print("* "); // Ganjil
            }
        }

    }
}