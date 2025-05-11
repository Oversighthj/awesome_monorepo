// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'transport_booking_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$TransportBookingDTO extends TransportBookingDTO {
  @override
  final int? id;
  @override
  final int userId;
  @override
  final String pickupAddress;
  @override
  final String dropoffAddress;
  @override
  final DateTime scheduledAt;
  @override
  final double price;

  factory _$TransportBookingDTO(
          [void Function(TransportBookingDTOBuilder)? updates]) =>
      (new TransportBookingDTOBuilder()..update(updates))._build();

  _$TransportBookingDTO._(
      {this.id,
      required this.userId,
      required this.pickupAddress,
      required this.dropoffAddress,
      required this.scheduledAt,
      required this.price})
      : super._() {
    BuiltValueNullFieldError.checkNotNull(
        userId, r'TransportBookingDTO', 'userId');
    BuiltValueNullFieldError.checkNotNull(
        pickupAddress, r'TransportBookingDTO', 'pickupAddress');
    BuiltValueNullFieldError.checkNotNull(
        dropoffAddress, r'TransportBookingDTO', 'dropoffAddress');
    BuiltValueNullFieldError.checkNotNull(
        scheduledAt, r'TransportBookingDTO', 'scheduledAt');
    BuiltValueNullFieldError.checkNotNull(
        price, r'TransportBookingDTO', 'price');
  }

  @override
  TransportBookingDTO rebuild(
          void Function(TransportBookingDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  TransportBookingDTOBuilder toBuilder() =>
      new TransportBookingDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is TransportBookingDTO &&
        id == other.id &&
        userId == other.userId &&
        pickupAddress == other.pickupAddress &&
        dropoffAddress == other.dropoffAddress &&
        scheduledAt == other.scheduledAt &&
        price == other.price;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, userId.hashCode);
    _$hash = $jc(_$hash, pickupAddress.hashCode);
    _$hash = $jc(_$hash, dropoffAddress.hashCode);
    _$hash = $jc(_$hash, scheduledAt.hashCode);
    _$hash = $jc(_$hash, price.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'TransportBookingDTO')
          ..add('id', id)
          ..add('userId', userId)
          ..add('pickupAddress', pickupAddress)
          ..add('dropoffAddress', dropoffAddress)
          ..add('scheduledAt', scheduledAt)
          ..add('price', price))
        .toString();
  }
}

class TransportBookingDTOBuilder
    implements Builder<TransportBookingDTO, TransportBookingDTOBuilder> {
  _$TransportBookingDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  int? _userId;
  int? get userId => _$this._userId;
  set userId(int? userId) => _$this._userId = userId;

  String? _pickupAddress;
  String? get pickupAddress => _$this._pickupAddress;
  set pickupAddress(String? pickupAddress) =>
      _$this._pickupAddress = pickupAddress;

  String? _dropoffAddress;
  String? get dropoffAddress => _$this._dropoffAddress;
  set dropoffAddress(String? dropoffAddress) =>
      _$this._dropoffAddress = dropoffAddress;

  DateTime? _scheduledAt;
  DateTime? get scheduledAt => _$this._scheduledAt;
  set scheduledAt(DateTime? scheduledAt) => _$this._scheduledAt = scheduledAt;

  double? _price;
  double? get price => _$this._price;
  set price(double? price) => _$this._price = price;

  TransportBookingDTOBuilder() {
    TransportBookingDTO._defaults(this);
  }

  TransportBookingDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _userId = $v.userId;
      _pickupAddress = $v.pickupAddress;
      _dropoffAddress = $v.dropoffAddress;
      _scheduledAt = $v.scheduledAt;
      _price = $v.price;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(TransportBookingDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$TransportBookingDTO;
  }

  @override
  void update(void Function(TransportBookingDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  TransportBookingDTO build() => _build();

  _$TransportBookingDTO _build() {
    final _$result = _$v ??
        new _$TransportBookingDTO._(
          id: id,
          userId: BuiltValueNullFieldError.checkNotNull(
              userId, r'TransportBookingDTO', 'userId'),
          pickupAddress: BuiltValueNullFieldError.checkNotNull(
              pickupAddress, r'TransportBookingDTO', 'pickupAddress'),
          dropoffAddress: BuiltValueNullFieldError.checkNotNull(
              dropoffAddress, r'TransportBookingDTO', 'dropoffAddress'),
          scheduledAt: BuiltValueNullFieldError.checkNotNull(
              scheduledAt, r'TransportBookingDTO', 'scheduledAt'),
          price: BuiltValueNullFieldError.checkNotNull(
              price, r'TransportBookingDTO', 'price'),
        );
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
