package com.example.springboot;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Annotation to indicate that the application context should be loaded for the test.
 * This is used to create an application context with all the beans and configurations.
 */
@SpringBootTest

/**
 * Annotation to enable and configure MockMvc for testing web endpoints without starting an actual HTTP server.
 * This allows for testing the web layer of the application in a lightweight manner.
 */
@AutoConfigureMockMvc
//@AutoConfigureMockMvc: This enables MockMvc for testing web endpoints without starting an actual HTTP server.


public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     * Test method for the GET request to the root ("/") endpoint.
     * This test performs a GET request and expects the response status to be OK (200)
     * and the content to be "Greetings from Spring Boot!".
     *
     * @throws Exception if an error occurs during the request
     */
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}