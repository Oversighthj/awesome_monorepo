import 'package:dio/dio.dart';
import '../models/transport_model.dart';

class TransportRemoteDataSource {
  final Dio dio;

  TransportRemoteDataSource(this.dio);

  Future<List<TransportModel>> fetchTransports() async {
    final response = await dio.get('/transport/flights');

    if (response.statusCode == 200) {
      final data = response.data;

      // تأكد أولًا أن data هو List
      if (data is! List) {
        throw Exception('Unexpected data format. Expected a JSON List, got $data');
      }

      // تأكد أن كل عنصر في القائمة هو Map<String, dynamic>
      return data.map((item) {
        if (item is! Map<String, dynamic>) {
          throw Exception('Transport item is not a valid JSON object: $item');
        }
        return TransportModel.fromJson(item);
      }).toList();
    } else {
      throw Exception(
        'Failed to load transports. Status code: ${response.statusCode}',
      );
    }
  }

  // لاحقًا نضيف bookTransport(), fetchTransportById() إلخ
}
