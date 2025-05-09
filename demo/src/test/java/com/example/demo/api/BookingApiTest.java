package com.example.demo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookingApiTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("POST /bookings then GET /bookings returns the created record")
    void create_thenList() throws Exception {
        String json = """
            {
              "userId": 1,
              "resourceId": 1001,
              "startTime": "2025-05-15T09:00:00Z",
              "endTime":   "2025-05-15T17:00:00Z",
              "totalPrice": 199.99
            }
            """;

        /* 1) إنشاء حجز */
        mvc.perform(post("/api/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
           .andExpect(status().isCreated());

        /* 2) جلب قائمة الحجوزات */
        mvc.perform(get("/api/bookings")
                .param("userId", "1"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id").exists())
           .andExpect(jsonPath("$[0].status").value("PENDING"));
    }
}
