// src/main/java/com/example/demo/service/BookingService.java
package com.example.demo.service;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingEntity createBooking(TransportBookingDTO dto) {
        BookingEntity booking = new BookingEntity();
        booking.setFlightId(dto.getFlightId());
        booking.setUserId(dto.getUserId());
        booking.setSeatCount(dto.getSeatCount());
        booking.setStatus("CONFIRMED");
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }
}
