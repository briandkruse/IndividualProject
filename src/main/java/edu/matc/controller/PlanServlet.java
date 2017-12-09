package edu.matc.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.persistence.RecipeDao;
import edu.matc.persistence.UserDirectory;
import org.apache.log4j.*;

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
        UserDirectory userDirectory = new UserDirectory();

        User user = (User)request.getSession().getAttribute("currentUser");


        //workaround, can't get objects through dao, can't identify login
        List<Recipe> recipes = recipeDao.getAllRecipes();

        List<Integer> removeList = new ArrayList<Integer>();
        for (Recipe recipe : recipes) {
            if (!recipe.getUser().getLogin().equals(user.getLogin())) {
                removeList.add(recipe.getId());
            }
        }
        recipes.removeAll(removeList);


        request.setAttribute("recipes", recipes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/newPlan.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException,
            IOException {

    }
}