package com.example.demo.user;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    // حقن (Injection) للمستودع عبر الكونستركتور
    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // ============ GET All ============
    @GetMapping
    public List<User> getAll() {
        return repo.findAll(); // يعيد جميع المستخدمين
    }

    // ============ POST Create ============
    @PostMapping
    public User create(@RequestBody User user) {
        // (1) لضمان عدم اعتبار هذا الكائن "موجود مسبقاً" لو جاء id=0 من العميل
        // نضع المعرف يساوي null، كي تدرك JPA أنه كائن جديد:
        user.setId(null);

        // (2) احفظ المستخدم
        return repo.save(user);
    }

    // ============ PUT Update ============
    @PutMapping("/{id}")
    public User update(
        @PathVariable Long id,
        @RequestBody User updatedUser
    ) {
        // ابحث عن المستخدم
        User existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // عدل بياناته
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());

        // حفظ التعديلات
        return repo.save(existing);
    }

    // ============ DELETE ============
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
