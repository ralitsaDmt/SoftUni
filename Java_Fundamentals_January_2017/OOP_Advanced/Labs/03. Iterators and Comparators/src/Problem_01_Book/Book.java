package Problem_01_Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title){
        this.title = title;
    }

    private void setYear(int year){
        this.year = year;
    }

    private void setAuthors(String... authors){
        if (authors.length == 0){
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book otherBook) {
        if (this.year < otherBook.year) {
            return -1;
        } else if (this.year > otherBook.year){
            return 1;
        } else {
            return this.title.compareTo(otherBook.title);
        }
    }
}
