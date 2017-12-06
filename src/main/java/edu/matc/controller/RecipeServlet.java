package edu.matc.controller;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Ingredient;
import edu.matc.entity.Recipe;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import edu.matc.entity.User;
import edu.matc.persistence.RecipeDao;
import edu.matc.persistence.UserDirectory;
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
        UserDirectory userDirectory = new UserDirectory();
        RecipeDao recipeDao = new RecipeDao();
        HttpSession session = request.getSession();
        User user = (User)request.getAttribute("currentUser");
        String jsonRecipe = "";
        BufferedReader br = request.getReader();
        String str;
        while((str = br.readLine()) != null){
            jsonRecipe += str;
        }

        ObjectMapper mapper = new ObjectMapper();
        Recipe recipe = mapper.readValue(jsonRecipe, Recipe.class);
        recipe.setUser(user);
        logger.info(recipe.toString());
        recipeDao.addRecipe(recipe);

/*        request.setAttribute("recipe", recipe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipeSubmitConfirmation.jsp");
        dispatcher.forward(request, response);*/
    }
}