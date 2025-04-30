import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../providers/user_controller.dart';
import '../../data/models/user_model.dart';

class UserFormPage extends ConsumerStatefulWidget {
  final UserModel? editingUser;
  const UserFormPage({this.editingUser, super.key});

  @override
  ConsumerState<UserFormPage> createState() => _UserFormPageState();
}

class _UserFormPageState extends ConsumerState<UserFormPage> {
  late final TextEditingController _nameCtrl;
  late final TextEditingController _emailCtrl;
  bool _loading = false;

  @override
  void initState() {
    super.initState();
    _nameCtrl = TextEditingController(text: widget.editingUser?.name ?? '');
    _emailCtrl = TextEditingController(text: widget.editingUser?.email ?? '');
  }

  @override
  void dispose() {
    _nameCtrl.dispose();
    _emailCtrl.dispose();
    super.dispose();
  }

  Future<void> _onSave() async {
    final name = _nameCtrl.text.trim();
    final email = _emailCtrl.text.trim();
    if (name.isEmpty || email.isEmpty) return;

    setState(() => _loading = true);
    final ctrl = ref.read(userControllerProvider);

    try {
      if (widget.editingUser == null) {
        await ctrl.addUser(name, email);
      } else {
        // handle nullable ID
        await ctrl.editUser(widget.editingUser!.id!, name, email);
      }
      // safe pop after async
      if (!mounted) return;
      Navigator.of(context).pop();
    } catch (e) {
      // safe snackbar after async
      if (!mounted) return;
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: $e')),
      );
    } finally {
      // تحديث الحالة فقط لو الـ State ما زالت مثبتة
      if (mounted) {
        setState(() => _loading = false);
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    final isEditing = widget.editingUser != null;
    return Scaffold(
      appBar: AppBar(title: Text(isEditing ? 'تعديل مستخدم' : 'إضافة مستخدم')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              controller: _nameCtrl,
              decoration: const InputDecoration(labelText: 'الاسم'),
            ),
            const SizedBox(height: 16),
            TextField(
              controller: _emailCtrl,
              decoration: const InputDecoration(labelText: 'الإيميل'),
            ),
            const SizedBox(height: 32),
            if (_loading)
              const CircularProgressIndicator()
            else
              ElevatedButton(
                onPressed: _onSave,
                child: Text(isEditing ? 'حفظ التعديلات' : 'إضافة'),
              ),
          ],
        ),
      ),
    );
  }
}
