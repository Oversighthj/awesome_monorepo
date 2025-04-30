// user_controller.dart

import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../data/datasources/user_remote_data_source.dart';
import '../../data/models/user_model.dart';
import '../../../../core/di/service_locator.dart';
// [جديد] استورد هنا ملف user_provider.dart إذا احتجت usersProvider
import 'user_provider.dart'; // <-- مثلا

/// Controller مسؤول عن كل عمليات CRUD
class UserController {
  UserController(this._ref)
      : _ds = UserRemoteDataSource(sl());

  final Ref _ref;
  final UserRemoteDataSource _ds;

  /// إعادة تحميل قائمة المستخدمين
  Future<void> reloadUsers() async {
    _ref.invalidate(usersProvider); // <-- صارنا نستخدمه من user_provider.dart
  }

  Future<UserModel> addUser(String name, String email) async {
    final newUser = UserModel(id: 0, name: name, email: email);
    final created = await _ds.createUser(newUser);
    await reloadUsers();
    return created;
  }

  Future<UserModel> editUser(int id, String name, String email) async {
    final updated = UserModel(id: id, name: name, email: email);
    final result = await _ds.updateUser(updated);
    await reloadUsers();
    return result;
  }

  Future<void> removeUser(int id) async {
    await _ds.deleteUser(id);
    await reloadUsers();
  }
}

/// نعلن Provider للـ Controller
final userControllerProvider = Provider<UserController>((ref) {
  return UserController(ref);
});

// هنا نحذف كلياً تعريف usersProvider لأنه موجود في user_provider.dart
