package co.scastillos.easyParkingBack.domain.reserva;

import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpace;
import co.scastillos.easyParkingBack.domain.usuario.User;
import co.scastillos.easyParkingBack.domain.tarifa.Rate;
import co.scastillos.easyParkingBack.domain.vehiculo.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "reservas")
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Date horaLLeagada;
//
//    private Date horaSalida;
//
//    @OneToOne
//    @JoinColumn(name = "id_vehiculo")
//    private Vehicle vehiculo;
//
//    @OneToOne
//    @JoinColumn(name = "id_usuario")
//    private User usuario;
//
//    @OneToOne
//    @JoinColumn(name = "id_tarifa")
//    private Rate tarifa;
//
//    @OneToOne
//    private Estacionamiento estacionamiento;


    private Date arrivalTime; // Hora de llegada

    private Date departureTime; // Hora de salida

    @OneToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle; // Vehículo

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user; // Usuario

    @OneToOne
    @JoinColumn(name = "id_rate")
    private Rate rate; // Tarifa

    @OneToOne
    @JoinColumn(name = "id_parking-space")
    private ParkingSpace parkingSpace; // espacio reservado

//    @OneToOne
//    private Parking parking; // Estacionamiento


}
