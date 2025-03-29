package co.scastillos.easyParkingBack.dto;

import lombok.Builder;

@Builder
public record nuevoUsuarioDto(
        Integer cedula,

        String nombre,

        String apellido,

        String direccion,

        Integer telefono
) {
}
