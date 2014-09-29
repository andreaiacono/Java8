package collections;

import core.Author;
import core.Setup;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 29/09/14
 * Time: 22.13
 */
public class CompareSample {

    public static void main(String[] args) {
        oldWaySort(Setup.authors);
        System.out.println("Sorted authors: " + Arrays.toString(Setup.authors.toArray()));
        java8Sort(Setup.authors);
        System.out.println("Sorted authors: " + Arrays.toString(Setup.authors.toArray()));
    }

    public static void oldWaySort(List<Author> authors) {
        Collections.sort(authors, new Comparator<Author>() {
            public int compare(Author author1, Author author2) {
                return author1.compareTo(author2);
            }
        });
    }

    public static void java8Sort(List<Author> authors) {
        Collections.sort(authors, (author1, author2) -> author1.compareTo(author2));
    }

}
