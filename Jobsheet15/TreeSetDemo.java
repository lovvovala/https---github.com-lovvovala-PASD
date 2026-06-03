package Jobsheet15;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> fruit = new TreeSet<>();

        fruit.add("Naga(DragonFruit)");
        fruit.add("Mangga(Mango)");
        fruit.add("Apel(Apple)");
        fruit.add("Jeruk(Orange)");
        fruit.add("Jambu(Jambu)");

        for (String temp : fruit) {
            System.out.println(temp);
        }

        System.out.println("First: " + fruit.first());
        System.out.println("Last: " + fruit.last());

        fruit.remove("Jeruk(Orange)");
        System.out.println("Setelah remove: " + fruit);

        fruit.pollFirst();
        System.out.println("Setelah pollFirst: " + fruit);

        fruit.pollLast();
        System.out.println("Setelah pollLast: " + fruit);

    }
}
