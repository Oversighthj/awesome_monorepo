# Backend - `demo/`

هذا المجلد يحتوي على مشروع Spring Boot المسؤول عن الـ API في هذا المستودع.

## نظرة عامة

- يعتمد على Spring Boot 3.4.5
- الملفات الأساسية:
  - `openapi.yaml`: المصدر الوحيد لتعريف جميع واجهات REST وDTOs
  - `pom.xml`: إعدادات Maven، بما في ذلك OpenAPI Generator وMapStruct وLombok
- توليد الكود آليًا عبر OpenAPI Generator
- استخدام MapStruct + Lombok للمطابقة بين الكيانات (Entities) وDTOs
- قاعدة بيانات H2 في الذاكرة للاختبارات والتطوير السريع
- Spring Security مع JWT للحماية (اختياري حسب التكوين في `security`)

## هيكل المجلدات

```
demo/
├── openapi.yaml
├── pom.xml
└── src/main/java/com/example/demo/
    ├── api/               # (Generated) Controllers & interfaces عبر OpenAPI Generator
    ├── model/             # (Generated) DTOs
    ├── user/              # الكيانات والـ DTO والمطابقات اليدوية
    │   ├── User.java      # كيان المستخدم (Entity)
    │   ├── UserDTO.java   # كائن نقل البيانات للمستخدم
    │   └── UserMapper.java# مطابقة MapStruct بين Entity وDTO
    └── security/          # تكوين الأمان (JWT، Roles)
        └── SecurityConfig.java
```

## المتطلبات

- JDK 17
- Maven 3.8 أو أعلى
- متصل بالإنترنت لتحميل التبعيات Maven

## توليد الكود والبناء

```bash
cd demo
data
./mvnw clean generate-sources compile
```

1. **Clean**: يحذف الملفات القديمة في `target/`
2. **generate-sources**: يستدعي OpenAPI Generator ليضع الكود المولد في `target/generated-sources/openapi`
3. **compile**: يترجم كل المصادر (المولد + يدي) إلى `target/classes`

## وضع المراقبة (Watch Mode)

للحصول على إعادة تجميع تلقائية أثناء التطوير:

```bash
cd demo
mvn compile --continuous
```

## تشغيل التطبيق

```bash
cd demo
./mvnw spring-boot:run
```

سيعمل السيرفر على: `http://localhost:8080`

## MapStruct + Lombok

في `pom.xml`:

```xml
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct</artifactId>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <configuration>
    <annotationProcessorPaths>
      <path>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
      </path>
      <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

- **Entity**: `src/main/java/com/example/demo/user/User.java`
- **DTO**: `src/main/java/com/example/demo/user/UserDTO.java`
- **Mapper**: `src/main/java/com/example/demo/user/UserMapper.java`

## الأمان (Security)

- ملف التكوين: `security/SecurityConfig.java`
- يدعم JWT وRoles مخصصة حول نقاط النهاية.

## CI/CD

يتم توليد الكود واختباره قبل الدمج عبر GitHub Actions:
- **Backend**: `mvn openapi-generator:generate` ثم `mvn compile`
- **Frontend**: (داخل `pilot_app/`) `flutter pub get`، `build_runner`، `flutter analyze --fatal-warnings`، `flutter test`

---

## Transport Booking

**Endpoint:** `POST /transport/book`

**Request JSON:**
```json
{
  "flightId": "FL123",
  "userId": "1",
  "seatCount": 2
}

> يمكنك التوسيع بحقل "License" أو وصلات إضافية حسب الحاجة.

