package com.example.demo.service.impl;

import com.example.demo.entity.BookingEntity;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.model.BookingDTO;
import com.example.demo.model.BookingStatus;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import jakarta.persistence.EntityNotFoundException;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

  private final BookingRepository repo;
  private final BookingMapper mapper;

  @Override
  @Transactional
  public BookingDTO create(BookingDTO dto) {

    boolean duplicate =
        repo.existsByUserIdAndResourceIdAndStartTime(
            dto.getUserId(), // Long
            dto.getResourceId(), // Long
            dto.getStartTime());

    if (duplicate) {
      throw new IllegalStateException("Duplicate booking detected");
    }

    BookingEntity entity = mapper.toEntity(dto);
    entity.setStatus(BookingStatus.PENDING);
    entity.setCreatedAt(OffsetDateTime.now());
    entity.setUpdatedAt(entity.getCreatedAt());

    return mapper.toDto(repo.save(entity));
  }

  @Override
  @Transactional(readOnly = true)
  public List<BookingDTO> listByUser(Long userId, BookingStatus status) {

    if (status == null) {
      return repo.findByUserId(userId).stream().map(mapper::toDto).toList();
    }

    return repo.findByUserIdAndStatus(userId, status).stream().map(mapper::toDto).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public BookingDTO getById(Long id) {
    return repo.findById(id)
        .map(mapper::toDto)
        .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
  }
}
