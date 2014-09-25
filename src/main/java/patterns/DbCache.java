package patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 25/09/14
 * Time: 21.27
 */
public class DbCache {

    private static enum QueryType {
        BOOKS_COUNT, PUBLISHERS_COUNT, COUNTRIES_COUNT;
    }
    private static Map<QueryType, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        Integer booksCount = getValue(QueryType.BOOKS_COUNT);
        System.out.println("Books #: " + booksCount);
        booksCount = getValue(QueryType.BOOKS_COUNT);
        System.out.println("Books #: " + booksCount);
    }

    public static Integer getValue(QueryType queryType) {
        Integer count;
        switch (queryType) {
            case BOOKS_COUNT:
                if (cache.containsKey(queryType)) {
                    System.out.println("Value got from cache: " + cache.get(queryType));
                    return cache.get(queryType);
                }
                count = countBooks();
                cache.put(queryType, count);
                System.out.println("Value got from DB: " + cache.get(queryType));
                return count;
            case PUBLISHERS_COUNT:
                if (cache.containsKey(queryType)) {
                    return cache.get(queryType);
                }
                count = countPublishers();
                cache.put(queryType, count);
                return count;
            case COUNTRIES_COUNT:
                if (cache.containsKey(queryType)) {
                    return cache.get(queryType);
                }
                count = countCountries();
                cache.put(queryType, count);
                return count;
        }
        return 0;
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
