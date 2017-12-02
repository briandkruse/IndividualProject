package edu.matc.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {


    private int id;
    private String name;
    private String catagory;
    private String description;
    /*@JsonDeserialize(as=ArrayList.class, contentAs=Ingredient.class)*/
    private List<Ingredient> ingredients = new ArrayList<>();
    private User user;

    // empty
    public Recipe() {    }

    // just name and catagory
    public Recipe(User user, String name, String catagory) {
        this.user = user;
        this.name = name;
        this.catagory = catagory;
    }

    // with variables
    public Recipe(User user, String name, String catagory, List<Ingredient> ingredients) {
        this.user = user;
        this.name = name;
        this.catagory = catagory;
        this.ingredients = ingredients;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "recipeid", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "catagory", nullable = false)
    public String getCatagory() {
        return this.catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "recipeingredient",
            joinColumns = {@JoinColumn(name = "recipeid", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ingredientid", nullable = false)}
    )
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", catagory='" + catagory + '\'' +
                ", ingredients=" + ingredients +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}


