package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.BookingEntity;
import com.example.demo.entity.BookingStatus;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    // يجلب كل الحجزات الخاصة بمستخدم وحالة معينة
    List<BookingEntity> findByUserIdAndStatus(Long userId, BookingStatus status);
}