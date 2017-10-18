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

        String url = "recipeServlet";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        // Code down here would keep running...Java is multi-threaded.
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse resp)
            throws ServletException,
            IOException {

        String catagory = request.getParameter("catagory");
        String recipeName = request.getParameter("name");
        String ingredientName = request.getParameter("ingredient1");
        BigDecimal ingredientAmount = new BigDecimal(request.getParameter("amount1"));
        logger.info("ingredientAmount:" + ingredientAmount);
        String unitMeasure = request.getParameter("unitmeasure1");
        Ingredient ingredient = new Ingredient(ingredientName, ingredientAmount, unitMeasure);
        Recipe recipe = new Recipe(recipeName, ingredient);
        RecipeDao recipeDao = new RecipeDao();
        recipeDao.addRecipe(recipe);

    }
}