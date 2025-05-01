package com.example.demo.service;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    private BookingService bookingService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        bookingService = new BookingService(bookingRepository);
    }

    @Test
    void createBooking_validDto_savesAndReturnsEntity() {
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("flight123");
        dto.setUserId("user456");
        dto.setSeatCount(3);

        BookingEntity saved = new BookingEntity();
        saved.setBookingId(42L);

        when(bookingRepository.save(any(BookingEntity.class))).thenReturn(saved);

        BookingEntity result = bookingService.createBooking(dto);

        assertThat(result).isSameAs(saved);
        verify(bookingRepository).save(any());
    }

    @Test
    void createBooking_invalidSeatCount_throwsAndDoesNotSave() {
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("flight123");
        dto.setUserId("user456");
        dto.setSeatCount(0);

        try {
            bookingService.createBooking(dto);
        } catch (IllegalArgumentException ex) {
            assertThat(ex).hasMessageContaining("Seat count must be positive");
        }
        verify(bookingRepository, never()).save(any());
    }
}
