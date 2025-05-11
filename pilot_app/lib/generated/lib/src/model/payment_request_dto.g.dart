// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'payment_request_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

const PaymentRequestDTOProviderEnum _$paymentRequestDTOProviderEnum_STRIPE =
    const PaymentRequestDTOProviderEnum._('STRIPE');
const PaymentRequestDTOProviderEnum _$paymentRequestDTOProviderEnum_PAYPAL =
    const PaymentRequestDTOProviderEnum._('PAYPAL');

PaymentRequestDTOProviderEnum _$paymentRequestDTOProviderEnumValueOf(
    String name) {
  switch (name) {
    case 'STRIPE':
      return _$paymentRequestDTOProviderEnum_STRIPE;
    case 'PAYPAL':
      return _$paymentRequestDTOProviderEnum_PAYPAL;
    default:
      throw new ArgumentError(name);
  }
}

final BuiltSet<PaymentRequestDTOProviderEnum>
    _$paymentRequestDTOProviderEnumValues = new BuiltSet<
        PaymentRequestDTOProviderEnum>(const <PaymentRequestDTOProviderEnum>[
  _$paymentRequestDTOProviderEnum_STRIPE,
  _$paymentRequestDTOProviderEnum_PAYPAL,
]);

Serializer<PaymentRequestDTOProviderEnum>
    _$paymentRequestDTOProviderEnumSerializer =
    new _$PaymentRequestDTOProviderEnumSerializer();

class _$PaymentRequestDTOProviderEnumSerializer
    implements PrimitiveSerializer<PaymentRequestDTOProviderEnum> {
  static const Map<String, Object> _toWire = const <String, Object>{
    'STRIPE': 'STRIPE',
    'PAYPAL': 'PAYPAL',
  };
  static const Map<Object, String> _fromWire = const <Object, String>{
    'STRIPE': 'STRIPE',
    'PAYPAL': 'PAYPAL',
  };

  @override
  final Iterable<Type> types = const <Type>[PaymentRequestDTOProviderEnum];
  @override
  final String wireName = 'PaymentRequestDTOProviderEnum';

  @override
  Object serialize(
          Serializers serializers, PaymentRequestDTOProviderEnum object,
          {FullType specifiedType = FullType.unspecified}) =>
      _toWire[object.name] ?? object.name;

  @override
  PaymentRequestDTOProviderEnum deserialize(
          Serializers serializers, Object serialized,
          {FullType specifiedType = FullType.unspecified}) =>
      PaymentRequestDTOProviderEnum.valueOf(
          _fromWire[serialized] ?? (serialized is String ? serialized : ''));
}

class _$PaymentRequestDTO extends PaymentRequestDTO {
  @override
  final int bookingId;
  @override
  final double amount;
  @override
  final String currency;
  @override
  final PaymentRequestDTOProviderEnum provider;

  factory _$PaymentRequestDTO(
          [void Function(PaymentRequestDTOBuilder)? updates]) =>
      (new PaymentRequestDTOBuilder()..update(updates))._build();

  _$PaymentRequestDTO._(
      {required this.bookingId,
      required this.amount,
      required this.currency,
      required this.provider})
      : super._() {
    BuiltValueNullFieldError.checkNotNull(
        bookingId, r'PaymentRequestDTO', 'bookingId');
    BuiltValueNullFieldError.checkNotNull(
        amount, r'PaymentRequestDTO', 'amount');
    BuiltValueNullFieldError.checkNotNull(
        currency, r'PaymentRequestDTO', 'currency');
    BuiltValueNullFieldError.checkNotNull(
        provider, r'PaymentRequestDTO', 'provider');
  }

  @override
  PaymentRequestDTO rebuild(void Function(PaymentRequestDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  PaymentRequestDTOBuilder toBuilder() =>
      new PaymentRequestDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is PaymentRequestDTO &&
        bookingId == other.bookingId &&
        amount == other.amount &&
        currency == other.currency &&
        provider == other.provider;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, bookingId.hashCode);
    _$hash = $jc(_$hash, amount.hashCode);
    _$hash = $jc(_$hash, currency.hashCode);
    _$hash = $jc(_$hash, provider.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'PaymentRequestDTO')
          ..add('bookingId', bookingId)
          ..add('amount', amount)
          ..add('currency', currency)
          ..add('provider', provider))
        .toString();
  }
}

class PaymentRequestDTOBuilder
    implements Builder<PaymentRequestDTO, PaymentRequestDTOBuilder> {
  _$PaymentRequestDTO? _$v;

  int? _bookingId;
  int? get bookingId => _$this._bookingId;
  set bookingId(int? bookingId) => _$this._bookingId = bookingId;

  double? _amount;
  double? get amount => _$this._amount;
  set amount(double? amount) => _$this._amount = amount;

  String? _currency;
  String? get currency => _$this._currency;
  set currency(String? currency) => _$this._currency = currency;

  PaymentRequestDTOProviderEnum? _provider;
  PaymentRequestDTOProviderEnum? get provider => _$this._provider;
  set provider(PaymentRequestDTOProviderEnum? provider) =>
      _$this._provider = provider;

  PaymentRequestDTOBuilder() {
    PaymentRequestDTO._defaults(this);
  }

  PaymentRequestDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _bookingId = $v.bookingId;
      _amount = $v.amount;
      _currency = $v.currency;
      _provider = $v.provider;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(PaymentRequestDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$PaymentRequestDTO;
  }

  @override
  void update(void Function(PaymentRequestDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  PaymentRequestDTO build() => _build();

  _$PaymentRequestDTO _build() {
    final _$result = _$v ??
        new _$PaymentRequestDTO._(
          bookingId: BuiltValueNullFieldError.checkNotNull(
              bookingId, r'PaymentRequestDTO', 'bookingId'),
          amount: BuiltValueNullFieldError.checkNotNull(
              amount, r'PaymentRequestDTO', 'amount'),
          currency: BuiltValueNullFieldError.checkNotNull(
              currency, r'PaymentRequestDTO', 'currency'),
          provider: BuiltValueNullFieldError.checkNotNull(
              provider, r'PaymentRequestDTO', 'provider'),
        );
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
