//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'payment_response_dto.g.dart';

/// PaymentResponseDTO
///
/// Properties:
/// * [checkoutUrl] 
/// * [expiresAt] 
/// * [providerSessionId] 
@BuiltValue()
abstract class PaymentResponseDTO implements Built<PaymentResponseDTO, PaymentResponseDTOBuilder> {
  @BuiltValueField(wireName: r'checkoutUrl')
  String get checkoutUrl;

  @BuiltValueField(wireName: r'expiresAt')
  DateTime? get expiresAt;

  @BuiltValueField(wireName: r'providerSessionId')
  String get providerSessionId;

  PaymentResponseDTO._();

  factory PaymentResponseDTO([void updates(PaymentResponseDTOBuilder b)]) = _$PaymentResponseDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(PaymentResponseDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<PaymentResponseDTO> get serializer => _$PaymentResponseDTOSerializer();
}

class _$PaymentResponseDTOSerializer implements PrimitiveSerializer<PaymentResponseDTO> {
  @override
  final Iterable<Type> types = const [PaymentResponseDTO, _$PaymentResponseDTO];

  @override
  final String wireName = r'PaymentResponseDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    PaymentResponseDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'checkoutUrl';
    yield serializers.serialize(
      object.checkoutUrl,
      specifiedType: const FullType(String),
    );
    if (object.expiresAt != null) {
      yield r'expiresAt';
      yield serializers.serialize(
        object.expiresAt,
        specifiedType: const FullType(DateTime),
      );
    }
    yield r'providerSessionId';
    yield serializers.serialize(
      object.providerSessionId,
      specifiedType: const FullType(String),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    PaymentResponseDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required PaymentResponseDTOBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'checkoutUrl':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.checkoutUrl = valueDes;
          break;
        case r'expiresAt':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(DateTime),
          ) as DateTime;
          result.expiresAt = valueDes;
          break;
        case r'providerSessionId':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.providerSessionId = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  PaymentResponseDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = PaymentResponseDTOBuilder();
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

