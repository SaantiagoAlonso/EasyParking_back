package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.domain.vehiculo.Vehicle;
import co.scastillos.easyParkingBack.domain.vehiculo.VehicleDto;
import co.scastillos.easyParkingBack.service.UserService;
import co.scastillos.easyParkingBack.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public ResponseEntity<Void> registerVehicle(@RequestBody VehicleDto vehicle){
        vehicleService.registerVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }





}
