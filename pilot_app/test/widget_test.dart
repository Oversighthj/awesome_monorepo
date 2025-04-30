// test/widget_test.dart

import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:pilot_app/main.dart';

void main() {
  testWidgets('PilotApp builds and shows Users page', (WidgetTester tester) async {
    await tester.pumpWidget(
      const ProviderScope(
        child: PilotApp(),
      ),
    );

    await tester.pumpAndSettle();

    expect(find.text('Users'), findsOneWidget);
    expect(find.byIcon(Icons.add), findsOneWidget);
  });
}
