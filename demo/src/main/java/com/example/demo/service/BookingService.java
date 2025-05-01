// src/main/java/com/example/demo/service/BookingService.java
package com.example.demo.service;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Persist a booking entity and return it.
     * (Tests expect BookingEntity, not a DTO.)
     */
    public BookingEntity createBooking(TransportBookingDTO dto) {
        BookingEntity entity = new BookingEntity();
        entity.setFlightId(dto.getFlightId());
        entity.setUserId(dto.getUserId());
        entity.setSeatCount(dto.getSeatCount());
        entity.setStatus("CONFIRMED");
        entity.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(entity);
    }
}
