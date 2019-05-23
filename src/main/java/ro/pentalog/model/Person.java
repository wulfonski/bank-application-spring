package ro.pentalog.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="address",length = 50)
    private String address;

    @Column(name = "first_name", length = 16)
    private String firstName;

    @Column(name = "last_name", length = 16)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) &&
                Objects.equals(getAddress(), person.getAddress()) &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getEmail(), person.getEmail()) &&
                Objects.equals(getUser(), person.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getFirstName(), getLastName(), getEmail(), getUser());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
