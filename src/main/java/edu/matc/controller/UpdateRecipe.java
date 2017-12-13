package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.persistence.RecipeDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(
        name = "UpdateRecipe",
        urlPatterns = "/updateRecipe"
)

public class UpdateRecipe extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        String jsonString = "";
        BufferedReader br = request.getReader();
        String str;
        while((str = br.readLine()) != null){
            jsonString += str;
        }
        jsonString += "] }";
        ObjectMapper mapper = new ObjectMapper();
        RecipeDao recipeDao = new RecipeDao();
        Recipe recipe = mapper.readValue(jsonString, Recipe.class);
        recipe.setUser(user);
        logger.info(recipe.toString());
        recipeDao.updateRecipe(recipe);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RecipeDao recipeDao = new RecipeDao();

        Recipe recipe = recipeDao.getRecipe(parseInt(request.getParameter("id")));
        User user = (User)session.getAttribute("currentUser");
        recipe.setUser(user);


        session.setAttribute("recipeUpdate", recipe);

        RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
        dispatcher.forward(request, response);


    }


}