package co.scastillos.easyParkingBack.domain.usuario;

import lombok.Builder;

@Builder
public record UpdateUserDto(

        Long id,
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
