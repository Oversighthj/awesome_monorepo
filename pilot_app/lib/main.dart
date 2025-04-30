import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';  // ← ضيف هذا
import 'core/di/service_locator.dart' as di;
import 'routes/app_router.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await di.initServiceLocator();

  runApp(
    const ProviderScope(                // ← غلف التطبيق بالـ ProviderScope
      child: PilotApp(),
    ),
  );
}

class PilotApp extends StatelessWidget {
  const PilotApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      title: 'Pilot App',
      theme: ThemeData(useMaterial3: true),
      routerConfig: router,
    );
  }
}
