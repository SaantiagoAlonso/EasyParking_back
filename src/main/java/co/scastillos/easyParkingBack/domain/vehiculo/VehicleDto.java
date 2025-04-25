package co.scastillos.easyParkingBack.domain.vehiculo;

import lombok.Builder;

@Builder
public record VehicleDto(

        Integer documentId,
        String licensePlate, // Número de matrícula
        String brand,        // Marca del vehículo
        String model,        // Modelo del vehículo
        String color,        // Color del vehículo
        String type

) {
    public VehicleDto(Vehicle v) {
        this( null,v.getLicensePlate(),v.getBrand(),v.getModel(), v.getColor(), v.getType());
    }
}
