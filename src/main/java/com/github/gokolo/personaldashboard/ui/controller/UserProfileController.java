package com.github.gokolo.personaldashboard.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "userProfile";
    }

}
