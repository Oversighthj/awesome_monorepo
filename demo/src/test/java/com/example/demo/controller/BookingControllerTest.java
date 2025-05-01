// src/test/java/com/example/demo/controller/BookingControllerTest.java
package com.example.demo.controller;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.service.BookingService;
import com.example.demo.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BookingController.class)
@Import(SecurityConfig.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Test
    public void bookTransport_ValidPayload_ReturnsBooking() throws Exception {
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId(1L);
        dto.setUserId(2L);
        dto.setSeatCount(3);

        BookingEntity booking = new BookingEntity();
        booking.setBookingId(100L);
        booking.setFlightId(dto.getFlightId());
        booking.setUserId(dto.getUserId());
        booking.setSeatCount(dto.getSeatCount());
        booking.setStatus("CONFIRMED");
        booking.setBookingTime(LocalDateTime.now());

        when(bookingService.createBooking(any(TransportBookingDTO.class))).thenReturn(booking);

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
            .andExpect(jsonPath("$.bookingId").value(100))
            .andExpect(jsonPath("$.status").value("CONFIRMED"));
    }

    @Test
    public void bookTransport_InvalidSeatCount_ReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/transport/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "flightId": 1,
                      "userId": 2,
                      "seatCount": 0
                    }
                    """))
            .andExpect(status().isBadRequest());
    }
}
