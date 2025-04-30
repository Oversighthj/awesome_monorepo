// test/features/user/presentation/user_controller_test.dart

import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:mocktail/mocktail.dart';
import 'package:dio/dio.dart';

import 'package:pilot_app/core/di/service_locator.dart' as di;
import 'package:pilot_app/core/network/api_client.dart';
import 'package:pilot_app/features/user/data/datasources/user_remote_data_source.dart';
import 'package:pilot_app/features/user/data/models/user_model.dart';
import 'package:pilot_app/features/user/presentation/providers/user_controller.dart';
import 'package:pilot_app/features/user/presentation/providers/user_provider.dart';

class MockApiClient extends Mock implements ApiClient {}

class FakeUserModel extends Fake implements UserModel {
  @override
  int get id => 0;

  @override
  String get name => 'fake';

  @override
  String get email => 'fake@example.com';

  @override
  Map<String, dynamic> toJson() => {
        'id': id,
        'name': name,
        'email': email,
      };
}

void main() {
  late ProviderContainer container;
  late MockApiClient mockApi;
  late UserRemoteDataSource realDs;

  setUpAll(() {
    registerFallbackValue(FakeUserModel());
  });

  setUp(() async {
    // أعد ضبط الـ service locator
    await di.sl.reset();

    // 1) أنشئ الـ MockApiClient
    mockApi = MockApiClient();

    // 2) سجّل الـ MockApiClient في GetIt لتفادي خطأ "لم يتم تسجيل ApiClient"
    di.sl.registerLazySingleton<ApiClient>(() => mockApi);

    // 3) أنشئ DataSource حقيقي بحقن الـ mockApi
    realDs = UserRemoteDataSource(di.sl<ApiClient>());

    // 4) سجّل الـ DataSource في GetIt
    di.sl.registerLazySingleton<UserRemoteDataSource>(() => realDs);

    // 5) أنشئ ProviderContainer لاختبار الـ Riverpod
    container = ProviderContainer();
    addTearDown(container.dispose);
  });

  final tUser = UserModel(id: 1, name: 'X', email: 'x@x.com');

  group('UserController CRUD ops', () {
    test('addUser calls createUser then reloads', () async {
      // بما أن UserRemoteDataSource حقيقي، فإنه سينفّذ client.post(...)
      // لذلك نعمل stub على mockApi.post(...) وليس على createUser().
      when(() => mockApi.post<Map<String, dynamic>>(any(), any()))
          .thenAnswer((_) async {
        return Response<Map<String, dynamic>>(
          data: {'id': 1, 'name': 'X', 'email': 'x@x.com'},
          requestOptions: RequestOptions(path: ''),
        );
      });

      final ctrl = container.read(userControllerProvider);
      final result = await ctrl.addUser('X', 'x@x.com');

      // تحقق من النتيجة
      expect(result, tUser);

      // تأكد أنه تم استدعاء mockApi.post مرة واحدة
      verify(() => mockApi.post<Map<String, dynamic>>(any(), any())).called(1);

      // تحقق من أن الـ usersProvider رجع بقائمة مستخدمين داخل AsyncValue
      final asyncVal = container.read(usersProvider);
      expect(asyncVal, isA<AsyncValue<List<UserModel>>>());
    });

    test('editUser calls updateUser then reloads', () async {
      // هنا نعمل stub على mockApi.put(...) لأن updateUser يستدعي put(...)
      when(() => mockApi.put<Map<String, dynamic>>(any(), any()))
          .thenAnswer((_) async {
        return Response<Map<String, dynamic>>(
          data: {'id': 1, 'name': 'X', 'email': 'x@x.com'},
          requestOptions: RequestOptions(path: ''),
        );
      });

      final ctrl = container.read(userControllerProvider);
      final result = await ctrl.editUser(1, 'Y', 'y@y.com');

      expect(result, tUser);
      verify(() => mockApi.put<Map<String, dynamic>>(any(), any())).called(1);

      final asyncVal = container.read(usersProvider);
      expect(asyncVal, isA<AsyncValue<List<UserModel>>>());
    });

    test('removeUser calls deleteUser then reloads', () async {
      // stub على mockApi.delete(...) لأن deleteUser يستدعي delete(...)
      when(() => mockApi.delete<void>(any()))
          .thenAnswer((_) async => Response<void>(
                data: null,
                requestOptions: RequestOptions(path: ''),
              ));

      final ctrl = container.read(userControllerProvider);
      await ctrl.removeUser(1);

      verify(() => mockApi.delete<void>(any())).called(1);

      final asyncVal = container.read(usersProvider);
      expect(asyncVal, isA<AsyncValue<List<UserModel>>>());
    });
  });
}
