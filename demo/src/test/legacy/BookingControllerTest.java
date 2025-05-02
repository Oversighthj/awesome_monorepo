package com.example.demo.controller;

import com.example.demo.entity.BookingEntity;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * اختبار وحدة لـ {@link BookingController}.
 */
class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @Mock
    private BookingMapper bookingMapper;

    private BookingController controller;

    private TransportBookingDTO dto;
    private BookingEntity entity;
    private BookingResponseDTO expectedDto;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new BookingController(bookingService, bookingMapper);

        // ---------- Arrange DTO ----------
        dto = new TransportBookingDTO();
        dto.setFlightId("123");
        dto.setUserId("456");
        dto.setSeatCount(2);

        // ---------- Arrange Entity ----------
        entity = new BookingEntity();
        entity.setBookingId(1L);
        entity.setFlightId("123");
        entity.setUserId("456");
        entity.setSeatCount(2);
        entity.setStatus("CONFIRMED");
        entity.setBookingTime(Instant.now());

        // ---------- Arrange Expected DTO ----------
        expectedDto = new BookingResponseDTO();
        expectedDto.setBookingId(1L);     
        expectedDto.setFlightId("123");
        expectedDto.setUserId("456");
        expectedDto.setSeatCount(2);
        expectedDto.setStatus("CONFIRMED");
        expectedDto.setBookingTime(
                OffsetDateTime.ofInstant(entity.getBookingTime(), ZoneOffset.UTC)
        );
    }

    @Test
    void bookTransport_validDto_returnsMappedResponse() {
        when(bookingService.createBooking(any(TransportBookingDTO.class)))
                .thenReturn(entity);
        when(bookingMapper.toDto(entity)).thenReturn(expectedDto);

        BookingResponseDTO resp = controller.bookTransport(dto);

        assertThat(resp).usingRecursiveComparison()
                .isEqualTo(expectedDto);

        verify(bookingService).createBooking(dto);
        verify(bookingMapper).toDto(entity);
    }

    @Test
    void bookTransport_invalidSeatCount_throwsException() {
        dto.setSeatCount(0);
        when(bookingService.createBooking(any()))
                .thenThrow(new IllegalArgumentException("Seat count must be positive"));

        try {
            controller.bookTransport(dto);
        } catch (IllegalArgumentException ex) {
            assertThat(ex).hasMessageContaining("Seat count must be positive");
        }

        verify(bookingService).createBooking(dto);
        verifyNoMoreInteractions(bookingMapper);
    }
}
