package Jobsheet14;

public class BTArray20 {
    Mhs20[] dataMhs;
    int idxLast;

    public BTArray20() {
        this.dataMhs = new Mhs20[10];
    }

    void populateData(Mhs20 dataMhs[], int idxLast) {
        this.dataMhs = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMhs[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMhs[idxStart].tampilkan();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
}
