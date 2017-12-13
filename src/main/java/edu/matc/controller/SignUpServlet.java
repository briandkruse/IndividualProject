package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
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
import java.io.IOException;

/**
 * The type Sign up servlet.
 */
@WebServlet(
        name = "SignUpServlet",
        urlPatterns = "/signUp"
)

public class SignUpServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    public void init(ServletConfig config) {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/newUser.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException,
            IOException {
        String login = request.getParameter("login");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        User user;
        UserRole role;
        HttpSession session;
        if (password1.equals(password2)) {
            UserDirectory userDao = new UserDirectory();
            user = new User(firstName, lastName, login, email, password1);
            role = new UserRole(login, "user");
            logger.info(user.toString());
            userDao.addUser(user);
            userDao.addRole(role);
            session = request.getSession(true);
            session.setAttribute("currentUser", user);
        } else {
            logger.error("passwords did not match");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}