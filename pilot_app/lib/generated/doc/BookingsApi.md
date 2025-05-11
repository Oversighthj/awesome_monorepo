# openapi.api.BookingsApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBooking**](BookingsApi.md#createbooking) | **POST** /bookings | Create a new booking (workspace, apartment, etc.)
[**getBooking**](BookingsApi.md#getbooking) | **GET** /bookings/{bookingId} | Get booking details
[**listBookings**](BookingsApi.md#listbookings) | **GET** /bookings | List bookings


# **createBooking**
> BookingDTO createBooking(bookingDTO)

Create a new booking (workspace, apartment, etc.)

### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getBookingsApi();
final BookingDTO bookingDTO = ; // BookingDTO | 

try {
    final response = api.createBooking(bookingDTO);
    print(response);
} catch on DioException (e) {
    print('Exception when calling BookingsApi->createBooking: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bookingDTO** | [**BookingDTO**](BookingDTO.md)|  | 

### Return type

[**BookingDTO**](BookingDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBooking**
> BookingDTO getBooking(bookingId)

Get booking details

### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getBookingsApi();
final int bookingId = 789; // int | 

try {
    final response = api.getBooking(bookingId);
    print(response);
} catch on DioException (e) {
    print('Exception when calling BookingsApi->getBooking: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bookingId** | **int**|  | 

### Return type

[**BookingDTO**](BookingDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/problem+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listBookings**
> BuiltList<BookingDTO> listBookings(userId, status)

List bookings

### Example
```dart
import 'package:openapi/api.dart';

final api = Openapi().getBookingsApi();
final int userId = 789; // int | 
final BookingStatus status = ; // BookingStatus | 

try {
    final response = api.listBookings(userId, status);
    print(response);
} catch on DioException (e) {
    print('Exception when calling BookingsApi->listBookings: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **int**|  | [optional] 
 **status** | [**BookingStatus**](.md)|  | [optional] 

### Return type

[**BuiltList&lt;BookingDTO&gt;**](BookingDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/problem+json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

