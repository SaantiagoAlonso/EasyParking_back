package co.scastillos.easyParkingBack.controller;

import co.scastillos.easyParkingBack.domain.reserva.CreateReservationDto;
import co.scastillos.easyParkingBack.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/createReservation")
    public ResponseEntity<Void> createReservation(@RequestBody CreateReservationDto reservation){
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
