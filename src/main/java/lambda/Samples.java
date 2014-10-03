package lambda;

import core.Book;
import core.Genre;
import core.Setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 18/06/14
 * Time: 14.47
 */
public class Samples {

    public static void main(String[] args) {

        // we want to get all the long books:
        List<Book> longBooks = getLongBooks(Setup.books);
        System.out.println("Long books: " + Arrays.toString(longBooks.toArray()));

        // if we want to modify the filter, we need to
        // create another one almost identical to the first
        List<Book> longNonFictionBooks = getNonFictionLongBooks(Setup.books);
        System.out.println("Long non fiction books: " + Arrays.toString(longNonFictionBooks.toArray()));

        // with lambdas we can define the behaviour of the filter in one line:
        BookFilter lambdaLongBooks = book -> book.getPages() > 400;
        longBooks = lambdaFilter(Setup.books, lambdaLongBooks);
        System.out.println("Lambda long books: " + Arrays.toString(longBooks.toArray()));

        BookFilter lambdaNonFictionLongBooks = book -> book.getPages() > 400 && Genre.NON_FICTION.equals(book.getGenre());
        longNonFictionBooks = lambdaFilter(Setup.books, lambdaNonFictionLongBooks);
        System.out.println("Lambda long non fiction books: " + Arrays.toString(longNonFictionBooks.toArray()));
    }


    public static List<Book> lambdaFilter(List<Book> books, BookFilter bookFilter) {
        List<Book> accumulator = new ArrayList<>();
        for (Book book : books) {
            if (bookFilter.test(book)) {
                accumulator.add(book);
            }
        }

        return accumulator;
    }


    public static List<Book> getLongBooks(List<Book> books) {
        List<Book> accumulator = new ArrayList<>();
        for (Book book : books) {
            if (book.getPages() > 400) {
                accumulator.add(book);
            }
        }

        return accumulator;
    }

    public static List<Book> getNonFictionLongBooks(List<Book> books) {
        List<Book> accumulator = new ArrayList<>();
        for (Book book : books) {
            if (book.getPages() > 400 && book.getGenre().equals(Genre.NON_FICTION)) {
                accumulator.add(book);
            }
        }

        return accumulator;
    }

}
