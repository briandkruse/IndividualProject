package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Ingredient.
 */
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {
    private int id;
    private String name;
    private BigDecimal amount;
    private String unitMeasure;
    private List<Recipe> recipes = new ArrayList<Recipe>();


    /**
     * Instantiates a new Ingredient.
     */
//empty
    public Ingredient() {
    }

    /**
     * Instantiates a new Ingredient.
     *
     * @param name        the name
     * @param amount      the amount
     * @param unitmeasure the unitmeasure
     */
//with instance variables
    public Ingredient(String name, BigDecimal amount, String unitmeasure) {
        this.name = name;
        this.amount = amount;
        this.unitMeasure = unitmeasure;
    }

    /**
     * Instantiates a new Ingredient.
     *
     * @param name        the name
     * @param amount      the amount
     * @param unitmeasure the unitmeasure
     * @param recipes     the recipes
     */
//with collections
    public Ingredient(String name, BigDecimal amount, String unitmeasure, List<Recipe> recipes) {
        this.name = name;
        this.amount = amount;
        this.unitMeasure = unitmeasure;
        this.recipes = recipes;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ingredientid", nullable = false)
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
    @Column(name = "name", nullable = true, length = 20)
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
     * Gets amount.
     *
     * @return the amount
     */
    @Basic
    @Column(name = "amount", nullable = true, precision = 3)
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets unit measure.
     *
     * @return the unit measure
     */
    @Basic
    @Column(name = "unitmeasure", nullable = true, length = 10)
    public String getUnitMeasure() {
        return unitMeasure;
    }

    /**
     * Sets unit measure.
     *
     * @param unitmeasure the unitmeasure
     */
    public void setUnitMeasure(String unitmeasure) {
        this.unitMeasure = unitmeasure;
    }

    /**
     * Gets recipes.
     *
     * @return the recipes
     */
    @ManyToMany(mappedBy = "ingredients")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (unitMeasure != null ? !unitMeasure.equals(that.unitMeasure) : that.unitMeasure != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (unitMeasure != null ? unitMeasure.hashCode() : 0);
        return result;
    }
}
