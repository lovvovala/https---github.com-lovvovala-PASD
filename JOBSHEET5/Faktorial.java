package JOBSHEET5;

public class Faktorial {

    int faktorialBF (int n) {
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto *= i;
        }
        return fakto;
    }

    int faktorialDC (int n) {
        if ( n == 1) {
            return 1;
        } else {
            return n * faktorialDC(n - 1);
        }
    }
}
