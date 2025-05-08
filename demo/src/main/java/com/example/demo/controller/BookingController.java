package com.example.demo.controller;

import com.example.demo.api.BookingsApi;
import com.example.demo.model.BookingDTO;
import com.example.demo.model.BookingStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class BookingController implements BookingsApi {

    /** GET /bookings */
    @Override
    public ResponseEntity<List<BookingDTO>> listBookings(Integer userId, BookingStatus status) {
        BookingDTO sample = new BookingDTO()
            .id(42L)                                 // id ما زال Long في DTO
            .userId(userId != null ? userId : 1)
            .resourceId("ROOM-A1")
            .startTime(OffsetDateTime.parse("2025-05-15T09:00:00Z"))
            .endTime(OffsetDateTime.parse("2025-05-15T17:00:00Z"))
            .totalPrice(199.99)
            .status(status != null ? status : BookingStatus.PENDING)
            .createdAt(OffsetDateTime.now())
            .updatedAt(OffsetDateTime.now());

        return ResponseEntity.ok(List.of(sample));
    }

    /** POST /bookings */
    @Override
    public ResponseEntity<BookingDTO> createBooking(BookingDTO bookingDTO) {
        bookingDTO.setId(1L);
        bookingDTO.setCreatedAt(OffsetDateTime.now());
        bookingDTO.setUpdatedAt(OffsetDateTime.now());
        return new ResponseEntity<>(bookingDTO, HttpStatus.CREATED);
    }

    /** GET /bookings/{bookingId} */
    @Override
    public ResponseEntity<BookingDTO> getBooking(Integer bookingId) {   // <-- Integer وليس Long
        BookingDTO sample = new BookingDTO()
            .id(bookingId.longValue())
            .userId(1)
            .resourceId("ROOM-A1")
            .startTime(OffsetDateTime.parse("2025-05-15T09:00:00Z"))
            .endTime(OffsetDateTime.parse("2025-05-15T17:00:00Z"))
            .totalPrice(199.99)
            .status(BookingStatus.PENDING)
            .createdAt(OffsetDateTime.now())
            .updatedAt(OffsetDateTime.now());
        return ResponseEntity.ok(sample);
    }
}
