// src/main/java/com/example/demo/user/UserController.java
package com.example.demo.user;

import com.example.demo.user.UserRepository;
import com.example.demo.user.UserMapper;
import com.example.demo.user.User;
import com.example.demo.user.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::toDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDto) {
        User toSave = userMapper.toEntity(userDto);
        // ensure a new entity
        toSave.setId(null);
        User saved = userRepository.save(toSave);
        return userMapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDto) {
        User existing = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found for id: " + id));
        existing.setName(userDto.getName());
        existing.setEmail(userDto.getEmail());
        User updated = userRepository.save(existing);
        return userMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
