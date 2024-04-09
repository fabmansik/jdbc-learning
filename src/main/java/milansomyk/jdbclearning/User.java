package milansomyk.jdbclearning;
public class User {
    Long id;
    String name;
    String surname;
    String email;

    public String getName() {
        return name;
    }

    public User(long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
