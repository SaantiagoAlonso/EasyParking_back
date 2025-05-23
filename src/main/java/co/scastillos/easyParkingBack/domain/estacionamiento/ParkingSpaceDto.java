package co.scastillos.easyParkingBack.domain.estacionamiento;

import lombok.Builder;

@Builder
public record ParkingSpaceDto(

        Long id,
        String status,
        String size,
        String location
) {
    public ParkingSpaceDto(ParkingSpace p) {
        this(p.getId(), p.getStatus(), p.getSize(), p.getLocation());
    }
}
