package streams;

import core.Author;
import core.Book;
import core.Setup;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 16/09/14
 * Time: 16.47
 */
public class FilterSamples {

    public static void main(String[] args) {
        List<Book> longBooks = Setup.books.stream().filter(b -> b.getPages()>400).collect(toList());
        System.out.println(Arrays.toString(longBooks.toArray()));

        List<String> titles = Setup.books.stream().map(b -> b.getTitle()).collect(toList());
        System.out.println("titles: " + Arrays.toString(titles.toArray()));

        List<Integer> years = Setup.books.stream().filter(b -> b.getPages() > 400).map(b -> b.getYear()).collect(toList());
        System.out.println("years: " + Arrays.toString(years.toArray()));

        List<String> countries = Setup.books.stream().flatMap(b -> b.getAuthors().stream()).map(author -> author.getCountry()).collect(toList());
        Set<Author> authors2 = Setup.books.stream().flatMap(b -> b.getAuthors().stream()).collect(toSet());
        System.out.println("countries: " + Arrays.toString(countries.toArray()));

//        Setup.books.stream().map(b -> b.getAuthors()).distinct().forEach(System.out::print);
    }
}
