package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type User role.
 */
@Entity
@Table(name = "user_roles")
public class UserRole {

    private int id;
    private String login;
    private String roleName;


    /**
     * Instantiates a new User role.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new User role.
     *
     * @param login    the login
     * @param roleName the role name
     */
    public UserRole(String login, String roleName) {
        this.login = login;
        this.roleName = roleName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    @Basic
    @Column(name = "login")
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
     * Gets role name.
     *
     * @return the role name
     */
    @Basic
    @Column(name = "rolename")
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName ='" + login + '\'' +
                ", roleName ='" + roleName + '\'' +
                '}';
    }
}