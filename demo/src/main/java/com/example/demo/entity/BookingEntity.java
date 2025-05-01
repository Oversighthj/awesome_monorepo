
package com.example.demo.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer flightId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Instant bookingTime;

    // Getter / Setter قياسية للـ id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Alias للاختبارات التي تستدعي setBookingId(...)
    public Long getBookingId() {
        return id;
    }
    public void setBookingId(Long bookingId) {
        this.id = bookingId;
    }

    // flightId كـ Integer
    public Integer getFlightId() {
        return flightId;
    }
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
    // Alias إذا أرسل الاختبار قيمة String
    public void setFlightId(String flightIdStr) {
        this.flightId = Integer.valueOf(flightIdStr);
    }

    // userId كـ Integer
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    // Alias إذا أرسل الاختبار قيمة String
    public void setUserId(String userIdStr) {
        this.userId = Integer.valueOf(userIdStr);
    }

    // seatCount
    public Integer getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    // status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // bookingTime كـ Instant
    public Instant getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(Instant bookingTime) {
        this.bookingTime = bookingTime;
    }
    // Alias إذا أرسل الاختبار LocalDateTime
    public void setBookingTime(LocalDateTime bookingDateTime) {
        this.bookingTime = bookingDateTime.atOffset(ZoneOffset.UTC).toInstant();
    }
}
