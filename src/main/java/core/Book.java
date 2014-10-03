package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 12/09/14
 * Time: 10.29
 */
public class Book {

    private List<Author> authors;
    private String title;
    private int pages;
    private Genre genre;
    private Optional<String> ISBN;
    private int year;
    private boolean hasHardCover;

    public Book(List<Author> authors, String title, int pages, Genre genre, Optional<String> isbn, int year, boolean hasHardCover) {
        this.authors = authors;
        this.title = title;
        this.pages = pages;
        this.genre = genre;
        this.ISBN = isbn;
        this.year = year;
        this.hasHardCover = hasHardCover;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public Optional<String> getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    public void setISBN(Optional<String> ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

    public boolean hasHardCover() {
        return hasHardCover;
    }

    public static Supplier<Book> emptyBook() {
        return () -> new Book(new ArrayList(), "", 0, Genre.NONE, Optional.empty(), 0, false);
    }
}
