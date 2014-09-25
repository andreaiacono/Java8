package patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 25/09/14
 * Time: 21.27
 */
public class FunctionalCache {

    private static enum QueryType {
        BOOKS_COUNT, PUBLISHERS_COUNT, COUNTRIES_COUNT;
    }
    private static Map<QueryType, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        Integer booksCount = getValue(QueryType.BOOKS_COUNT, f -> countBooks());
        System.out.println("Books #: " + booksCount);
        booksCount = getValue(QueryType.BOOKS_COUNT, f -> countBooks());
        System.out.println("Books #: " + booksCount);
    }

    public static Integer getValue(QueryType queryType, Function<QueryType, Integer> counter) {
        if (cache.containsKey(queryType)) {
            System.out.println("Value got from cache: " + cache.get(queryType));
            return cache.get(queryType);
        }
        Integer count = counter.apply(queryType);
        cache.put(queryType, count);
        System.out.println("Value got from DB: " + count);
        return count;
    }

    private static Integer countBooks() {
        // returns a value got from DB query
        return 4;
    }

    private static Integer countPublishers() {
        // returns a value got from DB query
        return 5;
    }

    private static Integer countCountries() {
        // returns a value got from DB query
        return 2;
    }
}
