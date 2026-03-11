package Jobsheet5.BFdanDC;

public class NilaiSistem {
    int cariMaxUTS(Mahasiswa arr[], int l, int r) {
        if (l == r) {
            return arr[l].nilaiUTS;
        }
        int mid = (l + r) / 2;
        int maxKiri = cariMaxUTS(arr, l, mid);
        int maxKanan = cariMaxUTS(arr, mid + 1, r);
        return Math.max(maxKiri, maxKanan);
    }

    int cariMinUTS(Mahasiswa arr[], int l, int r) {
        if (l == r) {
            return arr[l].nilaiUTS;
        }
        int mid = (l + r) / 2;
        int minKiri = cariMinUTS(arr, l, mid);
        int minKanan = cariMinUTS(arr, mid + 1, r);
        return Math.min(minKiri, minKanan);
    }

    double hitungRataRataUAS(Mahasiswa[] mhs) {
        double total = 0;
        for (int i = 0; i < mhs.length; i++) {
            total += mhs[i].nilaiUAS;
        }
        return total / mhs.length;  
    }
}
