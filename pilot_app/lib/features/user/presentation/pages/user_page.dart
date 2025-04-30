import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
// أضف استيراد go_router
import 'package:go_router/go_router.dart';

import '../providers/user_list_notifier.dart';
import '../../data/models/user_model.dart';
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

      // أضفنا هنا زر FloatingActionButton للتنقّل إلى صفحة /transports
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // استدعاء المسار المؤدي إلى TransportListPage
          context.push('/transports');
          // أو: GoRouter.of(context).go('/transports');
        },
        child: const Icon(Icons.directions_bus), // أيقونة تعبّر عن النقل
      ),
    );
  }
}
