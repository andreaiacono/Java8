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
        Author hawking = new Author("Stephen", "Hawking", "UK");
        Author hofstadter =new Author("Douglas", "Hofstadter", "USA");
        Author penrose = new Author("Roger", "Penrose", "UK");
        Author dennet = new Author("Daniel", "Dennet", "USA");
        Author dawkins = new Author("Richard", "Dawkins", "Kenya");
        Author sacks = new Author("Oliver", "Sacks", "UK");

        books.add(new Book(Arrays.asList(hawking), "A Brief History of Time", 256, Genre.PHYSICS, "9780553109535", 1988));
        books.add(new Book(Arrays.asList(dawkins), "The Selfish Gene", 224, Genre.EVOLUTION, "019857519X", 1976));
        books.add(new Book(Arrays.asList(dawkins), "The Blind Watchmaker", 240, Genre.EVOLUTION, "0393315703", 1986));
        books.add(new Book(Arrays.asList(hofstadter), "Godel, Escher, Bach", 777, Genre.CONSCIOUSNESS, "9780465026562", 1977));
        books.add(new Book(Arrays.asList(hofstadter, dennet), "The Mind's I", 501, Genre.CONSCIOUSNESS, "0553345842", 1982));
        books.add(new Book(Arrays.asList(dennet), "Darwin's Dangerous Idea", 586, Genre.EVOLUTION, "068482471", 1995));
        books.add(new Book(Arrays.asList(sacks), "Awakenings", 408, Genre.NOVEL, "0375704051", 1973));
        books.add(new Book(Arrays.asList(penrose), "The Emperor's New Mind", 480, Genre.ARTIFICIAL_INTELLIGENCE, "0198519737", 1989));
    }
}
