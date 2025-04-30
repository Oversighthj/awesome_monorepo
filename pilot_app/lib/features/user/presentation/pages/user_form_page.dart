import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../providers/user_controller.dart'; // افترضنا لديك ملف user_controller.dart
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
    // يفترض أن userControllerProvider لديه متد ط addUser() و editUser()

    try {
      if (widget.editingUser == null) {
        // إضافة مستخدم جديد
        await ctrl.addUser(name, email);
      } else {
        // تعديل مستخدم قائم
        // لاحظ هنا يجب التعامل مع أن widget.editingUser!.id يمكن يكون int? 
        // إذا كنت متأكد أن لديه قيمة فعليّة 100%، ضع علامة ! بعده
        await ctrl.editUser(widget.editingUser!.id!, name, email);
      }
      Navigator.of(context).pop(); // ارجع للقائمة بعد النجاح
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: $e')),
      );
    } finally {
      setState(() => _loading = false);
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
