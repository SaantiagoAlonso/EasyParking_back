package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.domain.vehiculo.LicencePlateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/readLicencePlate")
public class ReadMatriculeController {


    @PostMapping("/licencePlate")
    public ResponseEntity<?> readLicencePlate(@RequestBody LicencePlateDto licence){
        System.out.println(licence);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


}
