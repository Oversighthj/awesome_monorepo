// pilot_app/lib/routes/app_router.dart

import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import '../features/user/presentation/pages/user_page.dart';
// استيراد الصفحة الجديدة:
import '../features/transport/presentation/pages/transport_list_page.dart';

final router = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (context, state) => const UserPage(),
    ),
    // أضفنا المسار التالي:
    GoRoute(
      path: '/transports',
      builder: (context, state) => const TransportListPage(),
    ),
  ],
);
