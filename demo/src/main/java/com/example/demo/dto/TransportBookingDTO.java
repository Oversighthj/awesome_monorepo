package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportBookingDTO {
    @NotBlank
    private String flightId;

    @NotBlank
    private String userId;

    @NotNull
    @Min(1)
    private Integer seatCount;
}
