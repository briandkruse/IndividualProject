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

    public void init(ServletConfig config) {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RecipeDao recipeDao = new RecipeDao();
        UserDirectory userDirectory = new UserDirectory();

        User user = (User)session.getAttribute("currentUser");
        System.out.println(user.toString());
        List<String> recipes = recipeDao.getUserRecipes(user);
        request.setAttribute("recipes", recipes);
        System.out.println(recipes.toString());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/newPlan.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException,
            IOException {

    }
}