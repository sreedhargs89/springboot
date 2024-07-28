package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class for the Spring Boot application.
 */
@SpringBootApplication
public class Application {

    /**
     * Main method to run the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Bean definition for CommandLineRunner to inspect the beans provided by Spring Boot.
     * This runner will execute on application startup and print the names of all beans
     * defined in the application context.
     *
     * @param ctx the application context used to retrieve bean definitions
     * @return a CommandLineRunner that prints bean names
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

    /**
     * Configuration class for setting up view controllers.
     */
    @Configuration
    public static class MvcConfig implements WebMvcConfigurer {

        /**
         * Adds view controllers to the registry.
         *
         * @param registry the ViewControllerRegistry to add view controllers to
         */
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/home").setViewName("home");
            registry.addViewController("/").setViewName("home");
            registry.addViewController("/hello").setViewName("hello");
            registry.addViewController("/login").setViewName("login");
        }

    }
}