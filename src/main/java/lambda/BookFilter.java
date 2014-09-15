package lambda;

import core.Book;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 15/09/14
 * Time: 18.29
 */
public interface BookFilter {

    public boolean apply(Book book);
}
