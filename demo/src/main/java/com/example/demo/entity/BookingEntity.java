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

    // Standard getters/setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Alias for tests that call setBookingId(...)
    public Long getBookingId() {
        return id;
    }
    public void setBookingId(Long bookingId) {
        this.id = bookingId;
    }

    public Integer getFlightId() {
        return flightId;
    }
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
    // Alias for tests that pass a String
    public void setFlightId(String flightIdStr) {
        this.flightId = Integer.valueOf(flightIdStr);
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    // Alias for tests that pass a String
    public void setUserId(String userIdStr) {
        this.userId = Integer.valueOf(userIdStr);
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
    // Alias for tests that pass LocalDateTime
    public void setBookingTime(LocalDateTime bookingDateTime) {
        this.bookingTime = bookingDateTime.atOffset(ZoneOffset.UTC).toInstant();
    }
}
