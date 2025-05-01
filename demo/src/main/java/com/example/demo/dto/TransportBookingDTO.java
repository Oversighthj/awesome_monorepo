// src/main/java/com/example/demo/dto/TransportBookingDTO.java
package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransportBookingDTO {

    @NotNull
    private String flightId;

    @NotNull
    private String userId;

    @NotNull @Min(1)
    private Integer seatCount;

    // ───────────────
    // Getters & Setters
    // ───────────────

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /** Overload so tests can call setFlightId(1L) */
    public void setFlightId(long flightId) {
        this.flightId = Long.toString(flightId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** Overload so tests can call setUserId(1L) */
    public void setUserId(long userId) {
        this.userId = Long.toString(userId);
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
