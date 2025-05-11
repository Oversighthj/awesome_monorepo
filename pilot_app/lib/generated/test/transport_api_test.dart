import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for TransportApi
void main() {
  final instance = Openapi().getTransportApi();

  group(TransportApi, () {
    // Book a transport ride
    //
    //Future<TransportBookingDTO> bookTransport(TransportBookingDTO transportBookingDTO) async
    test('test bookTransport', () async {
      // TODO
    });

  });
}
