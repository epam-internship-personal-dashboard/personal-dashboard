package com.github.gokolo.personaldashboard.ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.gokolo.personaldashboard.ui.servlets.LoginServlet;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    @RequestMapping(method = RequestMethod.GET)
    public String get(final HttpServletRequest request) {
        LOG.info("user logged out");
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }
}
