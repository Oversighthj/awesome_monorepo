// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'payment_response_dto.dart';

// **************************************************************************
// BuiltValueGenerator
// **************************************************************************

class _$PaymentResponseDTO extends PaymentResponseDTO {
  @override
  final String checkoutUrl;
  @override
  final DateTime? expiresAt;
  @override
  final String providerSessionId;

  factory _$PaymentResponseDTO(
          [void Function(PaymentResponseDTOBuilder)? updates]) =>
      (new PaymentResponseDTOBuilder()..update(updates))._build();

  _$PaymentResponseDTO._(
      {required this.checkoutUrl,
      this.expiresAt,
      required this.providerSessionId})
      : super._() {
    BuiltValueNullFieldError.checkNotNull(
        checkoutUrl, r'PaymentResponseDTO', 'checkoutUrl');
    BuiltValueNullFieldError.checkNotNull(
        providerSessionId, r'PaymentResponseDTO', 'providerSessionId');
  }

  @override
  PaymentResponseDTO rebuild(
          void Function(PaymentResponseDTOBuilder) updates) =>
      (toBuilder()..update(updates)).build();

  @override
  PaymentResponseDTOBuilder toBuilder() =>
      new PaymentResponseDTOBuilder()..replace(this);

  @override
  bool operator ==(Object other) {
    if (identical(other, this)) return true;
    return other is PaymentResponseDTO &&
        checkoutUrl == other.checkoutUrl &&
        expiresAt == other.expiresAt &&
        providerSessionId == other.providerSessionId;
  }

  @override
  int get hashCode {
    var _$hash = 0;
    _$hash = $jc(_$hash, checkoutUrl.hashCode);
    _$hash = $jc(_$hash, expiresAt.hashCode);
    _$hash = $jc(_$hash, providerSessionId.hashCode);
    _$hash = $jf(_$hash);
    return _$hash;
  }

  @override
  String toString() {
    return (newBuiltValueToStringHelper(r'PaymentResponseDTO')
          ..add('checkoutUrl', checkoutUrl)
          ..add('expiresAt', expiresAt)
          ..add('providerSessionId', providerSessionId))
        .toString();
  }
}

class PaymentResponseDTOBuilder
    implements Builder<PaymentResponseDTO, PaymentResponseDTOBuilder> {
  _$PaymentResponseDTO? _$v;

  String? _checkoutUrl;
  String? get checkoutUrl => _$this._checkoutUrl;
  set checkoutUrl(String? checkoutUrl) => _$this._checkoutUrl = checkoutUrl;

  DateTime? _expiresAt;
  DateTime? get expiresAt => _$this._expiresAt;
  set expiresAt(DateTime? expiresAt) => _$this._expiresAt = expiresAt;

  String? _providerSessionId;
  String? get providerSessionId => _$this._providerSessionId;
  set providerSessionId(String? providerSessionId) =>
      _$this._providerSessionId = providerSessionId;

  PaymentResponseDTOBuilder() {
    PaymentResponseDTO._defaults(this);
  }

  PaymentResponseDTOBuilder get _$this {
    final $v = _$v;
    if ($v != null) {
      _checkoutUrl = $v.checkoutUrl;
      _expiresAt = $v.expiresAt;
      _providerSessionId = $v.providerSessionId;
      _$v = null;
    }
    return this;
  }

  @override
  void replace(PaymentResponseDTO other) {
    ArgumentError.checkNotNull(other, 'other');
    _$v = other as _$PaymentResponseDTO;
  }

  @override
  void update(void Function(PaymentResponseDTOBuilder)? updates) {
    if (updates != null) updates(this);
  }

  @override
  PaymentResponseDTO build() => _build();

  _$PaymentResponseDTO _build() {
    final _$result = _$v ??
        new _$PaymentResponseDTO._(
          checkoutUrl: BuiltValueNullFieldError.checkNotNull(
              checkoutUrl, r'PaymentResponseDTO', 'checkoutUrl'),
          expiresAt: expiresAt,
          providerSessionId: BuiltValueNullFieldError.checkNotNull(
              providerSessionId, r'PaymentResponseDTO', 'providerSessionId'),
        );
    replace(_$result);
    return _$result;
  }
}

// ignore_for_file: deprecated_member_use_from_same_package,type=lint
