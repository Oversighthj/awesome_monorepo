import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for BookingsApi
void main() {
  final instance = Openapi().getBookingsApi();

  group(BookingsApi, () {
    // Create a new booking (workspace, apartment, etc.)
    //
    //Future<BookingDTO> createBooking(BookingDTO bookingDTO) async
    test('test createBooking', () async {
      // TODO
    });

    // Get booking details
    //
    //Future<BookingDTO> getBooking(int bookingId) async
    test('test getBooking', () async {
      // TODO
    });

    // List bookings
    //
    //Future<BuiltList<BookingDTO>> listBookings({ int userId, BookingStatus status }) async
    test('test listBookings', () async {
      // TODO
    });

  });
}
