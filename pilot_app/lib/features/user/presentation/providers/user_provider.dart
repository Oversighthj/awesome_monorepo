import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../../../core/network/api_client.dart';
import '../../data/datasources/user_remote_data_source.dart';
import '../../data/models/user_model.dart';

/// Provider لـ ApiClient
/// ملاحظة: غيّر العنوان (baseUrl) حسب عنوان سيرفرك
final apiClientProvider = Provider<ApiClient>((ref) {
  // على المحاكي أندرويد: http://10.0.2.2:8080
  // على سطح المكتب: http://localhost:8080
  return ApiClient(baseUrl: 'http://localhost:8080');
});

/// Provider لـ UserRemoteDataSource
/// - يعتمد على apiClientProvider
final userRemoteDataSourceProvider = Provider<UserRemoteDataSource>((ref) {
  final apiClient = ref.watch(apiClientProvider);
  // نفترض أن الـ UserRemoteDataSource يستقبل ApiClient مباشرةً
  return UserRemoteDataSource(apiClient);
});

/// FutureProvider يعيد قائمة من UserModel
/// - يستخدم userRemoteDataSourceProvider لاستدعاء fetchUsers()
final usersProvider = FutureProvider<List<UserModel>>((ref) async {
  final ds = ref.watch(userRemoteDataSourceProvider);
  return ds.fetchUsers();
});
