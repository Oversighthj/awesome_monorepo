package com.example.demo.model;

public class TransportBookingDTO {
    private String flightId;
    private String userId;
    private Integer seatCount;

    public TransportBookingDTO() {
    }

    // JSON → String, or Jackson will coerce 2 → "2"
    public String getFlightId() {
        return flightId;
    }
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
    // allow dto.setFlightId(123) in tests, too
    public void setFlightId(Integer flightId) {
        this.flightId = String.valueOf(flightId);
    }

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
}
