package com.example.demo.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * اختبار تكاملي على /api/bookings مع اعتماد JWT Security:
 *  1. نطلب /auth/login للحصول على توكن
 *  2. نستخدمه في استدعاء POST /api/bookings
 *  3. نتأكد أننا نحصل على 201
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookingApiTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("POST /api/bookings then GET /api/bookings returns the created record, using JWT from /auth/login")
    void create_thenList() throws Exception {

        // أولاً: نسجّل الدخول للحصول على JWT
        String loginPayload = """
            {
              "username": "testuser",
              "password": "password"
            }
            """;

        MvcResult loginResult = mvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginPayload))
            .andExpect(status().isOk())
            .andReturn();

        // نقرأ الـ token من الاستجابة
        String loginResponse = loginResult.getResponse().getContentAsString();
        JsonNode jsonNode = mapper.readTree(loginResponse);

        // إذا AuthController يرجع الحقل "accessToken" عدّل السطر أدناه accordingly
        String token = jsonNode.get("token").asText();

        // ثانياً: ننفّذ POST /api/bookings مرفقًا بالتوكن
        String bookingJson = """
            {
              "userId": 1,
              "resourceId": 1001,
              "startTime": "2025-05-15T09:00:00Z",
              "endTime":   "2025-05-15T17:00:00Z",
              "totalPrice": 199.99
            }
            """;

        mvc.perform(post("/api/bookings")
                .header("Authorization", "Bearer " + token)  // إضافة الهيدر
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookingJson))
           .andExpect(status().isCreated());

        // ثالثاً: نختبر GET /api/bookings (لو أردت التأكد من البيانات)
        mvc.perform(get("/api/bookings")
                .header("Authorization", "Bearer " + token)
                .param("userId", "1"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id").exists())
           .andExpect(jsonPath("$[0].status").value("PENDING"));
    }
}
