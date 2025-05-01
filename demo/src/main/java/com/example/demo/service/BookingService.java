// src/main/java/com/example/demo/service/BookingService.java
package com.example.demo.service;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingResponseDTO createBooking(TransportBookingDTO dto) {
        BookingEntity entity = new BookingEntity();
        entity.setFlightId(dto.getFlightId());
        entity.setUserId(dto.getUserId());
        entity.setSeatCount(dto.getSeatCount());
        entity.setStatus("CONFIRMED");
        entity.setBookingTime(LocalDateTime.now());

        entity = bookingRepository.save(entity);

        BookingResponseDTO response = new BookingResponseDTO();
        // الآن نمرّر types مطابقة للـ DTO
        response.setBookingId(entity.getBookingId());     // Long → Long
        response.setFlightId(entity.getFlightId());       // String → String
        response.setUserId(entity.getUserId());           // String → String
        response.setSeatCount(entity.getSeatCount());     // Integer → Integer
        response.setStatus(entity.getStatus());           // String → String
        response.setBookingTime(entity.getBookingTime()); // LocalDateTime → LocalDateTime or OffsetDateTime
        return response;
    }
}
