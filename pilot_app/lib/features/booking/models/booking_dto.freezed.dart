// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'booking_dto.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#adding-getters-and-methods-to-our-models');

BookingDTO _$BookingDTOFromJson(Map<String, dynamic> json) {
  return _BookingDTO.fromJson(json);
}

/// @nodoc
mixin _$BookingDTO {
  /// ID of the booking (read-only, assigned by backend)
  int? get id => throw _privateConstructorUsedError;

  /// ID of the user who created the booking
  int get userId => throw _privateConstructorUsedError;

  /// ID of the resource being booked
  int get resourceId => throw _privateConstructorUsedError;

  /// Start time of the booking
  DateTime get startTime => throw _privateConstructorUsedError;

  /// End time of the booking
  DateTime get endTime => throw _privateConstructorUsedError;

  /// Total price for the booking
  double get totalPrice => throw _privateConstructorUsedError;

  /// Booking status
  BookingStatus get status => throw _privateConstructorUsedError;

  /// When the booking was created (read-only)
  DateTime? get createdAt => throw _privateConstructorUsedError;

  /// When the booking was last updated (read-only)
  DateTime? get updatedAt => throw _privateConstructorUsedError;

  /// Serializes this BookingDTO to a JSON map.
  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;

  /// Create a copy of BookingDTO
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  $BookingDTOCopyWith<BookingDTO> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $BookingDTOCopyWith<$Res> {
  factory $BookingDTOCopyWith(
          BookingDTO value, $Res Function(BookingDTO) then) =
      _$BookingDTOCopyWithImpl<$Res, BookingDTO>;
  @useResult
  $Res call(
      {int? id,
      int userId,
      int resourceId,
      DateTime startTime,
      DateTime endTime,
      double totalPrice,
      BookingStatus status,
      DateTime? createdAt,
      DateTime? updatedAt});
}

/// @nodoc
class _$BookingDTOCopyWithImpl<$Res, $Val extends BookingDTO>
    implements $BookingDTOCopyWith<$Res> {
  _$BookingDTOCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  /// Create a copy of BookingDTO
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? userId = null,
    Object? resourceId = null,
    Object? startTime = null,
    Object? endTime = null,
    Object? totalPrice = null,
    Object? status = null,
    Object? createdAt = freezed,
    Object? updatedAt = freezed,
  }) {
    return _then(_value.copyWith(
      id: freezed == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: null == userId
          ? _value.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as int,
      resourceId: null == resourceId
          ? _value.resourceId
          : resourceId // ignore: cast_nullable_to_non_nullable
              as int,
      startTime: null == startTime
          ? _value.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as DateTime,
      endTime: null == endTime
          ? _value.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as DateTime,
      totalPrice: null == totalPrice
          ? _value.totalPrice
          : totalPrice // ignore: cast_nullable_to_non_nullable
              as double,
      status: null == status
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as BookingStatus,
      createdAt: freezed == createdAt
          ? _value.createdAt
          : createdAt // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      updatedAt: freezed == updatedAt
          ? _value.updatedAt
          : updatedAt // ignore: cast_nullable_to_non_nullable
              as DateTime?,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$BookingDTOImplCopyWith<$Res>
    implements $BookingDTOCopyWith<$Res> {
  factory _$$BookingDTOImplCopyWith(
          _$BookingDTOImpl value, $Res Function(_$BookingDTOImpl) then) =
      __$$BookingDTOImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {int? id,
      int userId,
      int resourceId,
      DateTime startTime,
      DateTime endTime,
      double totalPrice,
      BookingStatus status,
      DateTime? createdAt,
      DateTime? updatedAt});
}

/// @nodoc
class __$$BookingDTOImplCopyWithImpl<$Res>
    extends _$BookingDTOCopyWithImpl<$Res, _$BookingDTOImpl>
    implements _$$BookingDTOImplCopyWith<$Res> {
  __$$BookingDTOImplCopyWithImpl(
      _$BookingDTOImpl _value, $Res Function(_$BookingDTOImpl) _then)
      : super(_value, _then);

  /// Create a copy of BookingDTO
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? userId = null,
    Object? resourceId = null,
    Object? startTime = null,
    Object? endTime = null,
    Object? totalPrice = null,
    Object? status = null,
    Object? createdAt = freezed,
    Object? updatedAt = freezed,
  }) {
    return _then(_$BookingDTOImpl(
      id: freezed == id
          ? _value.id
          : id // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: null == userId
          ? _value.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as int,
      resourceId: null == resourceId
          ? _value.resourceId
          : resourceId // ignore: cast_nullable_to_non_nullable
              as int,
      startTime: null == startTime
          ? _value.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as DateTime,
      endTime: null == endTime
          ? _value.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as DateTime,
      totalPrice: null == totalPrice
          ? _value.totalPrice
          : totalPrice // ignore: cast_nullable_to_non_nullable
              as double,
      status: null == status
          ? _value.status
          : status // ignore: cast_nullable_to_non_nullable
              as BookingStatus,
      createdAt: freezed == createdAt
          ? _value.createdAt
          : createdAt // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      updatedAt: freezed == updatedAt
          ? _value.updatedAt
          : updatedAt // ignore: cast_nullable_to_non_nullable
              as DateTime?,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$BookingDTOImpl implements _BookingDTO {
  const _$BookingDTOImpl(
      {this.id,
      required this.userId,
      required this.resourceId,
      required this.startTime,
      required this.endTime,
      required this.totalPrice,
      required this.status,
      this.createdAt,
      this.updatedAt});

  factory _$BookingDTOImpl.fromJson(Map<String, dynamic> json) =>
      _$$BookingDTOImplFromJson(json);

  /// ID of the booking (read-only, assigned by backend)
  @override
  final int? id;

  /// ID of the user who created the booking
  @override
  final int userId;

  /// ID of the resource being booked
  @override
  final int resourceId;

  /// Start time of the booking
  @override
  final DateTime startTime;

  /// End time of the booking
  @override
  final DateTime endTime;

  /// Total price for the booking
  @override
  final double totalPrice;

  /// Booking status
  @override
  final BookingStatus status;

  /// When the booking was created (read-only)
  @override
  final DateTime? createdAt;

  /// When the booking was last updated (read-only)
  @override
  final DateTime? updatedAt;

  @override
  String toString() {
    return 'BookingDTO(id: $id, userId: $userId, resourceId: $resourceId, startTime: $startTime, endTime: $endTime, totalPrice: $totalPrice, status: $status, createdAt: $createdAt, updatedAt: $updatedAt)';
  }

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$BookingDTOImpl &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.resourceId, resourceId) ||
                other.resourceId == resourceId) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            (identical(other.totalPrice, totalPrice) ||
                other.totalPrice == totalPrice) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.createdAt, createdAt) ||
                other.createdAt == createdAt) &&
            (identical(other.updatedAt, updatedAt) ||
                other.updatedAt == updatedAt));
  }

  @JsonKey(includeFromJson: false, includeToJson: false)
  @override
  int get hashCode => Object.hash(runtimeType, id, userId, resourceId,
      startTime, endTime, totalPrice, status, createdAt, updatedAt);

  /// Create a copy of BookingDTO
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @override
  @pragma('vm:prefer-inline')
  _$$BookingDTOImplCopyWith<_$BookingDTOImpl> get copyWith =>
      __$$BookingDTOImplCopyWithImpl<_$BookingDTOImpl>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$BookingDTOImplToJson(
      this,
    );
  }
}

abstract class _BookingDTO implements BookingDTO {
  const factory _BookingDTO(
      {final int? id,
      required final int userId,
      required final int resourceId,
      required final DateTime startTime,
      required final DateTime endTime,
      required final double totalPrice,
      required final BookingStatus status,
      final DateTime? createdAt,
      final DateTime? updatedAt}) = _$BookingDTOImpl;

  factory _BookingDTO.fromJson(Map<String, dynamic> json) =
      _$BookingDTOImpl.fromJson;

  /// ID of the booking (read-only, assigned by backend)
  @override
  int? get id;

  /// ID of the user who created the booking
  @override
  int get userId;

  /// ID of the resource being booked
  @override
  int get resourceId;

  /// Start time of the booking
  @override
  DateTime get startTime;

  /// End time of the booking
  @override
  DateTime get endTime;

  /// Total price for the booking
  @override
  double get totalPrice;

  /// Booking status
  @override
  BookingStatus get status;

  /// When the booking was created (read-only)
  @override
  DateTime? get createdAt;

  /// When the booking was last updated (read-only)
  @override
  DateTime? get updatedAt;

  /// Create a copy of BookingDTO
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  _$$BookingDTOImplCopyWith<_$BookingDTOImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
