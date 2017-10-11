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
    @Column(name="login")
    private String login;



    public User() {}

    public User(String firstName, String lastName, String login) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLogin(login);
        //TODO fix constructors
    }

    public User(String login) {
        this.setLogin(login);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String toString () {
        String userInformation =
                "First Name:" + this.firstName +
                " Last Name: " + this.lastName +
                " Login: " + this.login;
        return userInformation;
    }
}
