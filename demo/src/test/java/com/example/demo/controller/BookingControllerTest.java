// src/test/java/com/example/demo/controller/BookingControllerTest.java
package com.example.demo.controller;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    private BookingController controller;
    private TransportBookingDTO dto;
    private BookingEntity entity;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new BookingController(bookingService);

        dto = new TransportBookingDTO();
        dto.setFlightId("123");
        dto.setUserId("456");
        dto.setSeatCount(2);

        entity = new BookingEntity();
        entity.setBookingId(1L);
        entity.setFlightId("123");
        entity.setUserId("456");
        entity.setSeatCount(2);
        entity.setStatus("CONFIRMED");
        // now using LocalDateTime, to match BookingEntity#setBookingTime
        entity.setBookingTime(LocalDateTime.now(ZoneOffset.UTC));
    }

    @Test
    void bookTransport_validDto_returnsMappedResponse() {
        when(bookingService.createBooking(any(TransportBookingDTO.class)))
            .thenReturn(entity);

        BookingResponseDTO resp = controller.bookTransport(dto);

        // ← here we compare to 1L (Long) instead of 1
        assertThat(resp.getBookingId()).isEqualTo(1L);
        assertThat(resp.getFlightId()).isEqualTo("123");
        assertThat(resp.getUserId()).isEqualTo("456");
        assertThat(resp.getSeatCount()).isEqualTo(2);
        assertThat(resp.getStatus()).isEqualTo("CONFIRMED");
        assertThat(resp.getBookingTime())
            .isEqualTo(entity.getBookingTime().atOffset(ZoneOffset.UTC));
    }

    @Test
    void bookTransport_invalidSeatCount_throwsException() {
        dto.setSeatCount(0);
        when(bookingService.createBooking(any(TransportBookingDTO.class)))
            .thenThrow(new IllegalArgumentException("Seat count must be positive"));

        try {
            controller.bookTransport(dto);
        } catch (IllegalArgumentException ex) {
            assertThat(ex).hasMessageContaining("Seat count must be positive");
        }
        verify(bookingService).createBooking(any());
    }
}
