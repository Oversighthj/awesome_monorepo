package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

/** يوفّر عمليات CRUD كاملة على كيان {@code User} بدون الحاجة لكتابة SQL يدوي. */
public interface UserRepository extends JpaRepository<User, Long> {
  // يمكنك إضافة دوال بحث مخصّصة هنا لو أردت
}
