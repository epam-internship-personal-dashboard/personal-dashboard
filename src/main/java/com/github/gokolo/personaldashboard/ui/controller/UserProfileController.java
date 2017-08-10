package com.github.gokolo.personaldashboard.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.gokolo.personaldashboard.service.models.UserVO;
import com.github.gokolo.personaldashboard.service.services.UserService;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String get(final Authentication authentication, final Model model) {
        String username = authentication.getName();
        UserVO userVO = userService.findByUsername(username);
        model.addAttribute("user", userVO);
        return "userProfile";
    }

}
