package patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 25/09/14
 * Time: 21.27
 */
public class FunctionalMapCache {

    private static enum QueryType {
        BOOKS_COUNT(() -> countBooks()),
        PUBLISHERS_COUNT(() -> countPublishers()),
        COUNTRIES_COUNT(() -> countCountries());

        private Supplier<Integer> counter;
        QueryType(Supplier<Integer> counter) {
            this.counter = counter;
        }

        public Supplier<Integer> getCounter() {
            return counter;
        }
    }

    private static Map<QueryType, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        Integer booksCount = getValue(QueryType.BOOKS_COUNT);
        System.out.println("Books #: " + booksCount);
        booksCount = getValue(QueryType.BOOKS_COUNT);
        System.out.println("Books #: " + booksCount);
    }

    public static Integer getValue(QueryType queryType) {
        Integer count = cache.get(queryType);
        if (count == null) {
            count = queryType.getCounter().get();
            cache.put(queryType, count);
            System.out.println("Value got from DB: " + count);
        }
        else {
            System.out.println("Value got from cache: " + count);
        }
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
