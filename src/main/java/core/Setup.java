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
    public static List<Author> authors;

    static {
        books = new ArrayList<>();
        Author hawking = new Author("Stephen", "Hawking", "UK");
        Author hofstadter =new Author("Douglas", "Hofstadter", "USA");
        Author penrose = new Author("Roger", "Penrose", "UK");
        Author dennett = new Author("Daniel", "Dennett", "USA");
        Author dawkins = new Author("Richard", "Dawkins", "Kenya");
        Author sacks = new Author("Oliver", "Sacks", "UK");
        authors = Arrays.asList(hawking, hofstadter, penrose, dennett, dawkins, sacks);

        books.add(new Book(Arrays.asList(hawking), "A Brief History of Time", 256, Genre.PHYSICS, Optional.of("9780553109535"), 1988, true));
        books.add(new Book(Arrays.asList(dawkins), "The Selfish Gene", 224, Genre.EVOLUTION, Optional.of("019857519X"), 1995, false));
        books.add(new Book(Arrays.asList(dawkins), "The Blind Watchmaker", 240, Genre.EVOLUTION, Optional.of("0393315703"), 1986, false));
        books.add(new Book(Arrays.asList(hofstadter), "Godel, Escher, Bach", 777, Genre.CONSCIOUSNESS, Optional.of("9780465026562"), 1977, true));
        books.add(new Book(Arrays.asList(hofstadter, dennett), "The Mind's I", 501, Genre.CONSCIOUSNESS, Optional.of("0553345842"), 1982, true));
        books.add(new Book(Arrays.asList(dennett), "Darwin's Dangerous Idea", 586, Genre.EVOLUTION, Optional.of("068482471"), 1995, false));
        books.add(new Book(Arrays.asList(sacks), "Awakenings", 408, Genre.NOVEL, Optional.of("0375704051"), 1973, true));
        books.add(new Book(Arrays.asList(penrose), "The Emperor's New Mind", 480, Genre.ARTIFICIAL_INTELLIGENCE, Optional.of("0198519737"), 1982, false));
        books.add(new Book(Arrays.asList(sacks), "Awakenings", 408, Genre.NOVEL, Optional.of("0375704051"), 1973, false));
    }
}
