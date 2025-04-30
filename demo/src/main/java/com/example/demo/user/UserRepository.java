package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

// هذا الانترفيس يتيح لك CRUD بدون كتابة SQL
public interface UserRepository extends JpaRepository<User, Long> {
    // يمكنك إضافة دوال بحث مخصّصة هنا لو أردت
}
