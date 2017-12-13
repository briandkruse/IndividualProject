package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.persistence.RecipeDao;
import edu.matc.persistence.UserDirectory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * The type Recipe servlet.
 */
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

        RecipeDao recipeDao = new RecipeDao();
        User user = (User) request.getSession().getAttribute("currentUser");
        logger.info(user.toString());
        String jsonRecipe = "";
        BufferedReader br = request.getReader();
        String str;
        while ((str = br.readLine()) != null) {
            jsonRecipe += str;
        }

        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(jsonRecipe, Recipe.class);
        recipe.setUser(user);
        logger.info(recipe.toString());
        recipeDao.addRecipe(recipe);

        request.setAttribute("recipe", recipe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/newRecipe.jsp");
        dispatcher.forward(request, response);
    }
}