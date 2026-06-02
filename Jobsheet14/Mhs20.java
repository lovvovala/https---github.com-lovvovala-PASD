package Jobsheet14;

public class Mhs20 {
   String nim,nama, kelas;
   double ipk;

   public Mhs20() {
   }

   public Mhs20(String nim, String nama, String kelas, double ipk){
       this.nim = nim;
       this.nama = nama;
       this.kelas = kelas;
       this.ipk = ipk;
   }

   public void tampilkan(){
         System.out.println("NIM : " + this.nim + " " + 
         "Nama : " + this.nama + " " + 
         "Kelas : " + this.kelas + " " + 
         "IPK : " + this.ipk);
   }
}
