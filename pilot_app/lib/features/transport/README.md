# Transport Feature Module

هذا المجلد يضم ميزة النقل داخل تطبيق Flutter.

## الهيكل

```text
pilot_app/lib/features/transport/
├── models/
│   └── transport_model.dart   # نموذج بيانات للنقل (@JsonSerializable)
└── README.md                  # هذا الملف
```

## transport_model.dart

- يعتمد على `json_serializable` لتوليد دوال من/إلى JSON.
- مثال توضيحي (قد يختلف الحقل الفعلي):
  ```dart
  import 'package:json_annotation/json_annotation.dart';

  part 'transport_model.g.dart';

  @JsonSerializable()
  class TransportModel {
    final String id;
    final String name;
    final double cost;

    TransportModel({
      required this.id,
      required this.name,
      required this.cost,
    });

    factory TransportModel.fromJson(Map<String, dynamic> json) => _$TransportModelFromJson(json);
    Map<String, dynamic> toJson() => _$TransportModelToJson(this);
  }
  ```

## توليد الكود

لتوليد ملفات الإضافية (`transport_model.g.dart`):
```bash
cd pilot_app
flutter pub run build_runner build --delete-conflicting-outputs
```

## الاستخدام

يمكنك استخدام النموذج لتحويل البيانات من الـ API:
```dart
final json = {'id':'1','name':'Bus','cost':2.5};
final model = TransportModel.fromJson(json);
```

---

> يساعد هذا README في فهم بنية ميزة النقل وطريقة استخدام نموذج البيانات الخاصة بها.

