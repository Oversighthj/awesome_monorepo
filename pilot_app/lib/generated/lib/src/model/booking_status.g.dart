// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'booking_status.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

const BookingStatus _$PENDING = const BookingStatus._('PENDING');
const BookingStatus _$CONFIRMED = const BookingStatus._('CONFIRMED');
const BookingStatus _$CANCELLED = const BookingStatus._('CANCELLED');
const BookingStatus _$PAID = const BookingStatus._('PAID');
const BookingStatus _$EXPIRED = const BookingStatus._('EXPIRED');

BookingStatus _$valueOf(String name) {
  switch (name) {
    case 'PENDING':
      return _$PENDING;
    case 'CONFIRMED':
      return _$CONFIRMED;
    case 'CANCELLED':
      return _$CANCELLED;
    case 'PAID':
      return _$PAID;
    case 'EXPIRED':
      return _$EXPIRED;
    default:
      throw new ArgumentError(name);
  }
}

final BuiltSet<BookingStatus> _$values =
    new BuiltSet<BookingStatus>(const <BookingStatus>[
  _$PENDING,
  _$CONFIRMED,
  _$CANCELLED,
  _$PAID,
  _$EXPIRED,
]);

class _$BookingStatusMeta {
  const _$BookingStatusMeta();
  BookingStatus get PENDING => _$PENDING;
  BookingStatus get CONFIRMED => _$CONFIRMED;
  BookingStatus get CANCELLED => _$CANCELLED;
  BookingStatus get PAID => _$PAID;
  BookingStatus get EXPIRED => _$EXPIRED;
  BookingStatus valueOf(String name) => _$valueOf(name);
  BuiltSet<BookingStatus> get values => _$values;
}

mixin _$BookingStatusMixin {
  // ignore: non_constant_identifier_names
  _$BookingStatusMeta get BookingStatus => const _$BookingStatusMeta();
}

Serializer<BookingStatus> _$bookingStatusSerializer =
    new _$BookingStatusSerializer();

class _$BookingStatusSerializer implements PrimitiveSerializer<BookingStatus> {
  static const Map<String, Object> _toWire = const <String, Object>{
    'PENDING': 'PENDING',
    'CONFIRMED': 'CONFIRMED',
    'CANCELLED': 'CANCELLED',
    'PAID': 'PAID',
    'EXPIRED': 'EXPIRED',
  };
  static const Map<Object, String> _fromWire = const <Object, String>{
    'PENDING': 'PENDING',
    'CONFIRMED': 'CONFIRMED',
    'CANCELLED': 'CANCELLED',
    'PAID': 'PAID',
    'EXPIRED': 'EXPIRED',
  };

  @override
  final Iterable<Type> types = const <Type>[BookingStatus];
  @override
  final String wireName = 'BookingStatus';

  @override
  Object serialize(Serializers serializers, BookingStatus object,
          {FullType specifiedType = FullType.unspecified}) =>
      _toWire[object.name] ?? object.name;

  @override
  BookingStatus deserialize(Serializers serializers, Object serialized,
          {FullType specifiedType = FullType.unspecified}) =>
      BookingStatus.valueOf(
          _fromWire[serialized] ?? (serialized is String ? serialized : ''));
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
