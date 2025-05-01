package com.example.demo.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flightId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Instant bookingTime;

    // id ↔ bookingId alias for tests
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookingId() {
        return id;
    }
    public void setBookingId(Long bookingId) {
        this.id = bookingId;
    }

    // String flightId + alias for Integer
    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    public void setFlightId(Integer flightId) {
        this.flightId = String.valueOf(flightId);
    }

    // String userId + alias for Integer
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserId(Integer userId) {
        this.userId = String.valueOf(userId);
    }

    public Integer getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(Instant bookingTime) {
        this.bookingTime = bookingTime;
    }
    // alias for tests using LocalDateTime
    public void setBookingTime(LocalDateTime bookingDateTime) {
        this.bookingTime = bookingDateTime.atOffset(ZoneOffset.UTC).toInstant();
    }
}
