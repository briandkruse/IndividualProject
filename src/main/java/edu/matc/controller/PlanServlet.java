package edu.matc.controller;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Plan servlet.
 */
@WebServlet(
        name = "PlanServlet",
        urlPatterns = "/newPlan"
)
public class PlanServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RecipeDao recipeDao = new RecipeDao();

        User user = (User) request.getSession().getAttribute("currentUser");

        ArrayList<Integer> recipeIds = (ArrayList) recipeDao.getUserRecipes(user);
        List<Recipe> recipes = new ArrayList<Recipe>();

        Recipe recipe;
        for (Integer id : recipeIds) {
            recipe = recipeDao.getRecipe(id);
            recipes.add(recipe);
        }

        session.setAttribute("recipes", recipes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/newPlan.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException,
            IOException {

    }
}