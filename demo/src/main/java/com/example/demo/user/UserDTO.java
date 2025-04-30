package com.example.demo.user;

import lombok.*;

/**
 * Data Transfer Object لمستخدم.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
}
