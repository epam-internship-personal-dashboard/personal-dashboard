package com.github.gokolo.personaldashboard.ui.spring;

import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.github.gokolo.personaldashboard.service.converters.AddressVOConverter;
import com.github.gokolo.personaldashboard.service.converters.UserDTOConverter;
import com.github.gokolo.personaldashboard.service.converters.UserVOConverter;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

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

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private UserVOConverter userVOConverter;

    @Autowired
    private AddressVOConverter addressVOConverter;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig("/hikari.properties");
        return new HikariDataSource(config);
    }

    @Bean
    public ViewResolver configureViewResolver() {
        InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
        viewResolve.setPrefix("/WEB-INF/jsp/");
        viewResolve.setSuffix(".jsp");

        return viewResolve;
    }

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(userDTOConverter);
        service.addConverter(userVOConverter);
        service.addConverter(addressVOConverter);
        return service;
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }

}
