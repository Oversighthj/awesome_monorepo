
package com.example.demo.user;

import jakarta.persistence.*;
import lombok.*;

/**
 * كيان المستخدم ممثل لجدول USERS في قاعدة البيانات.
 */
@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // صريحًا أضفنا getter لـ id لتجنب خطأ المترجم بعدم وجوده
    public Long getId() {
        return this.id;
    }

    // بقيّة getters/setters تولدها Lombok (@Data)
}