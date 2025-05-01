package com.example.demo.controller;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/transport")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.OK)
    public BookingResponseDTO bookTransport(@Valid @RequestBody TransportBookingDTO dto) {
        // 1) call service, get back JPA entity
        BookingEntity entity = bookingService.createBooking(dto);

        // 2) map to API DTO
        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingId(entity.getBookingId().intValue());
        response.setFlightId(entity.getFlightId());
        response.setUserId(entity.getUserId());
        response.setSeatCount(entity.getSeatCount());
        response.setStatus(entity.getStatus());
        // BookingResponseDTO expects an OffsetDateTime
        response.setBookingTime(entity.getBookingTime().atOffset(ZoneOffset.UTC));
        return response;
    }
}
