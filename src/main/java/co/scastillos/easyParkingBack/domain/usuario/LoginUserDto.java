package co.scastillos.easyParkingBack.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record LoginUserDto(@NotBlank String username, @NotBlank String password) {
}
