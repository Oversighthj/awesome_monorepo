package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookingEntity;
import com.example.demo.mapper.BookingMapper;          // 🚀 Mapper جديد
import com.example.demo.model.BookingResponseDTO;
import com.example.demo.model.TransportBookingDTO;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/transport")
public class BookingController {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;        // 🔗 حقن المابِر

    public BookingController(
            BookingService bookingService,
            BookingMapper bookingMapper
    ) {
        this.bookingService = bookingService;
        this.bookingMapper  = bookingMapper;
    }

    @PostMapping("/book")
    public BookingResponseDTO bookTransport(@RequestBody TransportBookingDTO dto) {
        BookingEntity entity = bookingService.createBooking(dto);
        // تحوّل Entity → DTO عبر MapStruct
        return bookingMapper.toDto(entity);
    }
}
