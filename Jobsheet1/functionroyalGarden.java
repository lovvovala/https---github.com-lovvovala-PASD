package Jobsheet1;

public class functionroyalGarden {
   static int[][] stock = {
        {10, 5, 15, 7}, // RoyalGarden 1
        {6, 11, 9, 12}, // RoyalGarden 2
        {2, 10, 10, 5}, // RoyalGarden 3
        {5, 7, 12, 9}   // RoyalGarden 4
    };
    static int[] harga = {75000, 50000, 60000, 10000}; // Aglonema, Keladi, Alocasia, Mawar 
    static void tampilkanPendapatan() {
        for (int i = 0; i < stock.length; i++) {
            int pendapatan = 0;
            for (int j = 0; j < stock[i].length; j++) {
                pendapatan += (stock[i][j] * harga[j]); // Stok x Harga 
            }
            
            // 3. Tentukan Status 
            String status = (pendapatan > 1500000) ? "Sangat Baik" : "Perlu Evaluasi";
            
            System.out.printf("RoyalGarden %d : Rp %,d (%s)\n", (i + 1), pendapatan, status);
        }
    } 
    public static void main(String[] args) {
        System.out.println("=== PENDAPATAN CABANG ROYAL GARDEN ===");
        tampilkanPendapatan(); // Memanggil fungsi 
    }
}
