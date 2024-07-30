package cz.vavrecka.monolittomicroservices.user.controller;


import cz.vavrecka.monolittomicroservices.user.domain.User;
import cz.vavrecka.monolittomicroservices.user.dto.NewUserDto;
import cz.vavrecka.monolittomicroservices.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody NewUserDto user) {
        return ok(userService.createUser(user));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ok(userService.updateUser(user));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteUserById(@RequestParam UUID id) {
        userService.deleteUserById(id);
        return ok().build();
    }
}
