import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../domain/entities/transport.dart';
import '../../domain/repositories/transport_repository.dart';
// استوردنا transport_providers.dart لتعريف transportRepositoryProvider
import 'transport_providers.dart';

class TransportNotifier extends StateNotifier<AsyncValue<List<Transport>>> {
  final TransportRepository _repository;

  TransportNotifier(this._repository) : super(const AsyncValue.loading()) {
    fetchTransports();
  }

  Future<void> fetchTransports() async {
    try {
      state = const AsyncValue.loading();
      final result = await _repository.getTransports();
      state = AsyncValue.data(result);
    } catch (e, st) {
      state = AsyncValue.error(e, st);
    }
  }
}

final transportNotifierProvider =
    StateNotifierProvider<TransportNotifier, AsyncValue<List<Transport>>>(
  (ref) {
    // أخذ الـ Repository من مزوّد transportRepositoryProvider
    final repo = ref.watch(transportRepositoryProvider);
    return TransportNotifier(repo);
  },
);
