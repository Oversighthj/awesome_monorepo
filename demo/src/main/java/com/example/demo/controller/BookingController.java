package com.example.demo.controller;

import com.example.demo.api.BookingsApi;
import com.example.demo.model.BookingDTO;
import com.example.demo.model.BookingStatus;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController implements BookingsApi {

    private final BookingService bookingService;

    /** POST /bookings */
    @Override
    public ResponseEntity<BookingDTO> createBooking(BookingDTO bookingDTO) {
        BookingDTO saved = bookingService.create(bookingDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /** GET /bookings?userId=&status= */
    @Override
    public ResponseEntity<List<BookingDTO>> listBookings(Long userId,
                                                         BookingStatus status) {
        List<BookingDTO> bookings = bookingService.listByUser(userId, status);
        return ResponseEntity.ok(bookings);
    }

    /** GET /bookings/{bookingId} */
    @Override
    public ResponseEntity<BookingDTO> getBooking(Long bookingId) {
        BookingDTO dto = bookingService.getById(bookingId);
        return ResponseEntity.ok(dto);
    }
}
