package Jobsheet1;
import java.util.Scanner;
public class tugas1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Array 1 dimensi kode plat
        char[] KODE = {
                'A', 'B', 'D', 'E', 'F',
                'G', 'H', 'L', 'N', 'T'
        };
        // Array 2 dimensi nama kota
        char[][] KOTA = {
                {'B','A','N','T','E','N'},
                {'J','A','K','A','R','T','A'},
                {'B','A','N','D','U','N','G'},
                {'C','I','R','E','B','O','N'},
                {'B','O','G','O','R'},
                {'P','E','K','A','L','O','N','G','A','N'},
                {'S','E','M','A','R','A','N','G'},
                {'S','U','R','A','B','A','Y','A'},
                {'M','A','L','A','N','G'},
                {'T','E','G','A','L'}
        };
        // Input kode plat
        System.out.print("Masukkan kode plat nomor: ");
        char input = sc.next().toUpperCase().charAt(0);
        boolean ditemukan = false;
        // Pencarian kode plat
        for (int i = 0; i < KODE.length; i++) {
            if (input == KODE[i]) {
                System.out.print("Nama Kota : ");
                for (int j = 0; j < KOTA[i].length; j++) {
                    System.out.print(KOTA[i][j]);
                }
                System.out.println();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Kode plat tidak ditemukan");
        }

        sc.close();
    }
}

