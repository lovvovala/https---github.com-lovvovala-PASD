package Jobsheet14;

public class BTArray20 {
    Mhs20[] dataMhs;
    int idxLast;

    public BTArray20() {
        this.dataMhs = new Mhs20[10];
        this.idxLast = -1;
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

    //Tugas 4 : Method add() untuk menambahkan data mahasiswa ke dalam array
    void add(Mhs20 mhs) {
        if (idxLast >= dataMhs.length - 1) { // mengecek apakah masih ada ruang untuk menambahkan data mahasiswa
        System.out.println("Array sudah penuh, tidak dapat menambahkan data mahasiswa.");
        return;
        }
        idxLast++;
        dataMhs[idxLast] = mhs;
        System.out.println("Data mahasiswa berhasil ditambahkan: " + mhs.nama + " berhasil ditambahkan ke index " + idxLast);
    }
    // Tugas 4 : Method traversePreOrder() 
    void traversePreOrder(int idxStart) {
        // POLA : ROOT -> Subtree Kiri -> Subtree Kanan
        if (idxStart <= idxLast) {
            if (dataMhs[idxStart] != null) {
                dataMhs[idxStart].tampilkan();
                traversePreOrder(2 * idxStart + 1); // rekrusif ke subtree kiri
                traversePreOrder(2 * idxStart + 2); // rekrusif ke subtree kanan
            }
        }
    }
}

