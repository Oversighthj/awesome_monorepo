// lib/features/user/data/datasources/user_remote_data_source.dart

import '../../../../core/network/api_client.dart';
import '../models/user_model.dart';

class UserRemoteDataSource {
  final ApiClient client;
  UserRemoteDataSource(this.client);

  /// جلب جميع المستخدمين (GET /users)
  Future<List<UserModel>> fetchUsers() async {
    final res = await client.get<List>('/users');
    final data = res.data ?? [];
    return data
        .map((e) => UserModel.fromJson(e as Map<String, dynamic>))
        .toList();
  }

  /// إنشاء مستخدم جديد (POST /users)
  Future<UserModel> createUser(UserModel user) async {
    final res = await client.post<Map<String, dynamic>>(
      '/users',
      user.toJson(),
    );
    return UserModel.fromJson(res.data!);
  }

  /// تعديل مستخدم قائم (PUT /users/:id)
  Future<UserModel> updateUser(UserModel user) async {
    final res = await client.put<Map<String, dynamic>>(
      '/users/${user.id}',
      user.toJson(),
    );
    return UserModel.fromJson(res.data!);
  }

  /// حذف مستخدم (DELETE /users/:id)
  Future<void> deleteUser(int id) async {
    await client.delete<void>('/users/$id');
  }
}
