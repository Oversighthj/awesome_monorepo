// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'payment_request_dto.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$PaymentRequestDTOImpl _$$PaymentRequestDTOImplFromJson(
        Map<String, dynamic> json) =>
    _$PaymentRequestDTOImpl(
      bookingId: (json['bookingId'] as num).toInt(),
      amount: (json['amount'] as num).toDouble(),
      currency: json['currency'] as String,
      provider: $enumDecode(_$PaymentProviderEnumMap, json['provider']),
      successUrl: json['successUrl'] as String?,
      cancelUrl: json['cancelUrl'] as String?,
    );

Map<String, dynamic> _$$PaymentRequestDTOImplToJson(
        _$PaymentRequestDTOImpl instance) =>
    <String, dynamic>{
      'bookingId': instance.bookingId,
      'amount': instance.amount,
      'currency': instance.currency,
      'provider': _$PaymentProviderEnumMap[instance.provider]!,
      if (instance.successUrl case final value?) 'successUrl': value,
      if (instance.cancelUrl case final value?) 'cancelUrl': value,
    };

const _$PaymentProviderEnumMap = {
  PaymentProvider.stripe: 'STRIPE',
  PaymentProvider.paypal: 'PAYPAL',
};
