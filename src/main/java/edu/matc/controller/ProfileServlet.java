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
        name = "ProfileServlet",
        urlPatterns = "/profile"
)

public class ProfileServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDirectory userDirectory = new UserDirectory();
        RecipeDao recipeDao = new RecipeDao();

        HttpSession session = request.getSession();

        String currentUser = (String)session.getAttribute("currentUser");
        /*User currentUser = userDirectory.getUser(request.getRemoteUser());*/
        List<Recipe> recipes = recipeDao.getAllRecipes();
        request.setAttribute("user", currentUser);
        request.setAttribute("recipes", recipes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
        dispatcher.forward(request, response);


    }

}
