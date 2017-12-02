package edu.matc.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import edu.matc.entity.User;
import edu.matc.persistence.UserDirectory;
import org.apache.log4j.*;

@WebServlet(
        name = "SignUpServlet",
        urlPatterns = "/signUpServlet"
)

public class SignUpServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }
/*
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "userProfile.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }*/

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException,
            IOException {
        System.out.println("Signupservlet");
        logger.info("signupServlet");

        String login = request.getParameter("login");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");


        HttpSession session;
        if (password1.equals(password2)) {
            User user = new User(firstName, lastName, login, email, password1);
            UserDirectory userDao = new UserDirectory();
            userDao.addUser(user);
            session = request.getSession();
            session.setAttribute("currentUser", login);
        } else {
            logger.error("passwords did not match");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile");
        dispatcher.forward(request, response);




    }
}