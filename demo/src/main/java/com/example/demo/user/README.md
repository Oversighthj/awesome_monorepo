# User Module

هذا المجلد يتعامل مع كائنات `User` (كيانات المستخدمين) وطرائق مطابقة البيانات بين Entity وDTO.

## نظرة عامة على الملفات

```text
src/main/java/com/example/demo/user/
├── User.java      # الكيان (JPA Entity) للمستخدم
├── UserDTO.java   # Data Transfer Object لنقل بيانات المستخدم عبر الـ API
└── UserMapper.java# واجهة MapStruct لتحويل بين User وUserDTO
```

### 1. `User.java`
- يمثل جدول `USERS` في قاعدة البيانات (H2, MySQL, إلخ).
- يستخدم التعليقات التوضيحية من JPA:
  ```java
  @Entity
  @Table(name = "USERS")
  public class User { ... }
  ```
- يحتوي على حقول:
  - `Long id` (المفتاح الأساسي)
  - `String name`
  - `String email`

### 2. `UserDTO.java`
- كائن نقل البيانات لمستخدم جديد أو مسترجع من الـ API.
- مولَّد عبر OpenAPI Generator، ويحتوي على:
  - الحقول نفسها (`id`, `name`, `email`)
  - تعليقات Swagger (`@Schema`) لوثائق الـ OpenAPI.

### 3. `UserMapper.java`
- واجهة MapStruct لتحويل تلقائي بين `User` و`UserDTO`.
- مثال:
  ```java
  @Mapper(componentModel = "spring")
  public interface UserMapper {
      UserDTO toDto(User user);
      User toEntity(UserDTO dto);
  }
  ```
- MapStruct يولد الكود الفعلي أثناء عملية البناء.

## كيفية الاستخدام

- **إنشاء مستخدم جديد**:
  ```java
  User user = new User("Ahmed", "ahmed@example.com");
  User saved = userRepository.save(user);
  UserDTO dto = userMapper.toDto(saved);
  ```

- **تحديث مستخدم**:
  ```java
  User existing = userRepository.findById(id).orElseThrow();
  existing.setName(dto.getName());
  existing.setEmail(dto.getEmail());
  userRepository.save(existing);
  ```

- الكومPILEر يتطلب معالجات التعليقات:
  ```xml
  <annotationProcessorPaths>
    <path>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
    </path>
    <path>
      <groupId>org.mapstruct</groupId>
      <artifactId>mapstruct-processor</artifactId>
    </path>
  </annotationProcessorPaths>
  ```

---

> هذا التوثيق يساعد المطورين على فهم دور وأسلوب العمل في مجلد `user`.

