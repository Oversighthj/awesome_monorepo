package com.example.demo.model;

public class TransportBookingDTO {
    private String flightId;
    private String userId;
    private Integer seatCount;

    public TransportBookingDTO() {
    }

    // JSON → String (Jackson will coerce numbers to strings automatically)
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
    // allow dto.setUserId(456) in tests
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
