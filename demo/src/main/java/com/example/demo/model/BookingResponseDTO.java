package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

/**
 * بيانات استجابة حجز الرحلة.
 */
public class BookingResponseDTO {

    private Long bookingId;
    private String flightId;
    private String userId;
    private Integer seatCount;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING)          // تُعاد كسلسلة ISO-8601
    private OffsetDateTime bookingTime;                   // ✅ أصبح OffsetDateTime

    public BookingResponseDTO() {
        // no-args constructor
    }

    // --- Getters & Setters ---

    @JsonProperty("bookingId")
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("flightId")
    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("seatCount")
    public Integer getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("bookingTime")
    public OffsetDateTime getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(OffsetDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
