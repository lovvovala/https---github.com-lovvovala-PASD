package Jobsheet3;
import java.util.Scanner;
public class DosenDemo20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah dosen: ");
        int jumlah = input.nextInt();
        input.nextLine(); 
        Dosen20[] arrayOfDosen20 = new Dosen20[jumlah];
        String kode, nama, dummy;
        Boolean jenisKelamin;
        int usia;
        for (int i = 0; i < arrayOfDosen20.length; i++) {
            System.out.println("Masukkan data dosen ke-" + (i + 1));
            System.out.print("Kode\t\t\t: ");
            kode = input.nextLine();
            System.out.print("Nama\t\t\t: ");
            nama = input.nextLine();
            System.out.print("Jenis Kelamin (true untuk Pria, false untuk Wanita)\t: ");
            jenisKelamin = input.nextBoolean();
            input.nextLine(); 
            System.out.print("Usia\t\t\t: ");
            dummy = input.nextLine();
            usia = Integer.parseInt(dummy);
            arrayOfDosen20[i] = new Dosen20(kode, nama, jenisKelamin, usia);
            System.out.println("==============================================================");
        }

        System.out.println("\n===== DAFTAR DOSEN =====");
        int counter = 1;
        for (Dosen20 dosen : arrayOfDosen20) {
            System.out.println("Data Dosen ke-" + counter);
            System.out.println("Kode\t\t: " + dosen.kode);
            System.out.println("Nama\t\t: " + dosen.nama);
            System.out.println("Jenis Kelamin\t: " + (dosen.jenisKelamin ? "Pria" : "Wanita"));
            System.out.println("Usia\t\t: " + dosen.usia);
            System.out.println("==============================================================");
            counter++;

        }

        DataDosen20 dataDosen = new DataDosen20();
        System.out.println("\n===== ANALISIS DATA DOSEN =====");
        
        dataDosen.jumlahDosenperJenisKelamin(arrayOfDosen20);
        dataDosen.rataRataUsiaDosenperJenisKelamin(arrayOfDosen20);
        dataDosen.DosenTertua(arrayOfDosen20);     
        dataDosen.DosenTermuda(arrayOfDosen20);
    }
}
