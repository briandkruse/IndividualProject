package edu.matc.entity;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private String login;
    private String firstName;
    private String lastName;
    private Set<Recipe> recipes = new HashSet<>();





    // empty constructor
    public User() {}

    // with user variables
    public User(String firstName, String lastName, String login) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLogin(login);
    }

    // with collections
    public User(String firstName, String lastName, String login, Set<Recipe> recipes) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLogin(login);
        this.setRecipes(recipes);
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "firstname", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastname", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @OneToMany(mappedBy = "user")
    public Set<Recipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }


    public String toString () {
        String userInformation =
                "First Name:" + this.firstName +
                " Last Name: " + this.lastName +
                " Login: " + this.login;
        return userInformation;
    }
}
