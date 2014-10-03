package streams;

import core.Author;
import core.Book;
import core.Setup;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.joining;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 16/09/14
 * Time: 16.47
 */
public class Samples {

    public static void main(String[] args) {
        List<Book> longBooks = Setup.books.stream().filter(b -> b.getPages()>400).collect(toList());
        System.out.println(Arrays.toString(longBooks.toArray()));

        List<String> titles = Setup.books.stream().map(b -> b.getTitle()).collect(toList());
        System.out.println("titles: " + Arrays.toString(titles.toArray()));

        List<Integer> allYears = Setup.books.stream().map(b -> b.getYear()).distinct().collect(toList());
        System.out.println("years: " + Arrays.toString(allYears.toArray()));

        boolean onlyShortBooks = Setup.books.stream().allMatch(b -> b.getAuthors().size() > 1);
        System.out.println("Are all books short? " + onlyShortBooks);

        Optional<Book> multiAuthorBook = Setup.books.stream().filter((b -> b.getAuthors().size() > 1)).findAny();
        System.out.println("Multi author book: " + multiAuthorBook.orElseGet(Book.emptyBook()));

        Optional<Integer> totalPages = Setup.books.stream().map(Book::getPages).reduce(Integer::sum);
        System.out.println("Total number of pages: " + totalPages);

        Integer totalPages2 = Setup.books.stream().map(Book::getPages).reduce(0, (b1, b2) -> b1 + b2);
        System.out.println("Total number of pages(2): " + totalPages2);

        Optional<Integer> longestBook = Setup.books.stream().map(Book::getPages).reduce(Integer::max);
        System.out.println("Longest book has : " + longestBook + " pages.");

        Double averagePages = Setup.books.stream().collect(averagingInt(Book::getPages));
        System.out.println("Book average page number: " + averagePages + " pages.");

        String allTitles = Setup.books.stream().map(Book::getTitle).collect(joining(", "));
        System.out.println("All books titles: " + allTitles);

        List<Book> top3LongestBooks = Setup.books.stream().sorted((b1, b2) -> b2.getPages() - b1.getPages()).limit(3).collect(toList());
        System.out.println("top 3 longest books: " + Arrays.toString(top3LongestBooks.toArray()));

        List<String> countries = Setup.books.stream().flatMap(b -> b.getAuthors().stream()).map(author -> author.getCountry()).distinct().collect(toList());
        Set<Author> authors = Setup.books.stream().flatMap(b -> b.getAuthors().stream()).collect(toSet());
        System.out.println("Countries: " + Arrays.toString(countries.toArray()));
        System.out.println("Authors: " + Arrays.toString(authors.toArray()));

        Optional<Book> higherNumberOfAuthorsBook = Setup.books.stream().collect(maxBy(comparing(b -> b.getAuthors().size())));
        System.out.println("Book with higher number of authors: " + higherNumberOfAuthorsBook.orElseGet(Book.emptyBook()));

        Optional<Book> lastPublishedBook = Setup.books.stream().min(Comparator.comparingInt(Book::getYear));
        System.out.println("Last published book: " + lastPublishedBook.orElseGet(Book.emptyBook()));

        lastPublishedBook = Setup.books.stream().sorted((b1,b2) -> b1.getYear() - b2.getYear()).findFirst();
        System.out.println("Again Last published book: " + lastPublishedBook.orElseGet(Book.emptyBook()));

        Setup.books.clear();
        lastPublishedBook = Setup.books.stream().min(Comparator.comparingInt(Book::getYear));
        System.out.println("Last published book after clear(): " + lastPublishedBook.orElseGet(Book.emptyBook()));
    }
}
