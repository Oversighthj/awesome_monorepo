import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for UsersApi
void main() {
  final instance = Openapi().getUsersApi();

  group(UsersApi, () {
    // Get user by id
    //
    //Future<UserDTO> getUser(int id) async
    test('test getUser', () async {
      // TODO
    });

    // List all users
    //
    //Future<BuiltList<UserDTO>> listUsers() async
    test('test listUsers', () async {
      // TODO
    });

  });
}
