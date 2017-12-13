package edu.matc.entity;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Recipe> recipes = new ArrayList<>();




    // empty constructor
    public User() {}

    // with user variables
    public User(String firstName, String lastName, String login, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
    }

    // with password
    public User(String firstName, String lastName, String login, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.password= password;

    }

    // with collections
    public User(String firstName, String lastName, String login, String email, String password, List<Recipe> recipes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.password= password;
        this.recipes = recipes;

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

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", fetch=FetchType.EAGER, cascade = {javax.persistence.CascadeType.ALL})
    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", recipes=" + recipes +
                '}';
    }


}
