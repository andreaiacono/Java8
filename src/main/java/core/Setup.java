package core;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 12/09/14
 * Time: 17.15
 */
public class Setup {

    public static List<Book> books;

    static {
        books = new ArrayList<>();
        Author hawking = new Author("Stephen", "Hawking", "Oxford");
        Author hofstadter =new Author("Douglas", "Hofstadter", "New York");
        Author penrose = new Author("Roger", "Penrose", "Colchester");
        Author dennet = new Author("Daniel", "Dennet", "Boston");
        Author dawkins = new Author("Richard", "Dawkins", "Nairobi");

        books.add(new Book(Arrays.asList(hawking), "A brief hostory of time", 256, Genre.NON_FICTION, "978055310953"));
        books.add(new Book(Arrays.asList(dawkins), "The blind watchmaker", 240, Genre.NON_FICTION, "97888273645365"));
        books.add(new Book(Arrays.asList(hofstadter), "Godel, Escher, Bach", 240, Genre.NON_FICTION, "97888273645365"));
        books.add(new Book(Arrays.asList(hofstadter, dennet), "The Mind's I", 240, Genre.NON_FICTION, "97888273645365"));
        books.add(new Book(Arrays.asList(dennet), "Darwin's dangerous idea", 586, Genre.NON_FICTION, "97888273645365"));
    }
}
