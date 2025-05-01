package com.example.demo.service;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Create and persist a new BookingEntity from the generated TransportBookingDTO.
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
