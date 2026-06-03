package Jobsheet15;
import java.util.ArrayList;
import java.util.Collections;
public class DemoArrayLIst {
    public static void main(String[] args) {
        ArrayList<Custumer> cus= new ArrayList<>();
        Custumer cus1 = new Custumer(1, "Zakia");
        Custumer cus2 = new Custumer(2, "Budi");

        cus.add(cus1);
        cus.add(cus2);

        cus.add(new Custumer(4, "Cicak"));

        cus.add(2, new Custumer(100, "Rosa"));

        System.out.println(cus.indexOf(cus2));

        Custumer cust = cus.get(1);
        System.out.println(cust.name);
        cust.name = "Budi Utomo";

        ArrayList<Custumer> newcust = new ArrayList<>();
        newcust.add (new Custumer(201, "Doraemon"));
        newcust.add (new Custumer(202, "Nobita"));
        newcust.add (new Custumer(203, "Shizuka"));

        cus.addAll(newcust);

        for (Custumer c : cus) {
            System.out.println(c.toString());
        }

        System.out.println(cus);

        ArrayList<String> daftarSiswa = new ArrayList<>();
        daftarSiswa.add("Zakky");
        daftarSiswa.add("Andi");
        daftarSiswa.add("Rara");
        Collections.sort(daftarSiswa);

        System.out.println(daftarSiswa);

        cus.sort((c1, c2) -> c1.name.compareTo(c2.name));
        System.out.println(cus);
    }
}
