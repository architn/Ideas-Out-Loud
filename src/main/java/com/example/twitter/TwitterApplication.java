package com.example.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;

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

}
