package co.scastillos.easyParkingBack.domain.vehiculo;

import co.scastillos.easyParkingBack.domain.usuario.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehiculos")
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate; // Número de matrícula
    private String brand;        // Marca del vehículo
    private String model;        // Modelo del vehículo
    private String color;        // Color del vehículo
    private String type;         // Tipo de vehículo (por ejemplo, sedan, SUV, etc.)

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
