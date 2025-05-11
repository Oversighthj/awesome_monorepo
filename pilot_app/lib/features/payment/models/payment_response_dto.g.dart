// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'payment_response_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$PaymentResponseDTOImpl _$$PaymentResponseDTOImplFromJson(
        Map<String, dynamic> json) =>
    _$PaymentResponseDTOImpl(
      bookingId: (json['bookingId'] as num).toInt(),
      checkoutUrl: json['checkoutUrl'] as String,
      expiresAt: json['expiresAt'] == null
          ? null
          : DateTime.parse(json['expiresAt'] as String),
      providerSessionId: json['providerSessionId'] as String,
    );

Map<String, dynamic> _$$PaymentResponseDTOImplToJson(
        _$PaymentResponseDTOImpl instance) =>
    <String, dynamic>{
      'bookingId': instance.bookingId,
      'checkoutUrl': instance.checkoutUrl,
      'expiresAt': instance.expiresAt?.toIso8601String(),
      'providerSessionId': instance.providerSessionId,
    };
