package co.scastillos.easyParkingBack.domain.reserva;

import lombok.Builder;

@Builder
public record CreateReservationDto(

        Long idParkingSpace,
        String licensePlate,
        Integer documentId

) {
}
