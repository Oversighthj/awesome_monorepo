package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.service.BookingService;

import java.time.OffsetDateTime;   // ✅ لتحويل Instant إلى OffsetDateTime
import java.time.ZoneOffset;

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

        BookingResponseDTO resp = new BookingResponseDTO();
        resp.setBookingId(entity.getBookingId());
        resp.setFlightId(entity.getFlightId());
        resp.setUserId(entity.getUserId());
        resp.setSeatCount(entity.getSeatCount());
        resp.setStatus(entity.getStatus());

        // نحفظ التوقيت كـ OffsetDateTime متوافق مع الـ DTO المولّد
        resp.setBookingTime(
                OffsetDateTime.ofInstant(entity.getBookingTime(), ZoneOffset.UTC)
        );

        return resp;
    }
}
