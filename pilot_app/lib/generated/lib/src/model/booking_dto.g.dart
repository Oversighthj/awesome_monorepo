// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'booking_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$BookingDTO extends BookingDTO {
  @override
  final int? id;
  @override
  final int userId;
  @override
  final int resourceId;
  @override
  final DateTime startTime;
  @override
  final DateTime endTime;
  @override
  final double totalPrice;
  @override
  final BookingStatus? status;
  @override
  final DateTime? createdAt;
  @override
  final DateTime? updatedAt;

  factory _$BookingDTO([void Function(BookingDTOBuilder)? updates]) =>
      (new BookingDTOBuilder()..update(updates))._build();

  _$BookingDTO._(
      {this.id,
      required this.userId,
      required this.resourceId,
      required this.startTime,
      required this.endTime,
      required this.totalPrice,
      this.status,
      this.createdAt,
      this.updatedAt})
      : super._() {
    BuiltValueNullFieldError.checkNotNull(userId, r'BookingDTO', 'userId');
    BuiltValueNullFieldError.checkNotNull(
        resourceId, r'BookingDTO', 'resourceId');
    BuiltValueNullFieldError.checkNotNull(
        startTime, r'BookingDTO', 'startTime');
    BuiltValueNullFieldError.checkNotNull(endTime, r'BookingDTO', 'endTime');
    BuiltValueNullFieldError.checkNotNull(
        totalPrice, r'BookingDTO', 'totalPrice');
  }

  @override
  BookingDTO rebuild(void Function(BookingDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  BookingDTOBuilder toBuilder() => new BookingDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is BookingDTO &&
        id == other.id &&
        userId == other.userId &&
        resourceId == other.resourceId &&
        startTime == other.startTime &&
        endTime == other.endTime &&
        totalPrice == other.totalPrice &&
        status == other.status &&
        createdAt == other.createdAt &&
        updatedAt == other.updatedAt;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, id.hashCode);
    _$hash = $jc(_$hash, userId.hashCode);
    _$hash = $jc(_$hash, resourceId.hashCode);
    _$hash = $jc(_$hash, startTime.hashCode);
    _$hash = $jc(_$hash, endTime.hashCode);
    _$hash = $jc(_$hash, totalPrice.hashCode);
    _$hash = $jc(_$hash, status.hashCode);
    _$hash = $jc(_$hash, createdAt.hashCode);
    _$hash = $jc(_$hash, updatedAt.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'BookingDTO')
          ..add('id', id)
          ..add('userId', userId)
          ..add('resourceId', resourceId)
          ..add('startTime', startTime)
          ..add('endTime', endTime)
          ..add('totalPrice', totalPrice)
          ..add('status', status)
          ..add('createdAt', createdAt)
          ..add('updatedAt', updatedAt))
        .toString();
  }
}

class BookingDTOBuilder implements Builder<BookingDTO, BookingDTOBuilder> {
  _$BookingDTO? _$v;

  int? _id;
  int? get id => _$this._id;
  set id(int? id) => _$this._id = id;

  int? _userId;
  int? get userId => _$this._userId;
  set userId(int? userId) => _$this._userId = userId;

  int? _resourceId;
  int? get resourceId => _$this._resourceId;
  set resourceId(int? resourceId) => _$this._resourceId = resourceId;

  DateTime? _startTime;
  DateTime? get startTime => _$this._startTime;
  set startTime(DateTime? startTime) => _$this._startTime = startTime;

  DateTime? _endTime;
  DateTime? get endTime => _$this._endTime;
  set endTime(DateTime? endTime) => _$this._endTime = endTime;

  double? _totalPrice;
  double? get totalPrice => _$this._totalPrice;
  set totalPrice(double? totalPrice) => _$this._totalPrice = totalPrice;

  BookingStatus? _status;
  BookingStatus? get status => _$this._status;
  set status(BookingStatus? status) => _$this._status = status;

  DateTime? _createdAt;
  DateTime? get createdAt => _$this._createdAt;
  set createdAt(DateTime? createdAt) => _$this._createdAt = createdAt;

  DateTime? _updatedAt;
  DateTime? get updatedAt => _$this._updatedAt;
  set updatedAt(DateTime? updatedAt) => _$this._updatedAt = updatedAt;

  BookingDTOBuilder() {
    BookingDTO._defaults(this);
  }

  BookingDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _id = $v.id;
      _userId = $v.userId;
      _resourceId = $v.resourceId;
      _startTime = $v.startTime;
      _endTime = $v.endTime;
      _totalPrice = $v.totalPrice;
      _status = $v.status;
      _createdAt = $v.createdAt;
      _updatedAt = $v.updatedAt;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(BookingDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$BookingDTO;
  }

  @override
  void update(void Function(BookingDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  BookingDTO build() => _build();

  _$BookingDTO _build() {
    final _$result = _$v ??
        new _$BookingDTO._(
          id: id,
          userId: BuiltValueNullFieldError.checkNotNull(
              userId, r'BookingDTO', 'userId'),
          resourceId: BuiltValueNullFieldError.checkNotNull(
              resourceId, r'BookingDTO', 'resourceId'),
          startTime: BuiltValueNullFieldError.checkNotNull(
              startTime, r'BookingDTO', 'startTime'),
          endTime: BuiltValueNullFieldError.checkNotNull(
              endTime, r'BookingDTO', 'endTime'),
          totalPrice: BuiltValueNullFieldError.checkNotNull(
              totalPrice, r'BookingDTO', 'totalPrice'),
          status: status,
          createdAt: createdAt,
          updatedAt: updatedAt,
        );
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
