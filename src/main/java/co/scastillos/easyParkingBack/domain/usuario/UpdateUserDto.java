package co.scastillos.easyParkingBack.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record UpdateUserDto(

        @NonNull Long id,
        String username,
        String password,
        Integer documentId,
        String name,
        String lastname,
        String address,
        String email,
        Integer phone

) {
}
