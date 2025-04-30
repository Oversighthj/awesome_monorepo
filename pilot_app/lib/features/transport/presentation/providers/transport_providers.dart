import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../data/datasources/transport_remote_data_source.dart';
import '../../data/repositories/transport_repository_impl.dart';
import '../../domain/repositories/transport_repository.dart';

// إذا كنت تستخدم نفس الـ apiClientProvider المعرّف في user_provider.dart
// يمكنك ببساطة استيراد ملف user_provider.dart
import 'package:pilot_app/features/user/presentation/providers/user_provider.dart';
// أو ضعه في ملف مشترك (مثلاً core/network/api_client_provider.dart)

final transportRemoteDataSourceProvider = Provider<TransportRemoteDataSource>((ref) {
  // لاحظ أننا نأخذ الـ client من apiClientProvider
  final apiClient = ref.watch(apiClientProvider);
  return TransportRemoteDataSource(apiClient.dio);
  // أو إذا كان constructor يأخذ ApiClient بدلاً من Dio:
  // return TransportRemoteDataSource(apiClient);
});

final transportRepositoryProvider = Provider<TransportRepository>((ref) {
  final remoteDS = ref.watch(transportRemoteDataSourceProvider);
  return TransportRepositoryImpl(remoteDS);
});
