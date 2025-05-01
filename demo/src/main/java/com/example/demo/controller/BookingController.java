// src/main/java/com/example/demo/controller/BookingController.java
package com.example.demo.controller;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.dto.TransportBookingDTO;
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
        // call into your service (now takes the internal DTO)
        BookingEntity entity = bookingService.createBooking(dto);

        // map the JPA entity back into the generated API response DTO
        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingId(entity.getBookingId().intValue());
        response.setFlightId(dto.getFlightId());
        response.setUserId(dto.getUserId());
        response.setSeatCount(entity.getSeatCount());
        response.setStatus(entity.getStatus());
        response.setBookingTime(entity.getBookingTime().atOffset(ZoneOffset.UTC));
        return response;
    }
}
