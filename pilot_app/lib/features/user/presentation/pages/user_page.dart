import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';

import '../providers/user_list_notifier.dart';
import 'user_form_page.dart';

class UserPage extends ConsumerWidget {
  const UserPage({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final usersAsync = ref.watch(userListNotifierProvider);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Users'),
        actions: [
          IconButton(
            icon: const Icon(Icons.add),
            onPressed: () => Navigator.of(context).push(
              MaterialPageRoute(builder: (_) => const UserFormPage()),
            ),
          ),
        ],
      ),
      body: usersAsync.when(
        data: (users) => ListView.builder(
          itemCount: users.length,
          itemBuilder: (_, i) {
            final u = users[i];
            return ListTile(
              title: Text(u.name),
              subtitle: Text(u.email),
              trailing: Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  IconButton(
                    icon: const Icon(Icons.edit),
                    onPressed: () => Navigator.of(context).push(
                      MaterialPageRoute(
                        builder: (_) => UserFormPage(editingUser: u),
                      ),
                    ),
                  ),
                  IconButton(
                    icon: const Icon(Icons.delete),
                    onPressed: () async {
                      await ref
                          .read(userListNotifierProvider.notifier)
                          .removeUser(u.id!);
                    },
                  ),
                ],
              ),
            );
          },
        ),
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, st) => Center(child: Text(e.toString())),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          context.push('/transports');
        },
        child: const Icon(Icons.directions_bus),
      ),
    );
  }
}
