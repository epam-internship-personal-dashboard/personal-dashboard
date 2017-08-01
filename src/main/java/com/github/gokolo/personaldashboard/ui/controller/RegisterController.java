package com.github.gokolo.personaldashboard.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.gokolo.personaldashboard.data.dao.UserDAO;
import com.github.gokolo.personaldashboard.data.dto.UserDTO;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String register(final Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute final UserDTO user) {
        int save = userDAO.save(user);
        if (save == 0) {
            LOG.info("User Not Registered!");
        } else {
            LOG.info("User Registered!");
        }
        return "register";
    }

}
