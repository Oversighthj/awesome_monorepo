package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/transport")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public BookingResponseDTO bookTransport(@RequestBody TransportBookingDTO dto) {
        BookingEntity entity = bookingService.createBooking(dto);

        BookingResponseDTO response = new BookingResponseDTO();
        response.setBookingId(entity.getBookingId());
        response.setFlightId(entity.getFlightId());
        response.setUserId(entity.getUserId());
        response.setSeatCount(entity.getSeatCount());
        response.setStatus(entity.getStatus());
        response.setBookingTime(entity.getBookingTime().toString());
        return response;
    }
}
