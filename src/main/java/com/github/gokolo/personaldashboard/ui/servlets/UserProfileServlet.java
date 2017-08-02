package com.github.gokolo.personaldashboard.ui.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Component;

/**
 * Servlet implementation class UserProfileServlet
 */

@Component
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
    // private static final long serialVersionUID = 1L;
    //
    // @Autowired
    // private UserDAO userDAO;
    //
    // /**
    // * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    // * response)
    // */
    // // protected void doGet(HttpServletRequest request, HttpServletResponse
    // // response)
    // // throws ServletException, IOException {
    // // HttpSession session = request.getSession(false);
    // //
    // // if (session != null) {
    // // request.getRequestDispatcher("/userProfile").forward(request,
    // response);
    // // } else {
    // // response.sendRedirect(request.getContextPath() + "/loginPage");
    // // }
    // // }
    //
    // /**
    // * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    // * response)
    // */
    // protected void doPost(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // // TODO Auto-generated method stub
    // doGet(request, response);
    // }

}
