# ---------- 1) مرحلة البناء ----------
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
    
# انسخ كل ملفات المشروع إلى الحاوية
COPY . .
    
# تأكد أن ملف الـ wrapper قابل للتنفيذ داخل الحاوية
RUN chmod +x mvnw
    
# ابْنِ المشروع (تخطى الاختبارات لتسريع الصورة)
RUN ./mvnw -q -DskipTests package
    
# ---------- 2) مرحلة التشغيل ----------
FROM eclipse-temurin:17-jre
WORKDIR /opt/app
    
# انسخ الـ JAR الناتج من مرحلة build
COPY --from=build /app/target/*.jar app.jar
    
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/app.jar"]
    