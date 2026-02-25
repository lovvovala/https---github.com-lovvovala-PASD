package Jobsheet3;
import java.util.Scanner;
public class MahasiswaDemo20 {
 public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Mahasiswa20[] arrayofMahasiswa20s = new Mahasiswa20[3];
    String dummy;

    for (int i = 0; i < arrayofMahasiswa20s.length; i++) {
        arrayofMahasiswa20s[i] = new Mahasiswa20();
        System.out.println("Masukkan data mahasiswa ke-"+(i+1));
        System.out.print("NIM\t: ");
        arrayofMahasiswa20s[i].nim = input.nextLine();
        System.out.print("Nama\t: ");
        arrayofMahasiswa20s[i].nama = input.nextLine();
        System.out.print("Kelas\t: ");
        arrayofMahasiswa20s[i].kelas = input.nextLine();
        System.out.print("IPK\t: ");
        dummy = input.nextLine();
        arrayofMahasiswa20s[i].ipk = Float.parseFloat(dummy);
        System.out.println("---------------------------------------------");
    }
    for (int i = 0; i < arrayofMahasiswa20s.length; i++) {
        System.out.println("Data mahasiswa ke-"+(i+1));
        System.out.println("NIM\t: " + arrayofMahasiswa20s[i].nim);
        System.out.println("Nama\t: " + arrayofMahasiswa20s[i].nama);
        System.out.println("Kelas\t: " + arrayofMahasiswa20s[i].kelas);
        System.out.println("IPK\t: " + arrayofMahasiswa20s[i].ipk);
        System.out.println("---------------------------------------------");
    }
 }   
}
