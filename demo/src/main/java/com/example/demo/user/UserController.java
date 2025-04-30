package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;
    private final UserMapper mapper;

    public UserController(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    // ============ GET All ============
    @GetMapping
    public List<UserDTO> getAll() {
        return repo.findAll().stream()
                   .map(mapper::toDto)
                   .collect(Collectors.toList());
    }

    // ============ POST Create ============
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO dto) {
        User entity = mapper.toEntity(dto);
        entity.setId(null);
        User saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    // ============ PUT Update ============
    @PutMapping("/{id}")
    public UserDTO update(
        @PathVariable Long id,
        @RequestBody UserDTO dto
    ) {
        User existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        User updated = repo.save(existing);
        return mapper.toDto(updated);
    }

    // ============ DELETE ============
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
