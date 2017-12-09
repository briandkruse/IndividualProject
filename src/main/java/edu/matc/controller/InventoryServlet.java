package edu.matc.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import edu.matc.entity.Ingredient;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "InventoryServlet",
        urlPatterns = "/inventory"
)

public class InventoryServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/inventory.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException,
            IOException {

        HttpSession session = request.getSession();

        String jsonString = "";
        BufferedReader br = request.getReader();
        String str;
        while((str = br.readLine()) != null){
            jsonString += str;
        }

        ObjectMapper mapper = new ObjectMapper();
        RecipeDao recipeDao = new RecipeDao();
        List<Integer> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, Integer.class));

        List<Recipe> recipeArray = new ArrayList<Recipe>();
        for(Integer recipeId : list) {
            recipeArray.add(recipeDao.getRecipe(recipeId));
        }

/*        logger.info("recipe name" + recipeArray.get(0).getName());
        Recipe testR = recipeArray.get(0);
        List ingredients = testR.getIngredients();
        Ingredient ingredient = (Ingredient)ingredients.get(0);
        logger.info("first ingredient name" + ingredient.getName());*/

        session.setAttribute("recipes", recipeArray);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/inventory.jsp");
        dispatcher.forward(request, response);




    }
}
