package com.github.gokolo.personaldashboard.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.gokolo.personaldashboard.service.services.UserService;
import com.github.gokolo.personaldashboard.ui.servlets.LoginServlet;

@Controller
@RequestMapping("/")
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "login";
    }
}
