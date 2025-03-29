package co.scastillos.easyParkingBack.dto;

import lombok.Builder;

@Builder
public record UsuarioDto(
        Integer cedula,

        String nombre,

        String apellido,

        String direccion,

        Integer telefono ) {
}
