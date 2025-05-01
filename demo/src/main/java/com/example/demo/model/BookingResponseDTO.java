package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponseDTO {
    private Long bookingId;
    private Integer flightId;
    private Integer userId;
    private Integer seatCount;
    private String status;
    private String bookingTime;

    public BookingResponseDTO() {
    }

    @JsonProperty("bookingId")
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    @JsonProperty("flightId")
    public Integer getFlightId() {
        return flightId;
    }
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
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
    public String getBookingTime() {
        return bookingTime;
    }
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
