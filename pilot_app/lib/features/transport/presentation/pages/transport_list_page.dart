// pilot_app/lib/features/transport/presentation/pages/transport_list_page.dart

import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
// عدّل المسار أدناه إذا كان transport_notifier في مسار مختلف
import '../providers/transport_notifier.dart';

class TransportListPage extends ConsumerWidget {
  const TransportListPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final transportsAsync = ref.watch(transportNotifierProvider);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Available Transports'),
      ),
      body: transportsAsync.when(
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (error, stack) => Center(child: Text('Error: $error')),
        data: (transports) {
          if (transports.isEmpty) {
            return const Center(child: Text('No Transports Available.'));
          }
          return ListView.builder(
            itemCount: transports.length,
            itemBuilder: (context, index) {
              final t = transports[index];
              return ListTile(
                title: Text(t.title),
                subtitle: Text('${t.departure} → ${t.arrival}\n${t.dateTime}'),
                trailing: Text('\$${t.price.toStringAsFixed(2)}'),
                onTap: () {
                  // لاحقًا ننتقل إلى صفحة الحجز (TransportBookingPage)
                  // Navigator.of(context).push(...);
                },
              );
            },
          );
        },
      ),
    );
  }
}
