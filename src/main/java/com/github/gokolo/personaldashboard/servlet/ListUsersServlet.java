package com.github.gokolo.personaldashboard.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.gokolo.personaldashboard.dao.UserDAO;
import com.github.gokolo.personaldashboard.dao.UserDAOImpl;
import com.github.gokolo.personaldashboard.dto.UserDTO;

@SuppressWarnings("PMD")
@WebServlet(name = "ListUsersServlet", urlPatterns = "/xxx")
public class ListUsersServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();

    public void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        List<UserDTO> userCollection = userDAO.findAll();
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>").append("<html>").append("<head>").append("<title>").append("All Users")
                .append("</title>").append("</head>").append("<body>");

        for (UserDTO user : userCollection) {
            sb.append("<p>").append(user.getName()).append("</p>");
        }
        sb.append("</body>").append("</html>");

        PrintWriter writer = response.getWriter();
        writer.println(sb.toString());
    }

}
