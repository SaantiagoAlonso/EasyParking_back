package co.scastillos.easyParkingBack.repository;

import co.scastillos.easyParkingBack.entity.Estacionamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento,Long> {
}
