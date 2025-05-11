// payment_provider.dart
import 'package:json_annotation/json_annotation.dart';

part 'payment_provider.g.dart'; // ⬅️ Generated file for JSON serialization
/// PaymentProvider enum for the PaymentRequestDTO.
/// This matches STRIPE or PAYPAL from the OpenAPI spec.
@JsonEnum(alwaysCreate: true)
enum PaymentProvider {
  @JsonValue('STRIPE')
  stripe,

  @JsonValue('PAYPAL')
  paypal,
}
