package rafista.intencje.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "FIRSTNAME", nullable = true)
    private String firstName;

    @Column(name = "LASTNAME", nullable = true)
    private String lastName;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "TOKEN")
    private String token;

    public Customer(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public Customer(String password) {
        this.password = password;
    }

    public Customer(UUID id){
      this.id = id;
    }

    public Customer(){

    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
