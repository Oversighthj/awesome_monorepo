package com.example.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets BookingStatus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-02T14:14:32.978510261+08:00[Asia/Kuala_Lumpur]")
public enum BookingStatus {
  
  PENDING("PENDING"),
  
  CONFIRMED("CONFIRMED"),
  
  CANCELLED("CANCELLED"),
  
  PAID("PAID"),
  
  EXPIRED("EXPIRED");

  private String value;

  BookingStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BookingStatus fromValue(String value) {
    for (BookingStatus b : BookingStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

