package co.scastillos.easyParkingBack.domain.vehiculo;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record VehicleDto(

        @NonNull Integer documentId,
        @NonNull @NotBlank(message = "cannot be null ") String licensePlate, // Número de matrícula
        String brand,        // Marca del vehículo
        String model,        // Modelo del vehículo
        String color,        // Color del vehículo
        String type

) {
    public VehicleDto(Vehicle v) {
        this( null,v.getLicensePlate(),v.getBrand(),v.getModel(), v.getColor(), v.getType());
    }
}
