// lib/features/transport/domain/repositories/transport_repository.dart

import '../entities/transport.dart';

abstract class TransportRepository {
  Future<List<Transport>> getTransports();
  // ممكن نضيف: Future<Transport> getTransportById(int id);
  // Future<void> bookTransport(...);
}
