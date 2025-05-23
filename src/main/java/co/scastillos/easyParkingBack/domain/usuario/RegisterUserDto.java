package co.scastillos.easyParkingBack.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record RegisterUserDto(

       @NotBlank(message = "cannot be null ") @NonNull String username,
       @NotBlank(message = "cannot be null ") @NonNull String password,
       @NonNull Integer documentId,
       @NotBlank(message = "cannot be null ") @NonNull String name,
       @NotBlank(message = "cannot be null ") @NonNull String lastname,
       String address,
       @NotBlank(message = "cannot be null ") @NonNull String email,
       @NonNull Integer phone


) {
}
