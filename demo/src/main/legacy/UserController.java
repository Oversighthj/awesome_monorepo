package com.example.demo.user;

import com.example.demo.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller يُدير عمليات CRUD على الكيان {@code User}.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper     = userMapper;
    }

    // ──────── READ: جميع المستخدمين ────────
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    // ──────── CREATE: مستخدم جديد ────────
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDto) {
        var saved = userRepository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(saved);
    }

    // ──────── READ: مستخدم بالمعرّف ────────
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with id " + id));
        return userMapper.toDto(user);
    }

    // ──────── UPDATE: مستخدم ────────
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id,
                              @Valid @RequestBody UserDTO userDto) {

        var existing = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with id " + id));

        // نبقي الـ id الحالي (Long) على DTO قبل الحفظ
        userDto.setId(existing.getId());

        var updated = userMapper.toEntity(userDto);
        var saved   = userRepository.save(updated);
        return userMapper.toDto(saved);
    }

    // ──────── DELETE: مستخدم ────────
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
