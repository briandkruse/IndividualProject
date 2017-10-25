package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserDirectory;
import org.apache.log4j.Logger;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


    @WebServlet(
            name = "searchUser",
            urlPatterns = {"/searchUser"}
    )
    public class SearchUser extends HttpServlet {
        private final Logger logger = Logger.getLogger(this.getClass());

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            UserDirectory userDirectory = new UserDirectory();

                if (request.getParameter("submit").equals("Add")){
                    String firstName = request.getParameter("firstname");
                    String lastName = request.getParameter("lastname");
                    String login = request.getParameter("login");
                    logger.error(firstName + "firstname");
                    logger.error(lastName + "lastname");
                    User user = new User(firstName, lastName, login);
                    userDirectory.addUser(user);
                } else if (request.getParameter("submit").equals("Delete")){
                    String login = request.getParameter("deletelogin");
                    userDirectory.deleteUser(login);
                } else if (request.getParameter("submit").equals("Update")) {
                    String firstName = request.getParameter("updatefirstname");
                    String lastName = request.getParameter("updatelastname");
                    String login = request.getParameter("updatelogin");
                    User user = new User(firstName, lastName, login);
                    userDirectory.updateUser(user);
                }


        }


        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            UserDirectory userDirectory = new UserDirectory();
            req.setAttribute("users", userDirectory.getAllUsers());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
            dispatcher.forward(req, resp);
        }
    }

