package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name="id")
    private int id;



    public User() {}

    public User(String firstname, String lastname, int id) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setId(id);
    }

    public User(int id) {
        this.setId(id);
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
