package Problem_01_Book;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("01 Animal Farm", 2010, "George Orwell");

        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookFour = new Book("Animal Farm", 2008, "George Orwell");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        books.add(bookFour);

        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + book.getYear());
        }
    }

}
