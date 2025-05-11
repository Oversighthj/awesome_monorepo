// booking_dto.dart
// ignore_for_file: invalid_annotation_target
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:pilot_app/core/enums/booking_status.dart'; // Adjust import path as needed

part 'booking_dto.freezed.dart';
part 'booking_dto.g.dart';

@freezed
class BookingDTO with _$BookingDTO {
  const factory BookingDTO({
    /// ID of the booking (read-only, assigned by backend)
    int? id,

    /// ID of the user who created the booking
    required int userId,

    /// ID of the resource being booked
    required int resourceId,

    /// Start time of the booking
    required DateTime startTime,

    /// End time of the booking
    required DateTime endTime,

    /// Total price for the booking
    required double totalPrice,

    /// Booking status
    required BookingStatus status,

    /// When the booking was created (read-only)
    DateTime? createdAt,

    /// When the booking was last updated (read-only)
    DateTime? updatedAt,
  }) = _BookingDTO;

  factory BookingDTO.fromJson(Map<String, dynamic> json) => _$BookingDTOFromJson(json);
}
