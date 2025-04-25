package co.scastillos.easyParkingBack.domain.tarifa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tarifa")
@Builder
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rateType;      // Tipo de tarifa
    private String vehicleType;   // Tipo de vehículo
    private Double cost;          // Costo


}
