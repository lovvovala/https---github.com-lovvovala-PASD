package Jobsheet3;

import java.util.Scanner;

public class MataKuliahDemo20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MataKuliah20[] arrayofMataKuliah20s = new MataKuliah20[3];
        String kodeMK, nama, dummy;
        int sks, jumlahJam;

        for (int i = 0; i < arrayofMataKuliah20s.length; i++) {
            System.out.println("Masukkan data mata kuliah ke-" + (i + 1));
            System.out.print("Kode\t: ");
            kodeMK = input.nextLine();
            System.out.print("Nama\t: ");
            nama = input.nextLine();
            System.out.print("SKS\t: ");
            dummy = input.nextLine();
            sks = Integer.parseInt(dummy);
            System.out.print("Jumlah Jam\t: ");
            dummy = input.nextLine();
            jumlahJam = Integer.parseInt(dummy);
            System.out.println("---------------------------------------------");

            arrayofMataKuliah20s[i] = new MataKuliah20(kodeMK, nama, sks, jumlahJam);
        }
        for (int i = 0; i < 3; i++) {

            arrayofMataKuliah20s[i] = new MataKuliah20(arrayofMataKuliah20s[i].kodeMK, arrayofMataKuliah20s[i].nama,
                    arrayofMataKuliah20s[i].sks, arrayofMataKuliah20s[i].jumlahJam);

            arrayofMataKuliah20s[i].tambahData(arrayofMataKuliah20s[i].kodeMK, arrayofMataKuliah20s[i].nama,
                    arrayofMataKuliah20s[i].sks, arrayofMataKuliah20s[i].jumlahJam);
        }
    }
}
