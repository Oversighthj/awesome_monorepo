package com.example.demo.model;

public class TransportBookingDTO {
    private Integer flightId;
    private Integer userId;
    private Integer seatCount;

    public TransportBookingDTO() {
    }

    public Integer getFlightId() {
        return flightId;
    }
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
