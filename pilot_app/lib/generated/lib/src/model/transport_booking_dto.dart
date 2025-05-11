//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'transport_booking_dto.g.dart';

/// TransportBookingDTO
///
/// Properties:
/// * [id] 
/// * [userId] 
/// * [pickupAddress] 
/// * [dropoffAddress] 
/// * [scheduledAt] 
/// * [price] 
@BuiltValue()
abstract class TransportBookingDTO implements Built<TransportBookingDTO, TransportBookingDTOBuilder> {
  @BuiltValueField(wireName: r'id')
  int? get id;

  @BuiltValueField(wireName: r'userId')
  int get userId;

  @BuiltValueField(wireName: r'pickupAddress')
  String get pickupAddress;

  @BuiltValueField(wireName: r'dropoffAddress')
  String get dropoffAddress;

  @BuiltValueField(wireName: r'scheduledAt')
  DateTime get scheduledAt;

  @BuiltValueField(wireName: r'price')
  double get price;

  TransportBookingDTO._();

  factory TransportBookingDTO([void updates(TransportBookingDTOBuilder b)]) = _$TransportBookingDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(TransportBookingDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<TransportBookingDTO> get serializer => _$TransportBookingDTOSerializer();
}

class _$TransportBookingDTOSerializer implements PrimitiveSerializer<TransportBookingDTO> {
  @override
  final Iterable<Type> types = const [TransportBookingDTO, _$TransportBookingDTO];

  @override
  final String wireName = r'TransportBookingDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    TransportBookingDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    if (object.id != null) {
      yield r'id';
      yield serializers.serialize(
        object.id,
        specifiedType: const FullType(int),
      );
    }
    yield r'userId';
    yield serializers.serialize(
      object.userId,
      specifiedType: const FullType(int),
    );
    yield r'pickupAddress';
    yield serializers.serialize(
      object.pickupAddress,
      specifiedType: const FullType(String),
    );
    yield r'dropoffAddress';
    yield serializers.serialize(
      object.dropoffAddress,
      specifiedType: const FullType(String),
    );
    yield r'scheduledAt';
    yield serializers.serialize(
      object.scheduledAt,
      specifiedType: const FullType(DateTime),
    );
    yield r'price';
    yield serializers.serialize(
      object.price,
      specifiedType: const FullType(double),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    TransportBookingDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required TransportBookingDTOBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'id':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.id = valueDes;
          break;
        case r'userId':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.userId = valueDes;
          break;
        case r'pickupAddress':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.pickupAddress = valueDes;
          break;
        case r'dropoffAddress':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.dropoffAddress = valueDes;
          break;
        case r'scheduledAt':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(DateTime),
          ) as DateTime;
          result.scheduledAt = valueDes;
          break;
        case r'price':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(double),
          ) as double;
          result.price = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  TransportBookingDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = TransportBookingDTOBuilder();
    final serializedList = (serialized as Iterable<Object?>).toList();
    final unhandled = <Object?>[];
    _deserializeProperties(
      serializers,
      serialized,
      specifiedType: specifiedType,
      serializedList: serializedList,
      unhandled: unhandled,
      result: result,
    );
    return result.build();
  }
}

