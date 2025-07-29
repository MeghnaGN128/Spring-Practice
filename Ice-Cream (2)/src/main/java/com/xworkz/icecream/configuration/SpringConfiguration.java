package com.xworkz.icecream.configuration;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.apache.poi.ss.usermodel.CellType;
import java.io.FileInputStream;
import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.xworkz.icecream")
public class SpringConfiguration implements WebMvcConfigurer {

    public SpringConfiguration() {
        System.out.println("Running SpringConfiguration");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("addResourceHandlers method");
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


}
