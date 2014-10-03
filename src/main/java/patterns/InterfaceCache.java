package patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 25/09/14
 * Time: 21.27
 */
public class InterfaceCache {

    private static enum QueryType {
        BOOKS_COUNT, PUBLISHERS_COUNT, COUNTRIES_COUNT;
    }

    private static Map<QueryType, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        BooksCounter bookCounter = new BooksCounter();
        Integer booksCount = getValue(QueryType.BOOKS_COUNT, bookCounter);
        System.out.println("Books #: " + booksCount);
        booksCount = getValue(QueryType.BOOKS_COUNT, bookCounter);
        System.out.println("Books #: " + booksCount);
    }

    public static Integer getValue(QueryType queryType, Counter counter) {
        Integer count = cache.get(queryType);
        if (count == null) {
            count = counter.count();
            cache.put(queryType, count);
            System.out.println("Value got from DB: " + cache.get(queryType));
        }
        else {
            System.out.println("Value got from cache: " + cache.get(queryType));
        }
        return count;
    }
}

class BooksCounter implements Counter {

    @Override
    public Integer count() {
        // returns a value got from DB query
        return 4;
    }
}

class PublishersCounter implements Counter {

    @Override
    public Integer count() {
        // returns a value got from DB query
        return 5;
    }
}

class CountriesCounter implements Counter {

    @Override
    public Integer count() {
        // returns a value got from DB query
        return 5;
    }
}

interface Counter {
    public Integer count();
}
