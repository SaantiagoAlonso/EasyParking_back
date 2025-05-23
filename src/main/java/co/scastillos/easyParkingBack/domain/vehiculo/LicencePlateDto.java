package co.scastillos.easyParkingBack.domain.vehiculo;

import lombok.Builder;

@Builder
public record LicencePlateDto(String message,String licencePlate) {
}
