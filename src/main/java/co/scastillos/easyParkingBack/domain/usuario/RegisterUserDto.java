package co.scastillos.easyParkingBack.domain.usuario;

import lombok.Builder;

@Builder
public record RegisterUserDto(

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
