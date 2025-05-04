package com.example.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * TransportBookingDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-04T15:53:23.538767679+08:00[Asia/Kuala_Lumpur]")
public class TransportBookingDTO {

  private Integer id;

  private Integer userId;

  private String pickupAddress;

  private String dropoffAddress;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime scheduledAt;

  private Double price;

  /**
   * Default constructor
   * @deprecated Use {@link TransportBookingDTO#TransportBookingDTO(Integer, String, String, OffsetDateTime, Double)}
   */
  @Deprecated
  public TransportBookingDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransportBookingDTO(Integer userId, String pickupAddress, String dropoffAddress, OffsetDateTime scheduledAt, Double price) {
    this.userId = userId;
    this.pickupAddress = pickupAddress;
    this.dropoffAddress = dropoffAddress;
    this.scheduledAt = scheduledAt;
    this.price = price;
  }

  public TransportBookingDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TransportBookingDTO userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public TransportBookingDTO pickupAddress(String pickupAddress) {
    this.pickupAddress = pickupAddress;
    return this;
  }

  /**
   * Get pickupAddress
   * @return pickupAddress
  */
  @NotNull 
  @Schema(name = "pickupAddress", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pickupAddress")
  public String getPickupAddress() {
    return pickupAddress;
  }

  public void setPickupAddress(String pickupAddress) {
    this.pickupAddress = pickupAddress;
  }

  public TransportBookingDTO dropoffAddress(String dropoffAddress) {
    this.dropoffAddress = dropoffAddress;
    return this;
  }

  /**
   * Get dropoffAddress
   * @return dropoffAddress
  */
  @NotNull 
  @Schema(name = "dropoffAddress", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dropoffAddress")
  public String getDropoffAddress() {
    return dropoffAddress;
  }

  public void setDropoffAddress(String dropoffAddress) {
    this.dropoffAddress = dropoffAddress;
  }

  public TransportBookingDTO scheduledAt(OffsetDateTime scheduledAt) {
    this.scheduledAt = scheduledAt;
    return this;
  }

  /**
   * Get scheduledAt
   * @return scheduledAt
  */
  @NotNull @Valid 
  @Schema(name = "scheduledAt", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("scheduledAt")
  public OffsetDateTime getScheduledAt() {
    return scheduledAt;
  }

  public void setScheduledAt(OffsetDateTime scheduledAt) {
    this.scheduledAt = scheduledAt;
  }

  public TransportBookingDTO price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @NotNull 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransportBookingDTO transportBookingDTO = (TransportBookingDTO) o;
    return Objects.equals(this.id, transportBookingDTO.id) &&
        Objects.equals(this.userId, transportBookingDTO.userId) &&
        Objects.equals(this.pickupAddress, transportBookingDTO.pickupAddress) &&
        Objects.equals(this.dropoffAddress, transportBookingDTO.dropoffAddress) &&
        Objects.equals(this.scheduledAt, transportBookingDTO.scheduledAt) &&
        Objects.equals(this.price, transportBookingDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, pickupAddress, dropoffAddress, scheduledAt, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransportBookingDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    pickupAddress: ").append(toIndentedString(pickupAddress)).append("\n");
    sb.append("    dropoffAddress: ").append(toIndentedString(dropoffAddress)).append("\n");
    sb.append("    scheduledAt: ").append(toIndentedString(scheduledAt)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

