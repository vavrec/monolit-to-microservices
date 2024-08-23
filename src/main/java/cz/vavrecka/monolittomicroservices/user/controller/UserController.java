package cz.vavrecka.monolittomicroservices.user.controller;


import cz.vavrecka.monolittomicroservices.user.domain.User;
import cz.vavrecka.monolittomicroservices.user.dto.NewUserDto;
import cz.vavrecka.monolittomicroservices.user.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserService userService;

    @GetMapping(produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))})})
    public ResponseEntity<List<User>> getAllUsers() {
        return ok(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))})})
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))})})
    public ResponseEntity<User> createUser(@RequestBody NewUserDto user) {
        return ok(userService.createUser(user));
    }

    @PutMapping(produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "User does not exists", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))})})
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ok(userService.updateUser(user));
    }

    @DeleteMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))})})
    public ResponseEntity<Void> deleteUserById(@RequestParam Long id) {
        userService.deleteUserById(id);
        return ok().build();
    }
}
