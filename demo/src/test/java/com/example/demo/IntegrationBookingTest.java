// src/test/java/com/example/demo/IntegrationBookingTest.java
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationBookingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void bookTransport_Integration_ReturnsBookingEntity() throws Exception {
        mockMvc.perform(post("/transport/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "flightId": 1,
                      "userId": 2,
                      "seatCount": 3
                    }
                    """))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.bookingId").isNumber())
            // flightId is now serialized as a String
            .andExpect(jsonPath("$.flightId").value("1"))
            .andExpect(jsonPath("$.userId").value("2"));
    }
}
