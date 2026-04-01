package Jobsheet5Sort;

public class DataDosen {
    Dosen[] listDosen = new Dosen[10];
    int idx =0;

    void tambah(Dosen d) {
        if (idx < listDosen.length) {
            listDosen[idx] = d;
            idx++;
        } else {
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            listDosen[i].tampil();
            System.out.println("-----------------------------");
        }
    }

    void SortingBubbleASC() {
       for (int i = 0; i < idx-1; i ++) {
            for (int j = 1; j < idx-i; j++) {
                if (listDosen[j].usia < listDosen[j-1].usia) {
                    Dosen temp = listDosen[j];
                    listDosen[j] = listDosen[j-1];
                    listDosen[j-1] = temp;
                }
            }
       }
    }

    void SortingSelectionDESC() {
        for (int i = 0; i < idx-1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < idx; j++) {
                if (listDosen[j].usia > listDosen[maxIdx].usia) {
                    maxIdx = j;
                }
            }
            Dosen temp = listDosen[maxIdx];
            listDosen[maxIdx] = listDosen[i];
            listDosen[i] = temp;
        }
    }
  
    //ATAU

    void SortingInsersionDESC() {
        for (int i = 1; i < idx; i++) {
            Dosen key = listDosen[i];
            int j = i;
            while (j > 0 && listDosen[j-1].usia < key.usia) {
                listDosen[j] = listDosen[j-1];
                j--;
            }
            listDosen[j] = key;
        }
    }
}
