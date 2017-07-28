package com.github.gokolo.personaldashboard.ui.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * This implementation of Spring Web's {@link WebApplicationInitializer}
 * is responsible for booting up the Spring Application Context in a
 * Servlet API environment.
 *
 * This class will be automatically executed by the Servlet container
 * (e.g. Tomcat) when you deploy your application.
 *
 * @author  Attila_Gyongyosi
 * @since   0.4.0
 * @see     SpringWebAppConfig
 */
public class SpringWebAppInitializer implements WebApplicationInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(SpringWebAppInitializer.class);

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        LOG.info("Creating Spring Web Application Context...");

        // Creating Spring Web App Context object
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // Supplying the configuration class
        context.register(SpringWebAppConfig.class);

        // Registering a Servlet API listener
        servletContext.addListener(new ContextLoaderListener(context));

        LOG.info("Spring context has been set up successfully.");
    }
}
