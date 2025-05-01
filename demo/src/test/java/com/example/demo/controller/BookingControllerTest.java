// src/test/java/com/example/demo/controller/BookingControllerTest.java
package com.example.demo.controller;

import com.example.demo.controller.BookingController;
import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    private TransportBookingDTO requestDto;
    private BookingEntity mockEntity;

    @BeforeEach
    void setUp() {
        // Prepare a valid request DTO
        requestDto = new TransportBookingDTO();
        requestDto.setFlightId("FL123");
        requestDto.setUserId("U456");
        requestDto.setSeatCount(2);

        // Prepare the mock BookingEntity returned by the service
        mockEntity = new BookingEntity();
        mockEntity.setBookingId(1L);
        mockEntity.setFlightId("FL123");
        mockEntity.setUserId("U456");
        mockEntity.setSeatCount(2);
        mockEntity.setStatus("CONFIRMED");
        // Fixed date for determinism
        LocalDateTime now = LocalDateTime.of(2025, 1, 1, 12, 0);
        mockEntity.setBookingTime(now);
    }

    @Test
    void bookTransport_ValidPayload_ReturnsBooking() throws Exception {
        // Stub the service to return our mock entity when any TransportBookingDTO is passed
        when(bookingService.createBooking(ArgumentMatchers.any(TransportBookingDTO.class)))
            .thenReturn(mockEntity);

        mockMvc.perform(post("/transport/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"flightId\":\"FL123\",\"userId\":\"U456\",\"seatCount\":2}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.bookingId").value(1))
            .andExpect(jsonPath("$.flightId").value("FL123"))
            .andExpect(jsonPath("$.userId").value("U456"))
            .andExpect(jsonPath("$.seatCount").value(2))
            .andExpect(jsonPath("$.status").value("CONFIRMED"))
            .andExpect(jsonPath("$.bookingTime").value(
                OffsetDateTime.of(mockEntity.getBookingTime(), ZoneOffset.UTC).toString()
            ));
    }

    @Test
    void bookTransport_InvalidSeatCount_ReturnsBadRequest() throws Exception {
        // seatCount = 0 violates @Min(1) (or similar) on TransportBookingDTO
        mockMvc.perform(post("/transport/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"flightId\":\"FL123\",\"userId\":\"U456\",\"seatCount\":0}"))
            .andExpect(status().isBadRequest());
    }
}
