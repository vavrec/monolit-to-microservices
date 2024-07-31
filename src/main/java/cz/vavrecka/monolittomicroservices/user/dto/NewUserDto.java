package cz.vavrecka.monolittomicroservices.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "New User")
public record NewUserDto(String firstName, String lastName, String email) {
}
