// payment_response_dto.dart
// ignore_for_file: invalid_annotation_target
import 'package:freezed_annotation/freezed_annotation.dart';

part 'payment_response_dto.freezed.dart';
part 'payment_response_dto.g.dart';

@freezed
class PaymentResponseDTO with _$PaymentResponseDTO {
  const factory PaymentResponseDTO({
    /// The booking ID linked to this payment
    required int bookingId,

    /// URL to load for payment checkout
    required String checkoutUrl,

    /// Expiration time for the checkout session (nullable)
    DateTime? expiresAt,

    /// Provider session identifier
    required String providerSessionId,
  }) = _PaymentResponseDTO;

  factory PaymentResponseDTO.fromJson(Map<String, dynamic> json) =>
      _$PaymentResponseDTOFromJson(json);
}
