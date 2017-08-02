package com.github.gokolo.personaldashboard.ui.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring context configuration class. As of now, it only contains the component
 * scanning config.
 *
 * @author Attila_Gyongyosi
 * @since 0.4.0
 * @see SpringWebAppInitializer
 */
@Configuration
@ComponentScan(basePackages = "com.github.gokolo.personaldashboard")
public class SpringWebAppConfig {

    @Bean
    public ViewResolver configureViewResolver() {
        InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
        viewResolve.setPrefix("/WEB-INF/jsp/");
        viewResolve.setSuffix(".jsp");

        return viewResolve;
    }

}
