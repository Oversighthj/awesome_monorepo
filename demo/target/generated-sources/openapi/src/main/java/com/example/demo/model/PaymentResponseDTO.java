package com.example.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
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
 * PaymentResponseDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-02T11:01:44.032233944+08:00[Asia/Kuala_Lumpur]")
public class PaymentResponseDTO {

  private URI checkoutUrl;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime expiresAt;

  private String providerSessionId;

  /**
   * Default constructor
   * @deprecated Use {@link PaymentResponseDTO#PaymentResponseDTO(URI, String)}
   */
  @Deprecated
  public PaymentResponseDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaymentResponseDTO(URI checkoutUrl, String providerSessionId) {
    this.checkoutUrl = checkoutUrl;
    this.providerSessionId = providerSessionId;
  }

  public PaymentResponseDTO checkoutUrl(URI checkoutUrl) {
    this.checkoutUrl = checkoutUrl;
    return this;
  }

  /**
   * Get checkoutUrl
   * @return checkoutUrl
  */
  @NotNull @Valid 
  @Schema(name = "checkoutUrl", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("checkoutUrl")
  public URI getCheckoutUrl() {
    return checkoutUrl;
  }

  public void setCheckoutUrl(URI checkoutUrl) {
    this.checkoutUrl = checkoutUrl;
  }

  public PaymentResponseDTO expiresAt(OffsetDateTime expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * Get expiresAt
   * @return expiresAt
  */
  @Valid 
  @Schema(name = "expiresAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expiresAt")
  public OffsetDateTime getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(OffsetDateTime expiresAt) {
    this.expiresAt = expiresAt;
  }

  public PaymentResponseDTO providerSessionId(String providerSessionId) {
    this.providerSessionId = providerSessionId;
    return this;
  }

  /**
   * Get providerSessionId
   * @return providerSessionId
  */
  @NotNull 
  @Schema(name = "providerSessionId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("providerSessionId")
  public String getProviderSessionId() {
    return providerSessionId;
  }

  public void setProviderSessionId(String providerSessionId) {
    this.providerSessionId = providerSessionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentResponseDTO paymentResponseDTO = (PaymentResponseDTO) o;
    return Objects.equals(this.checkoutUrl, paymentResponseDTO.checkoutUrl) &&
        Objects.equals(this.expiresAt, paymentResponseDTO.expiresAt) &&
        Objects.equals(this.providerSessionId, paymentResponseDTO.providerSessionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checkoutUrl, expiresAt, providerSessionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentResponseDTO {\n");
    sb.append("    checkoutUrl: ").append(toIndentedString(checkoutUrl)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    providerSessionId: ").append(toIndentedString(providerSessionId)).append("\n");
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

