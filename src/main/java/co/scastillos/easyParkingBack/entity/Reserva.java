package co.scastillos.easyParkingBack.entity;

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
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date horaLLeagada;

    private Date horaSalida;

    @OneToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_tarifa")
    private Tarifa tarifa;

    @OneToOne
    private Estacionamiento estacionamiento;


}
