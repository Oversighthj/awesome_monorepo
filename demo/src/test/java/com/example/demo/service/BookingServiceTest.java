package com.example.demo.service;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Captor
    private ArgumentCaptor<BookingEntity> bookingCaptor;

    @Test
    void createBooking_WithValidDto_ShouldSaveAndReturnEntity() {
        // given
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("FL123");
        dto.setUserId("USR1");
        dto.setSeatCount(2);

        when(bookingRepository.save(any(BookingEntity.class)))
            .thenAnswer(invocation -> {
                BookingEntity arg = invocation.getArgument(0);
                arg.setId(100L);
                return arg;
            });

        // when
        BookingEntity result = bookingService.createBooking(dto);

        // then
        verify(bookingRepository).save(bookingCaptor.capture());
        BookingEntity captured = bookingCaptor.getValue();

        assertThat(captured.getFlightId()).isEqualTo(dto.getFlightId());
        assertThat(captured.getUserId()).isEqualTo(dto.getUserId());
        assertThat(captured.getSeatCount()).isEqualTo(dto.getSeatCount());
        assertThat(captured.getStatus()).isEqualTo("CONFIRMED");
        assertThat(captured.getBookingTime()).isBeforeOrEqualTo(LocalDateTime.now());

        assertThat(result.getId()).isEqualTo(100L);
    }

    @Test
    void createBooking_WhenRepositoryThrowsException_ShouldPropagate() {
        // given
        TransportBookingDTO dto = new TransportBookingDTO();
        dto.setFlightId("FL123");
        dto.setUserId("USR1");
        dto.setSeatCount(2);

        when(bookingRepository.save(any(BookingEntity.class)))
            .thenThrow(new RuntimeException("DB error"));

        // then
        assertThatThrownBy(() -> bookingService.createBooking(dto))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("DB error");
    }
}
