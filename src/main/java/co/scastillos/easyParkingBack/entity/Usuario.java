package co.scastillos.easyParkingBack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuarios")
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cedula;

    private String nombre;

    private String apellido;

    private String direccion;

    private Integer telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Vehiculo> vehiculos;


}
