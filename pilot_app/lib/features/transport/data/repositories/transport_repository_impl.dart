// lib/features/transport/data/repositories/transport_repository_impl.dart

import '../../domain/entities/transport.dart';
import '../../domain/repositories/transport_repository.dart';
import '../datasources/transport_remote_data_source.dart';

class TransportRepositoryImpl implements TransportRepository {
  final TransportRemoteDataSource remoteDataSource;

  TransportRepositoryImpl(this.remoteDataSource);

  @override
  Future<List<Transport>> getTransports() async {
    final models = await remoteDataSource.fetchTransports();
    return models; // لأنها أصلاً تمتد Transport
  }
}
