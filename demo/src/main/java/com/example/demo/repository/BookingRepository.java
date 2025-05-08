package com.example.demo.repository;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    List<BookingEntity> findByUserIdAndStatus(Long userId, BookingStatus status);

    List<BookingEntity> findByUserId(Long userId);

    boolean existsByUserIdAndResourceIdAndStartTime(
            Long userId, Long resourceId, OffsetDateTime startTime);
}
