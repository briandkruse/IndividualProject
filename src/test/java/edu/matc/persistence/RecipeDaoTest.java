package edu.matc.persistence;

import edu.matc.entity.Ingredient;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeDaoTest {

    private final Logger log = Logger.getLogger(this.getClass());
    RecipeDao recipeDao = new RecipeDao();
    Recipe recipe;
    int initialRecipeCount;

    @Test
    public void addRecipe() throws Exception {
        Recipe newRecipe = createRecipe();
        recipeDao.addRecipe(newRecipe);
        assertEquals("Recipe was not added to the database", initialRecipeCount +1, recipeDao.getAllRecipes().size());
    }

    @Test
    public void getAllRecipesTest() throws Exception {
        List<Recipe> recipes = recipeDao.getAllRecipes();
        assertTrue("Failed to get all recipies" + recipes.size(), recipes.size() > 0);
    }

    @Test
    public void deleteRecipeTest() {
        Recipe newRecipe = createRecipe();
        recipeDao.addRecipe(newRecipe);
        initialRecipeCount = recipeDao.getAllRecipes().size();
        recipeDao.deleteRecipe(newRecipe);
        assertEquals("Recipe was not deleted from the database", initialRecipeCount - 1, recipeDao.getAllRecipes().size());
    }

    public Recipe createRecipe() {
        UserDirectory userDirectory = new UserDirectory();
        User user = userDirectory.getUser("admin");
        BigDecimal amount = new BigDecimal("5");
        Ingredient ingredient = new Ingredient("Cheese", amount, "ounces");
        Set ingredients = new HashSet();
        ingredients.add(ingredient);
        Recipe recipe = new Recipe(user, "MacNCheeze", "pasta", ingredients);
        return recipe;
    }

}