package com.github.gokolo.personaldashboard.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.github.gokolo.personaldashboard.data.dao.UserDAO;
import com.github.gokolo.personaldashboard.entities.UserEntity;

/**
 * This Servlet handles login requests. It forwards GET requests to the login
 * jsp page. It handles POST request, by performing authentication. Servlet
 * implementation class userAuthentication
 *
 * @author Grace_Okolo
 *
 */
public class LoginServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserDAO userDAO;

    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * This method allow the servlet to handle a login POST requests. It
     * authenticates the username and password from the post request. If the
     * authentication succeeds, it forwards the request to the user profile jsp.
     * If it fails, it forwards the request back to itself.
     *
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        LOG.info("Authenticating user with name: {}", username);
        String password = request.getParameter("password");
        UserEntity userDTO = userDAO.findByUsernamePassword(username, password);

        if (userDTO == null) {
            request.setAttribute("message", "Invalid username or password!");
            request.getRequestDispatcher("/loginPage").forward(request, response);
            LOG.info("No user was found with the credentials");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDTO);
            response.sendRedirect(request.getContextPath() + "/userProfilePage");
            LOG.info("User {} was found", username);
        }

    }

    /**
     * This method allow the servlet to handle a login GET requests. It forwards
     * the request to the login jsp page.
     *
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     *      HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/loginPage").forward(request, response);
    }

}
