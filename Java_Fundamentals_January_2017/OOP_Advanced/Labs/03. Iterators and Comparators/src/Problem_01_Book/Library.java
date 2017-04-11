package Problem_01_Book;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books){
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return books.length > counter;
        }

        @Override
        public Book next() {
            Book nextBook = books[counter];
            counter++;
            return nextBook;
        }
    }
}
