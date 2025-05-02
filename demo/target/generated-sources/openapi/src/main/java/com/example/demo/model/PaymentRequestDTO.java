package com.example.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PaymentRequestDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-02T11:01:44.032233944+08:00[Asia/Kuala_Lumpur]")
public class PaymentRequestDTO {

  private Long bookingId;

  private Double amount;

  private String currency;

  /**
   * Gets or Sets provider
   */
  public enum ProviderEnum {
    STRIPE("STRIPE"),
    
    PAYPAL("PAYPAL");

    private String value;

    ProviderEnum(String value) {
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
    public static ProviderEnum fromValue(String value) {
      for (ProviderEnum b : ProviderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ProviderEnum provider;

  /**
   * Default constructor
   * @deprecated Use {@link PaymentRequestDTO#PaymentRequestDTO(Long, Double, String, ProviderEnum)}
   */
  @Deprecated
  public PaymentRequestDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaymentRequestDTO(Long bookingId, Double amount, String currency, ProviderEnum provider) {
    this.bookingId = bookingId;
    this.amount = amount;
    this.currency = currency;
    this.provider = provider;
  }

  public PaymentRequestDTO bookingId(Long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * @return bookingId
  */
  @NotNull 
  @Schema(name = "bookingId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookingId")
  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public PaymentRequestDTO amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public PaymentRequestDTO currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  @NotNull 
  @Schema(name = "currency", example = "MYR", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public PaymentRequestDTO provider(ProviderEnum provider) {
    this.provider = provider;
    return this;
  }

  /**
   * Get provider
   * @return provider
  */
  @NotNull 
  @Schema(name = "provider", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("provider")
  public ProviderEnum getProvider() {
    return provider;
  }

  public void setProvider(ProviderEnum provider) {
    this.provider = provider;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequestDTO paymentRequestDTO = (PaymentRequestDTO) o;
    return Objects.equals(this.bookingId, paymentRequestDTO.bookingId) &&
        Objects.equals(this.amount, paymentRequestDTO.amount) &&
        Objects.equals(this.currency, paymentRequestDTO.currency) &&
        Objects.equals(this.provider, paymentRequestDTO.provider);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, amount, currency, provider);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequestDTO {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
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

