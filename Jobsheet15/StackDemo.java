package Jobsheet15;
import java.util.Stack;
public class StackDemo {
    public static void main(String[] args) {
        Stack<Book> book = new Stack<>();
        Book book1 = new Book("1234", "Dasar Pemrograman");
        Book book2 = new Book("7541", "Lucunya Prabowo");
        Book book3 = new Book("3562", "Felia Imut");

        Stack<Book> bookS = new Stack<>();
        bookS.push(book1);
        bookS.push(book2);
        bookS.push(book3);

        Book temp = bookS.peek();
        if (temp != null){
            System.out.println(temp.toString());
        }

        Book temp2 = bookS.pop();
        if (temp2 != null){
            System.out.println(temp2.toString());
        }

        for (Book b : bookS) {
            System.out.println(b.toString());
        }

        System.out.println(bookS);
    }
}
