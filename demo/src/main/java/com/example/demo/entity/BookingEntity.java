package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(nullable = false)
    private String flightId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime bookingTime;

    // -----------------------
    // Standard getters/setters
    // -----------------------

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    // -----------------------
    // Alias methods for tests
    // -----------------------

    /** For tests expecting getId()/setId(Long) */
    public Long getId() {
        return bookingId;
    }

    public void setId(Long id) {
        this.bookingId = id;
    }

    /** To support tests that pass String IDs */
    public void setId(String id) {
        this.bookingId = (id == null ? null : Long.valueOf(id));
    }
}
