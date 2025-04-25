package co.scastillos.easyParkingBack.domain.usuario;

import co.scastillos.easyParkingBack.domain.vehiculo.VehicleDto;
import lombok.Builder;

import java.util.List;

@Builder
public record UserResponseDto (

        Long id,
        String username,
        Integer documentId,
        String name,
        String lastname,
        String address,
        String email,
        Integer phone,
        List<VehicleDto> vehicles


){
    public UserResponseDto(User user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getDocumentId(),
                user.getName(),
                user.getLastname(),
                user.getAddress(),
                user.getEmail(),
                user.getPhone(),
                user.getVehicles().stream().map(v -> new VehicleDto(v)).toList()
        );
    }
}
