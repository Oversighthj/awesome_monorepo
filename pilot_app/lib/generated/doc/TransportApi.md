# openapi.api.TransportApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bookTransport**](TransportApi.md#booktransport) | **POST** /transport/book | Book a transport ride


# **bookTransport**
> TransportBookingDTO bookTransport(transportBookingDTO)

Book a transport ride

### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getTransportApi();
final TransportBookingDTO transportBookingDTO = ; // TransportBookingDTO | 

try {
    final response = api.bookTransport(transportBookingDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling TransportApi->bookTransport: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transportBookingDTO** | [**TransportBookingDTO**](TransportBookingDTO.md)|  | 

### Return type

[**TransportBookingDTO**](TransportBookingDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

