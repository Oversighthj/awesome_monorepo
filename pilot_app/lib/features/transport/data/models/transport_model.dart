// lib/features/transport/data/models/transport_model.dart

import '../../domain/entities/transport.dart';

class TransportModel extends Transport {
  TransportModel({
    required int id,
    required String title,
    required String departure,
    required String arrival,
    required DateTime dateTime,
    required double price,
  }) : super(
          id: id,
          title: title,
          departure: departure,
          arrival: arrival,
          dateTime: dateTime,
          price: price,
        );

  factory TransportModel.fromJson(Map<String, dynamic> json) {
    return TransportModel(
      id: json['id'],
      title: json['title'],
      departure: json['departure'],
      arrival: json['arrival'],
      dateTime: DateTime.parse(json['dateTime']),
      price: (json['price'] as num).toDouble(),
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'title': title,
      'departure': departure,
      'arrival': arrival,
      'dateTime': dateTime.toIso8601String(),
      'price': price,
    };
  }
}
