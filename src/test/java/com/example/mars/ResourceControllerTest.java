package com.example.mars;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mars.controller.ResourceController;

@WebMvcTest(ResourceController.class)
public class ResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateResource() throws Exception {
        String json = "{\"id\": 3, \"name\": \"Hydrogen Tank D\", \"type\": \"Hydrogen\", \"quantity\": 75.0, \"consumptionRate\": 3.5}";

        mockMvc.perform(post("/resources")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }
}
