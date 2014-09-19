package lambda;

import core.Book;
import core.Genre;
import core.Setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 18/06/14
 * Time: 14.47
 */
public class PredicateFilterSample {

    public static void main(String[] args) {

        // instead of specifying our functional interface for filtering,
        // we can use a Predicate
        List<Book> longBooks = lambdaFilter(Setup.books, b -> b.getPages() > 400);
        System.out.println("Lambda long books: " + Arrays.toString(longBooks.toArray()));

        Predicate<Book> nflbFilter = b -> b.getPages() > 400 && Genre.NON_FICTION == b.getGenre();
        List<Book> longNonFictionBooks = lambdaFilter(Setup.books, nflbFilter);
        System.out.println("Lambda long non fiction books: " + Arrays.toString(longNonFictionBooks.toArray()));
    }

    public static List<Book> lambdaFilter(List<Book> books, Predicate<Book> bookFilter) {
        List<Book> accumulator = new ArrayList<>();
        for (Book book : books) {
            if (bookFilter.test(book)) {
                accumulator.add(book);
            }
        }
        return accumulator;
    }


}
