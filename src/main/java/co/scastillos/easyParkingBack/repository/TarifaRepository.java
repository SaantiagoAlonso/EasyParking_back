package co.scastillos.easyParkingBack.repository;

import co.scastillos.easyParkingBack.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa,Long> {
}
