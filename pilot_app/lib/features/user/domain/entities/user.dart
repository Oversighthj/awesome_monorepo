// pilot_app/lib/features/user/domain/entities/user.dart
class User {
  final int? id;
  final String name;
  final String email;

  const User({
    this.id,
    required this.name,
    required this.email,
  });
}
