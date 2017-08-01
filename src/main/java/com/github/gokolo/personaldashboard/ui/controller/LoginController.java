package com.github.gokolo.personaldashboard.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.gokolo.personaldashboard.data.dao.UserDAO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;
import com.github.gokolo.personaldashboard.ui.servlets.LoginServlet;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "login";
    }

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String post(final HttpServletRequest request) {
        String username = request.getParameter("username");
        LOG.info("Authenticating user with name: {}", username);
        String password = request.getParameter("password");
        UserDTO userDTO = userDAO.findByUsernamePassword(username, password);

        if (userDTO == null) {
            request.setAttribute("message", "Invalid username or password!");
            LOG.info("No user was found with the credentials");
            return "login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDTO);
            LOG.info("User {} was found", username);
        }

        return "userProfile";
    }
}
