package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Recipe> recipes = new ArrayList<>();


    /**
     * Instantiates a new User.
     */
// empty constructor
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param login     the login
     * @param email     the email
     */
// with user variables
    public User(String firstName, String lastName, String login, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param login     the login
     * @param email     the email
     * @param password  the password
     */
// with password
    public User(String firstName, String lastName, String login, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.password = password;

    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param login     the login
     * @param email     the email
     * @param password  the password
     * @param recipes   the recipes
     */
// with collections
    public User(String firstName, String lastName, String login, String email, String password, List<Recipe> recipes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.password = password;
        this.recipes = recipes;

    }

    /**
     * Gets login.
     *
     * @return the login
     */
    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    @Basic
    @Column(name = "firstname", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    @Basic
    @Column(name = "lastname", nullable = false)
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    @Basic
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets recipes.
     *
     * @return the recipes
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {javax.persistence.CascadeType.ALL})
    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    /**
     * Sets recipes.
     *
     * @param recipes the recipes
     */
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
