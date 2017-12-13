package edu.matc.controller;

import com.edamam.api.HitsItem;
import com.edamam.api.IngredientsItem;
import com.edamam.api.Recipe;
import com.edamam.api.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Edamam servlet.
 */
@WebServlet(
        name = "EdamamServlet",
        urlPatterns = "/edamam"
)

public class EdamamServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchTerm = request.getParameter("searchterm");
        String searchString = "https://api.edamam.com/search?q=" + searchTerm + "&app_id=376db8c2&app_key=5ea3504c65672bb93decbf9669548e5b";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(searchString);
        String jsonResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Response edamamResponse = mapper.readValue(jsonResponse, Response.class);
        List<HitsItem> hits = edamamResponse.getHits();
        Recipe edamamRecipe = hits.get(1).getRecipe();
        String recipeName = edamamRecipe.getLabel();
        List<IngredientsItem> ingredients = edamamRecipe.getIngredients();
        List<String> ingredientStringList = new ArrayList<>();
        String url = edamamRecipe.getUrl();

        for (IngredientsItem ingredient : ingredients) {
            ingredientStringList.add(ingredient.getText());
        }

        logger.info(recipeName + " " + ingredientStringList.toString());

        request.setAttribute("recipename", recipeName);
        request.setAttribute("ingredients", ingredientStringList);
        request.setAttribute("url", url);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/edamam.jsp");
        dispatcher.forward(request, response);
    }

}