package Jobsheet9;

import java.util.Stack;

public class StackTugasMhs20 {
    Mahasiswa20[] stack;
    int top;
    int size;

    public StackTugasMhs20(int size) {
        stack = new Mahasiswa20[size];
        this.size = size;
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa20 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
        }
    }

    public Mahasiswa20 pop() {
        if (!isEmpty()) {
            Mahasiswa20 mhs = stack[top];
            top--;
            return mhs;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk diambil.");
            return null;
        }
    }

    public Mahasiswa20 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk dilihat.");
            return null;
        }
    }

    public Mahasiswa20 peekBottom() {
        if (!isEmpty()) {
            return stack[0];
        } else {
            System.out.println("Stack masih kosong!");
            return null;
        }
    }

    public void print() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i].nim + "\t" + stack[i].nama + "\t" + stack[i].kelas);
            }
        } else {
            System.out.println("");
        }
    }

    public int getJumlahTugas() {
        return top + 1;
    }
}
