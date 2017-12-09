package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import edu.matc.entity.Ingredient;
import edu.matc.entity.Recipe;
import edu.matc.persistence.IngredientDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "ShopppingList",
        urlPatterns = "/shoppingList"
)

public class ShoppingListServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String jsonString = "";
        BufferedReader br = request.getReader();
        String str;
        while((str = br.readLine()) != null){
            jsonString += str;
        }
        logger.info(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        IngredientDao recipeDao = new IngredientDao();

        List<Integer> list = mapper.readValue(jsonString, TypeFactory.defaultInstance().constructCollectionType(List.class, Integer.class));

        List<Ingredient> ingredientArray = new ArrayList<Ingredient>();
        for(Integer ingredientId : list) {
            ingredientArray.add(recipeDao.getIngredient(ingredientId));
        }

        logger.info(ingredientArray.toString());
        session.setAttribute("ingredients", ingredientArray);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/shoppingList.jsp");
        dispatcher.forward(request, response);
    }
}
