package co.scastillos.easyParkingBack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "estacionamientos")
@Builder
public class Estacionamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // cambiar a futuro por un enum
    private String estado;

    private String tamaño;

    private String ubicacion;

//    private Vehiculo vehiculo;


}
