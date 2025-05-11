//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//

// ignore_for_file: unused_element
import 'package:built_collection/built_collection.dart';
import 'package:built_value/built_value.dart';
import 'package:built_value/serializer.dart';

part 'payment_request_dto.g.dart';

/// PaymentRequestDTO
///
/// Properties:
/// * [bookingId] 
/// * [amount] 
/// * [currency] 
/// * [provider] 
@BuiltValue()
abstract class PaymentRequestDTO implements Built<PaymentRequestDTO, PaymentRequestDTOBuilder> {
  @BuiltValueField(wireName: r'bookingId')
  int get bookingId;

  @BuiltValueField(wireName: r'amount')
  double get amount;

  @BuiltValueField(wireName: r'currency')
  String get currency;

  @BuiltValueField(wireName: r'provider')
  PaymentRequestDTOProviderEnum get provider;
  // enum providerEnum {  STRIPE,  PAYPAL,  };

  PaymentRequestDTO._();

  factory PaymentRequestDTO([void updates(PaymentRequestDTOBuilder b)]) = _$PaymentRequestDTO;

  @BuiltValueHook(initializeBuilder: true)
  static void _defaults(PaymentRequestDTOBuilder b) => b;

  @BuiltValueSerializer(custom: true)
  static Serializer<PaymentRequestDTO> get serializer => _$PaymentRequestDTOSerializer();
}

class _$PaymentRequestDTOSerializer implements PrimitiveSerializer<PaymentRequestDTO> {
  @override
  final Iterable<Type> types = const [PaymentRequestDTO, _$PaymentRequestDTO];

  @override
  final String wireName = r'PaymentRequestDTO';

  Iterable<Object?> _serializeProperties(
    Serializers serializers,
    PaymentRequestDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) sync* {
    yield r'bookingId';
    yield serializers.serialize(
      object.bookingId,
      specifiedType: const FullType(int),
    );
    yield r'amount';
    yield serializers.serialize(
      object.amount,
      specifiedType: const FullType(double),
    );
    yield r'currency';
    yield serializers.serialize(
      object.currency,
      specifiedType: const FullType(String),
    );
    yield r'provider';
    yield serializers.serialize(
      object.provider,
      specifiedType: const FullType(PaymentRequestDTOProviderEnum),
    );
  }

  @override
  Object serialize(
    Serializers serializers,
    PaymentRequestDTO object, {
    FullType specifiedType = FullType.unspecified,
  }) {
    return _serializeProperties(serializers, object, specifiedType: specifiedType).toList();
  }

  void _deserializeProperties(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
    required List<Object?> serializedList,
    required PaymentRequestDTOBuilder result,
    required List<Object?> unhandled,
  }) {
    for (var i = 0; i < serializedList.length; i += 2) {
      final key = serializedList[i] as String;
      final value = serializedList[i + 1];
      switch (key) {
        case r'bookingId':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(int),
          ) as int;
          result.bookingId = valueDes;
          break;
        case r'amount':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(double),
          ) as double;
          result.amount = valueDes;
          break;
        case r'currency':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(String),
          ) as String;
          result.currency = valueDes;
          break;
        case r'provider':
          final valueDes = serializers.deserialize(
            value,
            specifiedType: const FullType(PaymentRequestDTOProviderEnum),
          ) as PaymentRequestDTOProviderEnum;
          result.provider = valueDes;
          break;
        default:
          unhandled.add(key);
          unhandled.add(value);
          break;
      }
    }
  }

  @override
  PaymentRequestDTO deserialize(
    Serializers serializers,
    Object serialized, {
    FullType specifiedType = FullType.unspecified,
  }) {
    final result = PaymentRequestDTOBuilder();
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

class PaymentRequestDTOProviderEnum extends EnumClass {

  @BuiltValueEnumConst(wireName: r'STRIPE')
  static const PaymentRequestDTOProviderEnum STRIPE = _$paymentRequestDTOProviderEnum_STRIPE;
  @BuiltValueEnumConst(wireName: r'PAYPAL')
  static const PaymentRequestDTOProviderEnum PAYPAL = _$paymentRequestDTOProviderEnum_PAYPAL;

  static Serializer<PaymentRequestDTOProviderEnum> get serializer => _$paymentRequestDTOProviderEnumSerializer;

  const PaymentRequestDTOProviderEnum._(String name): super(name);

  static BuiltSet<PaymentRequestDTOProviderEnum> get values => _$paymentRequestDTOProviderEnumValues;
  static PaymentRequestDTOProviderEnum valueOf(String name) => _$paymentRequestDTOProviderEnumValueOf(name);
}

