package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name="id")
    private int id;



    public User() {}

    public User(String firstName, String lastName, int id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
        //TODO fix constructors
    }

    public User(int id) {
        this.setId(id);
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

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString () {
        String userInformation =
                "First Name:" + this.firstName +
                " Last Name: " + this.lastName +
                " ID: " + this.id;
        return userInformation;
    }
}
