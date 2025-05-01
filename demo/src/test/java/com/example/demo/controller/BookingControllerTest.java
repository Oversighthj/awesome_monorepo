// src/test/java/com/example/demo/controller/BookingControllerTest.java
package com.example.demo.controller;

import com.example.demo.controller.BookingController;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Test
    void bookTransport_ValidPayload_ReturnsBooking() throws Exception {
        // build request DTO
        TransportBookingDTO request = new TransportBookingDTO();
        request.setFlightId(1L);
        request.setUserId(2L);
        request.setSeatCount(3);

        // stub service
        BookingResponseDTO resp = new BookingResponseDTO();
        resp.setBookingId(100);
        resp.setFlightId("2");
        resp.setUserId("2");
        resp.setBookedAt(OffsetDateTime.now());
        when(bookingService.bookTransport(any(TransportBookingDTO.class))).thenReturn(resp);

        // perform with numeric JSON
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
            .andExpect(jsonPath("$.flightId").value("2"))
            .andExpect(jsonPath("$.userId").value("2"));
    }

    @Test
    void bookTransport_InvalidSeatCount_ReturnsBadRequest() throws Exception {
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
