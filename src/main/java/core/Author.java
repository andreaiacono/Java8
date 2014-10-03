package core;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 12/09/14
 * Time: 17.10
 */
public class Author implements Comparable<Author> {
    private String name;
    private String lastName;
    private String country;

    public Author(String name, String lastName, String city) {
        this.name = name;
        this.lastName = lastName;
        this.country = city;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    @Override
    public int compareTo(Author other) {
        return (this.name + "-" + this.lastName + "-" + this.country).compareTo(other.getName() + "-" + other.getLastName() + "-" + other.getCountry());
    }
}
