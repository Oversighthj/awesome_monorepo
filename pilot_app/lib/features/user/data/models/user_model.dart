import '../../domain/entities/user.dart';

/// يمثّل كائن UserModel المشتق من كلاس User (في domain)
/// يحتوي على دوال fromJson/toJson للتعامل مع JSON
class UserModel extends User {
  /// نسمح بأن يكون [id] فارغًا (int?) في حال إنشاء مستخدم جديد
  UserModel({
    int? id,
    required String name,
    required String email,
  }) : super(id: id, name: name, email: email);

  /// يحوّل خريطة JSON إلى [UserModel]
  factory UserModel.fromJson(Map<String, dynamic> json) {
    return UserModel(
      id: json['id'] as int?,
      name: json['name'] as String,
      email: json['email'] as String,
    );
  }

  /// يحوّل [UserModel] إلى خريطة JSON
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'email': email,
    };
  }

  /// للمقارنة بين كائنين من نوع UserModel
  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other is UserModel &&
            runtimeType == other.runtimeType &&
            id == other.id &&
            name == other.name &&
            email == other.email);
  }

  @override
  int get hashCode => id.hashCode ^ name.hashCode ^ email.hashCode;
}
