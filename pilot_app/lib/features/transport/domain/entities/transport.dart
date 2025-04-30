// lib/features/transport/domain/entities/transport.dart

class Transport {
  final int id;
  final String title;
  final String departure;
  final String arrival;
  final DateTime dateTime;
  final double price;

  Transport({
    required this.id,
    required this.title,
    required this.departure,
    required this.arrival,
    required this.dateTime,
    required this.price,
  });
}
