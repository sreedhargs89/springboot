package com.example.springboot.securityweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity to modify
     * @return the SecurityFilterChain
     * @throws Exception if an error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll() // Allow access to the root and home paths
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Specify the custom login page
                        .permitAll() // Allow everyone to access the login page
                )
                .logout((logout) -> logout.permitAll()); // Allow everyone to access the logout functionality

        return http.build();
    }

    /**
     * Configures an in-memory user details service with a default user.
     *
     * @return the UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder() // Use default password encoder (not recommended for production)
                        .username("user") // Set the username
                        .password("password") // Set the password
                        .roles("USER") // Assign the USER role
                        .build();

        return new InMemoryUserDetailsManager(user); // Return an in-memory user details manager
    }
}