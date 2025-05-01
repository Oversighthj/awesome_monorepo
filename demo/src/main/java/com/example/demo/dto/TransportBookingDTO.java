// src/main/java/com/example/demo/dto/TransportBookingDTO.java
package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransportBookingDTO {

    @NotNull
    private Long flightId;

    @NotNull
    private Long userId;

    @NotNull @Min(1)
    private Integer seatCount;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
