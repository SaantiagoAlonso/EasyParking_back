package co.scastillos.easyParkingBack.service;

import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpace;
import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpaceDto;
import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public List<ParkingSpaceDto> findAllParkingSpaces() {
        List<ParkingSpace> parkingSpaceList = parkingSpaceRepository.findAll();
        return parkingSpaceList.stream().map(ParkingSpaceDto::new).toList();

    }
}
