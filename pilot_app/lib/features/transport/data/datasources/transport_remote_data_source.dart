// lib/features/transport/data/datasources/transport_remote_data_source.dart

import 'package:dio/dio.dart';
import '../models/transport_model.dart';

class TransportRemoteDataSource {
  final Dio dio;

  TransportRemoteDataSource(this.dio);

  Future<List<TransportModel>> fetchTransports() async {
    final response = await dio.get('/transport/flights');
    if (response.statusCode == 200) {
      final data = response.data as List;
      return data.map((json) => TransportModel.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load transports');
    }
  }

  // لاحقًا نضيف bookTransport(), fetchTransportById() إلخ
}
