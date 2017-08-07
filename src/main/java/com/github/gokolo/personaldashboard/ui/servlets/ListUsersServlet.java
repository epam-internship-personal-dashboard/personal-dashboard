package com.github.gokolo.personaldashboard.ui.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.github.gokolo.personaldashboard.data.dao.UserDAO;
import com.github.gokolo.personaldashboard.entities.UserEntity;

/**
 * This Servlet handles requests to find all users. It forwards GET requests to
 * the users jsp page.
 *
 * @author Grace_Okolo
 */
@Component
@SuppressWarnings("PMD")
@WebServlet(name = "ListUsersServlet", urlPatterns = "/users")
public class ListUsersServlet extends HttpServlet {

    @Autowired
    private UserDAO userDAO;

    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * This method allow the servlet to handle a GET requests. It forwards the
     * request with a User collection to the users jsp page.
     *
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     *      HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        List<UserEntity> userDTOCollection = userDAO.findAll();
        request.setAttribute("userDTO", userDTOCollection);
        request.getRequestDispatcher("/usersPage").forward(request, response);
    }

}
