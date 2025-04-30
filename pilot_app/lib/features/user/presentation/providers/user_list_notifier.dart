import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../data/models/user_model.dart';
import '../../data/datasources/user_remote_data_source.dart';
// إذا أردت جلب الـ userRemoteDataSourceProvider من ملف آخر، استورده هنا
import 'user_provider.dart';

class UserListNotifier extends StateNotifier<AsyncValue<List<UserModel>>> {
  UserListNotifier(this._ds) : super(const AsyncValue.loading()) {
    _fetchUsers();
  }

  final UserRemoteDataSource _ds;

  Future<void> _fetchUsers() async {
    try {
      state = const AsyncValue.loading();
      final users = await _ds.fetchUsers();
      state = AsyncValue.data(users);
    } catch (e, st) {
      state = AsyncValue.error(e, st);
    }
  }

  Future<void> addUser(String name, String email) async {
    try {
      // عند إنشاء مستخدم جديد قد لا يكون لديه id بعد
      await _ds.createUser(UserModel(id: null, name: name, email: email));
      await _fetchUsers();
    } catch (e, st) {
      state = AsyncValue.error(e, st);
    }
  }

  Future<void> updateUser(int id, String name, String email) async {
    try {
      final updated = UserModel(id: id, name: name, email: email);
      await _ds.updateUser(updated);
      await _fetchUsers();
    } catch (e, st) {
      state = AsyncValue.error(e, st);
    }
  }

  Future<void> removeUser(int id) async {
    try {
      await _ds.deleteUser(id);
      await _fetchUsers();
    } catch (e, st) {
      state = AsyncValue.error(e, st);
    }
  }
}

final userListNotifierProvider =
    StateNotifierProvider<UserListNotifier, AsyncValue<List<UserModel>>>(
  (ref) {
    // نأخذ UserRemoteDataSource من userRemoteDataSourceProvider
    final ds = ref.watch(userRemoteDataSourceProvider);
    return UserListNotifier(ds);
  },
);
