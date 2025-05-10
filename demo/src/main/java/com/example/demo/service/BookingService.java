package com.example.demo.service;

import com.example.demo.model.BookingDTO;
import com.example.demo.model.BookingStatus;
import java.util.List;

public interface BookingService {

  BookingDTO create(BookingDTO dto);

  List<BookingDTO> listByUser(Long userId, BookingStatus status);

  BookingDTO getById(Long id);
}
