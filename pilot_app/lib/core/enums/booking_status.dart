// booking_status.dart
import 'package:json_annotation/json_annotation.dart';

part 'booking_status.g.dart';   // ⬅️ Generated file for JSON serialization
/// BookingStatus enum, matching the OpenAPI spec values.
/// We use @JsonValue to ensure correct serialization/deserialization.
@JsonEnum(alwaysCreate: true)
enum BookingStatus {
  @JsonValue('PENDING')
  pending,

  @JsonValue('CONFIRMED')
  confirmed,

  @JsonValue('CANCELLED')
  cancelled,

  @JsonValue('EXPIRED')
  expired,
}
