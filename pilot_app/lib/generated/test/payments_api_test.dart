import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for PaymentsApi
void main() {
  final instance = Openapi().getPaymentsApi();

  group(PaymentsApi, () {
    // Initiate payment session (Stripe / PayPal)
    //
    //Future<PaymentResponseDTO> initiatePayment(PaymentRequestDTO paymentRequestDTO) async
    test('test initiatePayment', () async {
      // TODO
    });

  });
}
