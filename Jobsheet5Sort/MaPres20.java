package Jobsheet5Sort;

public class MaPres20 {
    Mahasiswa20[] listMhs = new Mahasiswa20[5];
    int idx;

    void tambah(Mahasiswa20 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampil() {
        for (Mahasiswa20 m : listMhs) {
            m.tampilInformasi();
            System.out.println("-----------------------------");
        }
    }

    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 0; j < listMhs.length - 1 - i; j++) {
                if (listMhs[j].ipk < listMhs[j + 1].ipk) {
                    Mahasiswa20 temp = listMhs[j];
                    listMhs[j] = listMhs[j + 1];
                    listMhs[j + 1] = temp;
                }
            }
        }
    }

    void selectionSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < listMhs.length; j++) {
                if (listMhs[j].ipk < listMhs[minIdx].ipk) {
                    minIdx = j;
                }
            }
            Mahasiswa20 temp = listMhs[minIdx];
            listMhs[minIdx] = listMhs[i];
            listMhs[i] = temp;
        }
    }

    void insertionSort() {
        for (int i = 1; i < listMhs.length; i++) {
            Mahasiswa20 key = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j-1].ipk < key.ipk) {
                listMhs[j] = listMhs[j-1];
                j--;
            }
            listMhs[j] = key;
        }
    }
}
