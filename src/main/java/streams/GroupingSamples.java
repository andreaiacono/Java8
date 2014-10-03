package streams;

import core.Book;
import core.Genre;
import core.Setup;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 23/09/14
 * Time: 23.32
 */
public class GroupingSamples {
    public static void main(String[] args) {
        Map<Integer, List<Book>> booksPerYear = Setup.books.stream().collect(groupingBy(Book::getYear));
        System.out.println("Books per year: " + booksPerYear);

        Map<Integer, Map<Genre, List<Book>>> booksPerYearPerGenre = Setup.books.stream().collect(groupingBy(Book::getYear, groupingBy(Book::getGenre)));
        System.out.println("Books per year per genre: " + booksPerYearPerGenre);

        Map<Integer, Long> bookCountPerYear = Setup.books.stream().collect(groupingBy(Book::getYear, counting()));
        System.out.println("Book count per year: " + bookCountPerYear);

        Integer sumOfPages = Setup.books.stream().collect(summingInt(Book::getPages));
        System.out.println("Total number of pages: " + sumOfPages);

        Integer sumOfPages2 = Setup.books.stream().map(Book::getPages).reduce(Integer::sum).get();
        System.out.println("Total number of pages (2): " + sumOfPages2);

        Double averagePages = Setup.books.stream().collect(averagingInt(Book::getPages));
        System.out.println("Average number of pages: " + averagePages);
    }
}
