package cz.vavrecka.monolittomicroservices.user.controller;

import cz.vavrecka.monolittomicroservices.user.domain.User;
import cz.vavrecka.monolittomicroservices.user.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Tag(name = "Users", description = "Users API")
public class UsersController {

    private final UserService userService;

    @GetMapping(produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))})})
    public ResponseEntity<List<User>> getAllUsers() {
        return ok(userService.getAllUsers());
    }
}
