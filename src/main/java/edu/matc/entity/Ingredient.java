package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
public class Ingredient {
    private int id;
    private String name;
    private BigDecimal amount;
    private String unitmeasure;

    public Ingredient(String name, BigDecimal amount, String unitmeasure) {
        this.name = name;
        this.amount = amount;
        this.unitmeasure = unitmeasure;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 3)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "unitmeasure", nullable = true, length = 10)
    public String getUnitmeasure() {
        return unitmeasure;
    }

    public void setUnitmeasure(String unitmeasure) {
        this.unitmeasure = unitmeasure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (unitmeasure != null ? !unitmeasure.equals(that.unitmeasure) : that.unitmeasure != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (unitmeasure != null ? unitmeasure.hashCode() : 0);
        return result;
    }
}
