package com.github.gokolo.personaldashboard.ui.spring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    private static final Set<String> PAGES;

    static {
        PAGES = new HashSet<>();
        PAGES.add("/");
        PAGES.add("/register");
        PAGES.add("/userProfile");
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        for (final String page : PAGES) {
            registry.addViewController(page).setViewName("/resources/index.html");
        }
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
