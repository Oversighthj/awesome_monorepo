// payment_request_dto.dart
// ignore_for_file: invalid_annotation_target
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:pilot_app/core/enums/payment_provider.dart'; // Adjust import path

part 'payment_request_dto.freezed.dart';
part 'payment_request_dto.g.dart';

@freezed
class PaymentRequestDTO with _$PaymentRequestDTO {
  const factory PaymentRequestDTO({
    /// The booking ID associated with this payment
    required int bookingId,

    /// The amount to be charged
    required double amount,

    /// The currency code (e.g. 'USD', 'MYR')
    required String currency,

    /// The payment provider (STRIPE, PAYPAL, etc.)
    required PaymentProvider provider,

    /// (Future field) URL to redirect user upon successful payment
    @JsonKey(includeIfNull: false) String? successUrl,

    /// (Future field) URL to redirect user upon canceling payment
    @JsonKey(includeIfNull: false) String? cancelUrl,
  }) = _PaymentRequestDTO;

  factory PaymentRequestDTO.fromJson(Map<String, dynamic> json) =>
      _$PaymentRequestDTOFromJson(json);
}
