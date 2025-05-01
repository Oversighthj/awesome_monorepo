package com.example.demo.controller;

import com.example.demo.dto.TransportBookingDTO;
import com.example.demo.entity.BookingEntity;
import com.example.demo.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transport")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.OK)
    public BookingEntity bookTransport(
            @Valid @RequestBody TransportBookingDTO dto) {
        return bookingService.createBooking(dto);
    }
}
