package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    private int id;
    private String login;
    private String roleName;


    public UserRole() {
    }

    public UserRole(String login, String roleName) {
        this.login = login;
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column (name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "rolename")
    public String getRoleName() {
        return roleName;
    }

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