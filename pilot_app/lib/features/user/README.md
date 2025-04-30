# User Feature Module

هذا المجلد يضم كل ما يتعلق بميزة المستخدم ضمن تطبيق Flutter.

## الهيكل

```text
pilot_app/lib/features/user/
├── data/
│   ├── models/
│   │   └── user_model.dart        # كلاس UserModel مع @JsonSerializable
│   ├── remote/
│   │   └── user_remote_data_source.dart  # جلب البيانات من API
│   └── repository/
│       └── user_repository_impl.dart    # تطبيق UserRepository
├── presentation/
│   ├── pages/
│   │   ├── user_page.dart          # الصفحة الرئيسية لعرض قائمة المستخدمين
│   │   └── user_form_page.dart     # صفحة إضافة/تعديل مستخدم
│   └── controllers/
│       └── user_controller.dart    # Riverpod StateNotifier لإدارة الحالة
└── README.md                       # هذا الملف
```

## التقنيات والأدوات

- **Riverpod** لإدارة الحالة عبر `userControllerProvider`.
- **Freezed & json_serializable** في `user_model.dart` لتوليد بيانات النموذج.
- **get_it** أو **injectable** (عند الحاجة) لحقن التبعيات.
- **GoRouter** للتنقل بين الصفحات.

## شرح الملفات الرئيسية

### 1. user_model.dart
- يعرف `UserModel` مع الحقول:
  - `int id`
  - `String name`
  - `String email`
- يتم توليد الكود (toJson/fromJson) تلقائيًا عبر `json_serializable`.

### 2. user_remote_data_source.dart
- يحتوي على دوال لاستدعاء API:
  ```dart
  class UserRemoteDataSource {
    final ApiClient client;
    Future<List<UserModel>> fetchUsers();
    Future<UserModel> createUser(UserModel user);
  }
  ```

### 3. user_repository_impl.dart
- يجمع بين الـ remote والـ local (إن وجد):
  ```dart
  class UserRepositoryImpl implements UserRepository {
    final UserRemoteDataSource remote;
    @override
    Future<List<UserModel>> getUsers() async => remote.fetchUsers();
    // بقية الدوال
  }
  ```

### 4. user_controller.dart
- StateNotifier يستخدم Riverpod:
  ```dart
  class UserController extends StateNotifier<AsyncValue<List<UserModel>>> {
    Future<void> loadUsers() async { ... }
    Future<void> addUser(String name, String email) async { ... }
  }
  ```

### 5. user_page.dart & user_form_page.dart
- `user_page.dart`: يعرض قائمة المستخدمين مع زر إضافة.
- `user_form_page.dart`: يعرض نموذج لإضافة/تعديل مستخدم ويستخدم `userControllerProvider`.

## الأوامر الخاصة بالمجلد

```bash
cd pilot_app/lib/features/user
flutter pub run build_runner build --delete-conflicting-outputs  # لتوليد JSON serialization
```

---

> هذا الملف يساعد المطورين على فهم تفاصيل بنية ميزة المستخدم واستخدامها ضمن التطبيق.

