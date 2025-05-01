package com.example.demo.controller;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /transport/book - valid payload returns 200 and booking JSON")
    void bookTransport_ValidPayload_ReturnsBooking() throws Exception {
        // given
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("FL123");
        dto.setUserId("USR1");
        dto.setSeatCount(2);

        BookingEntity mockBooking = new BookingEntity();
        mockBooking.setId(42L);
        mockBooking.setFlightId(dto.getFlightId());
        mockBooking.setUserId(dto.getUserId());
        mockBooking.setSeatCount(dto.getSeatCount());
        mockBooking.setStatus("CONFIRMED");
        mockBooking.setBookingTime(LocalDateTime.of(2025, 4, 30, 15, 30));

        when(bookingService.createBooking(any(TransportBookingDTO.class)))
            .thenReturn(mockBooking);

        // when / then
        mockMvc.perform(post("/transport/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.bookingId").value(42))
            .andExpect(jsonPath("$.flightId").value("FL123"))
            .andExpect(jsonPath("$.userId").value("USR1"))
            .andExpect(jsonPath("$.seatCount").value(2))
            .andExpect(jsonPath("$.status").value("CONFIRMED"))
            .andExpect(jsonPath("$.bookingTime").value("2025-04-30T15:30:00Z"));
    }

    @Test
    @DisplayName("POST /transport/book - invalid seatCount returns 400")
    void bookTransport_InvalidSeatCount_ReturnsBadRequest() throws Exception {
        // given: seatCount < 1
        String invalidJson = """
            {
              "flightId": "FL123",
              "userId": "USR1",
              "seatCount": 0
            }
            """;

        // when / then
        mockMvc.perform(post("/transport/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
            .andExpect(status().isBadRequest());
    }
}
