package core;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 12/09/14
 * Time: 17.10
 */
public class Author {
    private String name;
    private String lastName;
    private String city;

    public Author(String name, String lastName, String city) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }
}
