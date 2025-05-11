// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'payment_request_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#adding-getters-and-methods-to-our-models');

PaymentRequestDTO _$PaymentRequestDTOFromJson(Map<String, dynamic> json) {
  return _PaymentRequestDTO.fromJson(json);
}

/// @nodoc
mixin _$PaymentRequestDTO {
  /// The booking ID associated with this payment
  int get bookingId => throw _privateConstructorUsedError;

  /// The amount to be charged
  double get amount => throw _privateConstructorUsedError;

  /// The currency code (e.g. 'USD', 'MYR')
  String get currency => throw _privateConstructorUsedError;

  /// The payment provider (STRIPE, PAYPAL, etc.)
  PaymentProvider get provider => throw _privateConstructorUsedError;

  /// (Future field) URL to redirect user upon successful payment
  @JsonKey(includeIfNull: false)
  String? get successUrl => throw _privateConstructorUsedError;

  /// (Future field) URL to redirect user upon canceling payment
  @JsonKey(includeIfNull: false)
  String? get cancelUrl => throw _privateConstructorUsedError;

  /// Serializes this PaymentRequestDTO to a JSON map.
  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;

  /// Create a copy of PaymentRequestDTO
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  $PaymentRequestDTOCopyWith<PaymentRequestDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $PaymentRequestDTOCopyWith<$Res> {
  factory $PaymentRequestDTOCopyWith(
          PaymentRequestDTO value, $Res Function(PaymentRequestDTO) then) =
      _$PaymentRequestDTOCopyWithImpl<$Res, PaymentRequestDTO>;
  @useResult
  $Res call(
      {int bookingId,
      double amount,
      String currency,
      PaymentProvider provider,
      @JsonKey(includeIfNull: false) String? successUrl,
      @JsonKey(includeIfNull: false) String? cancelUrl});
}

/// @nodoc
class _$PaymentRequestDTOCopyWithImpl<$Res, $Val extends PaymentRequestDTO>
    implements $PaymentRequestDTOCopyWith<$Res> {
  _$PaymentRequestDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  /// Create a copy of PaymentRequestDTO
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bookingId = null,
    Object? amount = null,
    Object? currency = null,
    Object? provider = null,
    Object? successUrl = freezed,
    Object? cancelUrl = freezed,
  }) {
    return _then(_value.copyWith(
      bookingId: null == bookingId
          ? _value.bookingId
          : bookingId // ignore: cast_nullable_to_non_nullable
              as int,
      amount: null == amount
          ? _value.amount
          : amount // ignore: cast_nullable_to_non_nullable
              as double,
      currency: null == currency
          ? _value.currency
          : currency // ignore: cast_nullable_to_non_nullable
              as String,
      provider: null == provider
          ? _value.provider
          : provider // ignore: cast_nullable_to_non_nullable
              as PaymentProvider,
      successUrl: freezed == successUrl
          ? _value.successUrl
          : successUrl // ignore: cast_nullable_to_non_nullable
              as String?,
      cancelUrl: freezed == cancelUrl
          ? _value.cancelUrl
          : cancelUrl // ignore: cast_nullable_to_non_nullable
              as String?,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$PaymentRequestDTOImplCopyWith<$Res>
    implements $PaymentRequestDTOCopyWith<$Res> {
  factory _$$PaymentRequestDTOImplCopyWith(_$PaymentRequestDTOImpl value,
          $Res Function(_$PaymentRequestDTOImpl) then) =
      __$$PaymentRequestDTOImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {int bookingId,
      double amount,
      String currency,
      PaymentProvider provider,
      @JsonKey(includeIfNull: false) String? successUrl,
      @JsonKey(includeIfNull: false) String? cancelUrl});
}

/// @nodoc
class __$$PaymentRequestDTOImplCopyWithImpl<$Res>
    extends _$PaymentRequestDTOCopyWithImpl<$Res, _$PaymentRequestDTOImpl>
    implements _$$PaymentRequestDTOImplCopyWith<$Res> {
  __$$PaymentRequestDTOImplCopyWithImpl(_$PaymentRequestDTOImpl _value,
      $Res Function(_$PaymentRequestDTOImpl) _then)
      : super(_value, _then);

  /// Create a copy of PaymentRequestDTO
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bookingId = null,
    Object? amount = null,
    Object? currency = null,
    Object? provider = null,
    Object? successUrl = freezed,
    Object? cancelUrl = freezed,
  }) {
    return _then(_$PaymentRequestDTOImpl(
      bookingId: null == bookingId
          ? _value.bookingId
          : bookingId // ignore: cast_nullable_to_non_nullable
              as int,
      amount: null == amount
          ? _value.amount
          : amount // ignore: cast_nullable_to_non_nullable
              as double,
      currency: null == currency
          ? _value.currency
          : currency // ignore: cast_nullable_to_non_nullable
              as String,
      provider: null == provider
          ? _value.provider
          : provider // ignore: cast_nullable_to_non_nullable
              as PaymentProvider,
      successUrl: freezed == successUrl
          ? _value.successUrl
          : successUrl // ignore: cast_nullable_to_non_nullable
              as String?,
      cancelUrl: freezed == cancelUrl
          ? _value.cancelUrl
          : cancelUrl // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$PaymentRequestDTOImpl implements _PaymentRequestDTO {
  const _$PaymentRequestDTOImpl(
      {required this.bookingId,
      required this.amount,
      required this.currency,
      required this.provider,
      @JsonKey(includeIfNull: false) this.successUrl,
      @JsonKey(includeIfNull: false) this.cancelUrl});

  factory _$PaymentRequestDTOImpl.fromJson(Map<String, dynamic> json) =>
      _$$PaymentRequestDTOImplFromJson(json);

  /// The booking ID associated with this payment
  @override
  final int bookingId;

  /// The amount to be charged
  @override
  final double amount;

  /// The currency code (e.g. 'USD', 'MYR')
  @override
  final String currency;

  /// The payment provider (STRIPE, PAYPAL, etc.)
  @override
  final PaymentProvider provider;

  /// (Future field) URL to redirect user upon successful payment
  @override
  @JsonKey(includeIfNull: false)
  final String? successUrl;

  /// (Future field) URL to redirect user upon canceling payment
  @override
  @JsonKey(includeIfNull: false)
  final String? cancelUrl;

  @override
  String toString() {
    return 'PaymentRequestDTO(bookingId: $bookingId, amount: $amount, currency: $currency, provider: $provider, successUrl: $successUrl, cancelUrl: $cancelUrl)';
  }

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$PaymentRequestDTOImpl &&
            (identical(other.bookingId, bookingId) ||
                other.bookingId == bookingId) &&
            (identical(other.amount, amount) || other.amount == amount) &&
            (identical(other.currency, currency) ||
                other.currency == currency) &&
            (identical(other.provider, provider) ||
                other.provider == provider) &&
            (identical(other.successUrl, successUrl) ||
                other.successUrl == successUrl) &&
            (identical(other.cancelUrl, cancelUrl) ||
                other.cancelUrl == cancelUrl));
  }

  @JsonKey(includeFromJson: false, includeToJson: false)
  @override
  int get hashCode => Object.hash(runtimeType, bookingId, amount, currency,
      provider, successUrl, cancelUrl);

  /// Create a copy of PaymentRequestDTO
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @override
  @pragma('vm:prefer-inline')
  _$$PaymentRequestDTOImplCopyWith<_$PaymentRequestDTOImpl> get copyWith =>
      __$$PaymentRequestDTOImplCopyWithImpl<_$PaymentRequestDTOImpl>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$PaymentRequestDTOImplToJson(
      this,
    );
  }
}

abstract class _PaymentRequestDTO implements PaymentRequestDTO {
  const factory _PaymentRequestDTO(
          {required final int bookingId,
          required final double amount,
          required final String currency,
          required final PaymentProvider provider,
          @JsonKey(includeIfNull: false) final String? successUrl,
          @JsonKey(includeIfNull: false) final String? cancelUrl}) =
      _$PaymentRequestDTOImpl;

  factory _PaymentRequestDTO.fromJson(Map<String, dynamic> json) =
      _$PaymentRequestDTOImpl.fromJson;

  /// The booking ID associated with this payment
  @override
  int get bookingId;

  /// The amount to be charged
  @override
  double get amount;

  /// The currency code (e.g. 'USD', 'MYR')
  @override
  String get currency;

  /// The payment provider (STRIPE, PAYPAL, etc.)
  @override
  PaymentProvider get provider;

  /// (Future field) URL to redirect user upon successful payment
  @override
  @JsonKey(includeIfNull: false)
  String? get successUrl;

  /// (Future field) URL to redirect user upon canceling payment
  @override
  @JsonKey(includeIfNull: false)
  String? get cancelUrl;

  /// Create a copy of PaymentRequestDTO
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  _$$PaymentRequestDTOImplCopyWith<_$PaymentRequestDTOImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
