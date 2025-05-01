// src/test/java/com/example/demo/service/BookingServiceTest.java
package com.example.demo.service;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    private BookingService bookingService;
    private BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        bookingRepository = Mockito.mock(BookingRepository.class);
        bookingService = new BookingService(bookingRepository);
    }

    @Test
    void createBooking_ValidDto_SavesEntity() {
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("FL123");
        dto.setUserId("U456");
        dto.setSeatCount(2);
        LocalDateTime now = LocalDateTime.now();

        BookingEntity savedEntity = new BookingEntity();
        savedEntity.setBookingId(42L);
        savedEntity.setFlightId(dto.getFlightId());
        savedEntity.setUserId(dto.getUserId());
        savedEntity.setSeatCount(dto.getSeatCount());
        savedEntity.setStatus("CONFIRMED");
        savedEntity.setBookingTime(now);

        when(bookingRepository.save(ArgumentMatchers.any(BookingEntity.class)))
            .thenReturn(savedEntity);

        BookingEntity result = bookingService.createBooking(dto);

        assertThat(result.getBookingId()).isEqualTo(42L);
        assertThat(result.getFlightId()).isEqualTo("FL123");
        assertThat(result.getUserId()).isEqualTo("U456");
        assertThat(result.getSeatCount()).isEqualTo(2);
        assertThat(result.getStatus()).isEqualTo("CONFIRMED");
        assertThat(result.getBookingTime()).isEqualTo(now);
    }

    @Test
    void createBooking_InvalidSeatCount_Throws() {
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("FL123");
        dto.setUserId("U456");
        dto.setSeatCount(0);

        assertThatThrownBy(() -> bookingService.createBooking(dto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("seatCount must be at least 1");
    }
}
