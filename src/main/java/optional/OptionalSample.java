package optional;

import core.Book;
import core.Setup;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 29/09/14
 * Time: 23.29
 */
public class OptionalSample {
    public static void main(String[] args) {

        // we're assuming at least one book is present
        Book book = Setup.books.get(0);

        book.setISBN(Optional.of("978000000"));
        Optional<String> isbn = book.getISBN();
        System.out.println("Book ISBN: " + isbn.orElse("NOT PRESENT"));

        // or, if the book was published before 1970
        book.setISBN(Optional.empty());
        isbn = book.getISBN();
        System.out.println("Old book ISBN: " + isbn.orElse("NOT PRESENT"));
    }
}
