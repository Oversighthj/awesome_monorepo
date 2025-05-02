package com.example.demo.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingEntity createBooking(TransportBookingDTO dto) {
        // 1) Validate seatCount before saving
        if (dto.getSeatCount() <= 0) {
            throw new IllegalArgumentException("Seat count must be positive");
        }

        // 2) Map DTO → Entity
        BookingEntity entity = new BookingEntity();
        entity.setFlightId(dto.getFlightId());
        entity.setUserId(dto.getUserId());
        entity.setSeatCount(dto.getSeatCount());
        entity.setStatus("CONFIRMED");
        entity.setBookingTime(Instant.now());

        // 3) Persist
        return bookingRepository.save(entity);
    }
}
