package edu.matc.controller;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.math.BigDecimal;

import edu.matc.entity.Ingredient;
import edu.matc.entity.Recipe;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import edu.matc.entity.User;
import edu.matc.persistence.RecipeDao;
import org.apache.log4j.*;

@WebServlet(
        name = "RecipeServlet",
        urlPatterns = "/recipeServlet"


)
public class RecipeServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());


    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RecipeDao recipeDao = new RecipeDao();
        request.setAttribute("recipe", recipeDao.getAllRecipes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/allRecipeResult.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException,
            IOException {

        String catagory = request.getParameter("catagory");
        String recipeName = request.getParameter("name");
        String ingredientName = request.getParameter("ingredient1");
        BigDecimal ingredientAmount = new BigDecimal(request.getParameter("amount1"));
        logger.info("ingredientAmount:" + ingredientAmount);
        String unitMeasure = request.getParameter("unitmeasure1");
        Ingredient ingredient = new Ingredient(ingredientName, ingredientAmount, unitMeasure);
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient);
        User user = new User("temp", "temp", request.getRemoteUser());
        Recipe recipe = new Recipe(user, recipeName, catagory, ingredients);
        RecipeDao recipeDao = new RecipeDao();
        recipeDao.addRecipe(recipe);
        request.setAttribute("recipe", recipe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipeSubmitConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}