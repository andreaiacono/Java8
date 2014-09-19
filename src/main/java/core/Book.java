package core;

import java.util.List;

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
    private String ISBN;
    private int year;

    public Book(List<Author> authors, String title, int pages, Genre genre, String isbn, int year) {
        this.authors = authors;
        this.title = title;
        this.pages = pages;
        this.genre = genre;
        this.ISBN = isbn;
        this.year = year;
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

    public String getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
