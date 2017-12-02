package edu.matc.entity;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date joinDate;
    private Set<Recipe> recipes = new HashSet<>();





    // empty constructor
    public User() {}

    // with user variables
    public User(String firstName, String lastName, String login, String email) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLogin(login);
    }

    // with password
    public User(String firstName, String lastName, String login, String email, String password) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLogin(login);
        this.setPassword(password);
    }

    // with collections
    public User(String firstName, String lastName, String login, String email, String password, Set<Recipe> recipes) {
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

    @Basic
    @Column(name = "joindate", nullable = false)
    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

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
