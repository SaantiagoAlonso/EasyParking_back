package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpace;
import co.scastillos.easyParkingBack.domain.estacionamiento.ParkingSpaceDto;
import co.scastillos.easyParkingBack.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parkingSpace")
public class ParkingSpaceController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @GetMapping("/findAll")
    public ResponseEntity<List<ParkingSpaceDto>> listParkingSpace(){
        return ResponseEntity.ok(parkingSpaceService.findAllParkingSpaces());
    }


}
