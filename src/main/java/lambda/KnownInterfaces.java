package lambda;

import core.Book;

import java.util.Comparator;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 18/09/14
 * Time: 0.00
 */
public class KnownInterfaces {

    public static void main(String[] args) throws Exception {

        // runnable interfaces defines only the void run() method
        Runnable r = () -> System.out.println("I'm running!");
        r.run();

        // Callable defines T call() method
        Callable<String> callable = () -> "This is a callable object";
        String result = callable.call();

        // Comparator defines the int compare(T t1, T t2) method
        Comparator<Book> bookLengthComparator = (b1, b2) -> b1.getPages() - b2.getPages();
        Comparator<Book> bookAgeComparator = (b1, b2) -> b1.getYear() - b2.getYear();
    }
}
