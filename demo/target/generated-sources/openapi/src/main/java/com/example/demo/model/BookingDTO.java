package com.example.demo.model;

import java.net.URI;
import java.util.Objects;
import com.example.demo.model.BookingStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BookingDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-02T13:43:29.120986689+08:00[Asia/Kuala_Lumpur]")
public class BookingDTO {

  private Long id;

  private Integer userId;

  private String resourceId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTime;

  private Double totalPrice;

  private BookingStatus status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime updatedAt;

  /**
   * Default constructor
   * @deprecated Use {@link BookingDTO#BookingDTO(Integer, String, OffsetDateTime, OffsetDateTime, Double)}
   */
  @Deprecated
  public BookingDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingDTO(Integer userId, String resourceId, OffsetDateTime startTime, OffsetDateTime endTime, Double totalPrice) {
    this.userId = userId;
    this.resourceId = resourceId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.totalPrice = totalPrice;
  }

  public BookingDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "42", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BookingDTO userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BookingDTO resourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  /**
   * Identifier of the booked asset (room, apartment, vehicle …)
   * @return resourceId
  */
  @NotNull 
  @Schema(name = "resourceId", example = "ROOM-A1", description = "Identifier of the booked asset (room, apartment, vehicle …)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("resourceId")
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public BookingDTO startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  */
  @NotNull @Valid 
  @Schema(name = "startTime", example = "2025-05-15T09:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startTime")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public BookingDTO endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  */
  @NotNull @Valid 
  @Schema(name = "endTime", example = "2025-05-15T17:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endTime")
  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public BookingDTO totalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * Get totalPrice
   * @return totalPrice
  */
  @NotNull 
  @Schema(name = "totalPrice", example = "199.99", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalPrice")
  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public BookingDTO status(BookingStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

  public BookingDTO createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @Valid 
  @Schema(name = "createdAt", accessMode = Schema.AccessMode.READ_ONLY, example = "2025-05-01T12:00Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public BookingDTO updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
  */
  @Valid 
  @Schema(name = "updatedAt", accessMode = Schema.AccessMode.READ_ONLY, example = "2025-05-01T12:00Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingDTO bookingDTO = (BookingDTO) o;
    return Objects.equals(this.id, bookingDTO.id) &&
        Objects.equals(this.userId, bookingDTO.userId) &&
        Objects.equals(this.resourceId, bookingDTO.resourceId) &&
        Objects.equals(this.startTime, bookingDTO.startTime) &&
        Objects.equals(this.endTime, bookingDTO.endTime) &&
        Objects.equals(this.totalPrice, bookingDTO.totalPrice) &&
        Objects.equals(this.status, bookingDTO.status) &&
        Objects.equals(this.createdAt, bookingDTO.createdAt) &&
        Objects.equals(this.updatedAt, bookingDTO.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, resourceId, startTime, endTime, totalPrice, status, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

