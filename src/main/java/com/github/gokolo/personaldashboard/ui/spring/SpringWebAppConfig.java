package com.github.gokolo.personaldashboard.ui.spring;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import com.github.gokolo.personaldashboard.service.converters.AddressVOConverter;
import com.github.gokolo.personaldashboard.service.converters.UserEntityConverter;
import com.github.gokolo.personaldashboard.service.converters.UserVOConverter;

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
    private UserEntityConverter userEntityConverter;

    @Autowired
    private UserVOConverter userVOConverter;

    @Autowired
    private AddressVOConverter addressVOConverter;

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(userEntityConverter);
        service.addConverter(userVOConverter);
        service.addConverter(addressVOConverter);
        return service;
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }

}
