package streams;

import core.Book;
import core.Genre;
import core.Setup;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 30/09/14
 * Time: 23.06
 */
public class Partitioning {
    public static void main(String[] args) {

        Map<Boolean, List<Book>> hardCoverBooks = Setup.books.stream().collect(partitioningBy(Book::hasHardCover));
        System.out.println("Hard Cover books: " + hardCoverBooks.get(true));

        Map<Boolean, Map<Genre, List<Book>>> hardCoverBooksByGenre = Setup.books.stream().collect(partitioningBy(Book::hasHardCover, groupingBy(Book::getGenre)));
        System.out.println("Hard Cover books by genre: " + hardCoverBooksByGenre.get(true));

        Map<Boolean, Long> count = Setup.books.stream().collect(partitioningBy(Book::hasHardCover, counting()));
        System.out.println("Books count by hardcover: " + count);
    }
}
