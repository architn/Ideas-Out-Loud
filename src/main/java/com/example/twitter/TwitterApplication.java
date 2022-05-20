package com.example.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication(scanBasePackages = "com.app.controllers")
@ComponentScan({"com.app.controllers"})
public class TwitterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(TwitterApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TwitterApplication.class);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
    	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    	multipartResolver.setMaxUploadSize(1000000);
    	return multipartResolver;
    }
}