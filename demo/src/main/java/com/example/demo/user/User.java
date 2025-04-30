package com.example.demo.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")  // تجنب الاسم المحجوز user
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // ========== Constructors ==========
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // ========== Getters/Setters ==========
    public Long getId() {
        return id;
    }

    /**
     * أضفنا هذه الدالة لتغيير قيمة المعرف (Id)
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
