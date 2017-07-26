package com.github.gokolo.personaldashboard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.gokolo.personaldashboard.dao.UserDAO;
import com.github.gokolo.personaldashboard.dao.UserDAOImpl;
import com.github.gokolo.personaldashboard.dto.UserDTO;

/**
 * @author Grace_Okolo
 *
 */
@SuppressWarnings("PMD")
@WebServlet(name = "ListUsersServlet", urlPatterns = "/users")
public class ListUsersServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        List<UserDTO> userCollection = userDAO.findAll();
        request.setAttribute("user", userCollection);
        request.getRequestDispatcher("/usersPage").forward(request, response);
    }

}
