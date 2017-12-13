package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Recipe.
 */
@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {


    private int id;
    private String name;
    private String catagory;
    private String description;
    private List<Ingredient> ingredients = new ArrayList<>();
    private User user;

    /**
     * Instantiates a new Recipe.
     */
    public Recipe() {
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param user     the user
     * @param name     the name
     * @param catagory the catagory
     */

    public Recipe(User user, String name, String catagory) {
        this.user = user;
        this.name = name;
        this.catagory = catagory;
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param user        the user
     * @param name        the name
     * @param catagory    the catagory
     * @param ingredients the ingredients
     */

    public Recipe(User user, String name, String catagory, List<Ingredient> ingredients) {
        this.user = user;
        this.name = name;
        this.catagory = catagory;
        this.ingredients = ingredients;
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param user        the user
     * @param name        the name
     * @param catagory    the catagory
     * @param ingredients the ingredients
     * @param id          the id
     */

    public Recipe(User user, String name, String catagory, List<Ingredient> ingredients, int id) {
        this.user = user;
        this.name = name;
        this.catagory = catagory;
        this.ingredients = ingredients;
        this.id = id;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "recipeid", nullable = false)
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
     * Gets name.
     *
     * @return the name
     */
    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets catagory.
     *
     * @return the catagory
     */
    @Basic
    @Column(name = "catagory", nullable = false)
    public String getCatagory() {
        return this.catagory;
    }

    /**
     * Sets catagory.
     *
     * @param catagory the catagory
     */
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recipeingredient",
            joinColumns = {@JoinColumn(name = "recipeid", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ingredientid", nullable = false)}
    )
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    /**
     * Sets ingredients.
     *
     * @param ingredients the ingredients
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login", nullable = false)
    public User getUser() {
        return this.user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", catagory='" + catagory + '\'' +
                ", ingredients=" + ingredients +
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


