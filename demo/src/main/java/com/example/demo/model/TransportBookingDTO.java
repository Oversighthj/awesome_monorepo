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
    // alias لاستقبال الاختبارات قيمة String
    public void setFlightId(String flightIdStr) {
        this.flightId = Integer.valueOf(flightIdStr);
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    // alias لاستقبال الاختبارات قيمة String
    public void setUserId(String userIdStr) {
        this.userId = Integer.valueOf(userIdStr);
    }

    public Integer getSeatCount() {
        return seatCount;
    }
    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
