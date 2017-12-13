package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.persistence.RecipeDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * The type Process profile.
 */
@WebServlet(
        name = "ProcessProfile",
        urlPatterns = "/processProfile"
)


public class ProcessProfile extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        Recipe recipe = recipeDao.getRecipe(parseInt(request.getParameter("id")));
        request.setAttribute("confirm", "successfully deleted " + recipe.getName());
        recipeDao.deleteRecipe(recipe);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile");
        dispatcher.forward(request, response);


    }

}
