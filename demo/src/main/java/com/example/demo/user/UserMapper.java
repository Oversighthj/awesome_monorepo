// src/main/java/com/example/demo/user/UserMapper.java
package com.example.demo.user;

import com.example.demo.model.UserDTO;
import com.example.demo.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User entity);
    User toEntity(UserDTO dto);
}
