package com.github.gokolo.personaldashboard.ui.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.gokolo.personaldashboard.service.models.UserVO;
import com.github.gokolo.personaldashboard.service.services.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(final Model model) {
        model.addAttribute("user", new UserVO());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute final UserVO user, BindingResult bindingResult,
            final HttpServletRequest request) {
        LOG.error("{}", bindingResult.getAllErrors());
        userService.save(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "userProfile";
    }

}
