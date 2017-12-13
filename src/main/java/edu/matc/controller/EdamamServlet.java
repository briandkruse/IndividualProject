package edu.matc.controller;

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

        /*request.getParameter("searchterm");*/
        logger.info(request.getParameter("searchterm"));


        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://api.edamam.com/search?q=lasagna&app_id=376db8c2&app_key=5ea3504c65672bb93decbf9669548e5b"
                );
        /*String response = target.request(MediaType.APPLICATION_JSON).get(com.edamam.api.Response.class);*/


        RequestDispatcher dispatcher = request.getRequestDispatcher("/edamam.jsp");
        dispatcher.forward(request, response);
    }

}