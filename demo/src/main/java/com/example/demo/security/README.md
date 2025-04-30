# Security Module

هذا المجلد يحتوي على كل ما يخص تأمين الـ API باستخدام Spring Security وJWT.

## الهيكل

```text
src/main/java/com/example/demo/security/
└── SecurityConfig.java  # تكوين الأمان
```

### 1. `SecurityConfig.java`
- **نوع التكوين**: Spring @Configuration لتفعيل WebSecurity.
- **المتطلبات**:
  - `spring-boot-starter-security`
  - `jjwt` (Java JWT) لإنشاء والتحقق من رموز JWT.
- **المحتوى الرئيسي**:
  - **PasswordEncoder** (مثلاً `BCryptPasswordEncoder`).
  - **AuthenticationManager** لإدارة مصادقة المستخدم.
  - **JWTFilter** (إن وجد) لاعتراض الطلبات وفحص رؤوس Authorization.
  - **HttpSecurity**:
    - تعطيل CSRF (لأننا نستخدم JWT).
    - إعداد قواعد الوصول:
      ```java
      http
        .authorizeHttpRequests()
          .requestMatchers("/api/auth/**").permitAll()
          .anyRequest().authenticated();
      ```
    - تكوين **JWT Authentication Filter** قبل فلتر UsernamePasswordAuthentication.

### 2. التبعيات في `pom.xml`
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt</artifactId>
  <version>0.9.1</version>
</dependency>
```

## كيفية الاستخدام

1. **إرسال طلب تسجيل دخول** لإحضار JWT:
   ```http
   POST /api/auth/login
   Content-Type: application/json
   {
     "username": "user",
     "password": "pass"
   }
   ```
   - تستقبل الرد حقل `token` في JSON.

2. **استخدام JWT** في باقي الطلبات:
   ```http
   GET /api/users
   Authorization: Bearer <token>
   ```

3. **صلاحيات (Roles)**:
   - يمكن تعديل القواعد في `SecurityConfig` لتحديد أي مداخل تحتاج دورًا معينًا.

---

> هذا التوثيق يساعد المطورين على فهم كيفية تأمين الـ API باستخدام JWT وSpring Security.

