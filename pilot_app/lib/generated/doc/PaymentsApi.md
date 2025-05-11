# openapi.api.PaymentsApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**initiatePayment**](PaymentsApi.md#initiatepayment) | **POST** /payments/checkout | Initiate payment session (Stripe / PayPal)


# **initiatePayment**
> PaymentResponseDTO initiatePayment(paymentRequestDTO)

Initiate payment session (Stripe / PayPal)

### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getPaymentsApi();
final PaymentRequestDTO paymentRequestDTO = ; // PaymentRequestDTO | 

try {
    final response = api.initiatePayment(paymentRequestDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling PaymentsApi->initiatePayment: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentRequestDTO** | [**PaymentRequestDTO**](PaymentRequestDTO.md)|  | 

### Return type

[**PaymentResponseDTO**](PaymentResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

