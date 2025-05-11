// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'payment_response_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#adding-getters-and-methods-to-our-models');

PaymentResponseDTO _$PaymentResponseDTOFromJson(Map<String, dynamic> json) {
  return _PaymentResponseDTO.fromJson(json);
}

/// @nodoc
mixin _$PaymentResponseDTO {
  /// The booking ID linked to this payment
  int get bookingId => throw _privateConstructorUsedError;

  /// URL to load for payment checkout
  String get checkoutUrl => throw _privateConstructorUsedError;

  /// Expiration time for the checkout session (nullable)
  DateTime? get expiresAt => throw _privateConstructorUsedError;

  /// Provider session identifier
  String get providerSessionId => throw _privateConstructorUsedError;

  /// Serializes this PaymentResponseDTO to a JSON map.
  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;

  /// Create a copy of PaymentResponseDTO
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  $PaymentResponseDTOCopyWith<PaymentResponseDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $PaymentResponseDTOCopyWith<$Res> {
  factory $PaymentResponseDTOCopyWith(
          PaymentResponseDTO value, $Res Function(PaymentResponseDTO) then) =
      _$PaymentResponseDTOCopyWithImpl<$Res, PaymentResponseDTO>;
  @useResult
  $Res call(
      {int bookingId,
      String checkoutUrl,
      DateTime? expiresAt,
      String providerSessionId});
}

/// @nodoc
class _$PaymentResponseDTOCopyWithImpl<$Res, $Val extends PaymentResponseDTO>
    implements $PaymentResponseDTOCopyWith<$Res> {
  _$PaymentResponseDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  /// Create a copy of PaymentResponseDTO
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bookingId = null,
    Object? checkoutUrl = null,
    Object? expiresAt = freezed,
    Object? providerSessionId = null,
  }) {
    return _then(_value.copyWith(
      bookingId: null == bookingId
          ? _value.bookingId
          : bookingId // ignore: cast_nullable_to_non_nullable
              as int,
      checkoutUrl: null == checkoutUrl
          ? _value.checkoutUrl
          : checkoutUrl // ignore: cast_nullable_to_non_nullable
              as String,
      expiresAt: freezed == expiresAt
          ? _value.expiresAt
          : expiresAt // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      providerSessionId: null == providerSessionId
          ? _value.providerSessionId
          : providerSessionId // ignore: cast_nullable_to_non_nullable
              as String,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$PaymentResponseDTOImplCopyWith<$Res>
    implements $PaymentResponseDTOCopyWith<$Res> {
  factory _$$PaymentResponseDTOImplCopyWith(_$PaymentResponseDTOImpl value,
          $Res Function(_$PaymentResponseDTOImpl) then) =
      __$$PaymentResponseDTOImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {int bookingId,
      String checkoutUrl,
      DateTime? expiresAt,
      String providerSessionId});
}

/// @nodoc
class __$$PaymentResponseDTOImplCopyWithImpl<$Res>
    extends _$PaymentResponseDTOCopyWithImpl<$Res, _$PaymentResponseDTOImpl>
    implements _$$PaymentResponseDTOImplCopyWith<$Res> {
  __$$PaymentResponseDTOImplCopyWithImpl(_$PaymentResponseDTOImpl _value,
      $Res Function(_$PaymentResponseDTOImpl) _then)
      : super(_value, _then);

  /// Create a copy of PaymentResponseDTO
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? bookingId = null,
    Object? checkoutUrl = null,
    Object? expiresAt = freezed,
    Object? providerSessionId = null,
  }) {
    return _then(_$PaymentResponseDTOImpl(
      bookingId: null == bookingId
          ? _value.bookingId
          : bookingId // ignore: cast_nullable_to_non_nullable
              as int,
      checkoutUrl: null == checkoutUrl
          ? _value.checkoutUrl
          : checkoutUrl // ignore: cast_nullable_to_non_nullable
              as String,
      expiresAt: freezed == expiresAt
          ? _value.expiresAt
          : expiresAt // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      providerSessionId: null == providerSessionId
          ? _value.providerSessionId
          : providerSessionId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$PaymentResponseDTOImpl implements _PaymentResponseDTO {
  const _$PaymentResponseDTOImpl(
      {required this.bookingId,
      required this.checkoutUrl,
      this.expiresAt,
      required this.providerSessionId});

  factory _$PaymentResponseDTOImpl.fromJson(Map<String, dynamic> json) =>
      _$$PaymentResponseDTOImplFromJson(json);

  /// The booking ID linked to this payment
  @override
  final int bookingId;

  /// URL to load for payment checkout
  @override
  final String checkoutUrl;

  /// Expiration time for the checkout session (nullable)
  @override
  final DateTime? expiresAt;

  /// Provider session identifier
  @override
  final String providerSessionId;

  @override
  String toString() {
    return 'PaymentResponseDTO(bookingId: $bookingId, checkoutUrl: $checkoutUrl, expiresAt: $expiresAt, providerSessionId: $providerSessionId)';
  }

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$PaymentResponseDTOImpl &&
            (identical(other.bookingId, bookingId) ||
                other.bookingId == bookingId) &&
            (identical(other.checkoutUrl, checkoutUrl) ||
                other.checkoutUrl == checkoutUrl) &&
            (identical(other.expiresAt, expiresAt) ||
                other.expiresAt == expiresAt) &&
            (identical(other.providerSessionId, providerSessionId) ||
                other.providerSessionId == providerSessionId));
  }

  @JsonKey(includeFromJson: false, includeToJson: false)
  @override
  int get hashCode => Object.hash(
      runtimeType, bookingId, checkoutUrl, expiresAt, providerSessionId);

  /// Create a copy of PaymentResponseDTO
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @override
  @pragma('vm:prefer-inline')
  _$$PaymentResponseDTOImplCopyWith<_$PaymentResponseDTOImpl> get copyWith =>
      __$$PaymentResponseDTOImplCopyWithImpl<_$PaymentResponseDTOImpl>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$PaymentResponseDTOImplToJson(
      this,
    );
  }
}

abstract class _PaymentResponseDTO implements PaymentResponseDTO {
  const factory _PaymentResponseDTO(
      {required final int bookingId,
      required final String checkoutUrl,
      final DateTime? expiresAt,
      required final String providerSessionId}) = _$PaymentResponseDTOImpl;

  factory _PaymentResponseDTO.fromJson(Map<String, dynamic> json) =
      _$PaymentResponseDTOImpl.fromJson;

  /// The booking ID linked to this payment
  @override
  int get bookingId;

  /// URL to load for payment checkout
  @override
  String get checkoutUrl;

  /// Expiration time for the checkout session (nullable)
  @override
  DateTime? get expiresAt;

  /// Provider session identifier
  @override
  String get providerSessionId;

  /// Create a copy of PaymentResponseDTO
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  _$$PaymentResponseDTOImplCopyWith<_$PaymentResponseDTOImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
