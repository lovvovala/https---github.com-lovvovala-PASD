package Jobsheet3;

public class DataDosen20 {
    void dataSemuaDosen(Dosen20[] arrayOfDosen) {
        for (int i = 0; i < arrayOfDosen.length; i++) {
            System.out.println("Data Dosen ke-" + (i + 1));
            System.out.println("Kode\t: " + arrayOfDosen[i].kode);
            System.out.println("Nama\t: " + arrayOfDosen[i].nama);
            System.out.println("Jenis Kelamin\t: " + (arrayOfDosen[i].jenisKelamin ? "Laki-laki" : "Perempuan"));
            System.out.println("Usia\t: " + arrayOfDosen[i].usia);
            System.out.println("---------------------------------------------");
        }
    }

    void jumlahDosenperJenisKelamin(Dosen20[] arrayOfDosen) {
        int jumlahLaki = 0;
        int jumlahPerempuan = 0;
        for (Dosen20 dosen : arrayOfDosen) {
            if (dosen.jenisKelamin) {
                jumlahLaki++;
            } else {
                jumlahPerempuan++;
            }
        }
        System.out.println("Jumlah Dosen Laki-laki: " + jumlahLaki);
        System.out.println("Jumlah Dosen Perempuan: " + jumlahPerempuan);
        System.out.println("==============================================================");
    }

    void rataRataUsiaDosenperJenisKelamin(Dosen20[] arrayOfDosen) {
        int totalUsiaLaki = 0;
        int totalUsiaPerempuan = 0;
        int jumlahLaki = 0;
        int jumlahPerempuan = 0;
        for (Dosen20 dosen : arrayOfDosen) {
            if (dosen.jenisKelamin) {
                totalUsiaLaki += dosen.usia;
                jumlahLaki++;
            } else {
                totalUsiaPerempuan += dosen.usia;
                jumlahPerempuan++;
            }
        }
        double rataRataLaki = (double) totalUsiaLaki / jumlahLaki;
        double rataRataPerempuan = (double) totalUsiaPerempuan / jumlahPerempuan;
        System.out.println("Rata-rata Usia Dosen Laki-laki: " + rataRataLaki);
        System.out.println("Rata-rata Usia Dosen Perempuan: " + rataRataPerempuan);
        System.out.println("==============================================================");
    }

    void DosenTertua(Dosen20[] arrayOfDosen) {
        Dosen20 dosenTertua = arrayOfDosen[0];
        for (Dosen20 dosen : arrayOfDosen) {
            if (dosen.usia > dosenTertua.usia) {
                dosenTertua = dosen;
            }
        }
        System.out.println("Dosen Tertua:");
        System.out.println("Kode\t: " + dosenTertua.kode);
        System.out.println("Nama\t: " + dosenTertua.nama);
        System.out.println("Jenis Kelamin\t: " + (dosenTertua.jenisKelamin ? "Laki-laki" : "Perempuan"));
        System.out.println("Usia\t: " + dosenTertua.usia);
        System.out.println("==============================================================");
    }

    void DosenTermuda(Dosen20[] arrayOfDosen) {
        Dosen20 dosenTermuda = arrayOfDosen[0];
        for (Dosen20 dosen : arrayOfDosen) {
            if (dosen.usia < dosenTermuda.usia) {
                dosenTermuda = dosen;
            }
        }
        System.out.println("Dosen Termuda:");
        System.out.println("Kode\t: " + dosenTermuda.kode);
        System.out.println("Nama\t: " + dosenTermuda.nama);
        System.out.println("Jenis Kelamin\t: " + (dosenTermuda.jenisKelamin ? "Laki-laki" : "Perempuan"));
        System.out.println("Usia\t: " + dosenTermuda.usia);
        System.out.println("==============================================================");
    }

}
