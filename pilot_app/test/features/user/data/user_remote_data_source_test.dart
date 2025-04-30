// test/features/user/data/user_remote_data_source_test.dart

import 'package:dio/dio.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mocktail/mocktail.dart';
import 'package:pilot_app/features/user/data/datasources/user_remote_data_source.dart';
import 'package:pilot_app/features/user/data/models/user_model.dart';
import '../../../api_client_mock.dart';

void main() {
  late MockApiClient mockClient;
  late UserRemoteDataSource ds;

  setUp(() {
    mockClient = MockApiClient();
    ds = UserRemoteDataSource(mockClient);
  });

  group('UserRemoteDataSource', () {
    final tUserJson = {'id': 1, 'name': 'Test', 'email': 'test@x.com'};
    final tUserModel = UserModel(id: 1, name: 'Test', email: 'test@x.com');

    test('fetchUsers returns list of UserModel on valid response', () async {
      when(() => mockClient.get<List>('/users')).thenAnswer(
        (_) async => Response(
          requestOptions: RequestOptions(path: '/users'),
          data: [tUserJson],
        ),
      );

      final result = await ds.fetchUsers();

      expect(result, [tUserModel]);
      verify(() => mockClient.get<List>('/users')).called(1);
    });

    test('createUser returns a UserModel on successful POST', () async {
      when(() => mockClient.post<Map<String, dynamic>>('/users', tUserModel.toJson()))
          .thenAnswer(
        (_) async => Response(
          requestOptions: RequestOptions(path: '/users'),
          data: tUserJson,
        ),
      );

      final result = await ds.createUser(tUserModel);

      expect(result, tUserModel);
      verify(() => mockClient.post<Map<String, dynamic>>('/users', tUserModel.toJson())).called(1);
    });

    test('updateUser returns updated UserModel on successful PUT', () async {
      when(() => mockClient.put<Map<String, dynamic>>('/users/1', tUserModel.toJson()))
          .thenAnswer(
        (_) async => Response(
          requestOptions: RequestOptions(path: '/users/1'),
          data: tUserJson,
        ),
      );

      final result = await ds.updateUser(tUserModel);

      expect(result, tUserModel);
      verify(() => mockClient.put<Map<String, dynamic>>('/users/1', tUserModel.toJson())).called(1);
    });

    test('deleteUser calls DELETE on correct endpoint', () async {
      when(() => mockClient.delete<void>('/users/1')).thenAnswer(
        (_) async => Response(
          requestOptions: RequestOptions(path: '/users/1'),
          data: null,
        ),
      );

      await ds.deleteUser(1);

      verify(() => mockClient.delete<void>('/users/1')).called(1);
    });
  });
}
