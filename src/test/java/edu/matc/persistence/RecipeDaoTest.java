package edu.matc.persistence;

import edu.matc.entity.Ingredient;
import edu.matc.entity.Recipe;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RecipeDaoTest {
    @Test
    public void addRecipe() throws Exception {
        RecipeDao rDao = new RecipeDao();
        BigDecimal number = new BigDecimal("5");
        Ingredient ingredient = new Ingredient("Cheese", number, "ounces");
        Recipe recipe = new Recipe("MacNCheeze", ingredient);
        rDao.addRecipe(recipe);
    }

}